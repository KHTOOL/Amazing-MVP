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
package com.amazing_mvp.ui.renderers.factory;

import com.amazing_mvp.R;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.renderers.renderers.GenreRenderer;
import com.github.ppamorim.recyclerrenderers.interfaces.RendererFactory;
import com.github.ppamorim.recyclerrenderers.renderer.Renderer;

public class Factory implements RendererFactory {

  private GenreCallback genreCallback;

  public Factory(GenreCallback genreCallback) {
    this.genreCallback = genreCallback;
  }

  @Override public Renderer getRenderer(int id) {
    switch (id) {
      case R.layout.adapter_genre:
        return new GenreRenderer(genreCallback);
      default:
        return null;
    }
  }

  public interface GenreCallback {
    void onGenreClick(Genre genre);
  }

}
