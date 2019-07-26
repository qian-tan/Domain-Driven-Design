package io.qiantan.server.service;

import io.qiantan.server.repository.UserRepository;
import io.qiantan.server.service.user.UserReadService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * @author yujiacheng
 * @date 2019/7/265:29 PM
 */
public class UserReadServiceTest extends AbstractServiceTest {

    @Configuration
    public static class MockitoBeans {

        @MockBean
        private UserRepository userRepository;
        @SpyBean
        private UserReadService userReadService;

    }

    protected Class<?> mockitoBeans() {
        return MockitoBeans.class;
    }

    private UserRepository userRepository;
    private UserReadService userReadService;

    protected void init() {
        userRepository = get(UserRepository.class);
        userReadService = get(UserReadService.class);
    }

    @Test
    public void findById() {
        when(userRepository.findById(any())).thenReturn(null);
        userReadService.findById(1L);
    }


}
