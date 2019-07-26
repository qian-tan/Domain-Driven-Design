package io.qiantan.exception;

/**
 * @author: yujiacheng
 * @date: 2019/7/2610:36 AM
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -8595551090259111372L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
