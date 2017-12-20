package com.point2points.aodit.Home.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.point2points.aodit.Login.activity.LoginActivity;
import com.point2points.aodit.R;

public class HomeActivity extends AppCompatActivity {

    private TextView mTxtLogoName;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTxtLogoName = (TextView) findViewById(R.id.txtLogoName);
        mTxtLogoName.setTypeface(Typeface.createFromAsset(getAssets(), "Bellota-Italic.otf"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 1000);
    }
}
