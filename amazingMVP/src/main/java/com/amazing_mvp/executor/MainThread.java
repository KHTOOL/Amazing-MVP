package com.amazing_mvp.executor;

public interface MainThread {
  void post(final Runnable runnable);
}
