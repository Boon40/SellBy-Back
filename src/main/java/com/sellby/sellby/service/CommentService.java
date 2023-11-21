package com.sellby.sellby.service;


import com.sellby.sellby.mapper.CommentMapper;
import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.CommentRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.CommentResponse;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.repository.CommentRepository;
import com.sellby.sellby.repository.ProductRepository;
import com.sellby.sellby.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    public List<CommentResponse> getAllComments(){
        return((List<Comment>) commentRepository.findAll())
                .stream()
                .map(commentMapper::toResponse)
                .toList();
    }

    public List<CommentResponse> getUserComments(int id){
        return((List<Comment>) commentRepository.getUserComments(userRepository.findById((long)id).orElseThrow()))
                .stream()
                .map(commentMapper::toResponse)
                .toList();
    }

    public float getAverageUserRating(int id){
        List<Comment> comments = commentRepository.getUserComments(userRepository.findById((long) id).orElseThrow());
        float ratingsSum = 0;
        for (Comment comment : comments){
            ratingsSum += comment.getRating();
        }
        return ratingsSum/comments.size();
    }

    public Comment getCommentById(int id){
        Optional<Comment> comment = commentRepository.findById((long) id);
        return comment.orElse(null);
    }

    public CommentResponse addComment(CommentRequest request){
        //request.setCreatedDate(LocalDate.now());
        final var comment = commentMapper.toEntity(request);
        final var savedComment = commentRepository.save(comment);

        return commentMapper.toResponse(savedComment);
    }

    public void deleteComment(int id){
        commentRepository.deleteById((long)id);
    }
}
