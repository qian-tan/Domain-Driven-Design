package io.qiantan.constant;

/**
 * @author: yujiacheng
 * @date: 2019/5/2810:01 PM
 */
public interface ErrorCode {

    String name();

    String getCode();

    String getMessage();

    default String description() {
        return this.getCode() + '-' + this.getMessage();
    }
}
