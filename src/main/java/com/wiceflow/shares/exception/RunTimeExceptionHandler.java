package com.wiceflow.shares.exception;


import com.wiceflow.shares.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;

/**
 * @author BF
 * @date 2022/6/19
 */

@Slf4j
@RestControllerAdvice
public class RunTimeExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleRRException(ServiceException e){
        log.error("异常统一管理处打印异常信息：" + e.getMessage());
        if (e.getCode() != 500){
            return AjaxResult.customResponse(e.getCode(),e.getMessage(),null);
        }
        return AjaxResult.errorResponse(e.getMsg());
    }

    /**
     * 参数校验异常统一打印
     * @param e  ConstraintViolationException 异常
     * @return   AjaxResult
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public AjaxResult handleConstraintViolationException(ConstraintViolationException e){
        String message = e.getConstraintViolations().iterator().next().getMessage();
        log.error("检验异常打印：{}",message);
        return AjaxResult.customResponse(403,message);
    }

    /**
     * 参数校验异常统一打印
     * <p> 针对 RequestBody 内的参数 </p>
     * @param exception  MethodArgumentNotValidException 异常
     * @return           AjaxResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        FieldError fieldError = exception.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error("检验异常打印：{}",fieldError.getField() + ":" + fieldError.getDefaultMessage());
        return AjaxResult.customResponse(403,fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e){
        // 控制台打印错误信息
        e.printStackTrace();
        return AjaxResult.errorResponse(e.getMessage());
    }

}
