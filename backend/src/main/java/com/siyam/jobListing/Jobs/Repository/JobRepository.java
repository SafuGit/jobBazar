package com.siyam.jobListing.Jobs.Repository;

import com.siyam.jobListing.Jobs.Model.Job;
import com.siyam.jobListing.Jobs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByEmployer(User employer);
}
