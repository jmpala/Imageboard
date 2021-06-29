package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.service.BoardService;
import com.github.jmpala.Imageboard.service.PostService;
import com.github.jmpala.Imageboard.service.CategoryService;
import com.github.jmpala.Imageboard.service.user.UserService;
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

    private UserService userService;

    @Autowired
    public BoardsController(BoardService boardService,
                            PostService postService,
                            CategoryService categoryService,
                            UserService userService) {
        this.boardService = boardService;
        this.postService = postService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @RequestMapping("/board/index")
    public String showBoardsIndex(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("posts", postService.findLast30());
        userService.findAll();
        return "boardsIndex.html";
    }

    @RequestMapping("/board/{category}")
    public String showSelectedBoard(@PathVariable("category") String category, Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("posts", postService.findByCategory(category));
        return "boardsIndex.html";
    }
}
