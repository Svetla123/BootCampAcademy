package com.BootCampAcademy.demo.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@SecondaryTable(name = "userProfiles")
public class User extends AppModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column (nullable = false)
    private String username;
    @ColumnDefault("0")
    private int arrivalSum;
    @ColumnDefault("0")
    private double sumPoints;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "userProfile_id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserTest> userTest;
    @OneToMany(mappedBy = "corrector")
    @JsonIgnore
    private List<UserTest> correctorTest;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserArrival> userArrivals;
}
