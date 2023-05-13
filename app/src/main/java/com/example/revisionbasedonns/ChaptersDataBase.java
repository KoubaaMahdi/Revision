package com.example.revisionbasedonns;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ChaptersDataBase extends SQLiteOpenHelper {
    private static final String Table_name = "table_Books";
    private static final String Col_ID = "ID";
    private static final String Col_Name = "Name";
    private static final String Col_Desc = "Description";

    private static final String Create_BDD = "CREATE TABLE "+Table_name+
            " ("+Col_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Col_Name+ " Text NOT NULL,"+
            Col_Desc + " Text NOT NULL );";
    public ChaptersDataBase(Context context, String name , SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+Table_name);
        onCreate(db);
    }
}
