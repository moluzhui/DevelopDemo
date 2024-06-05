package org.example.common.interfaces.outbond.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * .
 *
 * @since 2024/6/4 23:43
 */

@Data
@ApiModel(value = "UserVo", description = "用户登录信息")
public class UserVo {
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;
}
