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
package com.amazing_mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import butterknife.InjectView;
import com.amazing_mvp.R;
import com.amazing_mvp.domain.model.Genre;
import com.amazing_mvp.ui.activity.BaseActivity;
import com.amazing_mvp.ui.presenter.GenrePresenter;
import com.amazing_mvp.ui.renderers.factory.Factory;
import com.amazing_mvp.util.ViewUtil;
import com.github.ppamorim.recyclerrenderers.adapter.RendererAdapter;
import com.github.ppamorim.recyclerrenderers.builder.RendererBuilder;
import icepick.Icepick;
import java.util.Collection;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;

public class GenreFragment extends AbstractFragment implements GenrePresenter.View {

  private RendererAdapter genreAdapter;

  @Inject GenrePresenter genrePresenter;

  @InjectView(R.id.layout_error) FrameLayout errorLayout;
  @InjectView(R.id.layout_empty) FrameLayout emptyLayout;
  @InjectView(R.id.layout_loading) RelativeLayout loadingLayout;
  @InjectView(R.id.recycler_view) RecyclerView recyclerView;

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ((BaseActivity) getActivity()).genreFragmentComponent().inject(this);
    configRecyclerView();
    genrePresenter.setView(this);
    genrePresenter.initialize();
  }

  @Override public void onResume() {
    super.onResume();
    genrePresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    genrePresenter.pause();
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Icepick.saveInstanceState(this, outState);
  }

  @Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    if(savedInstanceState != null) {
      Icepick.restoreInstanceState(this, savedInstanceState);
    }
  }

  @Override public boolean isReady() {
    return isAdded();
  }

  @Override public void renderGenres(Collection<Genre> genres) {
    genreAdapter = new RendererAdapter(genres, new RendererBuilder(new Factory(onGenreCallback)));
    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(genreAdapter);
    recyclerView.setAdapter(alphaAdapter);
  }

  @Override public void showGenres() {
    recyclerView.setVisibility(View.VISIBLE);
    loadingLayout.setVisibility(View.GONE);
    emptyLayout.setVisibility(View.GONE);
    errorLayout.setVisibility(View.GONE);
  }

  @Override public void showLoading() {
    loadingLayout.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.GONE);
    emptyLayout.setVisibility(View.GONE);
    errorLayout.setVisibility(View.GONE);
  }

  @Override public void showEmpty() {
    emptyLayout.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.GONE);
    loadingLayout.setVisibility(View.GONE);
    errorLayout.setVisibility(View.GONE);
  }

  @Override public void showError() {
    errorLayout.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.GONE);
    loadingLayout.setVisibility(View.GONE);
    emptyLayout.setVisibility(View.GONE);
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_genre;
  }

  private Factory.GenreCallback onGenreCallback = new Factory.GenreCallback() {
    @Override public void onGenreClick(Genre genre) {
      genrePresenter.onGenreClick(genre);
    }
  };

  private void configRecyclerView() {
    ViewUtil.configRecyclerView(recyclerView);
  }

}
