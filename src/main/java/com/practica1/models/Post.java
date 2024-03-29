package com.practica1.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonView;

public class Post {

    public interface Basic {}

    @JsonView(Basic.class)
    private final String title;
    private final String content;
    private final Map<Long, Comment> comments;
    private final AtomicLong lastId;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.comments = new HashMap<>();
        this.lastId = new AtomicLong();
    }

    public Set<Entry<Long, Comment>> getComments() {
        return comments.entrySet();
    }

    public long addComment(Comment comment) {
        assert comment != null;
        long commentId = lastId.incrementAndGet();
        this.comments.put(commentId, comment);
        return commentId;
    }

    public Comment removeComment(long commentId) {
        return this.comments.remove(commentId);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}