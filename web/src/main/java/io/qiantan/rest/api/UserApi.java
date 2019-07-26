package io.qiantan.rest.api;

import com.alibaba.dubbo.config.annotation.Reference;
import io.qiantan.api.bean.request.UserFindByIdRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.api.bean.response.UserInfo;
import io.qiantan.api.facade.user.UserReadFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yujiacheng
 * @date: 2019/6/235:52 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
@Api(description = "用户管理")
public class UserApi {

    @Reference
    private UserReadFacade userReadFacade;

    @ApiOperation("根据ID查找用户")
    @PostMapping("/get")
    public ApiResponse<UserInfo> getUserInfo(@RequestBody UserFindByIdRequest findByIdRequest) {
        return userReadFacade.findById(findByIdRequest);
    }
}
