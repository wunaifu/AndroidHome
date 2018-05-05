package com.yongxin.mousingdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;

import java.util.HashMap;

/**
 * Created by wunaifu on 2018-05-04.
 */

public class UserMessageActivity extends Activity implements View.OnClickListener {

    private TextView userTop;
    private ImageView userLeft;
    private ImageView userRight;

    private ImageView userHead;
    private LinearLayout nameLayout;
    private TextView userName;
    private LinearLayout addressLayout;
    private TextView userAddress;
    private LinearLayout phoneLayout;
    private TextView userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);

        //StatusBarUtils.setWindowStatusBarColor(this,R.color.blue);
        userHead = (ImageView) findViewById(R.id.user_head);
        nameLayout = (LinearLayout) findViewById(R.id.name_layout);
        userName = (TextView) findViewById(R.id.user_name);
        addressLayout = (LinearLayout) findViewById(R.id.address_layout);
        userAddress = (TextView) findViewById(R.id.user_address);
        phoneLayout = (LinearLayout) findViewById(R.id.phone_layout);
        userPhone = (TextView) findViewById(R.id.user_phone);
        userLeft = (ImageView) findViewById(R.id.top_left);
        userTop = (TextView) findViewById(R.id.fragment_text_view);
        userRight = (ImageView) findViewById(R.id.top_right);
        userTop.setText("个人信息");
        userRight.setVisibility(View.INVISIBLE);
        userLeft.setVisibility(View.VISIBLE);
        userLeft.setOnClickListener(this);
        userHead.setOnClickListener(this);
        nameLayout.setOnClickListener(this);
        addressLayout.setOnClickListener(this);
        phoneLayout.setOnClickListener(this);
        userHead.setImageResource(R.drawable.headimage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_head:
                break;
            case R.id.top_left:
                finish();
                break;
            case R.id.address_layout:
                break;
            case R.id.phone_layout:
                break;
            case R.id.name_layout:
                break;
        }
    }
}

