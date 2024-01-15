package com.sellby.sellby.service;

import com.sellby.sellby.config.JwtService;
import com.sellby.sellby.mapper.RegisterMapper;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.AuthenticationRequest;
import com.sellby.sellby.model.request.RegisterRequest;
import com.sellby.sellby.model.response.AuthenticationResponse;
import com.sellby.sellby.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RegisterMapper registerMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws Exception{
        User user = registerMapper.toEntity(request);
        User existingUser = userRepository.findUserByEmail(user.getEmail());
        if (existingUser != null){
            throw new Exception ("Email already in use");
        }
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findUserByEmail(request.getEmail());
        if (user == null){
            throw new Exception("Wrong credentials!");
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
