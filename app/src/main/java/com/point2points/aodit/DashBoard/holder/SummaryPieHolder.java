package com.point2points.aodit.DashBoard.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.point2points.aodit.R;

import org.eazegraph.lib.charts.PieChart;

/**
 * Created by Edwin on 21/9/2016.
 */
public class SummaryPieHolder extends RecyclerView.ViewHolder {
    private TextView mTxtExpenditure;
    private TextView mTxtBudget;
    private TextView mTxtRemaining;
    private PieChart mPieChart;

    public SummaryPieHolder(View itemView){
        super(itemView);

        mTxtExpenditure = (TextView)itemView.findViewById(R.id.txtExpenditure);
        mTxtBudget = (TextView)itemView.findViewById(R.id.txtBudget);
        mTxtRemaining =(TextView)itemView.findViewById(R.id.txtRemaining);
        mPieChart = (PieChart)itemView.findViewById(R.id.piechart);
    }

    public TextView getmTxtExpenditure() {
        return mTxtExpenditure;
    }

    public TextView getmTxtBudget() {
        return mTxtBudget;
    }

    public TextView getmTxtRemaining() {
        return mTxtRemaining;
    }

    public PieChart getmPieChart() {
        return mPieChart;
    }
}
