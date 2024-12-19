package com.siyam.jobListing.Jobs.Interface;

import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.JobDTO;
import com.siyam.jobListing.Jobs.Model.User;
import org.springframework.http.ResponseEntity;

public interface Command {
    public ResponseEntity<JobDTO> createJob(Job job);
    public ResponseEntity<JobDTO> updateJob(Integer id, Job job);
    public ResponseEntity<Void> deleteJob(Integer id);
}
