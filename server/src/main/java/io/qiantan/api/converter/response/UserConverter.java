package io.qiantan.api.converter.response;

import io.qiantan.api.bean.response.UserInfo;
import io.qiantan.server.domain.model.User;

/**
 * @author: yujiacheng
 * @date: 2019/6/231:47 PM
 */
public class UserConverter {

    public static UserInfo convertToUserInfo(User user) {
        return UserInfo.builder()
                .id(user.getId())
                .isDelete(user.getIsDelete().name())
                .name(user.getName())
                .createdAt(user.getCreatedAt().getTime())
                .updatedAt(user.getUpdatedAt().getTime())
                .build();
    }
}
