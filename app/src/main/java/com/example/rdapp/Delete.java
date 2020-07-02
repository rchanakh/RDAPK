package com.example.rdapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Delete extends AppCompatActivity {


    private RecyclerView recyclerView;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setTitle("Delete");


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Retrive> options =
                new FirebaseRecyclerOptions.Builder<Retrive>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("user_info"), Retrive.class)
                        .build();

        adapter = new PostAdapter(options,this);
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

/*

 ListView RDlistview;
    FirebaseDatabase database;
    DatabaseReference ref;

    //DatabaseReference databaseUserInfo;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Retrive retrive;


//databaseUserInfo = FirebaseDatabase.getInstance().getReference("user_info");

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

        RDlistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
@Override
public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {

final int which_item = position;
        //final Retrive re = (Retrive) parent.getItemAtPosition(which_item);


        new AlertDialog.Builder(Delete.this).setIcon(android.R.drawable.sym_def_app_icon).
        setTitle("Are you Sure ?").setMessage("Are you want to Delete the item ?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        //list.remove(which_item);
        FirebaseDatabase.getInstance().getReference().child("user_info")
        .child().setValue(null).addOnCompleteListener(
        new OnCompleteListener<Void>() {
@Override
public void onComplete(@NonNull Task<Void> task) {
        Toast.makeText(Delete.this, "Successful !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        }
        );

        //databaseUserInfo.child(re.getAccNo()).removeValue();
        adapter.notifyDataSetChanged();
        //RDlistview.setAdapter(adapter);
        }
        })
        .setNegativeButton("No",null).show();


        return true;
        }
        });
        }

@Override
public void onCancelled(@NonNull DatabaseError databaseError) {

        }
        });



        }



public void btn_Home(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        */