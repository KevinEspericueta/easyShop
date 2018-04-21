package com.example.rga_c.easyshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = (Button)findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(loginActivity.this, MainActivity.class);
                startActivity(signup);
            }
        });


    }

/*    public void login(View v) {
        EditText userEdt = findViewById(R.id.username);
        String username = userEdt.getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();


        *//* Validate Credentials *//*


        user user = new user(username, username+"@test.com", password);

        Intent intent = new Intent(loginActivity.this, MainActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("user_id", user.getId());
        intent.putExtra("user", user);

        *//* Calls the new activity*//*
        startActivity(intent);
    }*/

/*    public void signup(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
}
