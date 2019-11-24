package com.practica1.models;

public class Comment {

    private final String userName;
    private final String comment;

    public Comment(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String getUserName() {
        return userName;
    }    
}