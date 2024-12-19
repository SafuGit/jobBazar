package com.siyam.jobListing.Jobs.Model;

public class ApplicationDTO {
    private Integer jobId;
    private Long userId;
    private CoverLetter coverLetter;
    private Application.Status status;

    // Getters and setters
    public Integer getJobId() {

        return jobId;
    }

    public void setJobId(Integer jobId) {

        this.jobId = jobId;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public CoverLetter getCoverLetter() {
        return coverLetter;
    }

    public Application.Status getStatus() {
        return status;
    }

//    public void setCoverLetter(String coverLetter) {
//
//        this.coverLetter = coverLetter;
//    }
}
