package com.example.task.dto.response;

import com.example.task.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {
    private Long id;
    private String email;
    private Role role;
}