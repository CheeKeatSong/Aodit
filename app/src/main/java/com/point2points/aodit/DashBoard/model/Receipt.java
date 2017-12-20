package com.point2points.aodit.DashBoard.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Edwin on 15/9/2016.
 */
public class Receipt implements Parcelable {

    private String receiptName;
    private String receiptPrice;
    private String receiptIcon;
    private int receiptType;
    private String receiptLocation;
    private String receiptNote;
    private String receiptDate;

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(String receiptPrice) {
        this.receiptPrice = receiptPrice;
    }

    public String getReceiptIcon() {
        return receiptIcon;
    }

    public void setReceiptIcon(String receiptIcon) {
        this.receiptIcon = receiptIcon;
    }

    public int getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(int receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptLocation() {
        return receiptLocation;
    }

    public void setReceiptLocation(String receiptLocation) {
        this.receiptLocation = receiptLocation;
    }

    public String getReceiptNote() {
        return receiptNote;
    }

    public void setReceiptNote(String receiptNote) {
        this.receiptNote = receiptNote;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Receipt() {
    }

    public Receipt(Parcel in) {
        readFromPacel(in);
    }

    public void readFromPacel(Parcel in) {
        this.receiptName = in.readString();
        this.receiptDate = in.readString();
        this.receiptIcon = in.readString();
        this.receiptLocation = in.readString();
        this.receiptNote = in.readString();
        this.receiptType = in.readInt();
        this.receiptPrice = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.receiptName);
        dest.writeString(this.receiptDate);
        dest.writeString(this.receiptIcon);
        dest.writeString(this.receiptLocation);
        dest.writeString(this.receiptNote);
        dest.writeInt(this.receiptType);
        dest.writeString(this.receiptPrice);
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Receipt createFromParcel(Parcel in) {
            return new Receipt(in);
        }

        @Override
        public Receipt[] newArray(int size) {
            return new Receipt[size];
        }
    };
}
