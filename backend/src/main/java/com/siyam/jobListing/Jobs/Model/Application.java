package com.siyam.jobListing.Jobs.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applications")
public class Application {

    public enum Status {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Job job;

    @ManyToOne
    @JsonIgnore
    private User applicant;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    public Status status;

    @JsonProperty("job_id")
    public Integer getJobId() {
        return job.getId();
    }

    @JsonProperty("job_title")
    public String getJobTitle() {
        return job.getTitle();
    }

    @JsonProperty("applicant_id")
    public Long getApplicantId() {
        return applicant.getId();
    }

    @JsonProperty("applicant_name")
    public String getApplicantName() {
        return applicant.getName();
    }

    @ManyToOne
    @JoinColumn(name = "cover_letter_id")  // Foreign key for cover_letter
    private CoverLetter coverLetter;

    @JsonProperty("cover_letter_id")
    public Integer getCoverLetterId() {
        return coverLetter.getId();
    }

//    private String coverLetter;

    // Getters and Setters
}
