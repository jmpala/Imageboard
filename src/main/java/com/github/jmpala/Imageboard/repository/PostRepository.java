package com.github.jmpala.Imageboard.repository;

import com.github.jmpala.Imageboard.base.BaseRepository;
import com.github.jmpala.Imageboard.dao.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends BaseRepository<Post> {

    List<Post> findTop30ByOrderByCreatedDesc();
}
