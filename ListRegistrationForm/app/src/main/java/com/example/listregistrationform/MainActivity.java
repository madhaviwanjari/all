package com.example.listregistrationform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnClickItemListner {
    CustomAdapter customAdapter;
    ArrayList<UserDetails> userDetailsList;
    ListView listView;
    UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        userDetailsList =new ArrayList<>();
        customAdapter=new CustomAdapter(this, userDetailsList,this);
        listView.setAdapter(customAdapter);

        Intent intent = new Intent(this,Registration.class);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == Activity.RESULT_OK){
         UserDetails userDetails= (UserDetails) data.getSerializableExtra("DATA");

          userDetailsList.add(userDetails);

          customAdapter.notifyDataSetChanged();
        }else if(resultCode == Activity.RESULT_CANCELED){
            Toast toastReg =Toast.makeText(this, "Register Canceled", Toast.LENGTH_SHORT);
            toastReg.show();
        }


    }

    @Override
    public void onItemClick(UserDetails userDetails) {

        Toast toastReg =Toast.makeText(this, "userDetails Canceled"+userDetails.userName, Toast.LENGTH_SHORT);
        toastReg.show();

    }
}