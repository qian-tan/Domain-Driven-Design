package io.qiantan.api.facade.user;

import io.qiantan.api.bean.request.UserFindByIdRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.api.bean.response.UserInfo;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:48 PM
 */
public interface UserReadFacade {

    ApiResponse<UserInfo> findById(UserFindByIdRequest findByIdRequest);
}
