package org.example.common.domain.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.domain.service.user.UserService;
import org.example.common.domain.service.user.entity.UserEntity;
import org.example.common.domain.service.user.mapper.UserMapper;
import org.example.common.interfaces.outbond.dto.LoginResultDto;
import org.example.common.interfaces.outbond.login.LoginUserVo;
import org.example.common.interfaces.outbond.login.UserVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * .
 *
 * @since 2024/6/19 0:03
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public LoginUserVo queryUserByName(String name) {
        LoginUserVo loginUserVo = new LoginUserVo();
        UserEntity userEntity = super.baseMapper.findUserByName(name);
        UserVo userVo = new UserVo();
        userVo.setUsername(userEntity.getUsername());
        userVo.setPassword(userEntity.getPassword());
        loginUserVo.setUserVo(userVo);
        ArrayList<String> ls = new ArrayList<>();
        ls.add("/admin/logout");
        loginUserVo.setUserVo(userVo);
        loginUserVo.setPermissions(ls);
        return loginUserVo;
    }
}
