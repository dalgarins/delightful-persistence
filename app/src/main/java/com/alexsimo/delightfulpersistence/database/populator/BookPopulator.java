package com.alexsimo.delightfulpersistence.database.populator;

import android.database.sqlite.SQLiteDatabase;
import com.alexsimo.delightfulpersistence.database.model.Book;
import com.alexsimo.delightfulpersistence.database.model.BookModel;
import java.util.GregorianCalendar;

public class BookPopulator {
  public static void populate(SQLiteDatabase db) {

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal()
            .title("Harry Potter and the Cursed Child")
            .isbn("1338099132")
            .release_year(new GregorianCalendar(2016, 31, 7))
            .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal()
            .title("Harry Potter and the Sorcerer's Stone: The Illustrated Edition")
            .isbn("0545790352")
            .release_year(new GregorianCalendar(2015, 6, 10))
            .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("A Shade Of Vampire")
        .isbn("1481280767")
        .release_year(new GregorianCalendar(2012, 12, 21))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("The Obsession")
        .isbn("0399175164")
        .release_year(new GregorianCalendar(2016, 3, 16))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("Stars of Fortune")
        .isbn("0425280101")
        .release_year(new GregorianCalendar(2015, 11, 3))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("The Last Mile")
        .isbn("1455586455")
        .release_year(new GregorianCalendar(2016, 19, 3))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("Memory Man")
        .isbn("1455559814")
        .release_year(new GregorianCalendar(2015, 15, 9))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("The Queen's Poisoner")
        .isbn("1503953300")
        .release_year(new GregorianCalendar(2016, 1, 3))
        .asContentValues());

    db.insert(BookModel.TABLE_NAME, null, Book.FACTORY.marshal().title("The Wretched of Muirwood")
        .isbn("1612187005")
        .release_year(new GregorianCalendar(2013, 15, 1))
        .asContentValues());
  }
}
