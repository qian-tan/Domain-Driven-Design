package io.qiantan.api.bean;

import io.qiantan.utils.JsonUtil;

import java.io.Serializable;

/**
 * @author: yujiacheng
 * @date: 2019/7/2611:07 AM
 */
public class DomainBean implements Serializable {
    private static final long serialVersionUID = -24534576509971141L;

    public DomainBean() {
    }

    public String toString() {
        return JsonUtil.getIndentNonEmptyJsonString(this);
    }
}
