package io.qiantan.server.service.user;

import io.qiantan.server.domain.model.User;
import io.qiantan.server.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:44 PM
 */
@Service
@Slf4j
public class UserWriteService {

    private final UserRepository userRepository;

    @Autowired
    public UserWriteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User findById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        return null;
    }
}
