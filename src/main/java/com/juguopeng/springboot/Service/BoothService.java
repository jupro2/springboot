package com.juguopeng.springboot.Service;

import com.juguopeng.springboot.bean.Comment;
import org.springframework.stereotype.Service;

/**
 * @author 风
 * @Date 2023 05 2023/5/21
 */
public interface BoothService {

    /**
     *
     * @param comment
     */
    void updateCommentNum(Comment comment);

    /**
     *
     * @param pickNumber 点赞数
     * @param postId  对应窗口ID
     * @description  进行点赞的更新
     */
    void updatePickNum(int pickNumber,int postId);
}
