package io.qiantan.exception;

/**
 * Description: Http 异常
 * User: xiao
 * Date: 25/05/2017
 */
public abstract class HttpException extends RuntimeException {

    private static final long serialVersionUID = -1099059403228887947L;

    public abstract String getCode();

    public abstract int getStatus();

    public abstract Object[] getArgs();
}
