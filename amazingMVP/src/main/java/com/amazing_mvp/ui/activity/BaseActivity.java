package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
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

public class BaseActivity extends AbstractActivity {

  private GenreFragmentComponent genreFragmentComponent;

  @InjectView(R.id.toolbar) Toolbar toolbar;
  @InjectView(R.id.smart_tab_layout) SmartTabLayout smartTabLayout;
  @InjectView(R.id.view_pager) ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
    configViewPager();
  }

  private void configViewPager() {
    FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
        getSupportFragmentManager(), FragmentPagerItems.with(this)
        .add(R.string.cameras, GenreFragment.class)
        .add(R.string.notifications, GenreFragment.class)
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
