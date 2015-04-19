package com.amazing_mvp;

import android.app.Application;
import com.amazing_mvp.di.ApplicationModule;
import com.amazing_mvp.di.components.ApplicationComponent;

public class AmazingMvpApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeDependencyInjector();
  }

  public ApplicationComponent component() {
    return applicationComponent;
  }

  private void initializeDependencyInjector() {
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

}
