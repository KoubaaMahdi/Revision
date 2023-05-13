package com.example.revisionbasedonns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {
    EditText name ;
    EditText description;
    Button add;
    LocalDataBase db;
    void init(){
        name=findViewById(R.id.editTextTitle);
        description=findViewById(R.id.editTextDescription);
        add=findViewById(R.id.buttonAddText);
        db = new LocalDataBase(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        init();
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Chapters book = new Chapters(name.getText().toString(),description.getText().toString());
                db.openForWrite();
                db.InsertBook(book);
            }
        });
    }
}