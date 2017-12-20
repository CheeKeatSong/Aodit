package com.point2points.aodit.Menu.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.point2points.aodit.Home.activity.HomeActivity;
import com.point2points.aodit.Menu.adapter.MenuAdapter;
import com.point2points.aodit.Menu.database.MenuDBHelper;
import com.point2points.aodit.Menu.provider.MenuProvider;
import com.point2points.aodit.R;
import com.point2points.aodit.Utilities.DBHelper;

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

public class NavigationDrawerFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private RecyclerView mRecyclerView;
    public static final String FREE_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    public ActionBarDrawerToggle mDrawerToggle;
    public DrawerLayout mDrawerLayout;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View mContainerView;
    private MenuAdapter mAdapter;
    private int mSelectedPosition = -1;
    private Cursor mCursor;
    private ImageView mLogo;
    private int mLoaderId = 487;
    private RelativeLayout mRl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState == null) {
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        mLogo = (ImageView) layout.findViewById(R.id.logo);
        mRl = (RelativeLayout) layout.findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        mAdapter = new MenuAdapter(getActivity(), mCursor, mSelectedPosition, mDrawerLayout);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getSupportLoaderManager().initLoader(mLoaderId, null, this);
        MenuDBHelper.insertDashboard(getActivity());
    }

    public void setPaddingRelativeLayout() {
        mRl.setFitsSystemWindows(false);
        mRl.setPadding(0, 0, 0, 0);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (id == mLoaderId) {
            Uri uri = MenuProvider.CONTENT_URI;
            return new CursorLoader(getActivity(), uri, null, DBHelper.MENU_COLUMN_TITLE + "!=?",null, DBHelper.MENU_COLUMN_ID + " ASC ");
        } else {
            return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == mLoaderId) {
            if (data != null) {
                this.mCursor = data;
                mAdapter.swapCursor(mCursor);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void setSelectedPosition(int mSelectedPosition) {
        this.mSelectedPosition = mSelectedPosition;
        mAdapter = new MenuAdapter(getActivity(),
                mCursor, mSelectedPosition, mDrawerLayout);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setLogoHeight(int height) {
        if (mLogo != null) {
            mLogo.getLayoutParams().height = height;
        }
    }

    public ActionBarDrawerToggle getmDrawerToggle() {
        return mDrawerToggle;
    }

    public DrawerLayout getmDrawerLayout() {
        return mDrawerLayout;
    }


    public void setOpenCloseDrawer() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    public void setCloseDrawer(Context context) {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            if (context.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName())) {
                ((Activity) context).moveTaskToBack(true);

            } else {
                ((Activity) context).finish();
            }
        }
    }


    public void setUp(int fragmentId, final DrawerLayout drawerLayout, final Toolbar toolbar) {
        mContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public boolean onOptionsItemSelected(android.view.MenuItem item) {
                /*if (item != null && item.getItemId() == R.id.menuRight) {
                    if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                    } else {
                        mDrawerLayout.openDrawer(Gravity.LEFT);
                    }
                    return true;
                }*/
                return false;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.i("onDrawerSlide", "offset " + slideOffset);
            }
        };


        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mContainerView);
        }

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FREE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FREE_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }
}
