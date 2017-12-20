package com.point2points.aodit.DashBoard.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Edwin on 17/9/2016.
 */
public class Summary implements Parcelable {
    private String summaryTitle;
    private String summaryExpenses;
    private String summaryExpenditure;
    private String summaryBudget;
    private String summaryRemainder;
    private String summaryRange;
    private String summaryBudgetExp;

    public String getSummaryTitle() {
        return summaryTitle;
    }

    public void setSummaryTitle(String summaryTitle) {
        this.summaryTitle = summaryTitle;
    }

    public String getSummaryExpenses() {
        return summaryExpenses;
    }

    public void setSummaryExpenses(String summaryExpenses) {
        this.summaryExpenses = summaryExpenses;
    }

    public String getSummaryExpenditure() {
        return summaryExpenditure;
    }

    public void setSummaryExpenditure(String summaryExpenditure) {
        this.summaryExpenditure = summaryExpenditure;
    }

    public String getSummaryBudget() {
        return summaryBudget;
    }

    public void setSummaryBudget(String summaryBudget) {
        this.summaryBudget = summaryBudget;
    }

    public String getSummaryRemainder() {
        return summaryRemainder;
    }

    public void setSummaryRemainder(String summaryRemainder) {
        this.summaryRemainder = summaryRemainder;
    }

    public String getSummaryRange() {
        return summaryRange;
    }

    public void setSummaryRange(String summaryRange) {
        this.summaryRange = summaryRange;
    }

    public String getSummaryBudgetExp() {
        return summaryBudgetExp;
    }

    public void setSummaryBudgetExp(String summaryBudgetExp) {
        this.summaryBudgetExp = summaryBudgetExp;
    }

    public Summary() {

    }

    public Summary(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        this.summaryBudget = in.readString();
        this.summaryBudgetExp = in.readString();
        this.summaryExpenditure = in.readString();
        this.summaryRemainder = in.readString();
        this.summaryTitle = in.readString();
        this.summaryRange = in.readString();
        this.summaryExpenses = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.summaryBudget);
        dest.writeString(this.summaryBudgetExp);
        dest.writeString(this.summaryExpenditure);
        dest.writeString(this.summaryRemainder);
        dest.writeString(this.summaryTitle);
        dest.writeString(this.summaryRange);
        dest.writeString(this.summaryExpenses);
    }


    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Summary createFromParcel(Parcel in) {
            return new Summary(in);
        }

        @Override
        public Summary[] newArray(int size) {
            return new Summary[size];
        }
    };
}
