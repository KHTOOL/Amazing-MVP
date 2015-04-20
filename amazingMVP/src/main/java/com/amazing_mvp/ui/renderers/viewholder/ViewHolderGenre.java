package com.amazing_mvp.ui.renderers.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.amazing_mvp.R;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.core.view.recyclerviewrenderers.viewholder.RenderViewHolder;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.renderers.factory.Factory;
import com.amazing_mvp.util.ViewUtil;

public class ViewHolderGenre extends RenderViewHolder<Genre> {

  private final Factory.GenreCallback genreCallback;

  @InjectView(R.id.genre_image) InstrumentedDraweeView genreImage;
  @InjectView(R.id.genre_name) TextView genreName;

  public ViewHolderGenre(View view, Factory.GenreCallback genreCallback) {
    super(view);
    ButterKnife.inject(this, view);
    this.genreCallback = genreCallback;
  }

  @Override public void onBindView(final Genre genre) {
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        genreCallback.onGenreClick(genre);
      }
    });
    genreName.setText(genre.getTitle());
    ViewUtil.bind(genreImage, genre.getImage());
  }



}
