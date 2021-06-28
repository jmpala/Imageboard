package com.github.jmpala.Imageboard.repository;

import com.github.jmpala.Imageboard.base.BaseRepository;
import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.dao.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends BaseRepository<Board> {

    List<Board> findBoardByCategory(Category category);
}
