package org.example.common.application.login;

import org.example.common.domain.service.UserBusService;
import org.example.common.interfaces.outbond.dto.LoginResultDto;
import org.example.common.interfaces.outbond.dto.ResultDto;
import org.example.common.interfaces.outbond.login.ILogin;
import org.example.common.interfaces.outbond.login.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * .
 *
 * @since 2024/6/4 23:24
 */
@RestController
@RequestMapping("/admin")
public class LoginControl implements ILogin {

    @Autowired
    private UserBusService userBusServiceImp;

    @Override
    @PostMapping("/login")
    public LoginResultDto login(@RequestBody UserVo userVo) {
        return userBusServiceImp.login(userVo);
    }

    @Override
    @GetMapping("/logout")
    public ResultDto<String> logout() {
        ResultDto<String> resultDto = new ResultDto<>();
        resultDto.setMessage("登出成功");
        return resultDto;
    }
}
