package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.model.UserArrival;
import com.BootCampAcademy.demo.service.IMeetingService;
import com.BootCampAcademy.demo.service.IUserArrivalService;
import com.BootCampAcademy.demo.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserArrivalController {
    private IUserArrivalService userArrivalService;
    private IUserService userService;

    private IMeetingService meetingService;
    public UserArrivalController(IUserArrivalService userArrivalService, IUserService userService, IMeetingService meetingService) {
        super();
        this.userArrivalService = userArrivalService;
        this.userService = userService;
        this.meetingService = meetingService;
    }
    @GetMapping("/api/userarrivals")
    public List<UserArrival> findAll () {
        List<UserArrival> userArrivals = this.userArrivalService.findAllUserArrivals();
        return userArrivals;
    }
    @GetMapping("/api/userarrivals/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        UserArrival userArrival = this.userArrivalService.findUserArrivalById(id);
        if (userArrival == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserArrival with id " + id + " not found");
        }
        return ResponseEntity.ok(userArrival);
    }

    @DeleteMapping ("/api/userarrivals{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.userArrivalService.deleteUserArrival(id);
        if (result) {
            return ResponseEntity.ok("UserArrival with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserArrival with id " + id + " not found");
        }
    }

    @PostMapping("/api/userarrivals")
    public ResponseEntity<?> create (@RequestBody UserArrival userArrival) {
//        userArrival.getUser().setId(userService.findUserByUsername(userArrival.getUser().getUsername()));

//        userArrival.getMeeting().setId((meetingService.findMeetingByName(userArrival.getMeeting().getName())));

        UserArrival newUserArrival = this.userArrivalService.createUserArrival(userArrival);
        return ResponseEntity.ok(newUserArrival);
    }

    @PutMapping("/api/userarrivals/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody UserArrival userArrival) {
        UserArrival updatedUserArrival = this.userArrivalService.updateUserArrival(id, userArrival);
        if (updatedUserArrival == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserArrival with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUserArrival);
    }
}
