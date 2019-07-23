package io.qiantan.api.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: yujiacheng
 * @date: 2019/6/2211:31 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户信息表")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1353272226710989849L;

    @ApiModelProperty(value = "ID", position = 1)
    private Long id;

    @ApiModelProperty(value = "用户名", position = 2)
    private String name;

    @ApiModelProperty(value = "状态标识位 YES NO", position = 3)
    private String isDelete;

    @ApiModelProperty(value = "创建时间", position = 4)
    private Long createdAt;

    @ApiModelProperty(value = "更新时间", position = 5)
    private Long updatedAt;
}
