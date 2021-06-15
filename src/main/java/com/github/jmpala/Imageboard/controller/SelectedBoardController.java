package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.service.BoardServiceImpl;
import com.github.jmpala.Imageboard.service.CategoryServiceImpl;
import com.github.jmpala.Imageboard.service.CommentServiceImpl;
import com.github.jmpala.Imageboard.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectedBoardController {

    private BoardServiceImpl boardService;
    private PostServiceImpl threadService;
    private CommentServiceImpl postServiceImpl;
    private CategoryServiceImpl categoryService;

    @Autowired
    public SelectedBoardController(BoardServiceImpl boardService, PostServiceImpl threadService, CommentServiceImpl postServiceImpl) {
        this.boardService = boardService;
        this.threadService = threadService;
        this.postServiceImpl = postServiceImpl;
    }

    @RequestMapping("/boards/{category}")
    public String showSelectedBoard(@PathVariable("category") String category, Model model) {
        System.out.println(category);
        model.addAttribute("boards", boardService.findByCategory(category));
        return "board.html";
    }
}
