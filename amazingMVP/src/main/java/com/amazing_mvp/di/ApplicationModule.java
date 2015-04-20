package com.amazing_mvp.di;

import android.app.Application;
import android.content.res.Resources;
import android.view.LayoutInflater;

import com.amazing_mvp.executor.InteractorExecutor;
import com.amazing_mvp.executor.MainThread;
import com.amazing_mvp.executor.MainThreadImpl;
import com.amazing_mvp.executor.ThreadExecutor;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Application provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(application);
  }

  @Provides @Singleton Resources provideResources() {
    return application.getResources();
  }

  @Provides @Singleton InteractorExecutor provideThreadExecutor(ThreadExecutor executor) {
    return executor;
  }

  @Provides @Singleton MainThread providePostExecutionThread(MainThreadImpl mainThread) {
    return mainThread;
  }

}
