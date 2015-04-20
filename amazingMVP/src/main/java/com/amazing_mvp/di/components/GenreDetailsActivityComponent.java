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
package com.amazing_mvp.di.components;

import com.amazing_mvp.di.ActivityModule;
import com.amazing_mvp.di.GenreDetailsModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenreDetails;
import com.amazing_mvp.ui.activity.SubGenreActivity;
import com.amazing_mvp.ui.presenter.GenreDetailsPresenter;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreDetailsModule.class })
public interface GenreDetailsActivityComponent extends AbstractActivityComponent {
  void inject(SubGenreActivity subGenreActivity);
  GenreDetailsPresenter getGenreDetailsPresenter();
  GetGenreDetails getGenreDetails();
}
