package com.point2points.aodit.PhotoDetails.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.point2points.aodit.PhotoDetails.adapter.CategoryAdapter;
import com.point2points.aodit.PhotoDetails.model.Category;
import com.point2points.aodit.R;

import java.util.ArrayList;

public class PhotoDetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mToolBarTxtTitle;
    private RecyclerView mRecyclerView;
    private ArrayList<Category> mCategory = new ArrayList<>();
    private CategoryAdapter mAdapter;
    private ImageView mImgPhoto;
    private String TAG = PhotoDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        addCategory();

        mToolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(mToolbar);
        mToolBarTxtTitle = (TextView) mToolbar.findViewById(R.id.txtTitle);
        mToolBarTxtTitle.setText(getString(R.string.photo));

        mImgPhoto = (ImageView) findViewById(R.id.photoDetails);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(PhotoDetailsActivity.this));
        mAdapter = new CategoryAdapter(PhotoDetailsActivity.this, mCategory);
        mRecyclerView.setAdapter(mAdapter);

        mToolbar.setNavigationIcon(R.mipmap.back);
        mToolbar.setNavigationOnClickListener(mToolbarOnClickListener);

        setImage();
    }

    private void addCategory() {
        String[] categoryTitle = {getString(R.string.food), getString(R.string.other)
                , getString(R.string.groceries), getString(R.string.entertaiment), getString(R.string.utility)
                , getString(R.string.transport)};
        for (int i = 0; i < 6; i++) {
            Category category = new Category();
            category.setCategoryName(categoryTitle[i]);
            mCategory.add(category);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_empty, menu);
        return true;
    }

    private View.OnClickListener mToolbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private void setImage() {
        Uri uri = getIntent().getParcelableExtra("DATA");
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            mImgPhoto.setImageBitmap(bitmap);
        } catch (Exception ex) {
            Log.e(TAG, "Error");
        }
    }
}
