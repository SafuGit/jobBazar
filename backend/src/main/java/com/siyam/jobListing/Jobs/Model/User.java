package com.siyam.jobListing.Jobs.Model;

import com.fasterxml.jackson.annotation.*;
import com.siyam.jobListing.Jobs.Repository.UserRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {
    public enum Role {
        USER,
        EMPLOYER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private Long phone_number;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role; // USER or EMPLOYER

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Job> jobs;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;

    @OneToOne(mappedBy = "user")
    private CoverLetter coverLetters;

    public User(Long id) {
        this.id = id;
    }

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "cv_file")
    private String cvFile;

    // Getters and Setters
}