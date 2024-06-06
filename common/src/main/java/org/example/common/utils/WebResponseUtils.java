package org.example.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * .
 *
 * @since 2024/6/6 23:53
 */
public class WebResponseUtils {

    public  static  void renderResponse(HttpServletResponse httpServletResponse, String message) throws IOException {
        httpServletResponse.setStatus(CommonConstant.STATUS_SUCCESS);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().print(message);
    }
}
