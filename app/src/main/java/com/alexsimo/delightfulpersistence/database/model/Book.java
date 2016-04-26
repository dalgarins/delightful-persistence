package com.alexsimo.delightfulpersistence.database.model;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;
import java.util.Calendar;

@AutoValue public abstract class Book implements BookModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  public final static Mapper<Book> MAPPER =
      new Mapper<>((Mapper.Creator<Book>) AutoValue_Book::new, DATE_ADAPTER);

  public static final class Marshal extends BookMarshal<Marshal> {

    public Marshal() {
      super(DATE_ADAPTER);
    }
  }
}
