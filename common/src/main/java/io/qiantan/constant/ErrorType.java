package io.qiantan.constant;

/**
 * @author: yujiacheng
 * @date: 2019/5/2810:02 PM
 */
public enum ErrorType {

    SERVER_BUSY("server.busy", "服务器忙"),
    SERVER_ERROR("server.error", "服务端错误"),
    CLIENT_ERROR("client.error", "客户端错误");

    private String code;
    private String message;

    public String toString() {
        return this.code + ": " + this.message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
