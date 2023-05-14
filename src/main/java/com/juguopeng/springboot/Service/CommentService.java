package com.juguopeng.springboot.Service;

import com.juguopeng.springboot.bean.Comment;

import java.util.List;

/**
 * @author 风
 * @Date 2023 04 2023/4/10
 */
public interface CommentService {

    /**
     * @description 插入评论
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * @description  获取评论
     * @return comment
     */
    List<String> getComment();
}
