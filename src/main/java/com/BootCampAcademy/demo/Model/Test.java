package com.BootCampAcademy.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tests")
@Data
public class Test extends AppModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    private String name;
    private String description;
    private LocalDate deadline;
    private double possiblePoints;

    @OneToMany(mappedBy = "test")
    @JsonIgnore
    private List<UserTest> usersTests;
}
