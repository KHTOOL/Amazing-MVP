package com.amazing_mvp.ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.InjectView;
import com.amazing_mvp.AmazingMvpApplication;
import com.amazing_mvp.R;
import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.components.DaggerGenreFragmentComponent;
import com.amazing_mvp.di.components.GenreFragmentComponent;
import com.amazing_mvp.ui.fragment.GenreFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import javax.inject.Inject;

public class BaseActivity extends AbstractActivity {

  private GenreFragmentComponent genreFragmentComponent;

  @Inject Resources resources;

  @InjectView(R.id.toolbar) Toolbar toolbar;
  @InjectView(R.id.toolbar_title) TextView toolbarTitle;
  @InjectView(R.id.smart_tab_layout) SmartTabLayout smartTabLayout;
  @InjectView(R.id.view_pager) ViewPager viewPager;

  @Override protected int getContentViewId() {
    return R.layout.activity_base;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    configToolbar();
    configViewPager();
  }

  private void configToolbar() {
    setSupportActionBar(toolbar);
    //toolbarTitle.setText(resources.getString(R.string.app_name));
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
