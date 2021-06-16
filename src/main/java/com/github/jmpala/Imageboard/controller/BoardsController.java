package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.service.BoardService;
import com.github.jmpala.Imageboard.service.PostService;
import com.github.jmpala.Imageboard.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardsController {

    private CategoryService categoryService;
    private BoardService boardService;
    private PostService postService;

    @Autowired
    public BoardsController(BoardService boardService,
                            PostService postService,
                            CategoryService categoryService) {
        this.boardService = boardService;
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/board/index")
    public String showBoardsIndex(Model model) {
        model.addAttribute("boards",boardService.findAll());
        model.addAttribute("posts", postService.findLast30());
        return "boardsIndex.html";
    }

    @RequestMapping("/board/{category}")
    public String showSelectedBoard(@PathVariable("category") String category, Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("posts", postService.findByCategory(category));
        return "boardsIndex.html";
    }
}
