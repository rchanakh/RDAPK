package com.example.rdapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RDList1 extends AppCompatActivity {

    /*ListView RDlistview;
    FirebaseDatabase database;
    DatabaseReference ref;

    ArrayList<String> list;
    ArrayAdapter <String> adapter;
    Retrive retrive;*/

    private RecyclerView recyclerView;
    private ListPostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdlist1);
        getSupportActionBar().setTitle("RD List");

        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Retrive> options =
                new FirebaseRecyclerOptions.Builder<Retrive>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("user_info"), Retrive.class)
                        .build();

        adapter = new ListPostAdapter(options,this);
        recyclerView.setAdapter(adapter);




        /*
        retrive = new Retrive();

        RDlistview =(ListView) findViewById(R.id.listviewrduser);
        database =FirebaseDatabase.getInstance();
        ref = database.getReference("user_info");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.userlist_info,R.id.userinfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    retrive =ds.getValue(Retrive.class);
                    list.add("Name:"+retrive.getName().toString()+"\n"+"Amt:"+retrive.getAmount().toString()+"\n"+
                            "A/c No:"+retrive.getAccNo().toString()+"\n"+"Mob :"+retrive.getMobile().toString()+"\n"
                    +"Date:"+retrive.getDate().toString());
                }
                RDlistview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    */



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


    public void btn_Home(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
