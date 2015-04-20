package com.amazing_mvp.ui.presenter;

import com.amazing_mvp.domain.model.Genre;
import java.util.Collection;

public interface GenrePresenter extends Presenter {

  void setView(View view);
  void onGenreClick(Genre genre);
  void restoreLoadedGenres(Collection<Genre> genres);
  Collection<Genre> getCurrentGenresLoaded();

  interface View {
    boolean isReady();
    void renderGenres(Collection<Genre> genres);
    void showGenres();
    void showLoading();
    void showError();
    void showEmpty();
  }

}
