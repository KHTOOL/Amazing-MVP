package com.amazing_mvp.ui.presenter;

public interface SyncPresenter extends Presenter {
  void setView(View view);
  interface View {
    boolean isReady();
    void onEndSync();
  }
}
