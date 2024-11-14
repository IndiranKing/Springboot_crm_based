package com.infosys_api.infosys_api.controller;

import com.infosys_api.infosys_api.payload.PostDto;
import com.infosys_api.infosys_api.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/api")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http:localhost:8080/posts/api
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){

        PostDto dto = postService.savePost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/posts/api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("The Post is Deleted",HttpStatus.OK);
    }

    //http://localhost:8080/posts/api/1
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        PostDto dto = postService.getPostById(id);

         return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //http://localhost:8080/posts/api/2
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto){
        PostDto dto = postService.updatePost(id, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
