package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.Model.UserArrival;

import java.util.List;

public interface IUserArrivalService {
    UserArrival findUserArrivalById(Long id);
    List<UserArrival> findAllUserArrivals();

    boolean deleteUserArrival(long id);

    UserArrival createUserArrival (UserArrival userArrival);

    UserArrival updateUserArrival (long id, UserArrival userArrival);
}
