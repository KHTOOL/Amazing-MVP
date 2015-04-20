package com.amazing_mvp.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class BaseNavigator {

  private final Context activityContext;

  BaseNavigator(Context activityContext) {
    this.activityContext = activityContext;
  }

  public Context getContext() {
    return activityContext;
  }

  public FragmentManager getFragmentManager() {
    return ((FragmentActivity) activityContext).getSupportFragmentManager();
  }

  public boolean isFragmentAvailable(Fragment fragment) {
    return fragment != null && fragment.isAdded();
  }

  public void startActivity(Intent intent) {
    activityContext.startActivity(intent);
  }

}

