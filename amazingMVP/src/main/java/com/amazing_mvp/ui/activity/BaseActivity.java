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
package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.InjectView;
import com.amazing_mvp.AmazingMvpApplication;
import com.amazing_mvp.R;
import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.SyncModule;
import com.amazing_mvp.di.components.DaggerGenreFragmentComponent;
import com.amazing_mvp.di.components.DaggerSyncComponent;
import com.amazing_mvp.di.components.GenreFragmentComponent;
import com.amazing_mvp.di.components.SyncComponent;
import com.amazing_mvp.ui.fragment.GenreFragment;
import com.amazing_mvp.ui.presenter.SyncPresenter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import javax.inject.Inject;

public class BaseActivity extends AbstractActivity implements SyncPresenter.View {

  private SyncComponent syncComponent;
  private GenreFragmentComponent genreFragmentComponent;

  @Inject SyncPresenter syncPresenter;

  @InjectView(R.id.toolbar) Toolbar toolbar;
  @InjectView(R.id.toolbar_title) TextView toolbarTitle;
  @InjectView(R.id.smart_tab_layout) SmartTabLayout smartTabLayout;
  @InjectView(R.id.view_pager) ViewPager viewPager;

  @Override protected int getContentViewId() {
    return R.layout.activity_base;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    syncComponent().inject(this);
    syncPresenter.setView(this);
    syncPresenter.initialize();
    configToolbar();

  }

  @Override public boolean isReady() {
    return !isFinishing();
  }

  @Override public void onEndSync() {
    configViewPager();
  }

  private void configToolbar() {
    setSupportActionBar(toolbar);
    toolbarTitle.setText(getResources().getString(R.string.app_name));
  }

  private void configViewPager() {
    FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
        getSupportFragmentManager(), FragmentPagerItems.with(this)
        //.add(R.string.house, GenreFragment.class)
        .add(R.string.techno, GenreFragment.class)
        .create());
    viewPager.setAdapter(adapter);
    smartTabLayout.setViewPager(viewPager);
  }

  public SyncComponent syncComponent() {
    if(syncComponent == null) {
      syncComponent = DaggerSyncComponent.builder()
          .applicationComponent(((AmazingMvpApplication) getApplication()).component())
          .syncModule(new SyncModule())
          .build();
    }
    return syncComponent;
  }

  public GenreFragmentComponent genreFragmentComponent() {
    if (genreFragmentComponent == null) {
      genreFragmentComponent = DaggerGenreFragmentComponent.builder()
          .applicationComponent(((AmazingMvpApplication) getApplication()).component())
          .activityModule(new ActivityModule(this))
          .build();
    }
    return genreFragmentComponent;
  }

}
