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
    private int id;
    private String email;
    private String number;
    private String first_name;
    private String last_name;
    private String country;
    private String city;
    private LocalDate createdDate;
}