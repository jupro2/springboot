package com.juguopeng.springboot.ServiceImpl;

import com.juguopeng.springboot.Service.BoothService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.mapper.BoothMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 风
 * @Date 2023 05 2023/5/21
 */
@Service
public class BoothServiceImpl implements BoothService {
    @Resource
    BoothMapper boothMapper;

    @Override
    public void updateCommentNum(Comment comment) {
        boothMapper.updateCommentNum(comment);
    }

    @Override
    public void updatePickNum(int pickNumber, int postId) {
        boothMapper.updatePickNum(pickNumber,postId);
    }
}
