package io.qiantan.exception;

import io.qiantan.constant.ErrorCode;
import io.qiantan.constant.ErrorType;

import java.util.Objects;

/**
 * @author: yujiacheng
 * @date: 2019/5/2810:02 PM
 */
public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 6681526750132863682L;
    private String moduleCode;
    private ErrorType errorType;
    private String errorCode;
    private String errorMessage;
    private String causeMessage;
    private String detailMessage;
    private Object[] params;

    public DomainException(ErrorCode code, Object... params) {
        this((ErrorCode)code, (Throwable)null, params);
    }

    public DomainException(String moduleCode, ErrorCode errorCode, Object... params) {
        this(moduleCode, errorCode, (Throwable)null, params);
    }

    public DomainException(ErrorCode errorCode, Throwable cause, Object... params) {
        this((String)null, errorCode, cause, params);
    }

    public DomainException(String moduleCode, ErrorCode errorCode, Throwable cause, Object... params) {
        this(moduleCode, errorCode, cause, ErrorType.SERVER_ERROR, params);
    }

    public DomainException(String moduleCode, ErrorCode errorCode, Throwable cause, ErrorType errorType, Object... params) {
        super(ExceptionUtil.getDetailErrorMessage(errorCode.toString(), cause, params));
        this.moduleCode = moduleCode;
        this.errorType = errorType;
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorCode.getMessage();
        this.causeMessage = this.causeErrorMessage(cause);
        this.detailMessage = this.getMessage();
        this.params = params;
    }

    private String causeErrorMessage(Throwable cause) {
        return Objects.nonNull(cause) ? ExceptionUtil.getSimpleCauseErrorMessage(cause) : "";
    }

    public String toString() {
        return JsonUtil.getIndentJsonString(this);
    }

    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    public String getModuleCode() {
        return this.moduleCode;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getCauseMessage() {
        return this.causeMessage;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public Object[] getParams() {
        return this.params;
    }
}
