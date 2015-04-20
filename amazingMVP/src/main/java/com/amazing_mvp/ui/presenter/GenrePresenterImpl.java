package com.amazing_mvp.ui.presenter;

import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.domain.model.Genre;
import java.util.Collection;

public class GenrePresenterImpl implements GenrePresenter {

  private View view;
  private Collection<Genre> currentGenresLoaded;
  private GetGenres getGenres;

  @Override public void setView(View view) {
    if (view == null) {
      throw new IllegalArgumentException("The view must not be null!");
    }
    this.view = view;
  }

  @Override public void initialize() {
    loadCameras();
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  @Override public void onGenreClick(Genre genre) {

  }

  @Override public void restoreLoadedGenres(Collection<Genre> genres) {
    showGenres(currentGenresLoaded);
  }

  @Override public Collection<Genre> getCurrentGenresLoaded() {
    return currentGenresLoaded;
  }

  private void loadCameras() {
    showLoading();
    getGenres.execute(new GetGenres.Callback() {
      @Override public void onGenresLoaded(Collection<Genre> genres) {
        if(genres.size() > 0) {
          showGenres(genres);
        } else {
          showEmpty();
        }
      }

      @Override public void onErrorLoad() {
        showError();
      }
    });
  }

  private void showLoading() {
    if(view.isReady()) {
      view.showLoading();
    }
  }

  private void showGenres(Collection<Genre> genres) {
    if (view.isReady() && genres != null) {
      currentGenresLoaded = genres;
      view.renderGenres(genres);
    }
  }

  private void showError() {
    if (view.isReady()) {
      view.showError();
    }
  }

  private void showEmpty() {
    if (view.isReady()) {
      view.showEmpty();
    }
  }

}
