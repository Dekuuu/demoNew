package com.example.demo.config;

import com.example.demo.Enum.ResultEnum;
import com.example.demo.result.ResultEntity;
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
    public ResultEntity customizeException(){
        return ResultEntity.fail(ResultEnum.INTERNAL_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResultEntity defaultException(){
        return ResultEntity.fail(ResultEnum.NOT_ACCESS);
    }
}
