package com.example.registrationformapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    public static final String tag = "splash";
    boolean isLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        isLogin= Utility.getSharedPref(this).getBoolean("isLogin",false);

        Utility.printLog("loginStatus","1111111     "+isLogin);

        Utility.printLog(tag,"on create splash");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                       update();
            }
        },(10000));

        }

    private void update() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SplashActivity.this, "hello", Toast.LENGTH_SHORT).show();
                View view = findViewById(R.id.imageView);
                Intent intent;
                // Intent intent = new Intent(view.getContext(),LoginActivity.class);
                // intent.putExtra("age",25);
                //startActivity(intent);


                isLogin= Utility.getSharedPref(SplashActivity.this).getBoolean("isLogin",false);

                Utility.printLog("loginStatus","1111111     "+isLogin);

                if(isLogin){
                    intent = new Intent(view.getContext(),DashboardActivity.class);
                }else {
                    intent = new Intent(view.getContext(),LoginActivity.class);
                    intent.putExtra("age",25);
                }
                startActivity(intent);
                finish();
                Utility.printLog(tag,"after finish splash"+intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Utility.printLog(tag,"on start splash");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utility.printLog(tag,"on resume splash");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Utility.printLog(tag,"on pause splash");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utility.printLog(tag,"on stop splash");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utility.printLog(tag,"on destroy splash");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utility.printLog(tag,"on restart splash");
    }


}
