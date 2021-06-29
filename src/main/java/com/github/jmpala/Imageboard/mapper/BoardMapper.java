package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.BoardDto;
import com.github.jmpala.Imageboard.repository.PostRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class BoardMapper {

    @Autowired
    private PostRepository postRepository;

    public BoardDto boardToBoardDto(Board board) {
        if(board == null) {
            return null;
        }

        BoardDto boardDto = new BoardDto();

        boardDto.setId(board.getId());
        boardDto.setFullName(board.getFullName());
        boardDto.setShortName(board.getShortName());
        boardDto.setAvailable(board.isAvailable());
        boardDto.setNSFW(board.isNSFW());

        for (Post post: board.getPosts()) {
            boardDto.getPostsIds().add(post.getId());
        }

        return boardDto;
    }

    public Board boardDtoToBoard(BoardDto boardDto) {
        if(boardDto == null) {
            return null;
        }

        Board board = new Board();

        board.setId(boardDto.getId());
        board.setFullName(boardDto.getFullName());
        board.setShortName(boardDto.getShortName());
        board.setAvailable(boardDto.isAvailable());
        board.setNSFW(boardDto.isNSFW());

        for (Long id: boardDto.getPostsIds()) {
            Optional<Post> oPost = postRepository.findById(id);
            if(oPost.isEmpty()) {
                return null;
            }
            board.getPosts().add(oPost.get());
        }

        return board;
    }

}
