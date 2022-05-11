package com.example.registrationformapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    public static final String tag = "register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utility.printLog(tag,"on create register");

        Button reset=(Button) findViewById(R.id.resetButtonId);
        EditText firstName = (EditText) findViewById(R.id.firstNameId);
        EditText lastName = (EditText) findViewById(R.id.lastNameId);
        EditText city = (EditText) findViewById(R.id.cityId);
        EditText mobNo = (EditText) findViewById(R.id.mobId);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
                city.setText("");
                mobNo.setText("");
                Toast toast = Toast.makeText(RegistrationActivity.this, "reset clicked", Toast.LENGTH_LONG);
                toast.show();
            }
        });


        Button ok=(Button) findViewById(R.id.OkButtonId);
        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String fName = firstName.getText().toString();
                String lName = lastName.getText().toString();
                String cityName = city.getText().toString();
                String mob = mobNo.getText().toString();
                Toast toastReg =Toast.makeText(RegistrationActivity.this, fName+"-"+lName+"-"+cityName+"-"+mob, Toast.LENGTH_SHORT);
                toastReg.show();

                Intent intent = new Intent();
                intent.putExtra("firstName",fName);
                intent.putExtra("lastName",lName);
                intent.putExtra("cityName",cityName);
                intent.putExtra("mobNumber",mob);

                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        setResult(Activity.RESULT_CANCELED);
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Utility.printLog(tag,"on start register");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utility.printLog(tag,"on resume register");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Utility.printLog(tag,"on pause register");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utility.printLog(tag,"on stop register");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utility.printLog(tag,"on destroy register");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utility.printLog(tag,"on restart register");
    }

}