package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.model.User;
import com.BootCampAcademy.demo.model.UserTest;
import com.BootCampAcademy.demo.service.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserTestController {
    @Autowired
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

    @DeleteMapping("/userTests/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.userTestService.deleteUserTest(id);
        if (result) {
            return ResponseEntity.ok("User test with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User test test with id " + id + " not found");
        }
    }

    @PostMapping("/userTests")
    public ResponseEntity<?> create (@RequestBody UserTest userTest) {
        UserTest newUserTest = this.userTestService.createUserTest(userTest);
        return ResponseEntity.ok(newUserTest);
    }

    @PutMapping ("/userTests/{id}")
    public ResponseEntity<?> update (@RequestBody UserTest userTest, @PathVariable Long id) {
        UserTest updatedUserTest = this.userTestService.updateUserTest(id,userTest);
        if (updatedUserTest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User test with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUserTest);
    }
}
