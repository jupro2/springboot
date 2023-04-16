package com.juguopeng.springboot.ServiceImpl;

import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 风
 * @Date 2023 04 2023/4/10
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public void insertComment(Comment comment)
    {
        commentMapper.insertComment(comment);
    }

}