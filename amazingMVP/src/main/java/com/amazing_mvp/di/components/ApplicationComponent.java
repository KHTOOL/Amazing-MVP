package com.amazing_mvp.di.components;

import android.app.Application;
import android.content.res.Resources;
import com.amazing_mvp.AmazingMvpApplication;
import com.amazing_mvp.di.ApplicationModule;
import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(AmazingMvpApplication amazingMvpApplication);
  Application application();
  Resources resources();
  InteractorExecutor executor();
  MainThread mainThread();
}
