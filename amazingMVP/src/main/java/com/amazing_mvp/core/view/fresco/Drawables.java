package com.amazing_mvp.core.view.fresco;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.amazing_mvp.R;

public class Drawables {

  public static void init(final Resources resources) {
    if (sPlaceholderDrawable == null) {
      sPlaceholderDrawable = resources.getDrawable(R.color.ripple_material_dark);
    }
    if (sErrorDrawable == null) {
      sErrorDrawable = resources.getDrawable(R.color.ripple_material_dark);
    }
  }

  public static Drawable sPlaceholderDrawable;
  public static Drawable sErrorDrawable;
  private Drawables() {}

}