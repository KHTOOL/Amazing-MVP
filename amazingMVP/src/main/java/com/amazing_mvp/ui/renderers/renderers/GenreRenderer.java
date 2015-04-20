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
package com.amazing_mvp.ui.renderers.renderers;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.amazing_mvp.core.view.recyclerviewrenderers.renderer.Renderer;
import com.amazing_mvp.core.view.recyclerviewrenderers.viewholder.RenderViewHolder;
import com.amazing_mvp.ui.renderers.factory.Factory;
import com.amazing_mvp.ui.renderers.viewholder.ViewHolderGenre;

public class GenreRenderer extends Renderer {

  private Factory.GenreCallback genreCallback;

  LayoutInflater layoutInflater;

  public GenreRenderer(int id, Factory.GenreCallback genreCallback) {
    super(id);
    this.genreCallback = genreCallback;
  }

  @Override public RenderViewHolder onCreateViewHolder(ViewGroup viewGroup, int id) {
    if(layoutInflater == null) {
      layoutInflater = LayoutInflater.from(viewGroup.getContext());
    }
    return new ViewHolderGenre(layoutInflater.inflate(id, viewGroup, false), genreCallback);
  }

}
