package com.amazing_mvp.ui.renderers.factory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.amazing_mvp.R;
import com.amazing_mvp.core.view.recyclerviewrenderers.interfaces.RendererFactory;
import com.amazing_mvp.core.view.recyclerviewrenderers.renderer.Renderer;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.renderers.renderers.GenreRenderer;

public class Factory implements RendererFactory {

  private GenreCallback genreCallback;

  public Factory(GenreCallback genreCallback) {
    this.genreCallback = genreCallback;
  }

  @Override public Renderer getRenderer(int id) {
    switch (id) {
      case R.layout.adapter_genre:
        return new GenreRenderer(id, genreCallback);
      default:
        return null;
    }
  }

  public static interface GenreCallback {
    void onGenreClick(Genre genre);
  }

}
