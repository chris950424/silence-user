//package com.silence.gateway.infrastructure.util.logging;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
//import org.springframework.core.Ordered;
//
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
///**
// * @author fengjianbo
// * @since 2020/12/8
// */
//@Component
//@Slf4j
//public class CustomizeTraceFilter implements GlobalFilter, Ordered {
//
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        MDC.put("traceId", "11111111111111");
//        ServerHttpRequest tokenRequest = exchange.getRequest().mutate().header("X-B3-TraceId", "11111111111111").build();
//        exchange.mutate().request(tokenRequest).build();
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
//
