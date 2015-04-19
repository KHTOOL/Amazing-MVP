package com.amazing_mvp.di.components;

import com.amazing_mvp.AmazingMvpApplication;
import com.amazing_mvp.di.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(AmazingMvpApplication amazingMvpApplication);
}
