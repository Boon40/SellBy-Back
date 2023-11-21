package com.sellby.sellby.model.response;

import com.sellby.sellby.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponse {
    private int id;
    private int rating;
    private String description;
    private UserResponse sender;
    private UserResponse receiver;
}
