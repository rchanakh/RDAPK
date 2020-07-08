package com.example.rdapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class PostAdapter extends FirebaseRecyclerAdapter<Retrive, PostAdapter.PastViewHolder> {

    private Context context;

    public PostAdapter(@NonNull FirebaseRecyclerOptions<Retrive> options, Context context) {
        super(options);
        this.context = context;
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, final int i, @NonNull final Retrive post) {


        holder.name.setText(post.getName());
        holder.amount.setText(post.getAmount());
        holder.acc_no.setText(post.getAccNo());
        holder.mobile_no.setText(post.getMobile());
        holder.date.setText(post.getDate());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference()
                        .child("user_info")
                        .child(getRef(i).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

                for(int j=0; j<13; j++) {
                    FirebaseDatabase.getInstance().getReference()
                            .child("month_entry")
                            .child(getRef(i).getKey()+"_"+j)
                            .removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });
                }

                for(int j=0; j<13; j++) {
                    FirebaseDatabase.getInstance().getReference()
                            .child("month_paid")
                            .child(getRef(i).getKey()+"_"+j)
                            .removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });
                }
            }
        });


    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView  name, amount, acc_no, mobile_no, date;
        ImageView delete;




        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            acc_no = itemView.findViewById(R.id.acc_no);
            mobile_no = itemView.findViewById(R.id.mobile);
            date = itemView.findViewById(R.id.date);
            delete = itemView.findViewById(R.id.delete);


        }
    }
}
