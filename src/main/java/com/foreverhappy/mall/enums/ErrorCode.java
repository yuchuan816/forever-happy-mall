package com.foreverhappy.mall.enums;


import com.foreverhappy.mall.exception.EnumMessage;

public enum ErrorCode implements EnumMessage {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    SYS_ERROR(9999, "系统错误"),

    /**
     * 对于受保护的资源，禁止直接访问
     */
    FORBIDDEN(1000, "禁止访问"),

    /**
     * 缺少有效访问标识
     */
    UNAUTHORIZED(1001, "未授权"),

    MISSING_ACCESS_TOKEN(1002, "没有token"),

    INVALID_ACCESS_TOKEN(1003, "无效token"),

    EXPIRED_ACCESS_TOKEN(1004, "token已过期，请重新登录"),

    INVALID_USER(1005, "无效用户"),

    PARAM_ERROR(1006, "参数错误，参数校验失败"),


    //业务相关CODE
    SYSTEM_MAINTENANCE(1007, "系统维护时间，不可操作"),
    KPI_SERVICE_REQUEST_FAILED(1008, "KPI服务请求异常"),
    THIS_USER_HAS_BEEN_UPDATED(1009, "该用户已拉新"),
    PROHIBIT_EXPORT_TASKS(1010, "当前有导出任务在进行中,请稍后再试"),
    WECHAT_NAME_CANNOT_BE_EMPTY(1011, "微信号名称不能为空"),
    PHONE_NUMBER_CANNOT_BE_EMPTY(1012, "手机号不能为空"),
    MEANS_CANNOT_BE_EMPTY(1013, "手段不能为空");


    private Integer errorCode;
    private String errorMsg;

    ErrorCode(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public int getCode() {
        return this.errorCode;
    }

    @Override
    public String getMsg() {
        return this.errorMsg;
    }
}
