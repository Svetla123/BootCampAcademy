package com.BootCampAcademy.demo.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "users_tests")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserTest extends AppModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    @Column(nullable = true)
    @ColumnDefault("0")
    private long achivedPoints;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "corrected_by")
    private User corrector;
}
