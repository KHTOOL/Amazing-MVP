package com.amazing_mvp.di;

import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.domain.interactors.GetGenresImpl;
import com.amazing_mvp.ui.presenter.GenrePresenter;
import com.amazing_mvp.ui.presenter.GenrePresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module public class GenreModule {

  @Provides @ActivityScope GenrePresenter provideGenrePresenter(
      GenrePresenterImpl presenter) {
    return presenter;
  }

  @Provides @ActivityScope GetGenres provideGetGenres(GetGenresImpl camera) {
    return camera;
  }

}
