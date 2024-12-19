package com.siyam.jobListing.Jobs.Controller;

import com.siyam.jobListing.Jobs.Model.Application;
import com.siyam.jobListing.Jobs.Model.ApplicationDTO;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> applyForJob(@RequestBody ApplicationDTO applicationRequest) {
        return applicationService.applyForJob(applicationRequest.getJobId(), applicationRequest.getUserId(), applicationRequest.getCoverLetter(), applicationRequest.getStatus());
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsForJob(@PathVariable Integer jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsForJob(jobId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Application>> getApplicationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByUser(userId));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long Id, @RequestBody Application application) {
        return applicationService.updateApplicationStatus(Id, application);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long Id) {
        return applicationService.deleteApplication(Id);
    }
}
