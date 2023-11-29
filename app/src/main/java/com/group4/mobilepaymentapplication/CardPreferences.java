package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;


import java.util.ArrayList;

public class CardPreferences {
    private static final String PREF_NAME = "CardPreferences";
    private static final String KEY_CARDS = "cards";

    public static void saveCards(Context context, ArrayList<PaymentCard> cardList)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        StringBuilder stringBuilder = new StringBuilder();
        for (PaymentCard card : cardList) {
            String cardInfo = card.getName() + "," + card.getCardNumber() + "," +
                    card.getExpiryDate() + "," + card.getCcvCode() + ";";
            stringBuilder.append(cardInfo);
        }
    }

    public static ArrayList<PaymentCard> getCards(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String cardsString = sharedPreferences.getString(KEY_CARDS, "");

        ArrayList<PaymentCard> cardList = new ArrayList<>();
        String[] cardStrings = cardsString.split(";");
        for (String cardString : cardStrings) {
            String[] cardDetails = cardString.split(",");
            if (cardDetails.length == 4) {
                // Convert each string back to a Card object (customize as needed)
                PaymentCard card = new PaymentCard(cardDetails[0], cardDetails[1], cardDetails[2], cardDetails[3]);
                cardList.add(card);
            }
        }
        return cardList;
    }
}
