package com.amazing_mvp.ui.presenter;

import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.navigation.GenreNavigator;
import java.util.Collection;
import javax.inject.Inject;

public class GenrePresenterImpl implements GenrePresenter {

  private View view;
  private Collection<Genre> currentGenresLoaded;
  private GenreNavigator genreNavigator;
  private GetGenres getGenres;

  @Inject GenrePresenterImpl(GenreNavigator genreNavigator, GetGenres getGenres) {
    this.genreNavigator = genreNavigator;
    this.getGenres = getGenres;
  }

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
    genreNavigator.openGenreActivity(genre);
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
        showGenres(genres);
      }

      @Override public void onGenresEmpty() {
        showEmpty();
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
      view.showGenres();
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
