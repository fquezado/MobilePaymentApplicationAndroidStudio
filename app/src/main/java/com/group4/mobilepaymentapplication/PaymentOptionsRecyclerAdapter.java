package com.group4.mobilepaymentapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentOptionsRecyclerAdapter extends RecyclerView.Adapter<PaymentOptionsRecyclerAdapter.MyViewHolder> {

    private ArrayList<Object> itemList;
    private OnItemClickListener mListener;

    // Interface for click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Constructor
    public PaymentOptionsRecyclerAdapter(ArrayList<Object> itemList) {
        this.itemList = itemList;
    }

    // ViewHolder class
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView primaryText;
        private TextView secondaryText;

        public MyViewHolder(final View view) {
            super(view);
            primaryText = view.findViewById(R.id.textPrimary);
            secondaryText = view.findViewById(R.id.textSecondary);

            // Set the click listener for the itemView
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public PaymentOptionsRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionsRecyclerAdapter.MyViewHolder holder, int position) {
        Object item = itemList.get(position);
        if (item instanceof CreditCard) {
            CreditCard card = (CreditCard) item;
            holder.primaryText.setText("Card Number: " + card.getCardNumber());
            holder.secondaryText.setText("Card Name: " + card.getName());

        } else if (item instanceof BankAccount) {
            BankAccount account = (BankAccount) item;
            holder.primaryText.setText("Account Holder: " + account.getAccountHolderName());
            holder.secondaryText.setText("Account Number: " + account.getAccountNumber());
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
