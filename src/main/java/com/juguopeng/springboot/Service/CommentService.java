package com.juguopeng.springboot.Service;

import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;
    public void insertComment(Comment comment){
        commentMapper.insertComment(comment);
    }

}
