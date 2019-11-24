package com.practica1.api;

import com.practica1.models.Comment;
import com.practica1.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentApiController {

    @Autowired
    BlogService blogService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Long newComment(@PathVariable long postId, @RequestBody Comment comment) {
        return blogService.AddComment(postId, comment);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment> newPost(@PathVariable long postId, @PathVariable long commentId) {
        Comment comment = blogService.removeComment(postId, commentId);
        if(comment == null)
            return (ResponseEntity<Comment>) ResponseEntity.notFound();
        return ResponseEntity.ok(comment);
    }
}