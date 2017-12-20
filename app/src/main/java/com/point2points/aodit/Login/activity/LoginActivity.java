package com.point2points.aodit.Login.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.point2points.aodit.DashBoard.activity.DashBoardActivity;
import com.point2points.aodit.R;

public class LoginActivity extends AppCompatActivity {

    private TextView mTxtLogoName;
    private TextView mTxtLoginText;
    private TextView mTxtRegisterText;
    private RelativeLayout mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTypeFace();

        mBtnLogin = (RelativeLayout) findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(mBtnLoginOnClickListner);
    }

    private View.OnClickListener mBtnLoginOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
            startActivity(intent);
        }
    };

    private void setTypeFace() {
        mTxtLogoName = (TextView) findViewById(R.id.txtLogoName);
        mTxtLoginText = (TextView) findViewById(R.id.txtLoginBtn);
        mTxtRegisterText = (TextView) findViewById(R.id.txtRegisterBtn);

        mTxtLogoName.setTypeface(Typeface.createFromAsset(getAssets(), "Bellota-Italic.otf"));
        mTxtRegisterText.setTypeface(Typeface.createFromAsset(getAssets(), "Bellota-Italic.otf"));
        mTxtLoginText.setTypeface(Typeface.createFromAsset(getAssets(), "Bellota-Italic.otf"));
    }
}
