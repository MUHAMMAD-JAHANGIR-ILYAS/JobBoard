package com.jobboard.service;

import com.jobboard.model.Job;
import com.jobboard.model.User;
import com.jobboard.repository.JobRepository;
import com.jobboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;


import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    // Create job (only recruiter)
    public Job createJob(Job job) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("👤 Authenticated user: " + auth.getName());
        System.out.println("🔐 Roles/Authorities: " + auth.getAuthorities());

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        job.setPostedBy(recruiter);
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get jobs posted by current recruiter
    public List<Job> getMyJobs() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return jobRepository.findByPostedByEmail(email);
    }

    // Delete job (ownership check to be added later)
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
