package com.amazing_mvp.di.components;

import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.ui.BaseActivity;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, CamerasModule.class })
public interface GenreFragmentComponent {
  void inject(BaseActivity baseActivity);
  GetGenres getGenres();
}
