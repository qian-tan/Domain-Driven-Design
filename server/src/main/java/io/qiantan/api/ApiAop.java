package io.qiantan.api;

import io.qiantan.api.bean.request.AbstractRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.exception.ApiException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author: yujiacheng
 * @date: 2019/7/2311:33 PM
 */
//@Aspect
//@Component
//@Order(0)
//@SuppressWarnings("unused")
public class ApiAop{

    @Pointcut(value = "within(io.qiantan.api.facade..*)")
    public void apiPointcut() {
    }

    @Around(value = "apiPointcut()")
    public Object doApi(ProceedingJoinPoint joinPoint) {

        try {
            if (!ObjectUtils.isEmpty(joinPoint.getArgs())
                    && joinPoint.getArgs()[0] instanceof AbstractRequest) {
//                return super.doApi(joinPoint);
                System.out.println("AbstractRequest...");
                return null;
            } else {

                return joinPoint.proceed();
            }
        } catch (ApiException apiException) {
            return ApiResponse.fail(apiException.getErrorMessage());
        } catch (Throwable throwable) {
            return ApiResponse.fail(throwable.getMessage());
        }
    }

}
