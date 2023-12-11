package com.sellby.sellby.model.response;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserResponse {
    private final int id;
    private final String email;
    private final String number;
    private final String first_name;
    private final String last_name;
    private final String country;
    private final String city;
    private final LocalDate createdDate;
}