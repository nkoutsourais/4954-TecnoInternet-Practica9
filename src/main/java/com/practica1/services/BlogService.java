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
    private final AtomicLong lastId = new AtomicLong();

    long createNewId() {
        return lastId.incrementAndGet();
    }

    public Set<Entry<Long, Post>> getPosts() {
        return posts.entrySet();
    }

    public Post getPost(long postId) {
        return posts.get(postId);
    }

    public long AddPost(Post post) {
        assert post != null;
        long id = createNewId();
        posts.put(id, post);
        return id;
    }

    public long AddComment(long postId, Comment comment) {
        return posts.get(postId).AddComment(comment);
    }

    public Comment removeComment(long postId, long commentId) {
        return posts.get(postId).removeComment(commentId);
    }
}