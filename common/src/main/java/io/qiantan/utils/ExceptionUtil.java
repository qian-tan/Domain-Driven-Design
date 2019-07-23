package io.qiantan.utils;

import io.qiantan.exception.ApiException;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author: yujiacheng
 * @date: 2019/7/2311:35 PM
 */
public abstract class ExceptionUtil {

    private static final String PKG_PREFIX = "io.qiantan.";

    public ExceptionUtil() {
    }

    public static String getSimpleStackString(Throwable ex) {
        StringBuilder ret = new StringBuilder(512);
        ret.append(ex.getMessage()).append("\n");
        Arrays.stream(ex.getStackTrace()).filter((m) -> {
            return m.getClassName().startsWith("io.qiantan.");
        }).forEach((m) -> {
            ret.append(m.toString()).append("\n");
        });
        return ret.toString();
    }

    public static String getFullStackString(Throwable ex, String excpetionPoint) {
        StringBuilder fullStack = getFullStackStringBuilder(ex);
        fullStack.append("异常位置:").append(excpetionPoint).append("\n");
        return fullStack.toString();
    }

    public static String getFullStackString(Throwable ex) {
        StringBuilder ret = getFullStackStringBuilder(ex);
        return ret.toString();
    }

    private static StringBuilder getFullStackStringBuilder(Throwable ex) {
        StringBuilder ret = new StringBuilder(1024);
        if (ex instanceof UndeclaredThrowableException) {
            ret.append("接口超时：");
            hystrixException(ex, ret);
        } else {
            String message = ex.getMessage();
            if (message != null && message.contains("Hystrix circuit short-circuited and is OPEN")) {
                ret.append("接口熔断：");
                hystrixException(ex, ret);
            } else if (message != null && message.contains("JMS")) {
                ret.append("接口断连：");
                jmsException(ex, ret);
            } else {
                ret.append(message).append("\n");
                Arrays.stream(ex.getStackTrace()).forEach((m) -> {
                    ret.append(m.toString()).append("\n");
                });

                for(Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
                    ret.append("cause: ").append(cause.getMessage()).append("\n");
                    Arrays.stream(cause.getStackTrace()).forEach((m) -> {
                        ret.append(m.toString()).append("\n");
                    });
                }
            }
        }

        return ret;
    }

    private static void hystrixException(Throwable ex, StringBuilder ret) {
        StackTraceElement api = (StackTraceElement)Arrays.stream(ex.getStackTrace()).filter((m) -> {
            return m.getClassName().startsWith("io.qiantan.");
        }).filter((m) -> {
            return m.getClassName().contains(".adaptor.") && !m.getClassName().contains("BySpringCGLIB");
        }).findFirst().orElse((StackTraceElement) null);
        if (api != null) {
            ret.append(api.getClassName()).append(".").append(api.getMethodName());
        } else {
            ret.append("未知接口");
        }

    }

    private static void jmsException(Throwable ex, StringBuilder ret) {
        String message = ex.getMessage();
        if (message.contains("Reason:") && message.contains("broker")) {
            ret.append(message.substring(message.lastIndexOf("javax.jms.JMSException: ")));
        } else {
            for(Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
                message = ex.getMessage();
                if (message.contains("Reason:") && message.contains("broker")) {
                    ret.append(message.substring(message.lastIndexOf("javax.jms.JMSException: ")));
                    break;
                }
            }
        }

    }

    public static String getDetailErrorMessage(String basicErrorMessage, Throwable cause, Object... params) {
        StringBuilder message = new StringBuilder(512);
        message.append(basicErrorMessage);

        while(Objects.nonNull(cause)) {
            message.append("; cause-").append(getCauseErrorMessage(cause));
            cause = cause.getCause();
        }

        if (Objects.nonNull(params) && params.length > 0) {
            Object[] var4 = params;
            int var5 = params.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Object param = var4[var6];
                if (null != param) {
                    message.append("; param-").append(param.getClass().getSimpleName()).append(":").append(param);
                }
            }
        }

        return message.toString();
    }

    public static String getSimpleCauseErrorMessage(Throwable cause) {
        return getCauseErrorMessage(cause, false);
    }

    private static String getCauseErrorMessage(Throwable cause) {
        return getCauseErrorMessage(cause, true);
    }

    private static String getCauseErrorMessage(Throwable cause, boolean needDetail) {
        if (Objects.isNull(cause)) {
            return "";
        } else if (cause instanceof ApiException) {
            ApiException apiException = (ApiException)cause;
            return (needDetail ? (StringUtil.isNotBlank(apiException.getModuleCode()) ? apiException.getModuleCode() + "-" : "") + apiException.getErrorCode() + "-" : "") + apiException.getErrorMessage();
        } else {
            return cause.getClass().getSimpleName() + ":" + cause.getMessage();
        }
    }
}
