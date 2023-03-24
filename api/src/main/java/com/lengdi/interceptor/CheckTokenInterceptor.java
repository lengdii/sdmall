package com.lengdi.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lengdi.sdmall.vo.ResStatus;
import com.lengdi.sdmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * Date:2022/12/13/ 22:25
 * Author:leng
 * Description:
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        System.out.println("-------------"+token);
        if(token == null){
            ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录!", null);
            //提示请先登录
            doResponse(response,resultVO);
        }else{

            String s = stringRedisTemplate.boundValueOps(token).get();
            if (s == null){
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录!", null);
                doResponse(response,resultVO);
            }else {
                stringRedisTemplate.boundValueOps(token).expire(1, TimeUnit.MINUTES);
                return true;
            }



           /* try {
                //验证token
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("LENGdi6666");  //解析token的SigningKey必须和生成token时设置的密码一致
                //如果token正确(密码正确，有效期内)则正常运行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            }catch (ExpiredJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_OVERDUE, "登录过期，请重新登录!", null);
                doResponse(response,resultVO);
            }catch (UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "token不合法，请自重!", null);
                doResponse(response,resultVO);
            }catch (Exception e){
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录", null);
                doResponse(response,resultVO);
            }*/
        }
        return false;
    }

    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }

}
