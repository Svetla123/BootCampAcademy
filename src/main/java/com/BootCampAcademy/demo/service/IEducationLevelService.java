package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.Model.EducationLevel;

import java.util.List;

public interface IEducationLevelService {
    EducationLevel findEducationLevelById(Long id);
    List<EducationLevel> findAllEducationLevels();

    EducationLevel createEducationLevel(EducationLevel educationLevel);
    boolean deleteEducationLevel(long id);

    EducationLevel updateEducationLevel (long id, EducationLevel educationLevel);

    Long findEducationLevelByName(String name);
}