package com.example.revisionbasedonns;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class LocalDataBase {
    private static final int VERSION = 1;
    private static final String Table_name = "table_Books";
    private static final String Col_ID = "ID";
    private static final String Col_Name = "Name";
    private static final String Col_Desc = "Description";
    private SQLiteDatabase bd;
    private ChaptersDataBase books;

    public LocalDataBase(Context context){
        books = new ChaptersDataBase(context, Table_name,null,VERSION);
    }
    public void openForWrite(){
        bd = books.getWritableDatabase();
    }
    public void openForRead(){
        bd = books.getReadableDatabase();
    }
    public void Close(){
        bd.close();
    }
    public SQLiteDatabase getBd(){
        return bd;
    }
    public void InsertBook(Chapters book){
        ContentValues content = new ContentValues();
        content.put(Col_Name,book.getName());
        content.put(Col_Desc,book.getDescription());
        bd.insert(Table_name,null,content);
    }
    public void DeleteBook(String name){
        String selection = Col_Name + " = ?";
        String[] selectionArgs = { name };
        bd.delete(Table_name, selection, selectionArgs);

    }

    public ArrayList<Chapters> getBooks(){
        Cursor c = bd.query(Table_name, new String[]{Col_ID,Col_Name,Col_Desc},null,null,null,null,null);
        if(c.getCount()==0){
            c.close();
            return null;
        }
        ArrayList<Chapters> bookLists = new ArrayList<Chapters>();
        while (c.moveToNext()){
            Chapters ch = new Chapters();
            ch.setName(c.getString(c.getColumnIndexOrThrow(Col_Name)));  // Set the correct column index for the chapter name
            ch.setDescription(c.getString(c.getColumnIndexOrThrow(Col_Desc)));
            bookLists.add(ch);
        }
        c.close();
        return bookLists;
    }
}
