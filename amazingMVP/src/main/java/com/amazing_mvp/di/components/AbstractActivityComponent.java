package com.amazing_mvp.di.components;

import android.app.Activity;
import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.navigation.GenreNavigator;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface AbstractActivityComponent {
  Activity activityContext();
  GenreNavigator genreNavigator();
}
