package com.juguopeng.springboot.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.juguopeng.springboot.Service.BoothService;
import com.juguopeng.springboot.bean.Booth;
import com.juguopeng.springboot.utlis.Result;
import com.juguopeng.springboot.utlis.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 风
 * @Date 2023 05 2023/5/28
 */
@RestController
@RequestMapping("/booth")
public class BoothController {
    @Autowired
    private BoothService boothService;

    /**
     * @description 通过postId进行评论的增加
     * @param jsonNode
     * @return
     */
    @PostMapping("/addPickNum")
    public Result addPickNum(@RequestBody JsonNode jsonNode) {

        int pickNumber = jsonNode.get("pickNumber").asInt();
        int postId = jsonNode.get("postId").asInt();
        boothService.updatePickNum(pickNumber, postId);
        return ResultUtils.success();
    }

    /**
     * @description 返回排行榜
     * @return
     */

    @GetMapping("/getRanking")
    public List<Booth> getPickNum() {
        return boothService.getRanking();
    }

}
