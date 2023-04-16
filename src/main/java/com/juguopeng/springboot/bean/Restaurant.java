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
public class Restaurant {
    private Integer resId;
    private String resName;
}
