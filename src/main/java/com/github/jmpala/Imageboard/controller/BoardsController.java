package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.common.Mappings;
import com.github.jmpala.Imageboard.service.BoardService;
import com.github.jmpala.Imageboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardsController {

    private BoardService boardService;
    private PostService postService;

    @Autowired
    public BoardsController(BoardService boardService, PostService postService) {
        this.boardService = boardService;
        this.postService = postService;
    }

    @RequestMapping(Mappings.BOARDS_PATH)
    public String showBoardsIndex(Model model) {
        model.addAttribute("boards",boardService.findAll());
        model.addAttribute("posts", postService.findLast30());
        return "boardsindex.html";
    }
}
