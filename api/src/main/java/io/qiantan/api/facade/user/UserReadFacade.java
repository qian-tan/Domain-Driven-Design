package io.qiantan.api.facade.user;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.qiantan.api.bean.response.ApiResponse;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:48 PM
 */
public interface UserReadFacade {

    ApiResponse<BIConversion.User> findById();
}
