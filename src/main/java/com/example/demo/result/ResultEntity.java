package com.example.demo.result;

import com.example.demo.Enum.ResultEnum;

/**
 * 全局请求返回实体类
 */
public class ResultEntity {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 数据
     */
    private Object data;

    public ResultEntity(){

    }

    public ResultEntity(Integer code,String errorMsg,Object data){
        this.code = code;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static ResultEntity success(Object data){
        ResultEntity resultEntity = new ResultEntity(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
        return resultEntity;
    }

    public static ResultEntity fail(ResultEnum resultEnum){
        ResultEntity resultEntity = new ResultEntity(resultEnum.getCode(), resultEnum.getMessage(), null);
        return resultEntity;
    }
}
