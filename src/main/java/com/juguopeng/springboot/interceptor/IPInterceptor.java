package com.juguopeng.springboot.interceptor;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.juguopeng.springboot.utlis.IPUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
/**
 * @author 风
 * @Date 2023 05 2023/5/28
 */
@Component
public class IPInterceptor implements HandlerInterceptor {

    private Cache<String, Long> ipCache;

    public IPInterceptor() {
        // 初始化缓存，设置过期时间为五分钟
        ipCache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = IPUtils.getIpAddr(request);

        // 检查缓存中是否存在该 IP 地址的记录
        Long lastRequestTime = ipCache.getIfPresent(ip);

        if (lastRequestTime != null) {
            // 计算距离上次请求的时间间隔
            long elapsedTime = System.currentTimeMillis() - lastRequestTime;

            if (elapsedTime < TimeUnit.MINUTES.toMillis(5)) {
                // 如果时间间隔不足五分钟，则认为是重复请求，进行拦截
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.getWriter().write("Too many requests, please try again later in five minutes.");
                return false;
            }
        }

        // 更新缓存中的时间戳
        ipCache.put(ip, System.currentTimeMillis());
        return true;
    }
}
