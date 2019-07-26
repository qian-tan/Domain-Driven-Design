package io.qiantan.api.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.qiantan.api.consts.ResultType;

import java.util.Date;

/**
 * @author: yujiacheng
 * @date: 2019/7/2611:08 AM
 */
public class OperationLog extends DomainBean {
    private static final long serialVersionUID = 8334461696591536552L;
    private String id;
    private String entityId;
    private String sentMqId;
    @JsonFormat(
            pattern = "yyyy-MM-dd'T'HH:mm:ss.S",
            timezone = "GMT+8"
    )
    private Date startTime;
    @JsonFormat(
            pattern = "yyyy-MM-dd'T'HH:mm:ss.S",
            timezone = "GMT+8"
    )
    private Date endTime;
    private long costTimeMills;
    private String reqId;
    private String clientIp;
    private String clientType;
    private String callerIp;
    private String callerType;
    private String operationName;
    private boolean isWrite;
    private ResultType result;
    private String request;
    private String response;
    private String errorStack;
    private DomainBean ext;

    public void calcCostTimeMills() {
        this.endTime = new Date();
        this.costTimeMills = this.endTime.getTime() - this.startTime.getTime();
    }

    public static OperationLog.OperationLogBuilder builder() {
        return new OperationLog.OperationLogBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getSentMqId() {
        return this.sentMqId;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public long getCostTimeMills() {
        return this.costTimeMills;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getClientType() {
        return this.clientType;
    }

    public String getCallerIp() {
        return this.callerIp;
    }

    public String getCallerType() {
        return this.callerType;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public boolean isWrite() {
        return this.isWrite;
    }

    public ResultType getResult() {
        return this.result;
    }

    public String getRequest() {
        return this.request;
    }

    public String getResponse() {
        return this.response;
    }

    public String getErrorStack() {
        return this.errorStack;
    }

    public DomainBean getExt() {
        return this.ext;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public void setSentMqId(String sentMqId) {
        this.sentMqId = sentMqId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setCostTimeMills(long costTimeMills) {
        this.costTimeMills = costTimeMills;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setCallerIp(String callerIp) {
        this.callerIp = callerIp;
    }

    public void setCallerType(String callerType) {
        this.callerType = callerType;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setWrite(boolean isWrite) {
        this.isWrite = isWrite;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }

    public void setExt(DomainBean ext) {
        this.ext = ext;
    }

    public OperationLog() {
    }

    public OperationLog(String id, String entityId, String sentMqId, Date startTime, Date endTime, long costTimeMills, String reqId, String clientIp, String clientType, String callerIp, String callerType, String operationName, boolean isWrite, ResultType result, String request, String response, String errorStack, DomainBean ext) {
        this.id = id;
        this.entityId = entityId;
        this.sentMqId = sentMqId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.costTimeMills = costTimeMills;
        this.reqId = reqId;
        this.clientIp = clientIp;
        this.clientType = clientType;
        this.callerIp = callerIp;
        this.callerType = callerType;
        this.operationName = operationName;
        this.isWrite = isWrite;
        this.result = result;
        this.request = request;
        this.response = response;
        this.errorStack = errorStack;
        this.ext = ext;
    }

    public static class OperationLogBuilder {
        private String id;
        private String entityId;
        private String sentMqId;
        private Date startTime;
        private Date endTime;
        private long costTimeMills;
        private String reqId;
        private String clientIp;
        private String clientType;
        private String callerIp;
        private String callerType;
        private String operationName;
        private boolean isWrite;
        private ResultType result;
        private String request;
        private String response;
        private String errorStack;
        private DomainBean ext;

        OperationLogBuilder() {
        }

        public OperationLog.OperationLogBuilder id(String id) {
            this.id = id;
            return this;
        }

        public OperationLog.OperationLogBuilder entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        public OperationLog.OperationLogBuilder sentMqId(String sentMqId) {
            this.sentMqId = sentMqId;
            return this;
        }

        public OperationLog.OperationLogBuilder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public OperationLog.OperationLogBuilder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public OperationLog.OperationLogBuilder costTimeMills(long costTimeMills) {
            this.costTimeMills = costTimeMills;
            return this;
        }

        public OperationLog.OperationLogBuilder reqId(String reqId) {
            this.reqId = reqId;
            return this;
        }

        public OperationLog.OperationLogBuilder clientIp(String clientIp) {
            this.clientIp = clientIp;
            return this;
        }

        public OperationLog.OperationLogBuilder clientType(String clientType) {
            this.clientType = clientType;
            return this;
        }

        public OperationLog.OperationLogBuilder callerIp(String callerIp) {
            this.callerIp = callerIp;
            return this;
        }

        public OperationLog.OperationLogBuilder callerType(String callerType) {
            this.callerType = callerType;
            return this;
        }

        public OperationLog.OperationLogBuilder operationName(String operationName) {
            this.operationName = operationName;
            return this;
        }

        public OperationLog.OperationLogBuilder isWrite(boolean isWrite) {
            this.isWrite = isWrite;
            return this;
        }

        public OperationLog.OperationLogBuilder result(ResultType result) {
            this.result = result;
            return this;
        }

        public OperationLog.OperationLogBuilder request(String request) {
            this.request = request;
            return this;
        }

        public OperationLog.OperationLogBuilder response(String response) {
            this.response = response;
            return this;
        }

        public OperationLog.OperationLogBuilder errorStack(String errorStack) {
            this.errorStack = errorStack;
            return this;
        }

        public OperationLog.OperationLogBuilder ext(DomainBean ext) {
            this.ext = ext;
            return this;
        }

        public OperationLog build() {
            return new OperationLog(this.id, this.entityId, this.sentMqId, this.startTime, this.endTime, this.costTimeMills, this.reqId, this.clientIp, this.clientType, this.callerIp, this.callerType, this.operationName, this.isWrite, this.result, this.request, this.response, this.errorStack, this.ext);
        }

        public String toString() {
            return "OperationLog.OperationLogBuilder(id=" + this.id + ", entityId=" + this.entityId + ", sentMqId=" + this.sentMqId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", costTimeMills=" + this.costTimeMills + ", reqId=" + this.reqId + ", clientIp=" + this.clientIp + ", clientType=" + this.clientType + ", callerIp=" + this.callerIp + ", callerType=" + this.callerType + ", operationName=" + this.operationName + ", isWrite=" + this.isWrite + ", result=" + this.result + ", request=" + this.request + ", response=" + this.response + ", errorStack=" + this.errorStack + ", ext=" + this.ext + ")";
        }
    }
}

