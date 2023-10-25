package com.example.springbootmasterclass.client;

import com.example.springbootmasterclass.api.model.Post;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JSONPlaceHolderClient {

  @GetMapping("posts")
  List<Post> getPosts();

  @GetMapping("posts/{postId}")
  Post getPost(@PathVariable("postId") int postId);
}
