package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.Model.Meeting;
import com.BootCampAcademy.demo.Model.Topic;
import com.BootCampAcademy.demo.service.IMeetingService;
import com.BootCampAcademy.demo.service.ITopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {
    private IMeetingService meetingService;

    private ITopicService topicService;

    public MeetingController(IMeetingService meetingService, ITopicService topicService) {
        super();
        this.meetingService = meetingService;
        this.topicService = topicService;
    }

    @GetMapping("/meetings")
    public List<Meeting> findAll () {
        List<Meeting> meetings = this.meetingService.findAllMeetings();
        return meetings;
    }

    @GetMapping("/meetings/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        Meeting meeting = this.meetingService.findMeetingById(id);
        if (meeting == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting with id " + id + " not found");
        }
        return ResponseEntity.ok(meeting);
    }

    @PostMapping("/meetings")
    public ResponseEntity<?> create (@RequestBody Meeting meeting) {
        meeting.setTopic(topicService.findTopicById(meeting.getTopic().getId()));
//        Topic topic = meeting.getTopic();
//        Long topicId = topicService.findTopicByName(topic.getName());
//        topic.setId(topicId);
//        meeting.setTopic(topic);
       Meeting newMeeting = this.meetingService.createMeeting(meeting);
        return ResponseEntity.ok(newMeeting);
    }

    @DeleteMapping("/meetings/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.meetingService.deleteMeeting(id);

        if (result) {
            return ResponseEntity.ok("Meeting with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting with id " + id + " not found");
        }
    }

    @PutMapping("/meetings/{id}")
    public ResponseEntity<?> update (@RequestBody Meeting meeting, @PathVariable Long id) {
        if (meeting.getTopic() != null){
            Topic topic = meeting.getTopic();
            Long topicId = topicService.findTopicByName(topic.getName());
            topic.setId(topicId);
            meeting.setTopic(topic);
        }
        Meeting updatedMeeting = this.meetingService.updateMeeting(meeting, id);
        if (updatedMeeting == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedMeeting);
    }
}
