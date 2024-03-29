/*
* Copyright (C) 2015 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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

  @Provides @Singleton InteractorExecutor provideThreadExecutor(ThreadExecutor executor) {
    return executor;
  }

  @Provides @Singleton MainThread providePostExecutionThread(MainThreadImpl mainThread) {
    return mainThread;
  }

}
