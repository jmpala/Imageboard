package com.github.jmpala.Imageboard.controller;

import com.github.jmpala.Imageboard.common.Mappings;
import com.github.jmpala.Imageboard.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardsController {

    private BoardServiceImpl boardService;

    @Autowired
    public BoardsController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(Mappings.BOARDS_PATH)
    public String showBoardsIndex(Model model) {
        model.addAttribute("boards",boardService.findAll());
        return "boardsindex.html";
    }
}
