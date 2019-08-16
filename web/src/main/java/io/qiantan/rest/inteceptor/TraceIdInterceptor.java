package io.qiantan.rest.inteceptor;

import io.qiantan.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author yujiacheng
 * @date 2019/8/155:48 PM
 */
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TraceIdInterceptor... execute method preHandle()");
        String traceId = UUID.randomUUID().toString().replace("-", "");
        MDC.put(Constants.TRACE_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("TraceIdInterceptor... execute method postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(Constants.TRACE_ID);
        log.info("TraceIdInterceptor... execute method afterCompletion()");
    }

}
