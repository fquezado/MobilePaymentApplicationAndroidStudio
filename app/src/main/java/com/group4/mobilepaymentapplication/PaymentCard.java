package com.group4.mobilepaymentapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PaymentCard implements Parcelable {

    String name;
    String cardNumber;
    String expiryDate;
    String ccvCode;

    public PaymentCard(String name, String cardNumber, String expiryDate, String ccvCode) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ccvCode = ccvCode;
    }

    protected PaymentCard(Parcel in) {
        name = in.readString();
        cardNumber = in.readString();
        expiryDate = in.readString();
        ccvCode = in.readString();
    }

    public static final Creator<PaymentCard> CREATOR = new Creator<PaymentCard>() {
        @Override
        public PaymentCard createFromParcel(Parcel in) {
            return new PaymentCard(in);
        }

        @Override
        public PaymentCard[] newArray(int size) {
            return new PaymentCard[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCcvCode() {
        return ccvCode;
    }

    public void setCcvCode(String ccvCode) {
        this.ccvCode = ccvCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cardNumber);
        dest.writeString(expiryDate);
        dest.writeString(ccvCode);
    }
}
