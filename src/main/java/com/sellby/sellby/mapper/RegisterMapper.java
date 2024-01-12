package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Role;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.RegisterRequest;
import com.sellby.sellby.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RegisterMapper {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(RegisterRequest request){
        return User.builder()
                .email(request.getEmail())
                .number(request.getNumber())
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .password_hash(passwordEncoder.encode(request.getPassword()))
                .country(request.getCountry())
                .city(request.getCity())
                .createdDate(LocalDate.now())
                .role(Role.USER)
                .build();
    }
}
