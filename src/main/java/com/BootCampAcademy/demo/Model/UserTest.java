package com.BootCampAcademy.demo.Model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "users_tests")
@Data
public class UserTest extends AppModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;
    //ako uspostavim created_at ovo mi ne treba
//    @Column(nullable = false)
//    private Instant uploadDate;
    @Column(nullable = false)
    private String submitedSolution;
    @ColumnDefault("1")
    private boolean state;
    @ColumnDefault("0")
    private long achivedPoints;


    @ManyToOne
    @JoinColumn(name = "solved_by")
    private User user;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "corrected_by")
    private User corrector;


}
