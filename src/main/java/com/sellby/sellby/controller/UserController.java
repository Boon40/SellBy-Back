package com.sellby.sellby.controller;

import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.request.UserRequest;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.service.ProductService;
import com.sellby.sellby.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PostMapping
    public ResponseEntity<UserResponse> registerUser(
            @RequestBody @Valid UserRequest request
    ) {
        try {
            return ResponseEntity.ok(userService.registerUser(request));
        } catch (Exception e){
            //TODO send error to front end and display it
            System.out.println(e.getMessage());
            return null;
        }
    }
}
