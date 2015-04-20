package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import com.amazing_mvp.R;

public class BaseActivity extends AbstractActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
  }

}
