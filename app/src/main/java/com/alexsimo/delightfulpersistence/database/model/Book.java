package com.alexsimo.delightfulpersistence.database.model;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;
import java.util.Calendar;

@AutoValue public abstract class Book implements BookModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  private final static Mapper<Book> MAPPER = new Mapper<>(new Mapper.Creator<Book>() {
    @Override
    public Book create(long _id, String isbn, String title, Calendar release_year) {
      return new AutoValue_Book(_id, isbn, title, release_year);
    }
  }, DATE_ADAPTER);

  public static final class Marshal extends BookMarshal<Marshal> {

    public Marshal() {
      super(DATE_ADAPTER);
    }
  }
}
