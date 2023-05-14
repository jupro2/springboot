package com.juguopeng.springboot.mapper;

import com.juguopeng.springboot.bean.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@Mapper
public interface CommentMapper {
    /**
     * @param comment
     */

    @Insert("INSERT INTO comment(id,userIp,postId,content,createdTime) VALUES (#{id},#{userIp},#{postId},#{content},#{createdTime})")
    void insertComment(Comment comment);


    @Select("SELECT content FROM comment")
    List<String> getComment();


}
