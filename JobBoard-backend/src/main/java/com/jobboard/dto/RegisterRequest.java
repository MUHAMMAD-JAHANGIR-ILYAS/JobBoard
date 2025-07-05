package com.jobboard.dto;

import com.jobboard.model.Role;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    @Getter
    private String email;
    private String password;
    private Set<Role> roles;

}