package com.github.jmpala.Imageboard.repository;

import com.github.jmpala.Imageboard.base.BaseRepository;
import com.github.jmpala.Imageboard.dao.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends BaseRepository<Post> {

    List<Post> findTop30ByOrderByCreatedDesc();

    @Query("SELECT p " +
            "FROM Post p " +
            "WHERE p.board = (SELECT b FROM Board b WHERE b.category = (SELECT c FROM Category c WHERE c.categoryName = :category))")
    List<Post> findByCategory(String category);
}
