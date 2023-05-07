package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
  PERMANENT("PermanentEmployee"),
  CONTRACT("TemporaryEmployee");

  private final String type;

  @Override
  public String toString() {
    return getType();
  }
}
