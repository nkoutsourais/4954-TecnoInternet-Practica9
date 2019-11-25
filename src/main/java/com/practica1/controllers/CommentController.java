package com.practica1.controllers;

import com.practica1.services.BlogService;
import com.practica1.models.Comment;
import com.practica1.models.Post;
import com.practica1.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    BlogService blogService;
    @Autowired
    User user;

    @PostMapping("/post/{postId}/comment/save")
    public String newComment(Model model, @PathVariable long postId, Comment comment) {
        if("".equals(user.getUserName()))
            user.setUserName(comment.getUserName());
        blogService.addComment(postId, comment);
        return addAttributes(model, postId);
    }

    @GetMapping("/post/{postId}/comment/{commentId}/delete")
    public String delComment(Model model, @PathVariable long postId, @PathVariable long commentId) {
        blogService.removeComment(postId, commentId);
        return addAttributes(model, postId);
    }

    private String addAttributes(Model model, long postId) {
        Post post = blogService.getPost(postId);
        model.addAttribute("post", post);
        model.addAttribute("usuario", user.getUserName());
        return "ver_post";
    }
}