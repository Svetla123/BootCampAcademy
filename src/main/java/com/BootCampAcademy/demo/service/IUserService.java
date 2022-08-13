package com.BootCampAcademy.demo.service;
import com.BootCampAcademy.demo.Model.User;
import java.util.List;

public interface IUserService {
    User findUserById(Long id);
    List<User> findAllUsers();

    boolean deleteUser(long id);

    User createUser(User user);

    User updateUser(User user, long id);

    Long findUserByUsername(String username);
}
