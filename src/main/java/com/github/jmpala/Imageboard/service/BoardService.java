package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.base.BaseService;
import com.github.jmpala.Imageboard.dao.Board;

import java.util.List;
import java.util.UUID;

public interface BoardService extends BaseService<Board, Long> {

    List<Board> findByCategory(String category);
}
