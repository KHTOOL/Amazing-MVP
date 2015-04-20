package com.amazing_mvp.di;

import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenreDetails;
import com.amazing_mvp.domain.interactors.GetGenreDetailsImpl;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenter;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module public class GenreDetailsModule {

  @Provides @ActivityScope GenreDetailsPresenter provideGenreDetailsPresenter(
      GenreDetailsPresenterImpl presenter) {
    return presenter;
  }

  @Provides @ActivityScope GetGenreDetails provideGetGenreDetails(GetGenreDetailsImpl getGenreDetails) {
    return getGenreDetails;
  }

}