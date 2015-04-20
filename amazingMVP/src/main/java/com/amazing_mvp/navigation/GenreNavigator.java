package com.amazing_mvp.navigation;

import android.app.Activity;
import android.content.Intent;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.domain.model.test;
import com.amazing_mvp.ui.activity.SubGenreActivity;
import com.amazing_mvp.util.DebugUtil;
import javax.inject.Inject;
import org.parceler.Parcels;

public class GenreNavigator extends BaseNavigator implements Navigator {

  @Inject public GenreNavigator(Activity activityContext) {
    super(activityContext);
  }

  public void openGenreActivity(Genre genre) {
    Intent intent = new Intent(getContext(), SubGenreActivity.class);
    intent.putExtra(Genre.TAG, Parcels.wrap(new test()));
    startActivity(intent);
  }

}
