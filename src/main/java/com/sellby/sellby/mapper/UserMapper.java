package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.request.UserRequest;
import com.sellby.sellby.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserResponse toResponse(User user){
        return new UserResponse(
            user.getId(),
            user.getEmail(),
            user.getNumber(),
            user.getFirst_name(),
            user.getLast_name(),
            user.getCountry(),
            user.getCity(),
            user.getCreatedDate()
        );
    }

    public User toEntity(UserRequest request){
        return User.builder()
                .email(request.getEmail())
                .number(request.getNumber())
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .password_hash(request.getPassword_hash())
                .country(request.getCountry())
                .city(request.getCity())
                .createdDate(LocalDate.now())
                .build();
    }

}
