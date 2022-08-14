package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.model.Topic;
import com.BootCampAcademy.demo.service.ITopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TopicController {

    private ITopicService topicService;

    public TopicController (ITopicService topicService) {
        super();
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public List<Topic> findAll () {
        List<Topic> topics = this.topicService.findAllTopics();
        return topics;
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity <?> findById (@PathVariable Long id){
        Topic topic = this.topicService.findTopicById(id);
        if (topic == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topic with id " + id + " not found");
        }
        return ResponseEntity.ok(topic);
    }

    @PostMapping ("/topics")
    public ResponseEntity <?> create (@RequestBody Topic topic){
        Topic newTopic = this.topicService.createTopic(topic);
        return ResponseEntity.ok(newTopic);
    }

    @DeleteMapping ("/topics/{id}")
    public ResponseEntity <?> delete (@PathVariable Long id){
        boolean result = this.topicService.deleteTopic(id);
        if (result){
            return ResponseEntity.ok("Topic with id " + id + " deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topic with id " + id + " not found");
    }

    @PutMapping ("/topics/{id}")
    public ResponseEntity <?> update (@PathVariable Long id, @RequestBody Topic topic){
        Topic updatedTopic = this.topicService.updateTopic(id, topic);
        if (updatedTopic == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topic with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedTopic);
    }
}
