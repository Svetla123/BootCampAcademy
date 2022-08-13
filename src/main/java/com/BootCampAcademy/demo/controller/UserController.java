package com.BootCampAcademy.demo.controller;
import com.BootCampAcademy.demo.Model.Role;
import com.BootCampAcademy.demo.Model.User;
import com.BootCampAcademy.demo.Model.UserProfile;
import com.BootCampAcademy.demo.service.IRoleService;
import com.BootCampAcademy.demo.service.IUserProfileService;
import com.BootCampAcademy.demo.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private IUserService usersService;

    private IRoleService rolesService;

    public UserController(IUserService usersService, IRoleService rolesService) {
        super();
        this.usersService = usersService;
        this.rolesService = rolesService;
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

    @DeleteMapping("/users{id}")
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
        user.getRole().setId(rolesService.findRoleByName(user.getRole().getName()));
        User newUser = this.usersService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping ("/users/{id}")
    public ResponseEntity<?> update (@RequestBody User user, @PathVariable Long id) {
        if (user.getRole() != null){
            user.setRole(rolesService.findRoleById(user.getRole().getId()));
        }
        User updatedUser = this.usersService.updateUser(user, id);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUser);
    }
}