package org.example.common.domain.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.common.domain.service.user.entity.UserEntity;
import org.example.common.interfaces.outbond.login.LoginUserVo;

/**
 * .
 *
 * @since 2024/6/19 0:00
 */
public interface UserService extends IService<UserEntity> {
    LoginUserVo queryUserByName(String name);
}
