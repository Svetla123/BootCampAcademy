package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.Model.UserTest;

import java.util.List;

public interface IUserTestService {
    UserTest findUserTestById(Long id);
    List<UserTest> findAllUserTests();

    boolean deleteUserTest(Long id);

    UserTest saveUserTest(UserTest userTest);

    UserTest updateUserTest(Long id, UserTest userTest);
}
