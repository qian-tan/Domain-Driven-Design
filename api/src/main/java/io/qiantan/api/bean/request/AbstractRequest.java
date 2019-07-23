package io.qiantan.api.bean.request;

import io.qiantan.api.consts.operation.OperationType;
import io.qiantan.api.utils.ParamUtil;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: yujiacheng
 * @date: 2019/6/2312:28 AM
 */
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 5032085155609716770L;

    @ApiModelProperty(hidden = true)
    private String reqId;

    @ApiModelProperty(hidden = true)
    private String callerIp;

    @ApiModelProperty(hidden = true)
    private String callerType;

    @ApiModelProperty(hidden = true)
    private Integer tenantId;

    @ApiModelProperty(hidden = true)
    private Map<String, String> extra;

    @ApiModelProperty(hidden = true)
    public abstract OperationType getOperationType();

    public void checkParam() {
        ParamUtil.nonNull(this.getOperationType(), "操作类型不能为空");
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getCallerIp() {
        return this.callerIp;
    }

    public String getCallerType() {
        return this.callerType;
    }

    public Integer getTenantId() {
        return this.tenantId;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public void setCallerIp(String callerIp) {
        this.callerIp = callerIp;
    }

    public void setCallerType(String callerType) {
        this.callerType = callerType;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    public AbstractRequest() {
    }
}
