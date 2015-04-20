package com.amazing_mvp.navigation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
