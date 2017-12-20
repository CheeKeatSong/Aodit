package com.point2points.aodit.Utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * -- =============================================
 * -- Author     : Edwin Cheong
 * -- Create date: 19/1/2016
 * -- Description: AssigneeList .java
 * -- =============================================
 * HISTORY OF UPDATE
 * <p/>
 * NO     DEVELOPER         DATETIME                      DESCRIPTION
 * *******************************************************************************
 * 1
 * 2
 */
public class DBHelper extends SQLiteOpenHelper {
    //Database Applab
    public static final String DATABASE_NAME = "applab.db";

    private Context mContext;

    //Table Dashboard
    public static final String MENU_TABLE_NAME = "applab_dashboard";
    public static final String MENU_COLUMN_ID = "id";
    public static final String MENU_COLUMN_TITLE = "title";
    public static final String MENU_COLUMN_NO = "no";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    public void clearData() {
           }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE IF NOT EXISTS " + MENU_TABLE_NAME +
                        "(" + MENU_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        "" + MENU_COLUMN_TITLE + " TEXT," +
                        "" + MENU_COLUMN_NO + " INTEGER) "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
