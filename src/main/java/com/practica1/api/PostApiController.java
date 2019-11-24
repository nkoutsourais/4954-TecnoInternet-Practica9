package com.practica1.api;

import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.practica1.models.Post;
import com.practica1.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostApiController {

    @Autowired
    BlogService blogService;

    @JsonView(Post.Basic.class)
    @GetMapping("/")
    public Set<Entry<Long, Post>> getAll() {
        return blogService.getPosts();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable long postId) {
        Post post = blogService.getPost(postId);
        if(post == null)
            return (ResponseEntity<Post>) ResponseEntity.notFound();
        return ResponseEntity.ok(post);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Long newPost(@RequestBody Post post) {
        return blogService.AddPost(post);
    }
}