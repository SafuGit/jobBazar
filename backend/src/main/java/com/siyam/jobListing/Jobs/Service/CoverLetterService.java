package com.siyam.jobListing.Jobs.Service;

import com.siyam.jobListing.Jobs.Model.CoverLetter;
import com.siyam.jobListing.Jobs.Model.User;
import com.siyam.jobListing.Jobs.Repository.CoverLetterRepository;
import com.siyam.jobListing.Jobs.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterService {
    public final CoverLetterRepository coverLetterRepository;
    public final UserRepository userRepository;

    public CoverLetterService(CoverLetterRepository coverLetterRepository, UserRepository userRepository) {
        this.coverLetterRepository = coverLetterRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<CoverLetter> getCoverLetterByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        CoverLetter coverLetter = coverLetterRepository.findByUser(user);
        return ResponseEntity.ok(coverLetter);
    }

    public ResponseEntity<CoverLetter> createCoverLetter(CoverLetter coverLetter, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        coverLetter.setUser(user);
        CoverLetter savedCoverLetter = coverLetterRepository.save(coverLetter);
        return ResponseEntity.ok(savedCoverLetter);
    }

    public ResponseEntity<CoverLetter> updateCoverLetter(Long userId, CoverLetter coverLetter) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        CoverLetter existingCoverLetter = coverLetterRepository.findByUser(user);
        existingCoverLetter.setPhone_number(coverLetter.getPhone_number());
        existingCoverLetter.setName(coverLetter.getName());
        existingCoverLetter.setLocation(coverLetter.getLocation());
        existingCoverLetter.setEmail(coverLetter.getEmail());
        existingCoverLetter.setSkills(coverLetter.getSkills());
        existingCoverLetter.setExperience(coverLetter.getExperience());
        existingCoverLetter.setInstitute(coverLetter.getInstitute());
        existingCoverLetter.setDegree(coverLetter.getDegree());
        existingCoverLetter.setPassing_year(coverLetter.getPassing_year());
        existingCoverLetter.setCgpa(coverLetter.getCgpa());
        CoverLetter updatedCoverLetter = coverLetterRepository.save(existingCoverLetter);
        return ResponseEntity.ok(updatedCoverLetter);
    }
}
