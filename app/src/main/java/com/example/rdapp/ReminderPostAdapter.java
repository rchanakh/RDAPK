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

public class ReminderPostAdapter extends FirebaseRecyclerAdapter<Paid, ReminderPostAdapter.PastViewHolder> {

    private Context context;

    public String AccNo, Date, Month3, Amount;

    //DatabaseReference databasemonthpaid = FirebaseDatabase.getInstance().getReference("month_paid");

    public ReminderPostAdapter(@NonNull FirebaseRecyclerOptions<Paid> options, Context context) {
        super(options);
        this.context = context;
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, final int i, @NonNull final Paid post) {


        holder.name.setText(post.getName());
        holder.amount.setText(post.getAmount());
        holder.acc_no.setText(post.getAccNo());
        holder.month.setText(post.getMonth3());
        holder.date.setText(post.getDate());

        AccNo = post.getAccNo();
        Date = post.getDate();
        Month3 = post.getMonth3();
        Amount = post.getAmount();



        holder.paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference()
                        .child("month_entry")
                        .child(getRef(i).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {


                            }

                        });

                MonthPaid monthPaid = new MonthPaid(AccNo, Date, Month3, Amount);
                FirebaseDatabase.getInstance().getReference("month_paid")
                        .child(getRef(i).getKey())
                        .setValue(monthPaid)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

            }
        });


    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_2, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView  name, amount, acc_no, date, month;
        ImageView paid;




        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name2);
            amount = itemView.findViewById(R.id.amount2);
            acc_no = itemView.findViewById(R.id.acc_no2);
            month = itemView.findViewById(R.id.month2);
            date = itemView.findViewById(R.id.date2);
            paid = itemView.findViewById(R.id.paid);


        }
    }
}
