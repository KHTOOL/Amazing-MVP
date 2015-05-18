package com.amazing_mvp.di.components;

import com.amazing_mvp.di.SyncModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetSync;
import com.amazing_mvp.ui.activity.BaseActivity;
import com.amazing_mvp.ui.presenter.SyncPresenter;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class, modules = SyncModule.class)
public interface SyncComponent {
  void inject(BaseActivity baseActivity);
  SyncPresenter getPresenter();
  GetSync getSync();
}
