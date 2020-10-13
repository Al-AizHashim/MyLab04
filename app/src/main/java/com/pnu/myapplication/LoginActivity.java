package com.pnu.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
    public  String  userName, dbpassword , dbUsername;
    String password ="0";
    EditText userNameTextView, passwordTextView;
    Button loginButton;
    boolean wrongInput=true;
    List<User> uu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        loginButton=findViewById(R.id.loginButton);
        userNameTextView=findViewById(R.id.userNametextView11);
        passwordTextView=findViewById(R.id.passwordtextView);

        loginButton.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                password = passwordTextView.getText().toString();
                userName = userNameTextView.getText().toString();

               if (userName.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fileds are empty", Toast.LENGTH_SHORT).show();
                }


                else {
                    while (wrongInput){
                         uu = db.getUsers(userName);
                         if(uu!=null)
                             wrongInput=false;
                    }

                   for (User u : uu) {
                       dbUsername =  u.getName() ;
                       dbpassword = u.getPassword();

                   }
                   if(dbUsername.equals(userName) && dbpassword.equals(password)) {
                       Toast.makeText(getApplicationContext(), "you Login successfully", Toast.LENGTH_SHORT).show();
                       moveToWelcomeActivity();
                   }else
                       Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

               }


            }
        });
    }
    public void moveToWelcomeActivity(){

        Intent intent =new Intent(this,WelcomActivity3.class);
        intent.putExtra ("name",userName);
        startActivity(intent);
    }

}