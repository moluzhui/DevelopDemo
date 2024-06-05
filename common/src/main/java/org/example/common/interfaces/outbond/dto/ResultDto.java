package org.example.common.interfaces.outbond.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * .
 *
 * @since 2024/6/4 23:46
 */
@Data
@ApiModel("返回的结果集")
public class ResultDto<T> extends BaseDto{

    @ApiModelProperty("返回的业务数据")
    private T data;

}
