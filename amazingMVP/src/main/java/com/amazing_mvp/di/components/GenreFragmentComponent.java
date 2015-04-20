package com.amazing_mvp.di.components;

import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.GenreModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.ui.activity.BaseActivity;
import com.amazing_mvp.ui.fragment.GenreFragment;
import com.amazing_mvp.ui.presenter.GenrePresenter;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreModule.class })
public interface GenreFragmentComponent extends AbstractActivityComponent {
  void inject(BaseActivity baseActivity);
  void inject(GenreFragment genreFragment);
  GenrePresenter getPresenter();
  GetGenres getGenres();
}
