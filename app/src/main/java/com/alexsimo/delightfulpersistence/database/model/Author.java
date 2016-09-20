package com.alexsimo.delightfulpersistence.database.model;

import com.alexsimo.delightfulpersistence.database.adapter.DateAdapter;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class Author implements AuthorModel {

  private final static DateAdapter DATE_ADAPTER = new DateAdapter();

  public static final Factory<Author> FACTORY = new Factory<>(AutoValue_Author::new, DATE_ADAPTER);

  public static final Mapper<Author> MAPPER = new Mapper<>(FACTORY);
}
