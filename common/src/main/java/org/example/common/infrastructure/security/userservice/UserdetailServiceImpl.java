package org.example.common.infrastructure.security.userservice;

import org.example.common.interfaces.outbond.login.LoginUserVo;
import org.example.common.interfaces.outbond.login.UserVo;
import org.example.common.utils.CommonConstant;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * .
 *
 * @since 2024/6/5 23:57
 */
@Service
public class UserdetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserVo loginUserVo = new LoginUserVo();
        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        userVo.setPassword(CommonConstant.PASS_WORD);
        ArrayList<String> ls = new ArrayList<>();
        ls.add("/admin/logout");
        loginUserVo.setUserVo(userVo);
        loginUserVo.setPermissions(ls);
        return loginUserVo;
    }
}
