package com.point2points.aodit.DashBoard.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.point2points.aodit.DashBoard.adapter.DashBoardPagerAdapter;
import com.point2points.aodit.PhotoDetails.activity.PhotoDetailsActivity;
import com.point2points.aodit.R;
import com.point2points.aodit.Tabs.SlidingTabLayout;
import com.sa90.materialarcmenu.ArcMenu;

import java.io.File;

public class DashBoardActivity extends AppCompatActivity {

    private SlidingTabLayout mTabs;
    private ViewPager mPager;
    private int mPage;
    private String TAG = DashBoardActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private TextView mTxtTitle;
    private ArcMenu mArcMenu;
    private static final int TAKE_PICTURE = 1;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mToolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(mToolbar);
        mTxtTitle = (TextView) mToolbar.findViewById(R.id.txtTitle);
        mTxtTitle.setText(getString(R.string.activity_dashboard));

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true);
        mTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText, R.id.tabNumber);
        mTabs.setBackgroundColor(ContextCompat.getColor(this, R.color.tabs_primary));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.color_highlight));
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(2);
        mPager.setAdapter(new DashBoardPagerAdapter(getSupportFragmentManager(), this));
        mPager.addOnPageChangeListener(mPagerOnPageChangeListener);
        mTabs.setViewPager(mPager);

        mToolbar.setNavigationIcon(R.mipmap.menu);
        mToolbar.setNavigationOnClickListener(mToolbarOnClickListener);

        mArcMenu = (ArcMenu) findViewById(R.id.arcMenu);
        findViewById(R.id.fab).setOnClickListener(subMenuClickListener);
        findViewById(R.id.fab2).setOnClickListener(subMenuClickListener);
        findViewById(R.id.fab3).setOnClickListener(subMenuClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        prepareDirectory(Environment.getExternalStorageDirectory() + "/"
                + getString(R.string.folder_name) + "/" + getString(R.string.picture));
    }

    private ViewPager.OnPageChangeListener mPagerOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 1) {
                mArcMenu.setVisibility(View.GONE);
            } else {
                mArcMenu.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private View.OnClickListener mToolbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    private View.OnClickListener subMenuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*Intent intent = new Intent(DashBoardActivity.this, PhotoDetailsActivity.class);
            startActivity(intent);*/
            takePhoto(v);
            mArcMenu.toggleMenu();
        }
    };

    private void takePhoto(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStorageDirectory() + "/"
                + getString(R.string.folder_name) + "/" + getString(R.string.picture), "Pic.jpg");
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
        mImageUri = Uri.fromFile(photo);
        startActivityForResult(cameraIntent, TAKE_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = mImageUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    ContentResolver cr = getContentResolver();
                    Bitmap bitmap = null;
                    try {
                        bitmap = android.provider.
                                MediaStore.Images.Media.getBitmap(cr, selectedImage);
                        Toast.makeText(this, selectedImage.toString(),
                                Toast.LENGTH_LONG).show();
                        passData(selectedImage);
                    } catch (Exception e) {
                        Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
                                .show();
                        Log.e("Camera", e.toString());
                    }
                }
        }
    }

    private void prepareDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                Log.e(TAG, "ERROR: Creation of directory " + path + " failed, check does Android Manifest have permission to write to external storage.");
            }
        } else {
            Log.i(TAG, "Created Directory" + path);
        }
    }

    private void passData(Uri image) {
        Intent intent = new Intent(DashBoardActivity.this, PhotoDetailsActivity.class);
        intent.putExtra("DATA", image);
        startActivity(intent);
    }
}
