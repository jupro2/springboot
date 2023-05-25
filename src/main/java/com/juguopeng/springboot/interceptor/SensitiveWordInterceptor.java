package com.juguopeng.springboot.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;

import com.juguopeng.springboot.bean.Comment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;

/**
 * @author 风
 * @Date 2023 05 2023/5/23
 */

@Component
public class SensitiveWordInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveWordInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在处理请求之前进行拦截操作
        // 获取评论内容
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        Comment data = objectMapper.readValue(json, Comment.class);
        String content = data.getContent();
        System.out.println("test" + content);

        // 进行关键词过滤，可以使用自定义的敏感词过滤工具类或库
        boolean containsSensitiveWord = containsSensitiveWord(content);

        // 如果评论内容包含敏感词，则阻止请求继续处理，并返回错误信息
        if (containsSensitiveWord) {
            response.getWriter().write("You comment have worn word,please got it");
            return false;
        }

        // 评论内容没有敏感词，允许请求继续处理
        return true;
    }


        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            // 在完成整个请求后进行拦截操作，可以进行资源清理等操作
        }


    private boolean containsSensitiveWord(String content) {
        return SensitiveWordHelper.contains(content);
    }

}


