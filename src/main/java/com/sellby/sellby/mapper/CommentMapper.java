package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.CommentRequest;
import com.sellby.sellby.model.response.CommentResponse;
import com.sellby.sellby.service.CommentService;
import com.sellby.sellby.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {
    private final UserMapper userMapper;

    public CommentResponse toResponse(Comment comment){
        return new CommentResponse(
            comment.getId(),
            comment.getRating(),
            comment.getDescription(),
            userMapper.toResponse(comment.getSender()),
            userMapper.toResponse(comment.getReceiver())
        );
    }

    public Comment toEntity(CommentRequest request, User sender, User receiver){
        return Comment.builder()
                .rating(request.getRating())
                .description(request.getDescription())
                .sender(sender)
                .receiver(receiver)
                .build();
    }
}
