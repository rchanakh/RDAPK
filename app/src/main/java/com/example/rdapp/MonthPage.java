package com.example.rdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MonthPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_page);
    }

    public void btn_jan(View view) { startActivity(new Intent(getApplicationContext(), Reminder.class));
    }

    public void btn_feb(View view) { startActivity(new Intent(getApplicationContext(), Reminder22.class));
    }

    public void btn_mar(View view) {startActivity(new Intent(getApplicationContext(), Reminder333.class));
    }

    public void btn_apr(View view) {startActivity(new Intent(getApplicationContext(), Reminder44.class));
    }

    public void btn_may(View view) {startActivity(new Intent(getApplicationContext(), Reminder5.class));
    }

    public void btn_jun(View view) {startActivity(new Intent(getApplicationContext(), Reminder6.class));
    }

    public void btn_jul(View view) {startActivity(new Intent(getApplicationContext(), Reminder7.class));
    }

    public void btn_aug(View view) {startActivity(new Intent(getApplicationContext(), Reminder8.class));
    }

    public void btn_sep(View view) {startActivity(new Intent(getApplicationContext(), Reminder9.class));
    }

    public void btn_oct(View view) {startActivity(new Intent(getApplicationContext(), Reminder10.class));
    }

    public void btn_nov(View view) {startActivity(new Intent(getApplicationContext(), Reminder11.class));
    }

    public void btn_dec(View view) {startActivity(new Intent(getApplicationContext(), Reminder12.class));
    }

}
