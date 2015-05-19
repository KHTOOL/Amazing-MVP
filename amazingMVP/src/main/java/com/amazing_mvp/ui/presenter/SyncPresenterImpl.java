package com.amazing_mvp.ui.presenter;

import com.amazing_mvp.domain.interactors.GetSync;
import javax.inject.Inject;

public class SyncPresenterImpl implements SyncPresenter {

  private View view;
  private GetSync getSync;

  @Inject SyncPresenterImpl(GetSync getSync) {
    this.getSync = getSync;
  }

  @Override public void setView(View view) {
    this.view = view;
  }

  @Override public void initialize() {
    sync();
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  private void sync() {
    getSync.execute(new GetSync.Callback() {
      @Override public void onSyncEnd() {
        onSyncEnded();
      }

      @Override public void onSyncFail() {

      }
    });
  }

  private void onSyncEnded() {
    if(view.isReady()) {
     view.onEndSync();
    }
  }

}