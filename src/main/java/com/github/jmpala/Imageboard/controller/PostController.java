package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.dto.PostDto;
import com.github.jmpala.Imageboard.service.CategoryService;
import com.github.jmpala.Imageboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    private PostService postService;
    private CategoryService categoryService;

    @Autowired
    public PostController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/post/{post_id}")
    public String showSelectedPost(@PathVariable("post_id") String post_id,
                                   Model model) {

        Optional<PostDto> oPostDto = postService.findById(Long.valueOf(post_id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("post", oPostDto.get());
        return "post.html";
    }

    @GetMapping("/post/create")
    public String showCreatePost(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("postDto", new PostDto());
        return "createPost.html";
    }

    @PostMapping("/post/create")
    public String createPost(@ModelAttribute PostDto postDto, Model model){
        PostDto savePostDto = postService.save(postDto);
        return "redirect:/post/" + savePostDto.getId();
    }


}
