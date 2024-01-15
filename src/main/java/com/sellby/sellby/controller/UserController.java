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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.getUserResponseById(Integer.valueOf(id)));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.getUserByEmail(email));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
