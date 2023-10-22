package com.example.springbootmasterclass.service;

import com.example.springbootmasterclass.client.JSONPlaceHolderClient;
import com.example.springbootmasterclass.model.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final JSONPlaceHolderClient jsonPlaceHolderClient;

  public List<Post> getPosts(){
    return jsonPlaceHolderClient.getPosts();
  }
}
