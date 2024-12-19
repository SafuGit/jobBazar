package com.siyam.jobListing.Jobs.Repository;

import com.siyam.jobListing.Jobs.Model.CoverLetter;
import com.siyam.jobListing.Jobs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterRepository extends JpaRepository<CoverLetter, Integer> {
    CoverLetter findByUser(User user);
}
