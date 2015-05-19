package com.amazing_mvp.domain.interactors;


import com.amazing_mvp.executor.Interactor;
import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import javax.inject.Inject;

public class GetSyncImpl extends BaseImpl implements Interactor, GetSync {

  private final InteractorExecutor interactorExecutor;
  private final MainThread mainThread;
  private Callback callback;

  @Inject GetSyncImpl(InteractorExecutor interactorExecutor, MainThread mainThread) {
    this.interactorExecutor = interactorExecutor;
    this.mainThread = mainThread;
  }


  @Override public void execute(Callback callback) {
    validateArguments(callback);
    this.callback = callback;
    this.interactorExecutor.run(this);
  }

  @Override public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    onSyncEnd();
  }

  private void onSyncEnd() {
    mainThread.post(new Runnable() {
     @Override public void run() {
     callback.onSyncEnd();
     }
    });
  }

  private void onSyncFail() {
    mainThread.post(new Runnable() {
     @Override public void run() {
     callback.onSyncFail();
     }
    });
  }

}
