package org.example.common.domain.service;

import org.example.common.interfaces.outbond.dto.BaseDto;
import org.example.common.interfaces.outbond.dto.LoginResultDto;
import org.example.common.interfaces.outbond.dto.ResultDto;
import org.example.common.interfaces.outbond.login.UserVo;

/**
 * .
 *
 * @since 2024/6/5 23:30
 */
public interface UserBusService {

    LoginResultDto login(UserVo userVo);

    BaseDto logout(UserVo userVo);
}
