package com.yongxin.mousingdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;

/**
 * Created by wunaifu on 2018-05-04.
 */

public class RegisterActivity extends Activity implements View.OnClickListener {

    private TextView password_top;
    private ImageView password_left;
    private ImageView password_right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        password_top = (TextView) findViewById(R.id.fragment_text_view);
        password_left = (ImageView) findViewById(R.id.top_left);
        password_right = (ImageView) findViewById(R.id.top_right);
        password_right.setVisibility(View.INVISIBLE);
        password_left.setVisibility(View.VISIBLE);
        password_top.setText("注册新用户");
        password_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.top_left:
                finish();
                break;
        }
    }

}

