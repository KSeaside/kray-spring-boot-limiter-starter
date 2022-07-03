package com.kray.kraylimiter;

import com.kray.kraylimiter.model.UrlProperties;
import com.kray.kraylimiter.service.LimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UrlProperties.class)
@ConditionalOnClass(LimiterService.class)
@ConditionalOnProperty(prefix = "spring.kray", value = "enabled", matchIfMissing = true)
public class KrayServiceAutoConfiguration {

    @Autowired
    private UrlProperties properties;
    @Bean
    @ConditionalOnMissingBean(LimiterService.class)
    public LimiterService limiterService() {
        return new LimiterService(properties);
    }
}
