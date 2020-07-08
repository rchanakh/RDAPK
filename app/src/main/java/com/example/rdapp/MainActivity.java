package com.example.rdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_newRD(View view) {
        startActivity(new Intent(getApplicationContext(), New_rd.class));
    }

    public void btn_UserInfo(View view) {
        startActivity(new Intent(getApplicationContext(), Userinfo.class));
    }

    public void btn_remind(View view) {
        startActivity(new Intent(getApplicationContext(), MonthPage.class));
    }

    public void btn_List(View view) {
        startActivity(new Intent(getApplicationContext(), RDList1.class));
        //Intent intent = new Intent(MainActivity.this, RDList1.class);
        //startActivity(intent);
    }

    public void btn_Delete(View view) {
        startActivity(new Intent(getApplicationContext(), Delete.class));
    }


}
