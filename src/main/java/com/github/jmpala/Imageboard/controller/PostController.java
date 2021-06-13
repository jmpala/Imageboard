package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.PostDto;
import com.github.jmpala.Imageboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/boards/{category}/{post}")
    public String showSelectedPost(@PathVariable("category") String category,
                                   @PathVariable("post") String post,
                                   Model model) {

        Optional<PostDto> oPostDto = postService.findById(Long.valueOf(post));
        model.addAttribute("post", oPostDto.get());

        return "post.html";
    }

}
