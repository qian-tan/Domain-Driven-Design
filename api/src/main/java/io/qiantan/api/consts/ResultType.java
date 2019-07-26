package io.qiantan.api.consts;

/**
 * @author: yujiacheng
 * @date: 2019/7/2611:10 AM
 */
public enum ResultType {
    OK("成功"),
    FAIL("失败"),
    REDIS_FAIL("Redis异常");

    private String type;

    public String getType() {
        return this.type;
    }

    private ResultType(String type) {
        this.type = type;
    }
}
