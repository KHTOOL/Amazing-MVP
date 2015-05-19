package com.amazing_mvp.domain.interactors;


import com.amazing_mvp.executor.Interactor;
import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import javax.inject.Inject;

public class GetSyncImpl implements GetSync {

  //private final InteractorExecutor interactorExecutor;
  //private final MainThread mainThread;
  //private Callback callback;

  @Inject GetSyncImpl() {
    //this.interactorExecutor = interactorExecutor;
    //this.mainThread = mainThread;
  }

  @Override public void execute(Callback callback) {

  }

  //
  //@Override public void execute(Callback callback) {
  //  validateArguments(callback);
  //  this.callback = callback;
  //  //this.interactorExecutor.run(this);
  //}
  //
  //@Override public void run() {
  //  //try {
  //  // JsonNode result = new CamerasService().doRequest();
  //  // onSyncEnd();
  //  //} catch (Exception e) {
  //  // if(DebugUtil.DEBUG) {
  //  // e.printStackTrace();
  //  // }
  //  // onSyncFail();
  //  //}
  //}
  //
  //private void onSyncEnd() {
  //  //mainThread.post(new Runnable() {
  //  // @Override public void run() {
  //  // callback.onSyncEnd();
  //  // }
  //  //});
  //}
  //
  //private void onSyncFail() {
  //  //mainThread.post(new Runnable() {
  //  // @Override public void run() {
  //  // callback.onSyncFail();
  //  // }
  //  //});
  //}

}
