package com.juguopeng.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;
    private String userIp;
    private Integer postId;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
}
