package com.amazing_mvp.ui.presenter;

import com.amazing_mvp.domain.interactors.GetSync;
import javax.inject.Inject;

public class SyncPresenterImpl implements SyncPresenter {

  private GetSync getSync;

  @Inject SyncPresenterImpl(GetSync getSync) {
    this.getSync = getSync;
  }

  @Override public void setView(View view) {
  }

  @Override public void initialize() {
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

}