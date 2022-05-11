package com.example.registrationformapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String tag = "login";

    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        password = (EditText) findViewById(R.id.password);
        userName = (EditText) findViewById(R.id.userName);


        Utility.printLog(tag,"on create login");

        Button reset=(Button) findViewById(R.id.resetButton);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName.setText("");
                password.setText("");
                int age = getIntent().getIntExtra("age",0);
                Toast toast = Toast.makeText(LoginActivity.this, "reset clicked "+age+"--"+getIntent(), Toast.LENGTH_LONG);
                toast.show();
            }
        });


        Button login=(Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = userName.getText().toString();
                String pw = password.getText().toString();

                Toast toastLogin =Toast.makeText(LoginActivity.this, user+"---"+pw, Toast.LENGTH_SHORT);
                toastLogin.show();

                Utility.savePref(LoginActivity.this,Constants.PREF_USER_NAME_KEY,user);

                Utility.savePref(LoginActivity.this,Constants.PREF_IS_LOGIN,true);

              /*  SharedPreferences pref = Utility.getSharedPref(LoginActivity.this);
                SharedPreferences.Editor edit = pref.edit();
                edit.putBoolean("isLogin",true);
                edit.commit();*/

                Intent   intent = new Intent(view.getContext(),DashboardActivity.class);
                startActivity(intent);

            }
        });



        Button register = findViewById(R.id.regButton);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast toastReg =Toast.makeText(LoginActivity.this, "Register", Toast.LENGTH_SHORT);
                toastReg.show();

                Intent intent = new Intent(view.getContext(),RegistrationActivity.class);
              //  startActivity(intent);//
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == Activity.RESULT_OK){
            String firstname= data.getStringExtra("firstName");
            String lastname= data.getStringExtra("lastName");
            String city= data.getStringExtra("cityName");
            String mob= data.getStringExtra("mobNumber");
            Utility.printLog("first",firstname +"-"+lastname+"-"+city+"-"+mob);

            userName.setText(firstname);

        }else if(resultCode == Activity.RESULT_CANCELED){
            Toast toastReg =Toast.makeText(LoginActivity.this, "Register Canceled", Toast.LENGTH_SHORT);
            toastReg.show();
        }


    }




    @Override
    protected void onStart() {
        super.onStart();
        Utility.printLog(tag,"on start login");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utility.printLog(tag,"on resume login");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Utility.printLog(tag,"on pause login");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utility.printLog(tag,"on stop login");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utility.printLog(tag,"on destroy login");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utility.printLog(tag,"on restart login");
    }

}
