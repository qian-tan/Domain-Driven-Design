package io.qiantan.server.repository.impl;

import io.qiantan.server.domain.model.User;
import io.qiantan.server.repository.UserRepository;
import io.qiantan.server.repository.impl.jpa.user.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:40 PM
 */
@Repository
public class UserRepositoryJpaImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserRepositoryJpaImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id);
    }
}
