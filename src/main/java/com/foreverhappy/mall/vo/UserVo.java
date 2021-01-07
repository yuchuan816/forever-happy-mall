package com.foreverhappy.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liuyuchuan
 * @date 2021/1/7
 */
@Getter
@Setter
public class UserVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nikeName;
}
