package com.jobboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String company;
    private String salary;
    private String postedBy; // email or username of recruiter
}
