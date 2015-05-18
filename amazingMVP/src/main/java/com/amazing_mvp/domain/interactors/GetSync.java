package com.amazing_mvp.domain.interactors;

public interface GetSync {
  void execute(Callback callback);
  interface Callback {
    void onSyncEnd();
    void onSyncFail();
  }
}
