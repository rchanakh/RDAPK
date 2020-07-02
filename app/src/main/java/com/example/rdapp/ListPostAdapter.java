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

public class ListPostAdapter extends FirebaseRecyclerAdapter<Retrive, ListPostAdapter.PastViewHolder> {

    private Context context;

    public ListPostAdapter(@NonNull FirebaseRecyclerOptions<Retrive> options, Context context) {
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

        /*holder.delete.setOnClickListener(new View.OnClickListener() {
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
            }
        });*/


    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_1, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView  name, amount, acc_no, mobile_no, date;
        ImageView delete;




        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name1);
            amount = itemView.findViewById(R.id.amount1);
            acc_no = itemView.findViewById(R.id.acc_no1);
            mobile_no = itemView.findViewById(R.id.mobile1);
            date = itemView.findViewById(R.id.date1);
            //delete = itemView.findViewById(R.id.delete);


        }
    }
}
