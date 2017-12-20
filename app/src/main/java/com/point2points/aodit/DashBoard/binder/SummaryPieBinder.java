package com.point2points.aodit.DashBoard.binder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.point2points.aodit.DashBoard.holder.SummaryPieHolder;
import com.point2points.aodit.DashBoard.model.Summary;
import com.point2points.aodit.R;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

/**
 * Created by Edwin on 21/9/2016.
 */
public class SummaryPieBinder extends DataBinder<SummaryPieHolder> {
    private Context mContext;
    private Summary mSummary = new Summary();
    private int pieCount = 0;

    public SummaryPieBinder(Context context, DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
        this.mContext = context;
    }

    @Override
    public SummaryPieHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_summary_details, parent, false);
        return new SummaryPieHolder(view);
    }

    @Override
    public void bindViewHolder(SummaryPieHolder holder, int position) {
        if (pieCount <= 0){
            setPieChart(holder.getmPieChart());
        }

        holder.getmTxtExpenditure().setText(mSummary.getSummaryExpenditure());
        holder.getmTxtBudget().setText(mSummary.getSummaryBudget());
        holder.getmTxtRemaining().setText(mSummary.getSummaryRemainder());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private void setPieChart(PieChart pieChart) {
        pieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
        pieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#56B7F1")));
        pieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#CDA67F")));
        pieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#FED70E")));

        pieChart.startAnimation();
        pieCount++;
    }

    public void addAll(Summary summary) {
        this.mSummary = summary;
        this.notifyBinderDataSetChanged();
    }
}
