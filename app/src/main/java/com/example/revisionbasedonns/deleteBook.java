package com.example.revisionbasedonns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class    deleteBook extends AppCompatActivity {
    EditText name;
    Button btn;
    LocalDataBase bd;

    public void init(){
        name = findViewById(R.id.editTextBookName);
        btn=findViewById(R.id.buttonDelete);
        bd=new LocalDataBase(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);
        init();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.openForWrite();
                bd.DeleteBook(name.getText().toString());
            }
        });
    }
}