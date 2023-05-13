package com.example.revisionbasedonns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewChapters extends AppCompatActivity {
    LocalDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chapters);
        db = new LocalDataBase(this);
        db.openForRead();
        ListView lv = findViewById(R.id.list);
        ArrayList<Chapters> arr = db.getBooks();
        Log.d("Tag",arr.get(0).getName());
        ArrayAdapter<Chapters> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);
    }
}