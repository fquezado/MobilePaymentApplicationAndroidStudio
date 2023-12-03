package com.group4.mobilepaymentapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CardDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CARDS = "cards";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CARD_NUMBER = "card_number";
    private static final String KEY_EXPIRY_DATE = "expiry_date";
    private static final String KEY_CCV_CODE = "ccv_code";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
        onCreate(db);
    }

    void addCard(PaymentCard card) {
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

    ArrayList<PaymentCard> getAllCards() {
        ArrayList<PaymentCard> cardList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CARDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                PaymentCard card = new PaymentCard(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                cardList.add(card);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return cardList;
    }
}
