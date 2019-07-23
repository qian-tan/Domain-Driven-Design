package io.qiantan.rest.api;

import com.alibaba.dubbo.config.annotation.Reference;
import io.qiantan.api.bean.request.UserFindByIdRequest;
import io.qiantan.api.bean.response.ApiResponse;
import io.qiantan.api.bean.response.UserInfo;
import io.qiantan.api.facade.user.UserReadFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yujiacheng
 * @date: 2019/6/235:52 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
@Api(description = "标签管理")
public class UserApi {

    @Reference
    private UserReadFacade userReadFacade;

    @ApiOperation("根据使用率分页查询标签")
    @GetMapping("/get")
    public ApiResponse<UserInfo> getUserInfo(/*UserFindByIdRequest findByIdRequest*/) {
        return userReadFacade.findById(UserFindByIdRequest.builder().userId(1L).build());
    }
}
