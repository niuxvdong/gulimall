package com.itnxd.gulimall.product.exception;

import com.itnxd.common.exception.BizCodeEnume;
import com.itnxd.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.MethodValidationConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  集中处理所有异常！
 *  @ControllerAdvice+@ExceptionHandler
 *
 * @author ITNXD
 * @create 2021-12-13 18:26
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.itnxd.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){

        log.error("数据校验出现问题{}, 异常类型{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error("未知异常：{}", throwable);
        return R.error(BizCodeEnume.UNKONW_EXCEPTION.getCode(), BizCodeEnume.UNKONW_EXCEPTION.getMsg());
    }
}
