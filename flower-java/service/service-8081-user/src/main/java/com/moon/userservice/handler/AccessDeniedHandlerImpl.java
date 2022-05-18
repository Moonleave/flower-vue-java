package com.moon.userservice.handler;

import com.alibaba.fastjson.JSON;
import com.moon.commonutils.R;
import com.moon.userservice.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String json = JSON.toJSONString(R.ok().code(HttpStatus.FORBIDDEN.value()).data("message","您的权限不足"));
        //处理异常
        WebUtils.renderString(response,json);
    }
}
