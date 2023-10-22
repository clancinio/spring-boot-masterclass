package com.example.springbootmasterclass.controller;

import com.example.springbootmasterclass.model.Post;
import com.example.springbootmasterclass.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @GetMapping
  public List<Post> getPosts() {
    return postService.getPosts();
  }
}
