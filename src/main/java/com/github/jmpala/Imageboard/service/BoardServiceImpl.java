package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Board> findById(Long uuid) {
        return boardRepository.findById(uuid);
    }

    @Override
    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    @Transactional
    public void delete(Board board) {
        boardRepository.delete(board);
    }

    @Override
    @Transactional
    public void deleteById(Long uuid) {
        boardRepository.deleteById(uuid);
    }

    @Override
    @Transactional
    public List<Board> findByCategory(String category) {
        return boardRepository.findByCategory(category);
    }
}
