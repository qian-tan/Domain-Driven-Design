package io.qiantan.api.facade.user;

import com.alibaba.dubbo.config.annotation.Service;
import io.qiantan.api.bean.request.UserFindByIdRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.api.bean.response.UserInfo;
import io.qiantan.api.converter.response.UserConverter;
import io.qiantan.server.service.user.UserReadService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:48 PM
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class UserReadFacadeImpl implements UserReadFacade {

    private final UserReadService userReadService;

    @Autowired
    public UserReadFacadeImpl(UserReadService userReadService) {
        this.userReadService = userReadService;
    }

    @Override
    public ApiResponse<UserInfo> findById(UserFindByIdRequest findByIdRequest) {
        UserInfo userInfo = UserConverter.convertToUserInfo(userReadService.findById(findByIdRequest.getUserId()));
        return ApiResponse.ok(userInfo);
    }
}
