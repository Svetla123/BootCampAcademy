package com.BootCampAcademy.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "educationLevels")
@Data
public class EducationLevel extends AppModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String abbreviation;

    @OneToMany (mappedBy = "educationLevel")
    @JsonIgnore
    private List<UserProfile> userProfiles;
}
