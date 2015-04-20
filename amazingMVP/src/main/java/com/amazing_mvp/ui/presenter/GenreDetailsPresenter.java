package com.amazing_mvp.ui.presenter;

import android.os.Parcelable;
import com.amazing_mvp.domain.model.Genre;

public interface GenreDetailsPresenter extends Presenter {

  void setView(View view);
  void setParcelable(Parcelable parcelable);

  interface View {
    void renderGenre(Genre genre);
    void showEmpty();
  }

}
