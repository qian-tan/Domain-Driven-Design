package io.qiantan.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yujiacheng
 * @date: 2019/7/2610:32 AM
 */
@Configuration
@ComponentScan(basePackages = {"io.qiantan.api.facade","io.qiantan.server"})
public class ServerConfiguration {
}
