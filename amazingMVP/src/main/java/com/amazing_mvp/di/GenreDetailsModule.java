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
package com.amazing_mvp.di;

import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenreDetails;
import com.amazing_mvp.domain.interactors.GetGenreDetailsImpl;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenter;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module public class GenreDetailsModule {

  @Provides @ActivityScope GenreDetailsPresenter provideGenreDetailsPresenter(
      GenreDetailsPresenterImpl presenter) {
    return presenter;
  }

  @Provides @ActivityScope GetGenreDetails provideGetGenreDetails(GetGenreDetailsImpl getGenreDetails) {
    return getGenreDetails;
  }

}