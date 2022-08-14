package com.BootCampAcademy.demo.controller;
import com.BootCampAcademy.demo.model.User;
import com.BootCampAcademy.demo.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private IUserService usersService;

    public UserController(IUserService usersService) {
        super();
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users = this.usersService.findAllUsers();
        return users;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        User user = this.usersService.findUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.usersService.deleteUser(id);

        if (result) {
            return ResponseEntity.ok("User with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> create (@RequestBody User user) {
        User newUser = this.usersService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping ("/users/{id}")
    public ResponseEntity<?> update (@RequestBody User user, @PathVariable Long id) {
        User updatedUser = this.usersService.updateUser(user, id);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUser);
    }
}
