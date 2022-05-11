package com.example.registrationformapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        TextView welcomeTextView= findViewById(R.id.welcomeTextView);

        welcomeTextView.setText("WELCOME HERE "+Utility.getPrefValue(this,Constants.PREF_USER_NAME_KEY));




    }
}
