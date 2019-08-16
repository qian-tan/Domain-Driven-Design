package io.qiantan.rest.api;

import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.constant.Constants;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author yujiacheng
 * @date 2019/8/155:55 PM
 */
@RestControllerAdvice
public class ResponseModifyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ApiResponse) {
            // put traceId to response
            ((ApiResponse) o).setTraceId(MDC.get(Constants.TRACE_ID));
            return o;
        }
        return o;
    }
}
