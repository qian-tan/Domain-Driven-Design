package io.qiantan.server.service.user;

import com.google.common.base.Throwables;
import io.qiantan.exception.ServiceException;
import io.qiantan.server.domain.model.User;
import io.qiantan.server.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: yujiacheng
 * @date: 2019/6/2211:52 PM
 */
@Service
@Slf4j
public class UserReadService {

    private final UserRepository userRepository;

    @Autowired
    public UserReadService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @param id 用户ID redis key: UserCache::findById{id}
     * @return  用户信息
     */
    @Cacheable(value = "UserCache", key = "methodName +#p0")
    public User findById(Long id) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("UserReadService findById id {} ", id);
            }
            Optional<User> byId = userRepository.findById(id);
            log.info("find user from db......");
            return byId.orElse(null);
        } catch (ServiceException e) {
            log.error("UserReadService findById id {}, cause : {}",
                    id, Throwables.getStackTraceAsString(e));
            throw new ServiceException(e.getMessage());
        } catch (Exception e) {
            log.error("UserReadService findById id {}, cause : {}",
                    id, Throwables.getStackTraceAsString(e));
            throw new ServiceException("未找到用户");
        }
    }
}
