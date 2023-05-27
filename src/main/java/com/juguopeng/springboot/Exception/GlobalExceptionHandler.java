package com.juguopeng.springboot.Exception;

import com.juguopeng.springboot.utlis.Result;
import com.juguopeng.springboot.utlis.ResultEnum;
import com.juguopeng.springboot.utlis.ResultUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 风
 * @Date 2023 05 2023/5/27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        if (e instanceof DuplicateKeyException) {
            return ResultUtils.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        } else {
            return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}
