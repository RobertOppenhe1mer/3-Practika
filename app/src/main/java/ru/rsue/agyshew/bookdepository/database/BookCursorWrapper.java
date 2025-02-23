package ru.rsue.agyshew.bookdepository.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import ru.rsue.agyshew.bookdepository.Book;

import java.util.Date;
import java.util.UUID;

public class BookCursorWrapper extends CursorWrapper {
    public BookCursorWrapper(Cursor cursor){
        super(cursor);
    }
    public Book getBook() {
        String uuidString = getString(getColumnIndex(BookDbSchema.BookTable.Cols.UUID));
        String title = getString(getColumnIndex(BookDbSchema.BookTable.Cols.TITLE));
        long date = getLong(getColumnIndex(BookDbSchema.BookTable.Cols.DATE));
        int isReaded = getInt(getColumnIndex(BookDbSchema.BookTable.Cols.READED));
        Book book = new Book(UUID.fromString(uuidString));
        book.setTitle(title);
        book.setDate(new Date(date));
        book.setReaded(isReaded != 0);
        return book;
    }
}
