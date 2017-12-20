package com.point2points.aodit.Menu.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.point2points.aodit.R;

/**
 -- =============================================
 -- Author     : Edwin Cheong
 -- Create date: 19/1/2016
 -- Description: AssigneeList .java
 -- =============================================
 HISTORY OF UPDATE

 NO     DEVELOPER         DATETIME                      DESCRIPTION
 ********************************************************************************
 1
 2
 */
public class MenuViewHolder extends RecyclerView.ViewHolder {
    private TextView mTxtTitle, mTtxtNotification;
    private ImageView mImgIcon;
    private RelativeLayout mRl;

    public MenuViewHolder(View itemView) {
        super(itemView);
        mTxtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        mTtxtNotification = (TextView) itemView.findViewById(R.id.txtNotification);
        mImgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        mRl = (RelativeLayout) itemView.findViewById(R.id.rl);
    }

    public TextView getmTxtTitle() {
        return mTxtTitle;
    }

    public TextView getmTtxtNotification() {
        return mTtxtNotification;
    }

    public ImageView getmImgIcon() {
        return mImgIcon;
    }

    public RelativeLayout getmRl() {
        return mRl;
    }
}