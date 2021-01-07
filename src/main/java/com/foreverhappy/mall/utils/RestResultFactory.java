package com.foreverhappy.mall.utils;


import com.foreverhappy.mall.enums.ErrorCode;
import com.foreverhappy.mall.exception.EnumMessage;

/**
 * 返回对象工厂
 *
 * @param <T>
 */
public class RestResultFactory<T> {

    /**
     * 统一返回正确处理结果
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return restful result
     */
    public static <T> RestResult<T> success(T data) {
        return getResult(ErrorCode.SUCCESS, data);
    }

    /**
     * @param <T> 数据类型
     * @return restful result
     */
    public static <T> RestResult<T> success() {
        return success(null);
    }

    public static <T> RestResult<T> error(EnumMessage enumMessage) {
        return getResult(enumMessage, null);
    }

    public static <T> RestResult<T> error(Integer errCode, String errMsg) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(errCode);
        restResult.setMsg(errMsg);
        restResult.setData(null);
        return restResult;
    }
    
    public static <T> RestResult<T> error(EnumMessage enumMessage, String errMsg) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(enumMessage.getCode());
        restResult.setMsg(errMsg);
        restResult.setData(null);
        return restResult;
    }


    public static <T> RestResult<T> error(Integer errCode, T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(errCode);
        restResult.setData(data);
        return restResult;
    }

    public static <T> RestResult<T> sysError() {
        return getResult(ErrorCode.SYS_ERROR, null);
    }

    /**
     * 通用结果返回
     *
     * @param enumMessage 错误码
     * @param data        数据
     * @return restResult
     */
    private static <T> RestResult<T> getResult(EnumMessage enumMessage, T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(enumMessage.getCode());
        restResult.setMsg(enumMessage.getMsg());
        restResult.setData(data);
        return restResult;
    }

}
