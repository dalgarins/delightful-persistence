package com.alexsimo.delightfulpersistence.database.populator;

import android.database.sqlite.SQLiteDatabase;
import com.alexsimo.delightfulpersistence.database.model.Author;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import java.util.GregorianCalendar;

public class AuthorPopulator {

  public static void populate(SQLiteDatabase db) {
    db.insert(AuthorModel.TABLE_NAME, null, new Author.Marshal().name("J. K. Rowling")
        .birth_year(new GregorianCalendar(1965, 7, 31))
        .asContentValues());
    db.insert(AuthorModel.TABLE_NAME, null, new Author.Marshal().name("Bella Forests")
        .birth_year(new GregorianCalendar(197, 17, 31))
        .asContentValues());
    db.insert(AuthorModel.TABLE_NAME, null, new Author.Marshal().name("Norah Roberts")
        .birth_year(new GregorianCalendar(1950, 10, 10))
        .asContentValues());
    db.insert(AuthorModel.TABLE_NAME, null, new Author.Marshal().name("David Baldacci")
        .birth_year(new GregorianCalendar(1960, 8, 5))
        .asContentValues());
    db.insert(AuthorModel.TABLE_NAME, null, new Author.Marshal().name("Jeff Wheeler")
        .birth_year(new GregorianCalendar(1955, 13, 31))
        .asContentValues());
  }
}
