package com.sellby.sellby.controller;


import com.sellby.sellby.model.request.CommentRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.CommentResponse;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CommentResponse>> getUserComments(@PathVariable String id) {
        return ResponseEntity.ok(commentService.getUserComments(Integer.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> addComment(
            @RequestBody @Valid CommentRequest request
    ) {
        return ResponseEntity.ok(commentService.addComment(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.deleteComment(Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
