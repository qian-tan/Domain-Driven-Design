package io.qiantan.server.repository;

import io.qiantan.server.domain.model.User;

import java.util.Optional;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:36 PM
 */
public interface UserRepository {

    void save(User user);

    Optional<User> findById(Long id);
}
