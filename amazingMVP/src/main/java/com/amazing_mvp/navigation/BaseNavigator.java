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

