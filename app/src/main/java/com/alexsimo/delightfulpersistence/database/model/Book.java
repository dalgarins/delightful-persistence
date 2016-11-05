package com.alexsimo.delightfulpersistence.database.model;

import android.support.annotation.NonNull;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;
import java.util.Calendar;

@AutoValue public abstract class Book implements BookModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  public static final Factory<Book> FACTORY = new Factory<>(AutoValue_Book::new, DATE_ADAPTER);
}
