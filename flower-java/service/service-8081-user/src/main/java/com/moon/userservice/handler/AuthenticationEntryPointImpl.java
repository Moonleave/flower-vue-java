package com.moon.userservice.handler;

import com.alibaba.fastjson.JSON;
import com.moon.commonutils.R;
import com.moon.userservice.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String json = JSON.toJSONString(R.ok().code(HttpStatus.UNAUTHORIZED.value()).data("message","用户认证失败请查询登录"));
        //处理异常
        WebUtils.renderString(response,json);
    }
}
