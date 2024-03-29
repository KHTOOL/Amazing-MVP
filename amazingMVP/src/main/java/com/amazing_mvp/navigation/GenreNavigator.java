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

import android.app.Activity;
import android.content.Intent;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.activity.SubGenreActivity;
import javax.inject.Inject;
import org.parceler.Parcels;

public class GenreNavigator extends BaseNavigator implements Navigator {

  @Inject public GenreNavigator(Activity activityContext) {
    super(activityContext);
  }

  public void openGenreActivity(Genre genre) {
    Intent intent = new Intent(getContext(), SubGenreActivity.class);
    intent.putExtra(Genre.TAG, Parcels.wrap(genre));
    startActivity(intent);
  }

}
