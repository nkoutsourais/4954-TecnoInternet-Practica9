package com.practica1.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.practica1.models.Comment;
import com.practica1.models.Post;

import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private static Map<Long, Post> posts = new HashMap<>();
    private final AtomicLong lastId;

    public BlogService() {
        this.lastId = new AtomicLong();
    }

    public Set<Entry<Long, Post>> getPosts() {
        return posts.entrySet();
    }

    public Post getPost(long postId) {
        return posts.get(postId);
    }

    public long addPost(Post post) {
        assert post != null;
        long id = lastId.incrementAndGet();
        posts.put(id, post);
        return id;
    }

    public long addComment(long postId, Comment comment) {
        Post post = getPost(postId);
        if(post != null) {
            return post.addComment(comment);
        }
        return -1;
    }

    public Comment removeComment(long postId, long commentId) {
        Post post = getPost(postId);
        if(post != null)
            return post.removeComment(commentId);
        return null;
    }
}