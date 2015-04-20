package com.amazing_mvp.domain.interactors;

public class BaseImpl {
  public void validateArguments(Object callback) {
    if (callback == null) {
      throw new IllegalArgumentException("Callback parameter can't be null");
    }
  }
}
