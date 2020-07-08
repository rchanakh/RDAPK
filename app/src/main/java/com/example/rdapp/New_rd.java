package com.example.rdapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class New_rd extends AppCompatActivity {

    EditText name, amount, acc_no, mobile_no, date;
    Button BtnSub;
    DatePickerDialog datePickerDialog;
    DatabaseReference databaseUserInfo;
    DatabaseReference databasemonthentry;
    DatabaseReference databasemonthpaid;
    int month1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rd);
        getSupportActionBar().setTitle("New RD");

        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year= calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(New_rd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        month1 = month+1;
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        databaseUserInfo = FirebaseDatabase.getInstance().getReference("user_info");
        databasemonthentry = FirebaseDatabase.getInstance().getReference("month_entry");
        databasemonthpaid = FirebaseDatabase.getInstance().getReference("month_paid");

        name = (EditText) findViewById(R.id.txt_Name);
        amount = (EditText) findViewById(R.id.amount);
        acc_no = (EditText) findViewById(R.id.accNo);
        mobile_no = (EditText) findViewById(R.id.mobile);
        date = (EditText) findViewById(R.id.date);
        BtnSub = (Button) findViewById(R.id.btnsubmit);

        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString().trim();
                String Amount = amount.getText().toString().trim();
                String AccNo = acc_no.getText().toString().trim();
                String MobileNo = mobile_no.getText().toString().trim();
                String Date = date.getText().toString().trim();


                if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(New_rd.this, "Please enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Amount)) {
                    Toast.makeText(New_rd.this, "Please enter Amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(AccNo)) {
                    Toast.makeText(New_rd.this, "Please enter A/c No", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(MobileNo)) {
                    Toast.makeText(New_rd.this, "Please enter Mobile No", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Date)) {
                    Toast.makeText(New_rd.this, "Please enter Date", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (MobileNo.length() != 10) {
                    Toast.makeText(New_rd.this, "Mobile No must be 10 Digit", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!TextUtils.isEmpty(Name)){
                    //String id = databaseUserInfo.push().getKey();

                    UserInfoDB userInfoDB = new UserInfoDB(Name, Amount, AccNo, MobileNo, Date, month1);

                    databaseUserInfo.child(AccNo).setValue(userInfoDB);

                    for(int month2=month1; month2>0; month2--)
                    {
                        //String id1 = databasemonthentry.push().getKey();
                        String month3 = String.valueOf(month2);
                        MonthEntry monthentry = new MonthEntry( Name,Amount,AccNo,Date,month3);

                        databasemonthentry.child(AccNo+"_"+month3).setValue(monthentry);

//                        String id1 = databasemonthpaid.push().getKey();
//                        MonthPaid monthPaid = new MonthPaid(AccNo, Date, month3, Amount);
//                        databasemonthpaid.child(AccNo+"_"+month3).setValue(monthPaid);

                    }

                    for(int month2=month1+1; month2<=12; month2++)
                    {
                        //String id2 = databasemonthentry.push().getKey();
                        String month3 = String.valueOf(month2);
                        MonthEntry monthentry = new MonthEntry( Name,Amount,AccNo,Date,month3);
                        databasemonthentry.child(AccNo+"_"+month3).setValue(monthentry);

//                        String id2 = databasemonthpaid.push().getKey();
//                        MonthPaid monthPaid = new MonthPaid(AccNo, Date, month3, Amount);
//                        databasemonthpaid.child(AccNo+"_"+month3).setValue(monthPaid);
                    }

                    Toast.makeText(New_rd.this, "Successful !", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

                else{
                    Toast.makeText(New_rd.this, "Failed !", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void btn_Home(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    //void addUserInfo(){


    //}
}
