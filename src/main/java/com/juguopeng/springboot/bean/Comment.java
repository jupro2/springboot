package com.juguopeng.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */

@Data
public class Comment {
    private Integer id;
    private Integer userIp;
    private Integer postId;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
}
