package com.juguopeng.springboot.ServiceImpl;

import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.dto.CommentVO;
import com.juguopeng.springboot.mapper.CommentMapper;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 风
 * @Date 2023 04 2023/4/10
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public int insertComment(Comment comment)
    {
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<CommentVO> getComment()
    {
        return commentMapper.getComment();
    }


}