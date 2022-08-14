package com.BootCampAcademy.demo.service.impl;

import com.BootCampAcademy.demo.model.User;
import com.BootCampAcademy.demo.repository.UserRepository;
import com.BootCampAcademy.demo.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepository users;
    private UserService(UserRepository users) {
        super();
        this.users = users;
    }
    @Override
    public User findUserById(Long id) {
        try{
            return this.users.findById(id).get();

        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<User> findAllUsers() {
        return this.users.findAll();
    }

    @Override
    public boolean deleteUser(long id) {
        User user = this.findUserById(id);

        try {
            this.users.delete(user);
        }
        catch (Exception e){
            return false;
        }
        finally {
            return true;
        }
    }

    @Override
    public User createUser(User user) {
        return this.users.save(user);
    }

    @Override
    public User updateUser(User user, long id) {
        User oldUser = this.findUserById(id);

        if (oldUser == null) {
            return null;
        } else {
            if (user.getEmail() != null) {
                oldUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                oldUser.setPassword(user.getPassword());
            }
            if (user.getArrivalSum() != 0) {
                oldUser.setArrivalSum(user.getArrivalSum());
            }
            if (user.getSumPoints() != 0.0) {
                oldUser.setSumPoints(user.getSumPoints());
            }
            if (user.getUsername() != null) {
                oldUser.setUsername(user.getUsername());
            }
            if (user.getUserProfile() != null) {
                oldUser.setUserProfile(user.getUserProfile());
            }
            if (user.getRole() != null) {
                oldUser.setRole(user.getRole());
            }
            return this.users.save(oldUser);
        }
    }

    public Long findUserByUsername(String username) {
        return this.users.findByUsername(username).getId();
    }
}
