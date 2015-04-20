package com.amazing_mvp.ui.activity;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.InjectView;
import com.amazing_mvp.R;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.util.ViewUtil;
import org.parceler.Parcels;

public class SubGenreActivity extends AbstractActivity {

  private Genre genre;

  @InjectView(R.id.genre_image) InstrumentedDraweeView genreImage;
  @InjectView(R.id.genre_title) TextView genreTitle;
  @InjectView(R.id.genre_details) TextView genreDetails;

  @Override protected int getContentViewId() {
    return R.layout.activity_sub_genre;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    genre = Parcels.unwrap(getIntent().getParcelableExtra(Genre.TAG));
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    ViewUtil.bind(genreImage, genre.getImage());
    ViewUtil.verifyStringAndSet(genreTitle, genre.getTitle());
    ViewUtil.verifyStringAndSet(genreDetails, genre.getDetails());
  }
}
