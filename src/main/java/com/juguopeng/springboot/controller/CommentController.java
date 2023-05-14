package com.juguopeng.springboot.controller;
import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.utlis.IPUtils;
import com.juguopeng.springboot.utlis.Result;
import com.juguopeng.springboot.utlis.ResultUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    /**
     *
     * @param comment
     * @param request
     * @return success
     * //TODO:当插入的时候，booth里面面的评论数加一；在BoothMapper中添加一个update来进行加一操作
     */
    @PostMapping("/insert")
    public Result insertComment(@RequestBody Comment comment, HttpServletRequest request){
        comment.setUserIp(IPUtils.getIpAddr(request));
        commentService.insertComment(comment);
        return ResultUtils.success(comment);
    }

    /**
     * @description 返回评论的数据
     * @return getComment
     */

    @GetMapping("/getComment")
    public Result getComment(){
        return ResultUtils.success(commentService.getComment());
    }





}
