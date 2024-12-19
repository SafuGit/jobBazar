package com.siyam.jobListing.Jobs.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cover_letters")
public class CoverLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Double phone_number;

    private String name;

    private String location;

    private String email;

    private String skills;

    private Integer experience;

    private String institute;

    private String degree;

    private Integer passing_year;

    private Float cgpa;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @JsonProperty("user_id")
    public Long getUserId() {
        return user.getId();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "coverLetter")
    private List<Application> applications;
    
}

