package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.model.User;
import com.BootCampAcademy.demo.model.UserProfile;
import com.BootCampAcademy.demo.model.UserTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserTestService {
    UserTest findUserTestById(Long id);
    List<UserTest> findAllUserTests();
    boolean deleteUserTest(Long id);
    UserTest createUserTest (UserTest userTest);
    UserTest updateUserTest (long id, UserTest userTest);

}
