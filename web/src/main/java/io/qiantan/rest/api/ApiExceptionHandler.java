package io.qiantan.rest.api;

import io.qiantan.exception.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yujiacheng
 * @date: 2019/7/2611:02 AM
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * 处理http异常
     */
    @ExceptionHandler(HttpException.class)
    public void processValidationError(HttpException ex, HttpServletResponse response) throws IOException {
        String errorMessage;
        if (!StringUtils.isEmpty(ex.getMessage())) {
            errorMessage = ex.getMessage();
        } else {
            errorMessage = ex.getCode();
        }
        if (log.isDebugEnabled()) {
            log.debug("Handle a httpException(status:{}, message:{})", ex.getStatus(), errorMessage);
        }
        response.sendError(ex.getStatus(), errorMessage);
    }
}