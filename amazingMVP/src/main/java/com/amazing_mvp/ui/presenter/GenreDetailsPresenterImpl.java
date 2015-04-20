package com.amazing_mvp.ui.presenter;

import android.os.Parcelable;
import com.amazing_mvp.domain.interactors.GetGenreDetails;
import com.amazing_mvp.domain.model.Genre;
import javax.inject.Inject;

public class GenreDetailsPresenterImpl implements GenreDetailsPresenter {

  private GenreDetailsPresenter.View view;
  private Genre genre;
  private GetGenreDetails getGenreDetails;

  @Inject GenreDetailsPresenterImpl(GetGenreDetails getGenreDetails) {
    this.getGenreDetails = getGenreDetails;
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

  @Override public void resume() {}

  @Override public void pause() {}

  private void loadCameras() {
    getGenreDetails.execute(new GetGenreDetails.Callback() {
      @Override public void onGenreLoaded(Genre genre) {
        showGenre(genre);
      }

      @Override public void onGenresEmpty() {
        showEmpty();
      }

    });
  }

  public void setParcelable(Parcelable parcelable) {
    getGenreDetails.setParcelable(parcelable);
  }

  private void showGenre(Genre genre) {
    if (genre != null) {
      this.genre = genre;
      view.renderGenre(genre);
    }
  }

  private void showEmpty() {
    view.showEmpty();
  }

}
