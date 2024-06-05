package org.example.common.interfaces.outbond.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * .
 *
 * @since 2024/6/4 23:45
 */
@Data
@ApiModel(value = "请求返回基本信息")
public class BaseDto {
    @ApiModelProperty("返回状态码")
    private int code = 200;

    @ApiModelProperty("返回状态消息")
    private String message = "success";
}
