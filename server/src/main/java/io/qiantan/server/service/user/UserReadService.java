package io.qiantan.server.service.user;

import io.qiantan.server.domain.model.User;
import io.qiantan.server.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User findById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        return null;
    }
}
