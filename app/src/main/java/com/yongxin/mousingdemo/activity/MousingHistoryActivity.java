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

public class MousingHistoryActivity extends Activity implements View.OnClickListener {

    private TextView password_top;
    private ImageView password_left;
    private ImageView password_right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_set);

        //StatusBarUtils.setWindowStatusBarColor(this, R.color.blue);
        findViewById(R.id.bt_sure).setOnClickListener(this);
        password_top = (TextView) findViewById(R.id.fragment_text_view);
        password_left = (ImageView) findViewById(R.id.top_left);
        password_right = (ImageView) findViewById(R.id.top_right);
        password_right.setVisibility(View.INVISIBLE);
        password_left.setVisibility(View.VISIBLE);
        password_top.setText("捕鼠记录");
        password_left.setOnClickListener(this);
    }

    private EditText getPhone() {
        return (EditText) findViewById(R.id.et_phone);
    }

    private EditText getCode() {
        return (EditText) findViewById(R.id.et_code);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_sure:
                String phone = getPhone().getText().toString();
                String code = getCode().getText().toString();
                saveNewPhone();
                break;
            case R.id.top_left:
                finish();
                break;
        }
    }

    private void saveNewPhone() {

        Toast.makeText(this, "手机修改成功!", Toast.LENGTH_LONG).show();
    }
}

