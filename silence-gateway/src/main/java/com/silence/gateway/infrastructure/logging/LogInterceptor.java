package com.silence.gateway.infrastructure.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.sleuth.CurrentTraceContext;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.web.WebFluxSleuthOperators;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Component
public class LogInterceptor implements GlobalFilter, Ordered {

    private static final Log log = LogFactory.getLog(LogInterceptor.class);


    @Autowired
    private Tracer tracer;

    @Autowired
    private CurrentTraceContext currentTraceContext;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        WebFluxSleuthOperators.withSpanInScope(tracer, currentTraceContext, exchange, () -> log.error("TESTABCTEST"));
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
