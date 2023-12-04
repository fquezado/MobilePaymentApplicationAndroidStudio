package com.group4.mobilepaymentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CardDatabase";
    private static final String TABLE_CARDS = "cards";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CARD_NUMBER = "card_number";
    private static final String KEY_EXPIRY_DATE = "expiry_date";
    private static final String KEY_CCV_CODE = "ccv_code";

    private static final String TABLE_BANK_ACCOUNTS = "bank_accounts";
    private static final String KEY_BANK_ID = "id";
    private static final String KEY_ACCOUNT_HOLDER_NAME = "account_holder_name";
    private static final String KEY_ACCOUNT_NUMBER = "account_number";
    private static final String KEY_ROUTING_NUMBER = "routing_number";

    private static final int DATABASE_VERSION = 3;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CARDS_TABLE = "CREATE TABLE " + TABLE_CARDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CARD_NUMBER + " TEXT,"
                + KEY_EXPIRY_DATE + " TEXT,"
                + KEY_CCV_CODE + " TEXT" + ")";
        db.execSQL(CREATE_CARDS_TABLE);

        String CREATE_BANK_ACCOUNTS_TABLE = "CREATE TABLE " + TABLE_BANK_ACCOUNTS + "("
                + KEY_BANK_ID + " INTEGER PRIMARY KEY,"
                + KEY_ACCOUNT_HOLDER_NAME + " TEXT,"
                + KEY_ACCOUNT_NUMBER + " TEXT,"
                + KEY_ROUTING_NUMBER + " TEXT" + ")";
        db.execSQL(CREATE_BANK_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
        onCreate(db);
    }

    void addCard(CreditCard card) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.getName());
        values.put(KEY_CARD_NUMBER, card.getCardNumber());
        values.put(KEY_EXPIRY_DATE, card.getExpiryDate());
        values.put(KEY_CCV_CODE, card.getCcvCode());

        db.insert(TABLE_CARDS, null, values);
        db.close();
    }

    public void deleteCard(String cardNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CARDS, KEY_CARD_NUMBER + " = ?", new String[] { cardNumber });
        db.close();
    }

    ArrayList<CreditCard> getAllCards() {
        ArrayList<CreditCard> cardList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CARDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CreditCard card = new CreditCard(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                cardList.add(card);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return cardList;
    }


    public void deleteBankAccount(String accountNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BANK_ACCOUNTS, KEY_ACCOUNT_NUMBER + " = ?", new String[] { accountNumber });
        db.close();
    }
    // Method to add a bank account
    public void addBankAccount(BankAccount account) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ACCOUNT_HOLDER_NAME, account.getAccountHolderName());
        values.put(KEY_ACCOUNT_NUMBER, account.getAccountNumber());
        values.put(KEY_ROUTING_NUMBER, account.getRoutingNumber());

        db.insert(TABLE_BANK_ACCOUNTS, null, values);
        db.close();
    }

    // Method to get all bank accounts
    public ArrayList<BankAccount> getAllBankAccounts() {
        ArrayList<BankAccount> bankList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_BANK_ACCOUNTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BankAccount account = new BankAccount(
                        cursor.getString(1), // Account holder's name
                        cursor.getString(2), // Account number
                        cursor.getString(3)  // Routing number
                );
                bankList.add(account);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return bankList;
    }

}
