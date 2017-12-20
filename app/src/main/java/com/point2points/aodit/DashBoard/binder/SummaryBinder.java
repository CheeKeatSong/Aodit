package com.point2points.aodit.DashBoard.binder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.point2points.aodit.DashBoard.holder.SummaryHolder;
import com.point2points.aodit.DashBoard.model.Summary;
import com.point2points.aodit.R;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;

import java.util.ArrayList;

/**
 * Created by Edwin on 21/9/2016.
 */
public class SummaryBinder extends DataBinder<SummaryHolder> {
    private Context mContext;
    private ArrayList<Summary> mSummary = new ArrayList<>();

    public SummaryBinder(DataBindAdapter dataBindAdapter, Context context) {
        super(dataBindAdapter);
        this.mContext = context;
    }

    @Override
    public SummaryHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_summary_row, parent, false);
        return new SummaryHolder(view);
    }

    @Override
    public void bindViewHolder(SummaryHolder holder, int position) {
        holder.getmTxtSummaryTitle().setText(mSummary.get(position).getSummaryTitle());
        holder.getmTxtSummaryBudget().setText(mSummary.get(position).getSummaryBudgetExp());
        holder.getmTxtSummaryExpenses().setText(mSummary.get(position).getSummaryExpenses());

        if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.entertaiment))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_cool));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_entertainment);
        } else if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.other))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.tabs_secodary));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_other);
        } else if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.transport))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_tetiary));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_transport);
        } else if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.utility))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_warm));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_utility);
        } else if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.food))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_hue));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_food);
        } else if (mSummary.get(position).getSummaryTitle().equals(mContext.getString(R.string.groceries))) {
            holder.getmLnBackground().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_dark));
            holder.getmImgSummaryIcon().setImageResource(R.mipmap.summary_groceries);
        }
    }

    @Override
    public int getItemCount() {
        return mSummary == null ? 0 : mSummary.size();
    }

    public void addAll(ArrayList<Summary> summaries) {
        mSummary.addAll(summaries);
        this.notifyDataSetChanged();
    }
}
