package com.example.listregistrationform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    public static final String tag = "register";

    EditText userName;
    EditText password;
    EditText city ;
    EditText mobNo ;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);

          reset=(Button) findViewById(R.id.resetButtonId);
          userName = (EditText) findViewById(R.id.userNameId);
          password = (EditText) findViewById(R.id.passwordId);
          city = (EditText) findViewById(R.id.cityId);
          mobNo = (EditText) findViewById(R.id.mobId);

        reset.setOnClickListener(this);
        Button ok=(Button) findViewById(R.id.OkButtonId);
        ok.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        setResult(Activity.RESULT_CANCELED);
        finish();

    }

    @Override
    public void onClick(View view) {
//        if(view.equals(reset)){
//
//        }

        if(view.getId()==R.id.resetButtonId){
           onReset();
        }else if(view.getId()==R.id.OkButtonId){
            String uName = userName.getText().toString();
            String passwrd = password.getText().toString();
            String cityName = city.getText().toString();
            String mob = mobNo.getText().toString();
            UserDetails   userDetails = new UserDetails(uName,passwrd,cityName,mob,R.drawable.aaa);
            Toast toastReg =Toast.makeText(Registration.this, uName+"-"+passwrd+"-"+cityName+"-"+mob, Toast.LENGTH_SHORT);
            toastReg.show();

            Intent intent = new Intent();
            Log.d("rList","requestCode ok "+userName+" "+password+" "+city+" "+mob);
            intent.putExtra("DATA",userDetails);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }

    private void onReset() {
        userName.setText("");
        password.setText("");
        city.setText("");
        mobNo.setText("");
        Toast toast = Toast.makeText(Registration.this, "reset clicked", Toast.LENGTH_LONG);
        toast.show();
    }
}
