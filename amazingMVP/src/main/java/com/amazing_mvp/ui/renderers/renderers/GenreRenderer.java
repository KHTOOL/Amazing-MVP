package com.amazing_mvp.ui.renderers.renderers;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.amazing_mvp.core.view.recyclerviewrenderers.renderer.Renderer;
import com.amazing_mvp.core.view.recyclerviewrenderers.viewholder.RenderViewHolder;
import com.amazing_mvp.ui.renderers.factory.Factory;
import com.amazing_mvp.ui.renderers.viewholder.ViewHolderGenre;
import javax.inject.Inject;

public class GenreRenderer extends Renderer {

  private Factory.GenreCallback genreCallback;

  @Inject LayoutInflater layoutInflater;

  public GenreRenderer(int id, Factory.GenreCallback genreCallback) {
    super(id);
    this.genreCallback = genreCallback;
  }

  @Override public RenderViewHolder onCreateViewHolder(ViewGroup viewGroup, int id) {
    return new ViewHolderGenre(layoutInflater.inflate(id, viewGroup, false), genreCallback);
  }

}
