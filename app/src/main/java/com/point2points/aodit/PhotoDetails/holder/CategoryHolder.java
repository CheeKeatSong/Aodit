package com.point2points.aodit.PhotoDetails.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.point2points.aodit.R;

/**
 * Created by Edwin on 18/9/2016.
 */
public class CategoryHolder extends RecyclerView.ViewHolder {

    private TextView mTxtCategoryName;
    private LinearLayout mLnBackground;
    private ImageView mImgCategoryIcon;

    public CategoryHolder(View itemView) {
        super(itemView);

        mTxtCategoryName = (TextView) itemView.findViewById(R.id.txtCategoryTitle);
        mImgCategoryIcon = (ImageView) itemView.findViewById(R.id.category_icon);
        mLnBackground = (LinearLayout) itemView.findViewById(R.id.lnBackground);
    }

    public TextView getmTxtCategoryName() {
        return mTxtCategoryName;
    }

    public LinearLayout getmLnBackground() {
        return mLnBackground;
    }

    public ImageView getmImgCategoryIcon() {
        return mImgCategoryIcon;
    }
}
