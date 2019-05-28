package io.qiantan.server.repository.impl.jpa.user;

import io.qiantan.server.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:37 PM
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
