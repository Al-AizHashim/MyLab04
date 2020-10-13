package com.pnu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomActivity3 extends AppCompatActivity {
    String name;
    TextView WelcomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent!=null) {
            name = intent.getStringExtra("name");
        }
        setContentView(R.layout.activity_welcom3);
        WelcomeTextView=findViewById(R.id.welcometextView);
        Bundle obj=getIntent().getExtras();
        name=null;
        if (obj != null){
            name=obj.getString("name");
        }
        WelcomeTextView.setText("Welcome "+name+" ^^");
    }
}