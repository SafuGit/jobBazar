package com.siyam.jobListing.Jobs.Service;

import com.siyam.jobListing.Jobs.Interface.Command;
import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.JobDTO;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Repository.JobRepository;
import com.siyam.jobListing.Jobs.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobCommandService implements Command {

    public final JobRepository jobRepository;
    public final UserRepository userRepository;

    public JobCommandService(JobRepository jobRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<JobDTO> createJob(Job job) {
        System.out.println(job.getEmployer());
        if (job.getEmployer() == null ) {
            throw new IllegalArgumentException("Employer is required to create a job listing");
//            System.out.println(job);
        }

        // Optional: Validate that the employer exists in the system (not strictly necessary if already set)
        Optional<User> employer = userRepository.findById(job.getEmployer().getId());
        if (!employer.isPresent() || !employer.get().getRole().equals(User.Role.EMPLOYER)) {
            throw new IllegalArgumentException("The user must be an Employer to create a job listing");
//            System.out.println(job);
//            System.out.println(employer.isPresent());
//            System.out.println(employer.get().getRole().equals(User.Role.EMPLOYER));
        }
        Job savedJob = jobRepository.save(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JobDTO(savedJob));
    }

    @Override
    public ResponseEntity<JobDTO> updateJob(Integer id, Job job) {
        Optional<Job> jobOpt = jobRepository.findById(id);
//        if (jobOpt.isPresent()) {
//            job.setId(id);
//            jobRepository.save(job);
//            return ResponseEntity.ok(new JobDTO(job));
//        } else {
//            throw new RuntimeException("Job not found");
//        }
        if (jobOpt.isPresent()) {
            Job existingJob = jobOpt.get();

            // Update basic fields
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setCompany(job.getCompany());
            existingJob.setLocation(job.getLocation());
            existingJob.setType(job.getType());
            existingJob.setSalary(job.getSalary());

            // Preserve the applications relationship (or update if necessary)
            if (job.getApplications() != null) {
                existingJob.getApplications().clear(); // Clear existing applications
                existingJob.getApplications().addAll(job.getApplications()); // Add updated applications
            }

            // Save the updated job
            jobRepository.save(existingJob);
            return ResponseEntity.ok(new JobDTO(existingJob));
        } else {
            throw new RuntimeException("Job not found");
        }
    }

    @Override
    public ResponseEntity<Void> deleteJob(Integer id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            jobRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new RuntimeException("Job not found");
        }
    }
}
