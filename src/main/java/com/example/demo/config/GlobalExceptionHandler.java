package com.example.demo.config;

import com.example.demo.Enum.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResultData customizeException(RuntimeException runtimeException){
        return ResultData.fail(ResultEnum.BUSSINESS_ERROR.getCode(),runtimeException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultData defaultException(Exception exception){
        return ResultData.fail(ResultEnum.INTERNAL_ERROR.getCode(),exception.getMessage());
    }
}
