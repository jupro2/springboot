package com.juguopeng.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 风
 * @Date 2023 05 2023/5/30
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
    private Integer id;
    private String content;

}
