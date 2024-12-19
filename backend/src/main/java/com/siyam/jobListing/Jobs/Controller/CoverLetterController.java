package com.siyam.jobListing.Jobs.Controller;

import com.siyam.jobListing.Jobs.Model.CoverLetter;
import com.siyam.jobListing.Jobs.Service.CoverLetterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverletter")
public class CoverLetterController {
    private final CoverLetterService coverLetterService;

    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CoverLetter> getCoverLetterByUserId(@PathVariable Long userId) {
        return coverLetterService.getCoverLetterByUserId(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CoverLetter> createCoverLetter(@RequestBody CoverLetter coverLetter, @PathVariable Long userId) {
        return coverLetterService.createCoverLetter(coverLetter, userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CoverLetter> updateCoverLetter(@PathVariable Long userId, @RequestBody CoverLetter coverLetter) {
        return coverLetterService.updateCoverLetter(userId, coverLetter);
    }
}
