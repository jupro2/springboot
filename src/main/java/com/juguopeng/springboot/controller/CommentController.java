package com.juguopeng.springboot.controller;
import com.juguopeng.springboot.Service.BoothService;
import com.juguopeng.springboot.Service.CommentService;
import com.juguopeng.springboot.bean.Comment;
import com.juguopeng.springboot.utlis.IPUtils;
import com.juguopeng.springboot.utlis.Result;
import com.juguopeng.springboot.utlis.ResultEnum;
import com.juguopeng.springboot.utlis.ResultUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;


/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private BoothService boothService;
    /**
     *
     * @param comment
     * @param request
     * @return success
     */
    @PostMapping("/insert")
    public Result insertComment(@RequestBody Comment comment, HttpServletRequest request){
        comment.setUserIp(IPUtils.getIpAddr(request));
        try{
            int insertRes=commentService.insertComment(comment);
            if(insertRes>0){
                boothService.updateCommentNum(comment);
                return ResultUtils.success(comment);
            }else {
                return ResultUtils.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
            }
        }catch (DuplicateKeyException e) {
            return ResultUtils.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        } catch (Exception e){
            return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }


    /**
     * @description 返回评论的数据
     * @return getComment
     */

    @GetMapping("/getComment")
    public Result getComment(){
        return ResultUtils.success(commentService.getComment());
    }



}
