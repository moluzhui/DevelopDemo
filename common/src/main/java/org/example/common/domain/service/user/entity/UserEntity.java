package org.example.common.domain.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.example.common.base.BaseEntity;

/**
 * .
 *
 * @since 2024/6/18 23:52
 */

@Data
@TableName("sys_user_t")
public class UserEntity extends BaseEntity {

    /**
     * 用户登录名
     */
    private String username;

    /**
     * 用户登录名
     */
    private String password;

    /**
     * 0:男，1：女
     */
    private int sex;

    /**
     * 工号
     */
    private  String workId;

    /**
     * 邮箱
     */
    private  String email;
}
