package com.silence.auth.infrastructure.config;

import brave.baggage.BaggageFields;
import brave.baggage.CorrelationScopeConfig;
import brave.baggage.CorrelationScopeCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 为 Sleuth 配置类
 *
 * @author shanhy
 * @date 2021/4/7 13:37
 */
//@Configuration
public class SleuthConfiguration {

    /**
     * Sleuth 默认只将 traceId 和 spanId 添加进入了 MDC {@link brave.baggage.CorrelationScopeDecorator.Builder }
     * 我们需要将 parentId 输出到 logback 中，所以在这里自定义添加 parent 到MDC中
     * Sleuth 为我们提供了自定义扩展接口 CorrelationScopeCustomizer，实现它即可对 builder 进行操作
     *
     * @return
     */
    @Bean
    public CorrelationScopeCustomizer createCorrelationScopeCustomizer(){
        return builder -> builder.add(CorrelationScopeConfig.SingleCorrelationField.create(BaggageFields.PARENT_ID));
    }
}

