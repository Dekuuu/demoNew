package com.example.demo.handler;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.ResultData;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一接口返回规范
 *
 */
@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    // 由于有全局异常捕获器，直接抛出即可
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        /**
         *
         * 处理异常的情况，全局异常处理器会返回ResultData对象
         */
        if(object instanceof ResultData){
            return object;
        }
//        所以导致这个问题的原因就是，controller层中返回的类型是String，但是在ResponseBodyAdvice实现类中，我们把响应的类型修改成了ResultData。
//        这就导致了，上面的这段代码在选择处理MessageConverter的时候，依旧根据之前的String类型选择对应String类型的StringMessageConverter。
//        而在StringMessageConverter类型，他只接受String类型的返回类型，
//        我们在ResponseBodyAdvice中将返回值从String类型改成ResponseResult类型之后，调用StringMessageConverter方法发生类型强转。ResultData无法转换成String，发生类型转换异常。
        if(object instanceof  String){
            return JSON.toJSONString(ResultData.success(object));
        }
        return ResultData.success(object);
    }
}
