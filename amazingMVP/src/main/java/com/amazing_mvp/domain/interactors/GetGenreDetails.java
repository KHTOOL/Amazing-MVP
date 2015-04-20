package com.amazing_mvp.domain.interactors;

import android.os.Parcelable;
import com.amazing_mvp.domain.model.Genre;

public interface GetGenreDetails {
  void execute(Callback callback);
  void setParcelable(Parcelable parcelable);
  interface Callback {
    void onGenreLoaded(final Genre genre);
    void onGenresEmpty();
    void onErrorLoad();
  }
}

