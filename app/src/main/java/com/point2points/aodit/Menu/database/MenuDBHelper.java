package com.point2points.aodit.Menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.point2points.aodit.Menu.provider.MenuProvider;
import com.point2points.aodit.Utilities.DBHelper;

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
public class MenuDBHelper {
    public static void insertDashboard(Context context) {
        if (getTotalDashboardRow(context) == 0) {
            ContentValues[] contentValueses = new ContentValues[9];
            String[] title = {

            };
            for (int i = 0; i < 0; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.MENU_COLUMN_TITLE, title[i]);
                contentValues.put(DBHelper.MENU_COLUMN_NO, 0);
                contentValueses[i] = contentValues;
            }
            context.getContentResolver().bulkInsert(MenuProvider.CONTENT_URI, contentValueses);
        }
    }

    public static int getTotalDashboardRow(Context context) {
        Cursor cursor = null;
        int total = 0;
        try {
            cursor = context.getContentResolver().query(MenuProvider.CONTENT_URI,
                    null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                total = cursor.getCount();
            }
        } catch (Exception ex) {
            ex.fillInStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return total;
    }
}
