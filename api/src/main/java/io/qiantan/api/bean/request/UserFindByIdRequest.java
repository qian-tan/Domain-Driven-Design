package io.qiantan.api.bean.request;

import io.qiantan.api.consts.operation.OperationType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yujiacheng
 * @date: 2019/6/2312:27 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "根据ID查找用户")
public class UserFindByIdRequest extends AbstractRequest {

    private static final long serialVersionUID = 6775326074118009149L;

    private Long userId;

    @Override
    public OperationType getOperationType() {
        return null;
    }
}
