package com.example.demo.Enum;

/**
 *返回状态码枚举
 */
public enum ResultEnum {
    SUCCESS(200,"请求成功"),
    NOT_ACCESS(403,"无权限"),
    INTERNAL_ERROR(503,"系统异常"),
    NOT_EXIST(404,"路径不存在");

    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 定义code和message的获取方法，有时可能只是想取个码值
     * @return
     */
    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
