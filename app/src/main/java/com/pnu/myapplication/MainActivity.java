package com.pnu.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        nextPage=findViewById(R.id.nextPageButton);
        DatabaseHelper db = new DatabaseHelper(this);
        // Inserting four values to  users table
        Log.d("Insert: ", "Inserting ..");
        db.addUser(new User("salwa", "1234"));
        db.addUser(new User("noor", "1234"));
        db.addUser(new User("ali", "1234"));
        db.addUser(new User("ahmed", "1234"));
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLoginActivity();
            }
        });
    }
    public void moveToLoginActivity(){
        Intent intent =new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}