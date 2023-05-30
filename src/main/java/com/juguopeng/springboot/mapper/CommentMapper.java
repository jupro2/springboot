package com.juguopeng.springboot.mapper;

import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.dto.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertComment(Comment comment);



    @Select("SELECT id,content FROM comment")
    List<CommentVO> getComment();


}
