package org.example.common.domain.service.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.common.domain.service.user.entity.UserEntity;

/**
 * .
 *
 * @since 2024/6/18 23:55
 */
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity findUserByName(String username);
}
