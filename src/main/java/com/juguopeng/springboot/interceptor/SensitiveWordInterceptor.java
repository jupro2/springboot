package com.juguopeng.springboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 风
 * @Date 2023 05 2023/5/23
 */

@Component
public class SensitiveWordInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取评论内容
        String commentContent = request.getParameter("content");

        // 执行敏感词检查

        if (containsSensitiveWord(commentContent)) {
            // 如果评论包含敏感词，可以返回错误结果或做其他处理
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("Your comment contains sensitive words.");
            return false;
        }
        return true;
    }

    private boolean containsSensitiveWord(String commentContent) {
        return commentContent.contains("中国");
    }
}
