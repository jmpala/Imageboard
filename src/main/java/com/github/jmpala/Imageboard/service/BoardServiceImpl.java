package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.dao.Category;
import com.github.jmpala.Imageboard.dto.BoardDto;
import com.github.jmpala.Imageboard.mapper.BoardMapper;
import com.github.jmpala.Imageboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;
    private Category category;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    @Transactional
    public List<BoardDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();
        for (Board board: boards) {
            boardDtos.add(boardMapper.boardToBoardDto(board));
        }
        return boardDtos;
    }

    @Override
    @Transactional
    public Optional<BoardDto> findById(Long id) {
        Optional<Board> oBoard = boardRepository.findById(id);
        if (oBoard.isEmpty())
            return null; // TODO: see what to return to the controller
        Optional<BoardDto> oBoardDto = Optional.of(boardMapper.boardToBoardDto(oBoard.get()));
        return oBoardDto;
    }

    @Override
    @Transactional
    public BoardDto save(BoardDto boardDto) {
        Board savedBoard = boardRepository.save(boardMapper.boardDtoToBoard(boardDto));
        return boardMapper.boardToBoardDto(savedBoard);
    }

    @Override
    @Transactional
    public void delete(BoardDto boardDto) {
        boardRepository.delete(boardMapper.boardDtoToBoard(boardDto));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}
