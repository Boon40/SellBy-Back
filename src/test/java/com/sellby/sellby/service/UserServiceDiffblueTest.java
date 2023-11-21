package com.sellby.sellby.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sellby.sellby.mapper.UserMapper;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.UserRequest;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.repository.UserRepository;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceDiffblueTest {
    @Mock
    private PasswordHasher passwordHasher;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        List<UserResponse> actualAllUsers = userService.getAllUsers();
        verify(userRepository).findAll();
        assertTrue(actualAllUsers.isEmpty());
    }

    /**
     * Method under test: {@link UserService#getUserById(int)}
     */
    @Test
    void testGetUserById() {
        User user = new User();
        user.setCity("Oxford");
        user.setCountry("GB");
        user.setCreatedDate(LocalDate.of(1970, 1, 1));
        user.setEmail("jane.doe@example.org");
        user.setFirst_name("Jane");
        user.setId(1);
        user.setLast_name("Doe");
        user.setNumber("42");
        user.setPassword_hash("Password hash");
        user.setProducts(new ArrayList<>());
        user.setReceivedComments(new ArrayList<>());
        user.setSendComments(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        User actualUserById = userService.getUserById(1);
        verify(userRepository).findById(Mockito.<Long>any());
        assertSame(user, actualUserById);
    }

    /**
     * Method under test: {@link UserService#registerUser(UserRequest)}
     */
    @Test
    void testRegisterUser() throws Exception {
        User user = new User();
        user.setCity("Oxford");
        user.setCountry("GB");
        user.setCreatedDate(LocalDate.of(1970, 1, 1));
        user.setEmail("jane.doe@example.org");
        user.setFirst_name("Jane");
        user.setId(1);
        user.setLast_name("Doe");
        user.setNumber("42");
        user.setPassword_hash("Password hash");
        user.setProducts(new ArrayList<>());
        user.setReceivedComments(new ArrayList<>());
        user.setSendComments(new ArrayList<>());
        when(userRepository.findUserByEmail(Mockito.<String>any())).thenReturn(user);
        assertThrows(Exception.class, () -> userService.registerUser(new UserRequest("jane.doe@example.org",
                "Password Hash", "42", "Jane", "Doe", "Password hash", "GB", "Oxford")));
        verify(userRepository).findUserByEmail(Mockito.<String>any());
    }
}

