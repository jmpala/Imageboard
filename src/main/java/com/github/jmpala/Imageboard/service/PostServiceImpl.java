package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.dao.Category;
import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.PostDto;
import com.github.jmpala.Imageboard.mapper.BoardMapper;
import com.github.jmpala.Imageboard.mapper.PostMapper;
import com.github.jmpala.Imageboard.repository.BoardRepository;
import com.github.jmpala.Imageboard.repository.CategoryRepository;
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
    private BoardRepository boardRepository;
    private PostMapper postMapper;
    private BoardMapper boardMapper;
    private CategoryRepository categoryRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, BoardRepository boardRepository,
                           PostMapper postMapper, BoardMapper boardMapper, CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.boardMapper = boardMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post: posts) {
            PostDto postDto = postMapper.postToPostDto(post);
            postDto.setBoardDto(boardMapper.boardToBoardDto(post.getBoard()));
            postDto.setBoardId(post.getBoard().getId());
            postDtos.add(postDto);
        }
        return postDtos;
    }

    @Override
    @Transactional
    public Optional<PostDto> findById(Long id) {
        Optional<Post> oPost = postRepository.findById(id);
        if (oPost.isEmpty())
            return null; // TODO: see what to return to the controller
        PostDto postDto = postMapper.postToPostDto(oPost.get());
        postDto.setBoardDto(boardMapper.boardToBoardDto(oPost.get().getBoard()));
        postDto.setBoardId(oPost.get().getBoard().getId());
        return Optional.of(postDto);
    }

    @Override
    @Transactional
    public PostDto save(PostDto postDto) {
        Post postDao = postMapper.postDtoToPost(postDto);
        Category category = categoryRepository.findById(postDto.getBoardId()).get();
        List<Board> boards = boardRepository.findBoardByCategory(category);
        Board board = boards.get(0);
        postDao.setBoard(board);
        Post savedPost = postRepository.save(postDao);
        return postMapper.postToPostDto(savedPost);
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
            PostDto postDto = postMapper.postToPostDto(post);
            postDto.setBoardDto(boardMapper.boardToBoardDto(post.getBoard()));
            postDto.setId(post.getId());
            postDtos.add(postDto);
        }
        return postDtos;
    }

    @Override
    @Transactional
    public List<PostDto> findByCategory(String category) {
        List<Post> posts = postRepository.findByCategory(category);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post: posts) {
            PostDto postDto = postMapper.postToPostDto(post);
            postDto.setBoardDto(boardMapper.boardToBoardDto(post.getBoard()));
            postDto.setId(post.getId());
            postDtos.add(postDto);
        }
        return postDtos;
    }
}
