package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.Model.Role;
import com.BootCampAcademy.demo.Model.UserTest;
import com.BootCampAcademy.demo.service.IUserTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTestController {
    private IUserTestService userTestService;
    public UserTestController(IUserTestService userTestService) {
        super();
        this.userTestService = userTestService;
    }

    @GetMapping("/userTests")
    public List<UserTest> findAll() {
        List <UserTest> userTests = this.userTestService.findAllUserTests();
        return userTests;
    }

    @GetMapping("/userTests/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        UserTest userTest = this.userTestService.findUserTestById(id);
        if (userTest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User test with id " + id + " not found");
        }
        return ResponseEntity.ok(userTest);
    }

    @DeleteMapping
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.userTestService.deleteUserTest(id);
        if (result) {
            return ResponseEntity.ok("User test with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User test with id " + id + " not found");
        }
    }

    @PostMapping("/userTests")
    public ResponseEntity<?> create (@RequestBody UserTest userTest) {
        UserTest newUserTest = this.userTestService.saveUserTest(userTest);
        return ResponseEntity.ok(newUserTest);
    }

    @PutMapping("/userTests/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody UserTest userTest) {
        UserTest updatedUserTest = this.userTestService.updateUserTest(id, userTest);
        if (updatedUserTest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User test with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUserTest);
    }
}
