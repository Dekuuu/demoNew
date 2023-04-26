package com.example.demo.entity.result;

import com.example.demo.Enum.ResultEnum;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class ResultData<T> {
    /** 结果状态 ,具体状态码参见ResultData.java*/
    private int status;
    private String message;
    private T data;
    private String timestamp ;


    public ResultData (){
        this.timestamp = new DateTime(System.currentTimeMillis()).toString();
    }


    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultEnum.SUCCESS.getCode());
        resultData.setMessage(ResultEnum.SUCCESS.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }

}
