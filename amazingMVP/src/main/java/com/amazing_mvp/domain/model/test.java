package com.amazing_mvp.domain.model;

import org.parceler.Parcel;

@Parcel
public class test {

  String image;
  String title;

  public test() {}

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

}
