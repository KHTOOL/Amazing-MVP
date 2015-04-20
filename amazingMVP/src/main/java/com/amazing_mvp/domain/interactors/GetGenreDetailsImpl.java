package com.amazing_mvp.domain.interactors;

import android.os.Parcelable;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.executor.Interactor;
import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import javax.inject.Inject;
import org.parceler.Parcels;

public class GetGenreDetailsImpl extends BaseImpl implements Interactor, GetGenreDetails {

  private final InteractorExecutor interactorExecutor;
  private final MainThread mainThread;
  private Parcelable parcelable;
  private Callback callback;

  @Inject GetGenreDetailsImpl(InteractorExecutor interactorExecutor, MainThread mainThread) {
    this.interactorExecutor = interactorExecutor;
    this.mainThread = mainThread;
  }

  @Override public void execute(Callback callback) {
    validateArguments(callback);
    this.callback = callback;
    this.interactorExecutor.run(this);
  }

  @Override public void run() {
    Genre genre = Parcels.unwrap(parcelable);
    if(genre != null) {
      notifySuccess(genre);
    } else {
      notifyEmpty();
    }
  }

  @Override public void setParcelable(Parcelable parcelable) {
    this.parcelable = parcelable;
  }

  private void notifySuccess(final Genre genre) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onGenreLoaded(genre);
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

}
