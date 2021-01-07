package com.foreverhappy.mall.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结果
 *
 * @param <T>
 */
@Getter
@Setter
public class RestResult<T> {
    private Integer code;
    private String msg;
    private T data;
}
