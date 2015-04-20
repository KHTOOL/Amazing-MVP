package com.amazing_mvp.domain.model;

import com.amazing_mvp.R;
import com.amazing_mvp.core.view.recyclerviewrenderers.interfaces.Renderable;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.ParcelProperty;

@Parcel
public class Genre implements Renderable {

  public static final String TAG = "Genre";

  public static final String TITLE = "title";
  public static final String IMAGE = "image";
  public static final String DETAILS = "details";

  @ParcelProperty(TITLE) String title;
  @ParcelProperty(IMAGE) String image;
  @ParcelProperty(DETAILS) String details;

  public Genre() {}

  @ParcelConstructor
  public Genre(
      @ParcelProperty(TITLE) String title,
      @ParcelProperty(IMAGE) String image,
      @ParcelProperty(DETAILS) String details) {
    this.title = title;
    this.image = image;
    this.details = details;
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

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Override public int getRenderableId() {
    return R.layout.adapter_genre;
  }

}
