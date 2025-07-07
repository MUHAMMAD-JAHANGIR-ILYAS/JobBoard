package com.jobboard.service;

import com.jobboard.dto.JobDto;
import com.jobboard.model.Job;
import com.jobboard.model.User;
import com.jobboard.repository.JobRepository;
import com.jobboard.repository.UserRepository;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void triggerJobTable() {
        Job test = Job.builder()
                .title("Temp")
                .description("trigger")
                .location("test")
                .company("test")
                .salary("0")
                .build();
        jobRepository.save(test);
    }
    private JobDto mapToDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getCompany(),
                job.getSalary(),
                job.getPostedBy().getEmail() // or getUsername()
        );
    }

    // Create job (only recruiter)
    public JobDto createJob(Job job) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("✅ Auth name: " + auth.getName());
        System.out.println("✅ Authorities: " + auth.getAuthorities());

        // Force display all values from token
        auth.getAuthorities().forEach(a -> System.out.println("🔍 Authority = " + a.getAuthority()));

        String email = auth.getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        job.setPostedBy(recruiter);
        Job saved = jobRepository.save(job);
        return mapToDto(saved);
    }


    // Get all jobs
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // Get jobs posted by current recruiter
    public List<JobDto> getMyJobs() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return jobRepository.findByPostedByEmail(email)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // Delete job (ownership check to be added later)
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
