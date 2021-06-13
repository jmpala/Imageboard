package com.github.jmpala.Imageboard.repository;

import com.github.jmpala.Imageboard.base.BaseRepository;
import com.github.jmpala.Imageboard.dao.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends BaseRepository<Board> {

    @Query("SELECT b FROM Board b WHERE LOWER(b.shortName) = LOWER(:category)")
    List<Board> findByCategory(@Param("category") String category);
}
