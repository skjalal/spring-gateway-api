package com.example.controller;

import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class UserController {

  @PostMapping("/data")
  public Mono<User> all(@RequestBody User user) {
    return Mono.just(user).doOnSuccess(d -> log.info(d.toString()));
  }
}
