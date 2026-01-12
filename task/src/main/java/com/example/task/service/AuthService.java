package com.example.task.service;

import com.example.task.domain.Role;
import com.example.task.domain.User;
import com.example.task.dto.request.LoginRequest;
import com.example.task.dto.request.RegisterRequest;
import com.example.task.dto.response.AuthResponse;
import com.example.task.exception.EmailAlreadyExistsException;
import com.example.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        User saved = userRepository.save(user);

        return new AuthResponse(
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return new AuthResponse(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
