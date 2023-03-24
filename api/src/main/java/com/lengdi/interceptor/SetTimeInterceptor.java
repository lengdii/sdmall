package com.lengdi.interceptor;

import com.lengdi.sdmall.vo.ResStatus;
import com.lengdi.sdmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Date:2023/03/06/ 22:09
 * Author:leng
 * Description:
 */
@Configuration
public class SetTimeInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (token != null){
            String s = stringRedisTemplate.boundValueOps(token).get();
            if (s != null){
                stringRedisTemplate.boundValueOps(token).expire(1, TimeUnit.MINUTES);
            }
        }
        return true;
    }
}
