package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static io.netty.util.internal.StringUtil.EMPTY_STRING;

@Slf4j
@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

  private final String basePath;

  public LoggingGlobalFilter(@Value("${spring.webflux.base-path}") String basePath) {
    this.basePath = basePath;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("GlobalFilter Executed...");
    var req = exchange.getRequest();
    var path = req.getURI().getRawPath();
    var newPath = path.replaceFirst(basePath, EMPTY_STRING);
    var request = req.mutate().path(newPath).contextPath(EMPTY_STRING).build();
    return chain.filter(exchange.mutate().request(request).build());
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
