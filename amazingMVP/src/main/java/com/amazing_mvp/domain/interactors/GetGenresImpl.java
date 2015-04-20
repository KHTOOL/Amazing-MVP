package com.amazing_mvp.domain.interactors;

import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.executor.Interactor;
import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import com.amazing_mvp.util.DebugUtil;
import java.util.ArrayList;
import javax.inject.Inject;

public class GetGenresImpl extends BaseImpl implements Interactor, GetGenres {

  private final InteractorExecutor interactorExecutor;
  private final MainThread mainThread;
  private Callback callback;

  @Inject GetGenresImpl(InteractorExecutor interactorExecutor, MainThread mainThread) {
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
      Thread.sleep(2000);
      ArrayList<Genre> cameras = createItems();
      if(cameras.size() > 0) {
        notifyConnectionSuccess(cameras);
      } else {
        notifyEmpty();
      }
    } catch (Exception e) {
      if(DebugUtil.DEBUG) {
        e.printStackTrace();
      }
      notifyConnectionError();
    }

  }

  private void notifyConnectionSuccess(final ArrayList<Genre> genres) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onGenresLoaded(genres);
      }
    });
  }

  private void notifyEmpty() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onGenresEmpty();
      }
    });
  }

  private void notifyConnectionError() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onErrorLoad();
      }
    });
  }

  private ArrayList<Genre> createItems() {
    ArrayList<Genre> items = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      items.add(new Genre("teste", "tes"));
    }
    return items;
  }

}
