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
package com.amazing_mvp.util;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class ViewUtil {

  @ActivityScope static Context context;

  public static void configRecyclerView(RecyclerView recyclerView) {
    recyclerView.setHasFixedSize(true);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(layoutManager);
  }

  public static void verifyStringAndSet(TextView textView, String text) {
    if(textView != null && text != null && text.length() > 0) {
      textView.setText(text.trim());
    }
  }

  public static void bind(final InstrumentedDraweeView view, String uri) {
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
