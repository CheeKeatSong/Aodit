package com.point2points.aodit.PhotoDetails.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Edwin on 18/9/2016.
 */
public class Category implements Parcelable {

    private String categoryName;
    private int categoryIcon;
    private String categoryShop;
    private String categroyNote;
    private String categoryLocation;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(int categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCategoryShop() {
        return categoryShop;
    }

    public void setCategoryShop(String categoryShop) {
        this.categoryShop = categoryShop;
    }

    public String getCategroyNote() {
        return categroyNote;
    }

    public void setCategroyNote(String categroyNote) {
        this.categroyNote = categroyNote;
    }

    public String getCategoryLocation() {
        return categoryLocation;
    }

    public void setCategoryLocation(String categoryLocation) {
        this.categoryLocation = categoryLocation;
    }
    
    public Category(){
        
    }
    
    public Category(Parcel in){
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in){
        this.categoryIcon = in.readInt();
        this.categoryName = in.readString();
        this.categoryShop = in.readString();
        this.categroyNote = in.readString();
        this.categoryLocation = in.readString();
    }
    
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.categoryIcon);
        dest.writeString(this.categoryName);
        dest.writeString(this.categoryShop);
        dest.writeString(this.categroyNote);
        dest.writeString(this.categoryLocation);
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
