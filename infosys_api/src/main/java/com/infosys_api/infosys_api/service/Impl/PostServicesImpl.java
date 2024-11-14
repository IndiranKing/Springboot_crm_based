package com.infosys_api.infosys_api.service.Impl;

import com.infosys_api.infosys_api.entity.Post;
import com.infosys_api.infosys_api.exception.ResourceNotFound;
import com.infosys_api.infosys_api.payload.PostDto;
import com.infosys_api.infosys_api.repository.PostRepository;
import com.infosys_api.infosys_api.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServicesImpl implements PostService {
    private PostRepository postRepository;

    public PostServicesImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedpost = postRepository.save(post);

        PostDto dto = mapToDto(savedpost);
        return dto;
    }

    @Override
    public void deletePost(long id) {

        postRepository.deleteById(id);

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("The post is not found with id : " + id) // lamda expresssion
        );
        PostDto Dto = mapToDto(post);
        return Dto;
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("The post is not found with id : " + id)
        );

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedpost = postRepository.save(post);

        PostDto dto = mapToDto(savedpost);
        return dto;
    }
}
