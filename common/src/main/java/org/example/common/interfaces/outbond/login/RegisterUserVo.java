package org.example.common.interfaces.outbond.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * .
 *
 * @since 2024/6/6 23:07
 */
@Data
@ApiModel(value = "RegisterUserVo", description = "用户注册信息")
public class RegisterUserVo extends UserVo{

    @ApiModelProperty("性别: 0:男; 1:女")
    private int sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("工号")
    private String workId;
}
