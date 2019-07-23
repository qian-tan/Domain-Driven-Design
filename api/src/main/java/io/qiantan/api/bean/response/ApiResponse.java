package io.qiantan.api.bean.response;

import io.qiantan.api.bean.ApiBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:52 PM
 */
@ApiModel(description = "接口应答")
public class ApiResponse<T> extends ApiBean {

    private static final long serialVersionUID = -93458611220099900L;
    @ApiModelProperty("返回数据")
    private T data;

    public static <T> ApiResponse.ApiResponseBuilder<T> builder() {
        return new ApiResponse.ApiResponseBuilder();
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public static class ApiResponseBuilder<T> {
        private T data;

        ApiResponseBuilder() {
        }

        public ApiResponse.ApiResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<UserInfo> build() {
            return new ApiResponse(this.data);
        }

        public String toString() {
            return "ApiResponse.ApiResponseBuilder(data=" + this.data + ")";
        }
    }
}
