package org.example.common.interfaces.outbond.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * .
 *
 * @since 2024/6/5 23:23
 */

@ApiModel("登录返回对象")
@Data
public class LoginResultDto  extends  BaseDto{

    @ApiModelProperty("认证通过的有效token")
    private String token;
}
