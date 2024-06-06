package org.example.common.interfaces.outbond.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.interfaces.outbond.dto.LoginResultDto;
import org.example.common.interfaces.outbond.dto.ResultDto;

/**
 * .
 *
 * @since 2024/6/4 23:23
 */
@Api("登录接口")
public interface ILogin {

    @ApiOperation("/admin/login")
    LoginResultDto login(UserVo userVo);

    @ApiOperation("/admin/logout")
    ResultDto<String> logout();

    @ApiOperation("/admin/addUser")
    ResultDto<String> addUser(RegisterUserVo registerUserVo);


}
