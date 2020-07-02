package com.example.rdapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Reminder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReminderPostAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().setTitle("Reminder");

        recyclerView = findViewById(R.id.recycler3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Paid> options =
                new FirebaseRecyclerOptions.Builder<Paid>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("month_entry"), Paid.class)
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


