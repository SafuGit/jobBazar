package com.siyam.jobListing.Jobs.Repository;

import com.siyam.jobListing.Jobs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
