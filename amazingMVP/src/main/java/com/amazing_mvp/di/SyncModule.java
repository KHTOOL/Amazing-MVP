package com.amazing_mvp.di;

import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetSync;
import com.amazing_mvp.domain.interactors.GetSyncImpl;
import com.amazing_mvp.ui.presenter.SyncPresenter;
import com.amazing_mvp.ui.presenter.SyncPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module public class SyncModule {

  @Provides @ActivityScope SyncPresenter provideSyncPresenter(
      SyncPresenterImpl presenter) {
    return presenter;
  }

  @Provides @ActivityScope GetSync provideGetSync(
      GetSyncImpl getSync) {
    return getSync;
  }

}
