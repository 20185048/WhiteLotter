package com.example.springwork.config;
import com.example.springwork.util.ResultJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultException {
    @ExceptionHandler
    public ResultJson defaultExceptionHandler(Exception ex){
        ex.printStackTrace();//控制台输出异常
        return ResultJson.error(ex.getMessage());
    }
}
