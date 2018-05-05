package com.yongxin.mousingdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;

/**
 * Created by wunaifu on 2018-05-04.
 */

public class SuggestActivity extends Activity implements View.OnClickListener {

    private TextView password_top;
    private ImageView password_left;
    private ImageView password_right;
    private Button bt_submit;
    private EditText et_suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        //StatusBarUtils.setWindowStatusBarColor(this, R.color.blue);
        et_suggest = (EditText)findViewById(R.id.et_suggest);
        findViewById(R.id.btn_submit).setOnClickListener(this);
        password_top = (TextView) findViewById(R.id.fragment_text_view);
        password_left = (ImageView) findViewById(R.id.top_left);
        password_right = (ImageView) findViewById(R.id.top_right);
        password_right.setVisibility(View.INVISIBLE);
        password_left.setVisibility(View.VISIBLE);
        password_top.setText("问题反馈");
        password_left.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                String suggest = et_suggest.getText().toString();

                break;
            case R.id.top_left:
                finish();
                break;
        }
    }
}

