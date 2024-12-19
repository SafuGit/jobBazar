package com.siyam.jobListing.Jobs.Repository;

import com.siyam.jobListing.Jobs.Model.Application;
import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByJob(Job job);
    List<Application> findByApplicant(User applicant);
    Optional<Application> findByApplicantAndJob(User applicant, Job job);
}
