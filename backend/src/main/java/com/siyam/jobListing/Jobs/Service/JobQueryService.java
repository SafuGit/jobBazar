package com.siyam.jobListing.Jobs.Service;

import com.siyam.jobListing.Jobs.Interface.Query;
import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.JobDTO;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Repository.JobRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobQueryService implements Query {
    private final JobRepository jobRepository;

    public JobQueryService(JobRepository jobRepository) {

        this.jobRepository = jobRepository;
    }

    @Override
    public ResponseEntity<JobDTO> getJobById(Integer id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            return ResponseEntity.ok(new JobDTO(job.get()));
        } else {
            throw new RuntimeException("Job not found");
        }
    }

    @Override
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOs = jobs.stream().map(JobDTO::new).toList();
        return ResponseEntity.ok(jobDTOs);
    }

    public List<Job> getJobsByEmployer(User employer) {
        return jobRepository.findByEmployer(employer);
    }
}
