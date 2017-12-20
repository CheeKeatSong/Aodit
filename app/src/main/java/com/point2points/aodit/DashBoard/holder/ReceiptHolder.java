package com.point2points.aodit.DashBoard.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.point2points.aodit.R;

/**
 * Created by Edwin on 15/9/2016.
 */
public class ReceiptHolder extends RecyclerView.ViewHolder {

    private TextView mTxtReceiptName;
    private TextView mTxtReceiptDate;
    private TextView mTxtReceiptLocation;
    private TextView mTxtReceiptNote;
    private TextView mTxtReceiptPrice;
    private ImageView mImgReceiptIcon;
    private ImageView mImgReceipType;
    private LinearLayout mLnBackground;

    public ReceiptHolder(View itemView) {
        super(itemView);

        mTxtReceiptName = (TextView) itemView.findViewById(R.id.txtReceiptName);
        mTxtReceiptDate = (TextView) itemView.findViewById(R.id.txtReceiptDate);
        mTxtReceiptLocation = (TextView) itemView.findViewById(R.id.txtReceiptLocation);
        mTxtReceiptNote = (TextView) itemView.findViewById(R.id.txtReceiptNote);
        mTxtReceiptPrice = (TextView) itemView.findViewById(R.id.txtReceiptPrice);
        mImgReceiptIcon = (ImageView) itemView.findViewById(R.id.imgPicIcon);
        mImgReceipType = (ImageView) itemView.findViewById(R.id.imgReceiptType);
        mLnBackground = (LinearLayout) itemView.findViewById(R.id.lnBackgroubd);
    }

    public TextView getmTxtReceiptName() {
        return mTxtReceiptName;
    }

    public TextView getmTxtReceiptDate() {
        return mTxtReceiptDate;
    }

    public TextView getmTxtReceiptLocation() {
        return mTxtReceiptLocation;
    }

    public TextView getmTxtReceiptNote() {
        return mTxtReceiptNote;
    }

    public TextView getmTxtReceiptPrice() {
        return mTxtReceiptPrice;
    }

    public ImageView getmImgReceiptIcon() {
        return mImgReceiptIcon;
    }

    public ImageView getmImgReceipType() {
        return mImgReceipType;
    }

    public LinearLayout getmLnBackground() {
        return mLnBackground;
    }
}
