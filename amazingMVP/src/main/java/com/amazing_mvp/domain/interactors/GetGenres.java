package com.amazing_mvp.domain.interactors;

import com.amazing_mvp.domain.model.Genre;
import java.util.Collection;

public interface GetGenres {
  void execute(Callback callback);
  interface Callback {
    void onGenresLoaded(final Collection<Genre> genres);
    void onGenresEmpty();
    void onErrorLoad();
  }
}
