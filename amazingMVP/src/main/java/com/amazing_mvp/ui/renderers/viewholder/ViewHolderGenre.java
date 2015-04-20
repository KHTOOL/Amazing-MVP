package com.amazing_mvp.ui.renderers.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.amazing_mvp.R;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.core.view.recyclerviewrenderers.viewholder.RenderViewHolder;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.renderers.factory.Factory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class ViewHolderGenre extends RenderViewHolder<Genre> {

  private final Factory.GenreCallback genreCallback;

  @InjectView(R.id.genre_image) InstrumentedDraweeView genreImage;
  @InjectView(R.id.genre_name) TextView genreName;

  public ViewHolderGenre(View view, Factory.GenreCallback genreCallback) {
    super(view);
    ButterKnife.inject(this, view);
    this.genreCallback = genreCallback;
  }

  @Override public void onBindView(Genre genre) {
    genreName.setText(genre.getTitle());
    bind(genreImage, genre.getImage());
  }

  protected void bind(final InstrumentedDraweeView view, String uri) {
    ImageRequest imageRequest =
        ImageRequestBuilder.newBuilderWithSource(Uri.parse(uri))
            .build();
    DraweeController draweeController = Fresco.newDraweeControllerBuilder()
        .setImageRequest(imageRequest)
        .setOldController(view.getController())
        .setControllerListener(view.getListener())
        .setAutoPlayAnimations(true)
        .build();
    view.setController(draweeController);
  }

}