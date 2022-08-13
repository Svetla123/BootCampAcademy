package com.BootCampAcademy.demo.controller;
import com.BootCampAcademy.demo.Model.Test;
import com.BootCampAcademy.demo.service.ITestService;
import com.BootCampAcademy.demo.service.IUserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private ITestService testService;

    public TestController(ITestService testService) {
        super();
        this.testService = testService;
    }

    @GetMapping("/tests")
    public List<Test> findAll() {
        List<Test> tests = this.testService.findAllTests();
        return tests;
    }

    @GetMapping("/tests/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Test test = this.testService.findTestById(id);
        if (test == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Test with id " + id + " not found");
        }
        return ResponseEntity.ok(test);
    }

    @DeleteMapping("tests/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.testService.deleteTest(id);

        if (result) {
            return ResponseEntity.ok("Test with id" + id + "deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Test with id" + id + "not found");
        }
    }

    @PostMapping ("/tests")
    public ResponseEntity<?> create (@RequestBody Test test) {
        Test newTest = this.testService.createTest(test);
        return ResponseEntity.ok(newTest);
    }

    @PutMapping("/tests/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Test test) {
        Test updatedTest = this.testService.updateTest(id, test);
        if (updatedTest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Test with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedTest);
    }
}
