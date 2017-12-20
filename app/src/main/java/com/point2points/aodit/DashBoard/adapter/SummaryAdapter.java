package com.point2points.aodit.DashBoard.adapter;

import android.content.Context;

import com.point2points.aodit.DashBoard.binder.SummaryBinder;
import com.point2points.aodit.DashBoard.binder.SummaryPieBinder;
import com.point2points.aodit.DashBoard.model.Summary;
import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumMapBindAdapter;

import java.util.ArrayList;

/**
 * Created by Edwin on 21/9/2016.
 */
public class SummaryAdapter extends EnumMapBindAdapter<SummaryAdapter.SummaryViewType> {
    private Context mContext;

    public enum SummaryViewType {
        SUMMARY_PIE, SUMMARY_CATEGORY
    }

    public SummaryAdapter(Context context) {
        this.mContext = context;
        putBinder(SummaryViewType.SUMMARY_PIE, new SummaryPieBinder(mContext, this));
        putBinder(SummaryViewType.SUMMARY_CATEGORY, new SummaryBinder(this, mContext));
    }

    public void setSummaryData(ArrayList<Summary> summaries, Summary summary) {
        ((SummaryPieBinder) getDataBinder(SummaryViewType.SUMMARY_PIE)).addAll(summary);
        ((SummaryBinder) getDataBinder(SummaryViewType.SUMMARY_CATEGORY)).addAll(summaries);
    }

    @Override
    public SummaryViewType getEnumFromPosition(int position) {
        if (position == 0) {
            return SummaryViewType.SUMMARY_PIE;
        } else {
            return SummaryViewType.SUMMARY_CATEGORY;
        }
    }

    @Override
    public SummaryViewType getEnumFromOrdinal(int ordinal) {
        return SummaryViewType.values()[ordinal];
    }
}
