package com.sellby.sellby.model.response;

import com.sellby.sellby.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponse {
    private final int id;
    private final int rating;
    private final String description;
    private final UserResponse sender;
    private final UserResponse receiver;
}
