package io.qiantan.api.bean.response;

import com.google.common.base.MoreObjects;
import io.qiantan.api.bean.ApiBean;
import io.swagger.annotations.ApiModel;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:52 PM
 */
@ApiModel(description = "接口应答")
public class ApiResponse<T> extends ApiBean {

    private boolean success; //调用是否成功
    private T result;       // 如果success = true,则通过result可以获得调用结果
    private String code;    // 错误码
    private String error;   // 如果success = false,则通过error可以查看错误信息
    private String sourceIp;    // 出问题的服务IP
    private String sourceStack;     // 问题堆栈

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean errorOf(String codeToCompare) {
        return Objects.equals(code, codeToCompare);
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceStack(String sourceStack) {
        this.sourceStack = sourceStack;
    }

    public String getSourceStack() {
        return sourceStack;
    }


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public void setError(String code, String error) {
        this.success = false;
        this.code = code;
        this.error = error;
    }

    public void setError(String code, String error, String sourceStack) {
        this.success = false;
        this.code = code;
        this.error = error;
        this.sourceStack = sourceStack;
    }



    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("success", success)
                .add("result", result)
                .add("code", code)
                .add("error", error)
                .add("sourceIp", sourceIp)
                .add("sourceStack", sourceStack)
                .omitNullValues()
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ApiResponse)) return false;
        ApiResponse other = (ApiResponse) o;
        if (!Objects.equals(this.success, other.success)) return false;
        if (!Objects.equals(this.result, other.result)) return false;
        if (!Objects.equals(this.code, other.code)) return false;
        if (!Objects.equals(this.error, other.error)) return false;
        if (!Objects.equals(this.sourceIp, other.sourceIp)) return false;
        if (!Objects.equals(this.sourceStack, other.sourceStack)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result*PRIME) + (this.success ? 1 : 0);
        result = (result*PRIME) + (this.result == null ? 0 : this.result.hashCode());
        result = (result*PRIME) + (this.code == null ? 0 : this.code.hashCode());
        result = (result*PRIME) + (this.error == null ? 0 : this.error.hashCode());
        result = (result*PRIME) + (this.sourceIp == null ? 0 : this.sourceIp.hashCode());
        result = (result*PRIME) + (this.sourceStack == null ? 0 : this.sourceStack.hashCode());
        return result;
    }


    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> resp = new ApiResponse<>();
        resp.setResult(data);
        return resp;
    }

    public static <T> ApiResponse<T> ok() {
        return ApiResponse.ok(null);
    }

    public static <T> ApiResponse<T> fail(String error) {
        ApiResponse<T> resp = new ApiResponse<>();
        resp.setError(error);
        return resp;
    }

    /**
     * usage: Response&lt;String&gt; resp = Response.get(() -> someDAO.getSomeStringResult(), "error.code")
     * <br>
     * 这个封装有个不太好的地方，无法打印出自定义错误日志……
     *
     * @param supplier lambda
     * @param errorCode error code
     * @param <T> anything
     * @return Response
     */
    public static <T> ApiResponse<T> get(Supplier<T> supplier, String errorCode) {
        try {
            T result = supplier.get();
            return ApiResponse.ok(result);
        } catch (Exception e) {
            return ApiResponse.fail(errorCode);
        }
    }

    public static <T> ApiResponse<T> fail(String code, String error) {
        ApiResponse<T> resp = new ApiResponse<>();
        resp.setError(code, error);
        return resp;
    }

    public static <T> ApiResponse<T> fail(String code, String error, String sourceStack) {
        ApiResponse<T> resp = new ApiResponse<>();
        resp.setError(code, error, sourceStack);
        return resp;
    }

    public ApiResponse<T> code(String code) {
        this.code = code;
        return this;
    }


    public ApiResponse<T> sourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    public ApiResponse<T> sourceStack(String sourceStack) {
        this.sourceStack = sourceStack;
        return this;
    }
}
