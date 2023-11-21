package com.sellby.sellby.model.request;

import com.sellby.sellby.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {

    @NotNull(message = "Rating is required")
    private int rating;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Sender is required")
    private int senderId;

    @NotNull(message = "Receiver is required")
    private int receiverId;
}
