package com.example.revisionbasedonns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;

    private void init(){
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button3);
        b3=findViewById(R.id.button2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ecouteClick();
    }
    private void navigateToActivity(Class nextActivity){
        Intent intent= new Intent(MainActivity.this,nextActivity);
        startActivity(intent);
    }
    private void ecouteClick(){
        b1.setOnClickListener((View.OnClickListener)this);
        b2.setOnClickListener((View.OnClickListener)this);
        b3.setOnClickListener((View.OnClickListener)this);
    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.button){
            navigateToActivity(AddBook.class);
        }
        else if(v.getId()==R.id.button2){
            navigateToActivity(viewChapters.class);
        }else{
            navigateToActivity(deleteBook.class);
        }

    }
}