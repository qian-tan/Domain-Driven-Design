package io.qiantan.server.cache;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author: yujiacheng
 * @date: 2019/7/261:57 PM
 */
@Slf4j
@Component
public class LocalCache {

    private static LoadingCache<String, Optional<Object>> loadingCache = CacheBuilder
            .newBuilder()
            .maximumSize(100)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .removalListener(notification -> System.out.println("cache expired, remove key : " + notification.getKey()))
            .build(new CacheLoader<String, Optional<Object>>() {
                @Override
                public Optional<Object> load(String key) throws Exception {
                    return Optional.ofNullable(MockCache.loadFromPersistence(key));
                }
            });

    private static Object getByKey(String key) {
        try {
            return loadingCache.getUnchecked(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("LocalCache getByKey error ke {},cause {}", key, e);
        }
        return null;
    }

    static class MockCache {

        private static Map<String, Object> mockPersistence = new HashMap<String, Object>() {
            private static final long serialVersionUID = -7238467405866216903L;

            {
                this.put("mockKey", "mockValue");
            }
        };

        static Object loadFromPersistence(String key) {
            System.out.println("load key from persistence : " + key);
            return mockPersistence.get(key);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("first " + LocalCache.getByKey("mockKey"));
        Thread.sleep(2000);
        System.out.println("second " + LocalCache.getByKey("mockKey"));
        Thread.sleep(2000);
        System.out.println("third " + LocalCache.getByKey("mockKey"));
        Thread.sleep(2000);
        System.out.println("null " + LocalCache.getByKey("mockKey1"));
    }
}
