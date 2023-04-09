package com.juguopeng.springboot.controller;

import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/insert")
    public String insertComment(@RequestBody Comment comment){
        commentService.insertComment(comment);
        return ("插入成功");
    }
}
