package org.example.common.infrastructure.security.filter;

import io.jsonwebtoken.Claims;
import org.example.common.interfaces.outbond.login.LoginUserVo;
import org.example.common.interfaces.outbond.login.UserVo;
import org.example.common.utils.CommonConstant;
import org.example.common.utils.JWTUtil;
import org.example.common.utils.StringUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JWT 认证过滤器
 *
 * @since 2024/6/6 0:34
 */
@Component
public class JWTSecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        checkToken(request,response,filterChain);
    }

    private void checkToken(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(CommonConstant.TOKEN_STR);
        if (!StringUtil.isEmpty(token)){
            Claims claims = JWTUtil.parseJWT(token);
            String username = claims.getSubject();
            // 去缓存中获取用户权限点信息
            // TODO: 临时代码，暂无缓存
            LoginUserVo loginUserVo = new LoginUserVo();
            UserVo userVo = new UserVo();
            userVo.setUsername(username);
            userVo.setPassword(username);
            ArrayList<String> ls = new ArrayList<>();
            ls.add("/admin/logout");
            ls.add("ROLE_admin");
            loginUserVo.setUserVo(userVo);
            loginUserVo.setPermissions(ls);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userVo,null,loginUserVo.getAuthorities());
            //上下文根
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request,response);
    }
}
