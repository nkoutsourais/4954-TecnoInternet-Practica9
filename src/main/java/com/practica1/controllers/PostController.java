package com.practica1.controllers;

import javax.servlet.http.HttpSession;

import com.practica1.services.BlogService;
import com.practica1.models.Post;
import com.practica1.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

  @Autowired
  BlogService blogService;
  @Autowired
  Usuario usuario;

  @GetMapping("/")
  public String tablon(Model model, HttpSession session) {
    model.addAttribute("posts", blogService.getPosts());
    return "blog";
  }

  @PostMapping("/post/save")
  public String nuevoPost(Model model, Post post) {
    blogService.AddPost(post);
    return "post_guardado";
  }

  @GetMapping("/post/new")
  public String nuevoPostForm(Model model) {
    return "nuevo_post";
  }

  @GetMapping("/post/{postId}")
  public String nuevoAnuncio(Model model, @PathVariable long postId) {
    Post post = blogService.getPost(postId);
    model.addAttribute("post", post);
    model.addAttribute("usuario", usuario.getNombre());
    return "ver_post";
  }
}