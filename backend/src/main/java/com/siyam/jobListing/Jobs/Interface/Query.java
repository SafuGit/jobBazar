package com.siyam.jobListing.Jobs.Interface;

import com.siyam.jobListing.Jobs.Model.JobDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Query {
    public ResponseEntity<JobDTO> getJobById(Integer id);
    public ResponseEntity<List<JobDTO>> getAllJobs();
}
