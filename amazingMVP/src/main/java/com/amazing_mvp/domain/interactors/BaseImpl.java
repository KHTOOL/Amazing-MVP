package com.amazing_mvp.domain.interactors;

public class BaseImpl {
  public void validateArguments(GetGenres.Callback callback) {
    if (callback == null) {
      throw new IllegalArgumentException("Callback parameter can't be null");
    }
  }
}
