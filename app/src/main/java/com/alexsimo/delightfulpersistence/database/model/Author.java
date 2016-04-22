package com.alexsimo.delightfulpersistence.database.model;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.ColumnAdapter;
import java.util.Calendar;

@AutoValue public abstract class Author implements AuthorModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  private final static Mapper<Author> MAPPER = new Mapper<>(new Mapper.Creator<Author>() {
    @Override
    public Author create(Long _id, String name, Calendar birth_year) {
      return new AutoValue_Author(_id, name, birth_year);
    }
  }, DATE_ADAPTER);

  public static final class Marshal extends AuthorMarshal<Marshal> {

    public Marshal(ColumnAdapter<Calendar> birth_yearAdapter) {
      super(DATE_ADAPTER);
    }
  }
}
