package com.amazing_mvp.di.components;

import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.GenreDetailsModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenreDetails;
import com.amazing_mvp.ui.activity.SubGenreActivity;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenter;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreDetailsModule.class })
public interface GenreDetailsActivityComponent extends AbstractActivityComponent {
  void inject(SubGenreActivity subGenreActivity);
  GenreDetailsPresenter getGenreDetailsPresenter();
  GetGenreDetails getGenreDetails();
}
