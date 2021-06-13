package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Comment;
import com.github.jmpala.Imageboard.dto.CommentDto;
import com.github.jmpala.Imageboard.mapper.CommentMapper;
import com.github.jmpala.Imageboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    @Transactional
    public List<CommentDto> findAll() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment: comments) {
            commentDtos.add(commentMapper.commentToCommentDto(comment));
        }
        return commentDtos;
    }

    @Override
    @Transactional
    public Optional<CommentDto> findById(Long id) {
        Optional<Comment> oComment = commentRepository.findById(id);
        if (oComment.isEmpty())
            return null; // TODO: see what to return to the controller
        CommentDto commentDto = commentMapper.commentToCommentDto(oComment.get());
        return Optional.of(commentDto);
    }

    @Override
    @Transactional
    public CommentDto save(CommentDto commentDto) {
        Comment savedComment = commentRepository.save(commentMapper.CommentDtoToComment(commentDto));
        return commentMapper.commentToCommentDto(savedComment);
    }

    @Override
    @Transactional
    public void delete(CommentDto commentDto) {
        commentRepository.delete(commentMapper.CommentDtoToComment(commentDto));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
