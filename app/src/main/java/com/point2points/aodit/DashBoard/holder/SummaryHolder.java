package com.point2points.aodit.DashBoard.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.point2points.aodit.R;

/**
 * Created by Edwin on 17/9/2016.
 */
public class SummaryHolder extends RecyclerView.ViewHolder {

    private ImageView mImgSummaryIcon;
    private TextView mTxtSummaryTitle;
    private TextView mTxtSummaryBudget;
    private TextView mTxtSummaryExpenses;
    private SeekBar mSeekRange;
    private LinearLayout mLnBackground;

    public SummaryHolder(View itemView) {
        super(itemView);

        mImgSummaryIcon = (ImageView) itemView.findViewById(R.id.imgSummaryIcon);
        mTxtSummaryTitle = (TextView) itemView.findViewById(R.id.txtSummaryTitle);
        mTxtSummaryBudget = (TextView) itemView.findViewById(R.id.txtSummaryBudget);
        mTxtSummaryExpenses = (TextView) itemView.findViewById(R.id.txtSummaryExpense);
        mSeekRange = (SeekBar) itemView.findViewById(R.id.rangeValue);
        mLnBackground = (LinearLayout) itemView.findViewById(R.id.lnBackground);
    }

    public ImageView getmImgSummaryIcon() {
        return mImgSummaryIcon;
    }

    public TextView getmTxtSummaryTitle() {
        return mTxtSummaryTitle;
    }

    public TextView getmTxtSummaryBudget() {
        return mTxtSummaryBudget;
    }

    public TextView getmTxtSummaryExpenses() {
        return mTxtSummaryExpenses;
    }

    public SeekBar getmSeekRange() {
        return mSeekRange;
    }

    public LinearLayout getmLnBackground() {
        return mLnBackground;
    }
}
