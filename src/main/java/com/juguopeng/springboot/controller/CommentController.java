package com.juguopeng.springboot.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.juguopeng.springboot.Service.BoothService;
import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.dto.CommentVO;
import com.juguopeng.springboot.utlis.IPUtils;
import com.juguopeng.springboot.utlis.Result;
import com.juguopeng.springboot.utlis.ResultEnum;
import com.juguopeng.springboot.utlis.ResultUtils;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
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
    @Resource
    private BoothService boothService;


    /**
     *
     * @param comment
     * @param request
     * @description 进行评论的插入功能
     */
    @PostMapping("/insert")
    public Result insertComment(@RequestBody Comment comment, HttpServletRequest request) {
        comment.setUserIp(IPUtils.getIpAddr(request));
        //测试postman使用
//        long timestamp = request.getDateHeader("Date");
//        Date sendTime = new Date(timestamp);

        if (containsSensitiveWord(comment.getContent())) {
            return ResultUtils.error(ResultEnum.SENSITIVE_DATA.getCode(), ResultEnum.SENSITIVE_DATA.getMsg());
        }
        if (StringUtils.isEmpty(comment.getContent())) {
            return ResultUtils.error(ResultEnum.DATA_IS_NULL.getCode(), ResultEnum.DATA_IS_NULL.getMsg());
        }

        int insertRes = commentService.insertComment(comment);
        if (insertRes > 0) {
            boothService.updateCommentNum(comment);
            return ResultUtils.success(comment);
        } else {
            return ResultUtils.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
    }


    /**
     * @description 返回评论
     * @return getComment
     */

    @GetMapping("/getComment")
    public List<CommentVO> getComment(){
        List<CommentVO> comment = commentService.getComment();
        for(CommentVO commentVO:comment)
            System.out.println(commentVO);
        return comment;
    }

    /**
     * @description 通过指定的窗口返回评论
     * @param jsonNode
     * @return List<CommentVO>
     */

    @GetMapping("/getCommentByBoothId")
    public List<CommentVO> getCommentByBoothId(@RequestBody JsonNode jsonNode){
        int boothId = jsonNode.get("boothId").asInt();
        List<CommentVO> comment = commentService.getCommentByPostId(boothId);
        for(CommentVO commentVO:comment) {
            System.out.println(commentVO);
        }
        return comment;
    }


    /**
     * @description 对关键词进行检查的方法
     * @param content
     * @return
     */
    private boolean containsSensitiveWord(String content) {
        return SensitiveWordHelper.contains(content);
    }






}
