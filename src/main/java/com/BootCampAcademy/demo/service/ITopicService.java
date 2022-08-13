package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.Model.Topic;

import java.util.List;

public interface ITopicService {
    Topic findTopicById(Long id);
    List<Topic> findAllTopics();

    Topic createTopic(Topic topic);

    boolean deleteTopic(long id);

    Topic updateTopic (long id, Topic topic);

    Long findTopicByName(String name);
}
