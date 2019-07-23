package io.qiantan.exception;

import io.qiantan.constant.ErrorCode;
import io.qiantan.constant.ErrorType;
import io.qiantan.utils.JsonUtil;

/**
 * @author: yujiacheng
 * @date: 2019/7/2311:36 PM
 */
public class ApiException extends Exception {
    private static long serialVersionUID = -8787516993124229948L;
    private String serviceType;
    private String moduleCode;
    private String errorType;
    private String errorCode;
    private String errorMessage;

    public ApiException(String serviceType, ErrorType errorType) {
        this(serviceType, errorType, errorType.getMessage());
    }

    public ApiException(String serviceType, DomainException de) {
        this(serviceType, de.getModuleCode(), de.getErrorType(), de.getErrorCode(), de.getErrorMessage());
    }

    public ApiException(String serviceType, ErrorType errorType, String errorMessage) {
        this(serviceType, (ErrorType)errorType, (String)null, (String)errorMessage);
    }

    public ApiException(String serviceType, ErrorType errorType, ErrorCode errorCode) {
        this(serviceType, (String)null, errorType, errorCode.getCode(), errorCode.getMessage());
    }

    public ApiException(String serviceType, ErrorType errorType, String errorCode, String errorMessage) {
        this(serviceType, (String)null, errorType, errorCode, errorMessage);
    }

    public ApiException(String serviceType, String moduleCode, ErrorType errorType, ErrorCode errorCode) {
        this(serviceType, moduleCode, errorType, errorCode.getCode(), errorCode.getMessage());
    }

    public ApiException(String serviceType, String moduleCode, ErrorType errorType, String errorCode, String errorMessage) {
        super(errorMessage);
        this.serviceType = null;
        if (serviceType != null) {
            this.serviceType = serviceType;
            this.moduleCode = moduleCode;
            this.errorType = errorType.getCode();
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

    public String toString() {
        return JsonUtil.getIndentJsonString(this);
    }

    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getModuleCode() {
        return this.moduleCode;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ApiException() {
        this.serviceType = null;
    }
}