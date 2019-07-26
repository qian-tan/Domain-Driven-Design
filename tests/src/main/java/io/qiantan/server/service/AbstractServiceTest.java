package io.qiantan.server.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;


/**
 * @author yujiacheng
 * @date 2019/7/265:42 PM
 */
@Slf4j
public abstract class AbstractServiceTest {

    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    private List<Class<?>> beanList = Lists.newArrayList(PropertyPlaceholderAutoConfiguration.class);

    protected void addBean(Class<?> clazz) {
        ctx.register(clazz);
    }

    private void init() throws InvocationTargetException, IllegalAccessException {
        for (Method method : this.getClass().getMethods()) {
            try {
                if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                    ctx.getBean(method.getParameterTypes()[0]);
                    method.invoke(this, ctx.getBean(method.getParameterTypes()[0]));
                    log.info("Inject {} with {}", method.getName(), ctx.getBean(method.getParameterTypes()[0]));
                }
            } catch (BeansException e) {
                // ignore
            }
        }
    }

    private Class<?> mockitoBeans() {
        return null;
    }

    @Before
    public void setUp() throws Exception {

        injectYmlProperties(ctx, "application-test.yml");
        beanList.forEach(ctx::register);
        MockitoPostProcessor.register(ctx);
        ctx.register(mockitoBeans());
        ctx.refresh();
        init();
    }

    private static void injectYmlProperties(AnnotationConfigApplicationContext context, String yml) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(new ClassPathResource(yml));
        context.getEnvironment().getPropertySources()
                .addLast(new PropertiesPropertySource("ymlProperties", Objects.requireNonNull(factory.getObject())));
    }


    protected <T> T get(Class<T> t) {
        return ctx.getBean(t);
    }
}
