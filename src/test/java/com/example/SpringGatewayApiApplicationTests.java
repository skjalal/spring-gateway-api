package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringGatewayApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Test
  void testRoute() {
    webTestClient.get().uri("/users").exchange().expectStatus().is2xxSuccessful();
  }
}
