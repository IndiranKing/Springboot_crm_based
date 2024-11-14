package com.infosys_api.infosys_api.service;

import com.infosys_api.infosys_api.payload.PostDto;

public interface PostService {

    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    PostDto getPostById(long id);

    PostDto updatePost(long id, PostDto postDto);
}
