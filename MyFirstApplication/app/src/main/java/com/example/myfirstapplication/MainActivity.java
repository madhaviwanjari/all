package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      Button reset=(Button) findViewById(R.id.resetButton);
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);

      reset.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              userName.setText("");
              password.setText("");
              Toast toast = Toast.makeText(MainActivity.this, "reset clicked", Toast.LENGTH_LONG);
                    toast.show();
          }
      });


        Button login=(Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = userName.getText().toString();
                String pw = password.getText().toString();
                Toast toastLogin =Toast.makeText(MainActivity.this, user+"---"+pw, Toast.LENGTH_SHORT);
                toastLogin.show();
            }
        });
    }
}