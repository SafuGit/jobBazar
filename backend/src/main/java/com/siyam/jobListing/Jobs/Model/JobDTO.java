package com.siyam.jobListing.Jobs.Model;

import lombok.Data;

@Data
public class JobDTO {

    private Integer id;
    private String title;
    private String description;
    private String company;
    private String location;
    private Job.JobType type;
    private Double salary;
    private Long employerId;

    public JobDTO(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.company = job.getCompany();
        this.location = job.getLocation();
        this.type = job.getType();
        this.salary = job.getSalary();
        this.employerId = job.getEmployer().getId();
    }
}
