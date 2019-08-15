package io.qiantan.api;

import io.qiantan.api.bean.request.AbstractRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * @author: yujiacheng
 * @date: 2019/7/2311:33 PM
 */
@Slf4j
@Aspect
@Component
@Order(0)
@SuppressWarnings("unused")
public class ApiAop{

    @Pointcut(value = "within(io.qiantan.api.facade..*)")
    public void apiPointcut() {
    }

    @Before("apiPointcut()")
    public void doApi(JoinPoint joinPoint) {
        try {
            if (!ObjectUtils.isEmpty(joinPoint.getArgs())
                    && joinPoint.getArgs()[0] instanceof AbstractRequest) {
                Object[] args = joinPoint.getArgs();
                log.info("The method [ {} ] begins with Parameters: {}", joinPoint.getSignature(), Arrays.toString(args));
            } else {
                log.error("find some error");
            }
        } catch (Throwable throwable) {
            log.error("find some error");
        }
    }

    @AfterReturning(value = "apiPointcut()", returning = "result")
    public void afterMethodReturn(JoinPoint joinPoint, Object result) {
        log.info("The method [ {} ] ends with Result: {}", joinPoint.getSignature(), result);
    }

}
