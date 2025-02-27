package org.example.common.infrastructure.security.hander;

import com.alibaba.fastjson.JSONObject;
import org.example.common.interfaces.outbond.dto.BaseDto;
import org.example.common.utils.WebResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * .
 *
 * @since 2024/6/6 23:46
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        BaseDto baseDto = new BaseDto();
        baseDto.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        baseDto.setMessage("无权限访问");
        WebResponseUtils.renderResponse(httpServletResponse, JSONObject.toJSONString(baseDto));
    }
}
