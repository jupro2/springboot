package com.juguopeng.springboot.utlis;

/**
 * @author 风
 * @Date 2023 04 2023/4/9
 */
public class Result<T> {
    /*响应码*/
    private int code;
    /*响应消息*/
    private String msg;
    /*流水号*/
    private String flowcode;
    /*数据单元*/
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }


    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }


}
