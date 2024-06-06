package org.example.common.domain.service.impl;

import org.example.common.domain.service.UserBusService;
import org.example.common.interfaces.outbond.dto.BaseDto;
import org.example.common.interfaces.outbond.dto.LoginResultDto;
import org.example.common.interfaces.outbond.login.LoginUserVo;
import org.example.common.interfaces.outbond.login.UserVo;
import org.example.common.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @since 2024/6/5 23:31
 */
@Service
public class UserBusServiceImpl implements UserBusService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginResultDto login(UserVo userVO) {
        LoginResultDto loginResultDo = new LoginResultDto();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userVO.getUsername(),userVO.getPassword());
        Authentication authentication =authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(null==authentication){
            throw new RuntimeException("认证失败");
        }
        LoginUserVo loginUserVO = (LoginUserVo)authentication.getPrincipal();
        String username= loginUserVO.getUsername();
        //用登录账号生成token，把token传到请求方，作为下次访问的凭证
        loginResultDo.setToken(JWTUtil.createJWT(username));
        //loginUserVO 存在分布式缓存里，作
        return loginResultDo;
    }

    @Override
    public BaseDto logout(UserVo userVo) {
        return null;
    }
}
