package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.base.BaseService;
import com.github.jmpala.Imageboard.dto.PostDto;

import java.util.List;

public interface PostService extends BaseService<PostDto, Long> {

    List<PostDto> findLast30();
}
