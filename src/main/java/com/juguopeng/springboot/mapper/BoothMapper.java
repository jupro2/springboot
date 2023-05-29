package com.juguopeng.springboot.mapper;

import com.juguopeng.springboot.bean.Booth;
import com.juguopeng.springboot.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 风
 * @Date 2023 05 2023/5/17
 */

@Mapper
public interface BoothMapper {
    @Update("UPDATE booth SET contentNumber = contentNumber+1 where postId = #{postId}")
    void updateCommentNum(Comment comment);

    @Update("UPDATE booth SET pickNumber = pickNumber + #{pickNumber} where postId = #{postId}")
    void updatePickNum(int pickNumber,int postId);

    @Select("SELECT * FROM booth ORDER BY pickNumber DESC")
    List<Booth> getRanking();

}
