package com.amazing_mvp.domain.model;

import com.amazing_mvp.R;
import com.amazing_mvp.core.view.recyclerviewrenderers.interfaces.Renderable;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.ParcelProperty;

@Parcel(Parcel.Serialization.BEAN)
public class Genre implements Renderable {

  public static final String IMAGE = "image";
  public static final String TITLE = "title";

  @ParcelProperty(IMAGE) String image;
  @ParcelProperty(TITLE) String title;

  @ParcelConstructor
  public Genre(String image, String title) {
    this.image = image;
    this.title = title;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override public int getRenderableId() {
    return R.layout.adapter_genre;
  }

}
