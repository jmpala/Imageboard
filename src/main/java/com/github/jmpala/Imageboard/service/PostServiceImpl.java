package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.PostDto;
import com.github.jmpala.Imageboard.mapper.PostMapper;
import com.github.jmpala.Imageboard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    @Transactional
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post: posts) {
            postDtos.add(postMapper.postToPostDto(post));
        }
        return postDtos;
    }

    @Override
    @Transactional
    public Optional<PostDto> findById(Long id) {
        Optional<Post> oPost = postRepository.findById(id);
        if (oPost.isEmpty())
            return null; // TODO: see what to return to the controller
        return Optional.of(postMapper.postToPostDto(oPost.get()));
    }

    @Override
    @Transactional
    public PostDto save(PostDto postDto) {
        return postMapper.postToPostDto(postMapper.postDtoToPost(postDto));
    }

    @Override
    @Transactional
    public void delete(PostDto postDto) {
        postRepository.delete(postMapper.postDtoToPost(postDto));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> findLast30() {
        List<Post> posts = postRepository.findTop30ByOrderByCreatedDesc();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post: posts) {
            postDtos.add(postMapper.postToPostDto(post));
        }
        return postDtos;
    }

    @Override
    @Transactional
    public List<PostDto> findByCategory(String category) {
        List<Post> posts = postRepository.findByCategory(category);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post: posts) {
            postDtos.add(postMapper.postToPostDto(post));
        }
        return postDtos;
    }
}
