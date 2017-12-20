package com.point2points.aodit.Menu.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.point2points.aodit.Utilities.DBHelper;

/**
 -- =============================================
 -- Author     : Edwin Cheong
 -- Create date: 20/1/2016
 -- Description: AssigneeList .java
 -- =============================================
 HISTORY OF UPDATE

 NO     DEVELOPER         DATETIME                      DESCRIPTION
 ********************************************************************************
 1
 2
 */
public class Menu implements Parcelable {
    private int id;
    private String title;
    private int no;
    private boolean isSelected = false;

    public Menu() {
    }

    public Menu(Parcel in) {
        readFromParcel(in);
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.no);
    }

    /**
     * Called from the constructor to create this
     * object from a parcel.
     *
     * @param in parcel from which to re-create object.
     */
    public void readFromParcel(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.no = in.readInt();
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public static Menu getMenu(Cursor cursor, int position, int selectedPosition) {
        Menu menu = new Menu();
        cursor.moveToPosition(position);
        menu.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.MENU_COLUMN_ID)));
        menu.setTitle(cursor.getString(cursor.getColumnIndex(DBHelper.MENU_COLUMN_TITLE)));
        menu.setIsSelected(position == selectedPosition);
        if (!cursor.isNull(cursor.getColumnIndex(DBHelper.MENU_COLUMN_NO))) {
            menu.setNo(cursor.getInt(cursor.getColumnIndex(DBHelper.MENU_COLUMN_NO)));
        } else {
            menu.setNo(0);
        }
        return menu;
    }

}
