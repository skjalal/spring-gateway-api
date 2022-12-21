package com.example.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthenticationGatewayFilterFactory
    extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

  public AuthenticationGatewayFilterFactory() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    log.info("Gateway Filter: {}", config.getName());
    return this::execute;
  }

  private Mono<Void> execute(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("Execute Authentication ....");
    return chain.filter(exchange);
  }

  @Getter
  @Setter
  public static class Config {
    private String name;
  }
}
