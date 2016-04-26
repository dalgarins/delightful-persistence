package com.alexsimo.delightfulpersistence.database.model;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class Author implements AuthorModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  public final static Mapper<Author> MAPPER =
      new Mapper<>((Mapper.Creator<Author>) AutoValue_Author::new, DATE_ADAPTER);

  public static final class Marshal extends AuthorMarshal<Marshal> {

    public Marshal() {
      super(DATE_ADAPTER);
    }
  }
}
