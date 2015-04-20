package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;

public abstract class AbstractActivity extends ActionBarActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentViewId());
    injectViews();
  }

  protected abstract int getContentViewId();

  private void injectViews() {
    ButterKnife.inject(this);
  }

}
