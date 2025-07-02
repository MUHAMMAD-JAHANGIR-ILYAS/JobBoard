package com.jobboard.dto;

import com.jobboard.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
