package com.siyam.jobListing.Jobs.Controller;

import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.JobDTO;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Repository.UserRepository;
import com.siyam.jobListing.Jobs.Service.JobCommandService;
import com.siyam.jobListing.Jobs.Service.JobQueryService;
import com.siyam.jobListing.Jobs.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobQueryService jobQueryService;
    private final JobCommandService jobCommandService;
    private final UserRepository userRepository;

    public JobController(JobQueryService jobQueryService, JobCommandService jobCommandService, UserService userService, UserRepository userRepository) {
        this.jobQueryService = jobQueryService;
        this.jobCommandService = jobCommandService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs() {

        return jobQueryService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Integer id) {

        return jobQueryService.getJobById(id);
    }

    @PostMapping
    public ResponseEntity<JobDTO> createJob(@RequestBody Job job) {
        return jobCommandService.createJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Integer id, @RequestBody Job job) {
        return jobCommandService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {

        return jobCommandService.deleteJob(id);
    }

    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<Job>> getJobsByEmployer(@PathVariable Long employerId) {
        User employer = userRepository.findById(employerId).orElseThrow(() -> new RuntimeException("User not found."));
        return ResponseEntity.ok(jobQueryService.getJobsByEmployer(employer));
    }
}
