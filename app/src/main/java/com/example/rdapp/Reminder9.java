package com.example.rdapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Reminder9 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReminderPostAdapter adapter;

    //private Spinner spinner;


    String xyz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().setTitle("Reminder");


        //onStart();

/*
        Spinner spinner = findViewById(R.id.spinner1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xyz= parent.getSelectedItem().toString();
                //Toast.makeText(Reminder.this,parent.getSelectedItem().toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
        recyclerView = findViewById(R.id.recycler3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String abc= xyz;
        FirebaseRecyclerOptions<Paid> options =
                new FirebaseRecyclerOptions.Builder<Paid>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("month_entry").orderByChild("Month3").equalTo("9"), Paid.class)
                        .build();

        adapter = new ReminderPostAdapter(options,this);
        recyclerView.setAdapter(adapter);
    }



    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}


