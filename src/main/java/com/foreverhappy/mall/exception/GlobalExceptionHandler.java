package com.foreverhappy.mall.exception;

import com.foreverhappy.mall.enums.ErrorCode;
import com.foreverhappy.mall.utils.RestResult;
import com.foreverhappy.mall.utils.RestResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private final HttpServletRequest request;

    public GlobalExceptionHandler(HttpServletRequest request) {
        this.request = request;
    }

    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult<?> handlerMyRuntimeException(CommonException ex) {
        log.error("request url:{},method:{},remote ip:{} throws exception:,errorCode：{}，errorMsg：{}", request.getRequestURI(),
                request.getMethod(), request.getRemoteAddr(), ex.getErrorCode(), ex.getErrorMsg());
        return RestResultFactory.error(ex.getErrorCode(), ex.getErrorMsg());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult<?> exceptionHandler(Exception e) {
        log.error("request url:{},method:{},remote ip:{} throws exception:{}", request.getRequestURI(),
                request.getMethod(), request.getRemoteAddr(), e);
        return RestResultFactory.error(ErrorCode.SYS_ERROR);
    }

}
