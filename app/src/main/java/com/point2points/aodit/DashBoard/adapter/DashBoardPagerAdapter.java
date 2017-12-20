package com.point2points.aodit.DashBoard.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.point2points.aodit.DashBoard.fragment.ReceiptFragment;
import com.point2points.aodit.DashBoard.fragment.SummaryFragment;
import com.point2points.aodit.R;

/**
 * Created by Edwin on 9/9/2016.
 */
public class DashBoardPagerAdapter extends FragmentPagerAdapter {
    String[] mTabs;
    Context mContext;

    public DashBoardPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        mTabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment item = null;
        ReceiptFragment receiptFragment = new ReceiptFragment();
        SummaryFragment summaryFragment = new SummaryFragment();

        if (position == 0) {
            item = receiptFragment;
        } else {
            item = summaryFragment;
        }

        return item;
    }

    @Override
    public int getCount() {
        return mContext.getResources().getStringArray(R.array.tabs).length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
