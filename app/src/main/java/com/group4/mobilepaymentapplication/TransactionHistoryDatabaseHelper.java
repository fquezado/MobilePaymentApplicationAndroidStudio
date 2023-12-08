package com.group4.mobilepaymentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "transactions.db";
    private static final int DATABASE_VERSION = 8;

    public TransactionHistoryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TRANSACTION = "CREATE TABLE transactions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "amount TEXT, " +
                "paymentMethod TEXT, " +
                "date TEXT)";
        db.execSQL(CREATE_TABLE_TRANSACTION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If the table exists, delete it
        db.execSQL("DROP TABLE IF EXISTS transactions");

        // Recreate the table with the updated schema
        onCreate(db);
    }

    public void addTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("amount", transaction.getAmount());
        values.put("paymentMethod", transaction.getPaymentMethod());
        values.put("date", transaction.getDate());

        db.insert("transactions", null, values);
        db.close();
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Check if the 'transactions' table exists
        Cursor checkCursor = db.rawQuery("SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name = 'transactions'", null);
        boolean tableExists = false;
        if (checkCursor != null && checkCursor.moveToFirst()) {
            int count = checkCursor.getInt(0);
            tableExists = count > 0;
            checkCursor.close();
        }

        if (tableExists) {
            String selectQuery = "SELECT * FROM transactions";
            Cursor cursor = db.rawQuery(selectQuery, null);

            int amountIndex = cursor.getColumnIndex("amount");
            int paymentMethodIndex = cursor.getColumnIndex("paymentMethod");
            int dateIndex = cursor.getColumnIndex("date");

            if (cursor.moveToFirst()) {
                do {
                    String amount = amountIndex != -1 ? cursor.getString(amountIndex) : "N/A";
                    String paymentMethod = paymentMethodIndex != -1 ? cursor.getString(paymentMethodIndex) : "N/A";
                    String date = dateIndex != -1 ? cursor.getString(dateIndex) : "N/A";

                    Transaction transaction = new Transaction(amount, paymentMethod, date);
                    transactions.add(transaction);
                } while (cursor.moveToNext());
            }

            cursor.close();
        } else {
            // Table doesn't exist, return a list with one Transaction object with "N/A" fields
            transactions.add(new Transaction("N/A", "N/A", "N/A"));
        }

        db.close();
        return transactions;
    }


}
