package com.sellby.sellby.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sellby.sellby.mapper.CommentMapper;
import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.CommentRequest;
import com.sellby.sellby.model.response.CommentResponse;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.repository.CommentRepository;
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
class CommentServiceDiffblueTest {
    @Mock
    private CommentMapper commentMapper;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @Mock
    private UserRepository userRepository;

    /**
     * Method under test: {@link CommentService#getAllComments()}
     */
    @Test
    void testGetAllComments() {
        when(commentRepository.findAll()).thenReturn(new ArrayList<>());
        List<CommentResponse> actualAllComments = commentService.getAllComments();
        verify(commentRepository).findAll();
        assertTrue(actualAllComments.isEmpty());
    }

    /**
     * Method under test: {@link CommentService#getUserComments(int)}
     */
    @Test
    void testGetUserComments() {
        when(commentRepository.getUserComments(Mockito.<User>any())).thenReturn(new ArrayList<>());

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
        List<CommentResponse> actualUserComments = commentService.getUserComments(1);
        verify(commentRepository).getUserComments(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        assertTrue(actualUserComments.isEmpty());
    }

    /**
     * Method under test: {@link CommentService#getAverageUserRating(int)}
     */
    @Test
    void testGetAverageUserRating() {
        when(commentRepository.getUserComments(Mockito.<User>any())).thenReturn(new ArrayList<>());

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
        float actualAverageUserRating = commentService.getAverageUserRating(1);
        verify(commentRepository).getUserComments(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        assertEquals(Float.NaN, actualAverageUserRating);
    }

    /**
     * Method under test: {@link CommentService#getAverageUserRating(int)}
     */
    @Test
    void testGetAverageUserRating2() {
        User receiver = new User();
        receiver.setCity("Oxford");
        receiver.setCountry("GB");
        receiver.setCreatedDate(LocalDate.of(1970, 1, 1));
        receiver.setEmail("jane.doe@example.org");
        receiver.setFirst_name("Jane");
        receiver.setId(1);
        receiver.setLast_name("Doe");
        receiver.setNumber("42");
        receiver.setPassword_hash("Password hash");
        receiver.setProducts(new ArrayList<>());
        receiver.setReceivedComments(new ArrayList<>());
        receiver.setSendComments(new ArrayList<>());

        User sender = new User();
        sender.setCity("Oxford");
        sender.setCountry("GB");
        sender.setCreatedDate(LocalDate.of(1970, 1, 1));
        sender.setEmail("jane.doe@example.org");
        sender.setFirst_name("Jane");
        sender.setId(1);
        sender.setLast_name("Doe");
        sender.setNumber("42");
        sender.setPassword_hash("Password hash");
        sender.setProducts(new ArrayList<>());
        sender.setReceivedComments(new ArrayList<>());
        sender.setSendComments(new ArrayList<>());

        Comment comment = new Comment();
        comment.setDescription("The characteristics of someone or something");
        comment.setId(1);
        comment.setRating(1);
        comment.setReceiver(receiver);
        comment.setSender(sender);

        ArrayList<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        when(commentRepository.getUserComments(Mockito.<User>any())).thenReturn(commentList);

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
        float actualAverageUserRating = commentService.getAverageUserRating(1);
        verify(commentRepository).getUserComments(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        assertEquals(1.0f, actualAverageUserRating);
    }

    /**
     * Method under test: {@link CommentService#getAverageUserRating(int)}
     */
    @Test
    void testGetAverageUserRating3() {
        User receiver = new User();
        receiver.setCity("Oxford");
        receiver.setCountry("GB");
        receiver.setCreatedDate(LocalDate.of(1970, 1, 1));
        receiver.setEmail("jane.doe@example.org");
        receiver.setFirst_name("Jane");
        receiver.setId(1);
        receiver.setLast_name("Doe");
        receiver.setNumber("42");
        receiver.setPassword_hash("Password hash");
        receiver.setProducts(new ArrayList<>());
        receiver.setReceivedComments(new ArrayList<>());
        receiver.setSendComments(new ArrayList<>());

        User sender = new User();
        sender.setCity("Oxford");
        sender.setCountry("GB");
        sender.setCreatedDate(LocalDate.of(1970, 1, 1));
        sender.setEmail("jane.doe@example.org");
        sender.setFirst_name("Jane");
        sender.setId(1);
        sender.setLast_name("Doe");
        sender.setNumber("42");
        sender.setPassword_hash("Password hash");
        sender.setProducts(new ArrayList<>());
        sender.setReceivedComments(new ArrayList<>());
        sender.setSendComments(new ArrayList<>());
        Comment comment = mock(Comment.class);
        when(comment.getRating()).thenReturn(1);
        doNothing().when(comment).setDescription(Mockito.<String>any());
        doNothing().when(comment).setId(anyInt());
        doNothing().when(comment).setRating(anyInt());
        doNothing().when(comment).setReceiver(Mockito.<User>any());
        doNothing().when(comment).setSender(Mockito.<User>any());
        comment.setDescription("The characteristics of someone or something");
        comment.setId(1);
        comment.setRating(1);
        comment.setReceiver(receiver);
        comment.setSender(sender);

        ArrayList<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        when(commentRepository.getUserComments(Mockito.<User>any())).thenReturn(commentList);

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
        float actualAverageUserRating = commentService.getAverageUserRating(1);
        verify(comment).getRating();
        verify(comment).setDescription(Mockito.<String>any());
        verify(comment).setId(anyInt());
        verify(comment).setRating(anyInt());
        verify(comment).setReceiver(Mockito.<User>any());
        verify(comment).setSender(Mockito.<User>any());
        verify(commentRepository).getUserComments(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        assertEquals(1.0f, actualAverageUserRating);
    }

    /**
     * Method under test: {@link CommentService#getCommentById(int)}
     */
    @Test
    void testGetCommentById() {
        User receiver = new User();
        receiver.setCity("Oxford");
        receiver.setCountry("GB");
        receiver.setCreatedDate(LocalDate.of(1970, 1, 1));
        receiver.setEmail("jane.doe@example.org");
        receiver.setFirst_name("Jane");
        receiver.setId(1);
        receiver.setLast_name("Doe");
        receiver.setNumber("42");
        receiver.setPassword_hash("Password hash");
        receiver.setProducts(new ArrayList<>());
        receiver.setReceivedComments(new ArrayList<>());
        receiver.setSendComments(new ArrayList<>());

        User sender = new User();
        sender.setCity("Oxford");
        sender.setCountry("GB");
        sender.setCreatedDate(LocalDate.of(1970, 1, 1));
        sender.setEmail("jane.doe@example.org");
        sender.setFirst_name("Jane");
        sender.setId(1);
        sender.setLast_name("Doe");
        sender.setNumber("42");
        sender.setPassword_hash("Password hash");
        sender.setProducts(new ArrayList<>());
        sender.setReceivedComments(new ArrayList<>());
        sender.setSendComments(new ArrayList<>());

        Comment comment = new Comment();
        comment.setDescription("The characteristics of someone or something");
        comment.setId(1);
        comment.setRating(1);
        comment.setReceiver(receiver);
        comment.setSender(sender);
        Optional<Comment> ofResult = Optional.of(comment);
        when(commentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Comment actualCommentById = commentService.getCommentById(1);
        verify(commentRepository).findById(Mockito.<Long>any());
        assertSame(comment, actualCommentById);
    }

    /**
     * Method under test: {@link CommentService#addComment(CommentRequest)}
     */
    @Test
    void testAddComment() {
        User receiver = new User();
        receiver.setCity("Oxford");
        receiver.setCountry("GB");
        receiver.setCreatedDate(LocalDate.of(1970, 1, 1));
        receiver.setEmail("jane.doe@example.org");
        receiver.setFirst_name("Jane");
        receiver.setId(1);
        receiver.setLast_name("Doe");
        receiver.setNumber("42");
        receiver.setPassword_hash("Password hash");
        receiver.setProducts(new ArrayList<>());
        receiver.setReceivedComments(new ArrayList<>());
        receiver.setSendComments(new ArrayList<>());

        User sender = new User();
        sender.setCity("Oxford");
        sender.setCountry("GB");
        sender.setCreatedDate(LocalDate.of(1970, 1, 1));
        sender.setEmail("jane.doe@example.org");
        sender.setFirst_name("Jane");
        sender.setId(1);
        sender.setLast_name("Doe");
        sender.setNumber("42");
        sender.setPassword_hash("Password hash");
        sender.setProducts(new ArrayList<>());
        sender.setReceivedComments(new ArrayList<>());
        sender.setSendComments(new ArrayList<>());

        Comment comment = new Comment();
        comment.setDescription("The characteristics of someone or something");
        comment.setId(1);
        comment.setRating(1);
        comment.setReceiver(receiver);
        comment.setSender(sender);
        when(commentRepository.save(Mockito.<Comment>any())).thenReturn(comment);

        User receiver2 = new User();
        receiver2.setCity("Oxford");
        receiver2.setCountry("GB");
        receiver2.setCreatedDate(LocalDate.of(1970, 1, 1));
        receiver2.setEmail("jane.doe@example.org");
        receiver2.setFirst_name("Jane");
        receiver2.setId(1);
        receiver2.setLast_name("Doe");
        receiver2.setNumber("42");
        receiver2.setPassword_hash("Password hash");
        receiver2.setProducts(new ArrayList<>());
        receiver2.setReceivedComments(new ArrayList<>());
        receiver2.setSendComments(new ArrayList<>());

        User sender2 = new User();
        sender2.setCity("Oxford");
        sender2.setCountry("GB");
        sender2.setCreatedDate(LocalDate.of(1970, 1, 1));
        sender2.setEmail("jane.doe@example.org");
        sender2.setFirst_name("Jane");
        sender2.setId(1);
        sender2.setLast_name("Doe");
        sender2.setNumber("42");
        sender2.setPassword_hash("Password hash");
        sender2.setProducts(new ArrayList<>());
        sender2.setReceivedComments(new ArrayList<>());
        sender2.setSendComments(new ArrayList<>());

        Comment comment2 = new Comment();
        comment2.setDescription("The characteristics of someone or something");
        comment2.setId(1);
        comment2.setRating(1);
        comment2.setReceiver(receiver2);
        comment2.setSender(sender2);
        when(commentMapper.toEntity(Mockito.<CommentRequest>any())).thenReturn(comment2);
        UserResponse sender3 = new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford",
                LocalDate.of(1970, 1, 1));

        CommentResponse commentResponse = new CommentResponse(1, 1, "The characteristics of someone or something", sender3,
                new UserResponse(1, "jane.doe@example.org", "42", "Jane", "Doe", "GB", "Oxford", LocalDate.of(1970, 1, 1)));

        when(commentMapper.toResponse(Mockito.<Comment>any())).thenReturn(commentResponse);
        CommentResponse actualAddCommentResult = commentService
                .addComment(new CommentRequest(1, "The characteristics of someone or something", 1, 1));
        verify(commentMapper).toEntity(Mockito.<CommentRequest>any());
        verify(commentMapper).toResponse(Mockito.<Comment>any());
        verify(commentRepository).save(Mockito.<Comment>any());
        assertSame(commentResponse, actualAddCommentResult);
    }

    /**
     * Method under test: {@link CommentService#deleteComment(int)}
     */
    @Test
    void testDeleteComment() {
        doNothing().when(commentRepository).deleteById(Mockito.<Long>any());
        commentService.deleteComment(1);
        verify(commentRepository).deleteById(Mockito.<Long>any());
    }
}

