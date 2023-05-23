package com.juguopeng.springboot.mapper;

import com.juguopeng.springboot.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author 风
 * @Date 2023 05 2023/5/17
 */

@Mapper
public interface BoothMapper {
    @Update("UPDATE booth SET contentNumber = contentNumber+1 where postId = #{postId}")
    void updateCommentNum(Comment comment);
}
