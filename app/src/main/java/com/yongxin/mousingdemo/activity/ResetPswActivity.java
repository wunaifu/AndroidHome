package com.yongxin.mousingdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;

import java.util.HashMap;

/**
 * Created by wunaifu on 2018-05-04.
 */

public class ResetPswActivity extends Activity implements View.OnClickListener {

    private TextView password_top;
    private ImageView password_left;
    private ImageView password_right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_password);

        //StatusBarUtils.setWindowStatusBarColor(this, R.color.blue);
        findViewById(R.id.save_btn).setOnClickListener(this);
        password_top = (TextView) findViewById(R.id.fragment_text_view);
        password_left = (ImageView) findViewById(R.id.top_left);
        password_right = (ImageView) findViewById(R.id.top_right);
        password_right.setVisibility(View.INVISIBLE);
        password_left.setVisibility(View.VISIBLE);
        password_top.setText("修改密码");
        password_left.setOnClickListener(this);
    }

    private EditText getPasswordOld() {
        return (EditText) findViewById(R.id.password_old);
    }

    private EditText getPasswordNew1() {
        return (EditText) findViewById(R.id.password_new1);
    }

    private EditText getPasswordNew2() {
        return (EditText) findViewById(R.id.password_new2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_btn:
                String password1 = getPasswordNew1().getText().toString();
                String password2 = getPasswordNew2().getText().toString();
                String passwordOld = getPasswordOld().getText().toString();
                if (!password1.equals(password2)) {
                    Toast.makeText(this, "新密码输入错误!", Toast.LENGTH_LONG).show();
                } else {
                    saveNewPassword();

                }
                //TODO implement
                break;
            case R.id.top_left:
                finish();
                break;
        }
    }

    private void saveNewPassword() {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", String.valueOf(""));
        map.put("oldPassword", getPasswordOld().getText().toString());
        map.put("newPassword", getPasswordNew2().getText().toString());

        Toast.makeText(this, "密码修改成功!", Toast.LENGTH_LONG).show();
    }
}

