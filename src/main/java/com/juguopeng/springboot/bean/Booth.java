package com.juguopeng.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 风
 * @Date 2023 04 2023/4/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booth {

    /**
     * postId 展厅id
     * boothName 展厅名称
     */

    private Integer postId;
    private String boothName;
    private Integer floodNumber;
    private Integer contentNumber;
    private Integer pickNumber;
    private Integer resId;


}
