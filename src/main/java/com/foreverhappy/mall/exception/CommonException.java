package com.foreverhappy.mall.exception;


import com.foreverhappy.mall.enums.ErrorCode;

/**
 * 通用的异常类
 **/
public class CommonException extends RuntimeException implements IException {
    private int code;
    private String errorMsg;

    public CommonException(int code){
        this(code, ErrorCode.SYS_ERROR.getMsg());
    }

    public CommonException(String errorMsg) {
        super(errorMsg);
        this.code = ErrorCode.SYS_ERROR.getCode();
        this.errorMsg = errorMsg;
    }

    public CommonException(int code,String errorMsg) {
        super(errorMsg);
        this.code = code;
        this.errorMsg = errorMsg;
    }
    
    public CommonException(EnumMessage enumMessage) {
    	super(enumMessage.getMsg());
        this.code = enumMessage.getCode();
        this.errorMsg = enumMessage.getMsg();
    }

    @Override
    public int getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
