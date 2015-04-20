package com.amazing_mvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public abstract class AbstractFragment extends Fragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(getFragmentLayout(), container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectViews(view);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    resetViews();
  }

  protected abstract int getFragmentLayout();

  private void injectViews(final View view) {
    ButterKnife.inject(this, view);
  }

  private void resetViews() {
    ButterKnife.reset(this);
  }

}
