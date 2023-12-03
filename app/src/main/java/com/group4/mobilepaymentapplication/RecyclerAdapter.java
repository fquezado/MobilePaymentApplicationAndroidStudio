package com.group4.mobilepaymentapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<PaymentCard> cardList;

    public RecyclerAdapter(ArrayList<PaymentCard> cardList)
    {
        this.cardList = cardList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;
        private TextView numberTxt;

        public MyViewHolder(final View view)
        {
            super (view);
            nameTxt = view.findViewById(R.id.textCardHolderName);
            numberTxt = view.findViewById(R.id.textCardNumber);
        }
    }


    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String number = "Card Number: " + cardList.get(position).getCardNumber();
        String name = "Card Name: " + cardList.get(position).getName();
        holder.numberTxt.setText(number);
        holder.nameTxt.setText(name);

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
