package com.amazing_mvp.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import com.amazing_mvp.core.view.fresco.InstrumentedDraweeView;
import com.amazing_mvp.di.scopes.ActivityScope;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import javax.inject.Inject;

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
