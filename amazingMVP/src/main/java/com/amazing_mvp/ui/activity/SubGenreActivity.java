package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.InjectView;
import com.amazing_mvp.AmazingMvpApplication;
import com.amazing_mvp.R;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.components.DaggerGenreDetailsActivityComponent;
import com.amazing_mvp.di.components.GenreDetailsActivityComponent;
import com.amazing_mvp.di.components.GenreFragmentComponent;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenter;
import com.amazing_mvp.util.ViewUtil;
import javax.inject.Inject;

public class SubGenreActivity extends AbstractActivity implements GenreDetailsPresenter.View {

  private GenreDetailsActivityComponent genreDetailsActivityComponent;

  @Inject GenreDetailsPresenter genreDetailsPresenter;

  @InjectView(R.id.genre_image) InstrumentedDraweeView genreImage;
  @InjectView(R.id.genre_title) TextView genreTitle;
  @InjectView(R.id.genre_details) TextView genreDetails;

  @Override protected int getContentViewId() {
    return R.layout.activity_sub_genre;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    genreDetailsActivityComponent().inject(this);
    genreDetailsPresenter.setParcelable(getIntent().getParcelableExtra(Genre.TAG));
    genreDetailsPresenter.setView(this);
    genreDetailsPresenter.initialize();
  }

  @Override public void renderGenre(Genre genre) {
    ViewUtil.bind(genreImage, genre.getImage());
    ViewUtil.verifyStringAndSet(genreTitle, genre.getTitle());
    ViewUtil.verifyStringAndSet(genreDetails, genre.getDetails());
  }

  @Override public void showGenres() {

  }

  @Override public void showLoading() {

  }

  @Override public void showError() {

  }

  @Override public void showEmpty() {

  }

  public GenreDetailsActivityComponent genreDetailsActivityComponent() {
    if (genreDetailsActivityComponent == null) {
      genreDetailsActivityComponent = DaggerGenreDetailsActivityComponent.builder()
          .applicationComponent(((AmazingMvpApplication) getApplication()).component())
          .activityModule(new ActivityModule(this))
          .build();
    }
    return genreDetailsActivityComponent;
  }

}
