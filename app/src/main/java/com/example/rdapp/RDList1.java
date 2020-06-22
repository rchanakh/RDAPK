package com.example.rdapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RDList1 extends AppCompatActivity {

    ListView RDlistview;
    FirebaseDatabase database;
    DatabaseReference ref;

    ArrayList<String> list;
    ArrayAdapter <String> adapter;
    Retrive retrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdlist1);
        getSupportActionBar().setTitle("RD List");

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



    }

    public void btn_Home(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
/* ListView listviewrduser1;
    DatabaseReference databaseUserInfo;

    List<UserInfoDB> userInfoDBRDList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdlist1);
        getSupportActionBar().setTitle("RD List");

        databaseUserInfo = FirebaseDatabase.getInstance().getReference("user_info");

        listviewrduser1 =(ListView) findViewById(R.id.listviewrduser);

        userInfoDBRDList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseUserInfo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userInfoDBRDList.clear();
                for(DataSnapshot rdusersnapshot : dataSnapshot.getChildren()){
                    UserInfoDB userInfoDB = rdusersnapshot.getValue(UserInfoDB.class);
                    userInfoDBRDList.add(userInfoDB);

                }

                RdUserList adapter = new RdUserList(RDList1.this, userInfoDBRDList);
                listviewrduser1.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/