package com.point2points.aodit.DashBoard.behaviour;

import android.content.Context;
import android.content.res.TypedArray;

import com.point2points.aodit.R;

/**
 * Created by Edwin on 15/9/2016.
 */
public class Utils {
    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static int getTabsHeight(Context context) {
        return (int) context.getResources().getDimension(R.dimen.tabs_text_size);
    }
}
