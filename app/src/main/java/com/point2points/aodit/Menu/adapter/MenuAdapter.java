package com.point2points.aodit.Menu.adapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.point2points.aodit.Menu.holder.MenuViewHolder;
import com.point2points.aodit.Menu.model.Menu;
import com.point2points.aodit.R;

/**
 * -- =============================================
 * -- Author     : Edwin Cheong
 * -- Create date: 19/1/2016
 * -- Description: AssigneeList .java
 * -- =============================================
 * HISTORY OF UPDATE
 * <p/>
 * NO     DEVELOPER         DATETIME                      DESCRIPTION
 * *******************************************************************************
 * 1
 * 2
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private LayoutInflater mInflater;
    private Cursor mCursor;
    private Context mContext;
    public DrawerLayout mDrawerLayout;
    public int mSelectedPosition;
    private int page = 0;
    private int page2 = 1;
    private int page3 = 2;
    private int page4 = 3;
    private int page5 = 4;

    public MenuAdapter(Context context, Cursor cursor, int selectedPosition, DrawerLayout drawerLayout) {
        this.mInflater = LayoutInflater.from(context);
        this.mCursor = cursor;
        this.mContext = context;
        this.mSelectedPosition = selectedPosition;
        this.mDrawerLayout = drawerLayout;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_menu_row, parent, false);
        MenuViewHolder holder = new MenuViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu current = Menu.getMenu(mCursor, position, mSelectedPosition);
        holder.getmTxtTitle().setText(current.getTitle());
        if (current.getIsSelected()) {
            holder.getmRl().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_highlight));
        }
        /*if (current.getNo() > 0) {
            holder.getmTtxtNotification().setVisibility(View.VISIBLE);
            if (current.getNo() > 9) {
                holder.getmTtxtNotification().setText("+9");
            } else {
                holder.getmTtxtNotification().setText(String.valueOf(current.getNo()));
            }
        } else {
            holder.getmTtxtNotification().setVisibility(View.GONE);
        }*/
        setWholeOnClickListener(position, holder.getmRl());
    }

    public void menuNavigation(int position) {

        if (mSelectedPosition != position) {
        }
        //mDrawerLayout = (DrawerLayout) ((Activity) mContext).findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawers();
    }

    private void setWholeOnClickListener(final int positon, final RelativeLayout whole) {
        whole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuNavigation(positon);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public Cursor swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return null;
        }
        Cursor oldCursor = this.mCursor;
        this.mCursor = cursor;
        if (cursor != null) {
            android.os.Message msg = mHandler.obtainMessage();
            mHandler.handleMessage(msg);
        }
        return oldCursor;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            MenuAdapter.this.notifyDataSetChanged();
        }
    };
}
