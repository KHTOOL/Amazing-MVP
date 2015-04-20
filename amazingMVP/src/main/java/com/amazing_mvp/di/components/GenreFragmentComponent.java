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
import com.amazing_mvp.di.GenreModule;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.amazing_mvp.domain.interactors.GetGenres;
import com.amazing_mvp.ui.activity.BaseActivity;
import com.amazing_mvp.ui.fragment.GenreFragment;
import com.amazing_mvp.ui.presenter.GenrePresenter;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreModule.class })
public interface GenreFragmentComponent extends AbstractActivityComponent {
  void inject(BaseActivity baseActivity);
  void inject(GenreFragment genreFragment);
  GenrePresenter getPresenter();
  GetGenres getGenres();
}
