package com.yongxin.mousingdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;
import com.yongxin.mousingdemo.common.APPConfig;
import com.yongxin.mousingdemo.common.SharedPrefsUtil;


/**
 * Created by wunaifu on 2018-05-04.
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText usernameEdit;
    private EditText passwordEdit;
    private TextView userForget;
    private TextView userRegist;
    private Button signBtn;
    private CheckBox rememberPassword;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        initView();
    }

    public void initView() {
        usernameEdit = (EditText) findViewById(R.id.user_name);
        passwordEdit = (EditText) findViewById(R.id.user_password);
        rememberPassword = (CheckBox) findViewById(R.id.user_remember_password);
        signBtn = (Button) findViewById(R.id.user_sign);
        userForget = (TextView) findViewById(R.id.user_forget);
        userRegist = (TextView) findViewById(R.id.user_regist);

        //StatusBarUtils.setWindowStatusBarColor(this, R.color.red);
        //startService(intent);
        signBtn.setOnClickListener(this);
        userRegist.setOnClickListener(this);
        userForget.setOnClickListener(this);

        //获取保存在SharePreferences里面的账号信息，实现自动登录
        rememberPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rememberPassword.isChecked()) {
                    System.out.println("记住账号框已选中状态");
                    SharedPrefsUtil.putValue(LoginActivity.this,"ISCHECK", true);
                } else {
                    System.out.println("记住账号框未选中");
                    SharedPrefsUtil.putValue(LoginActivity.this,"ISCHECK", false);
                }
            }
        });
        if (SharedPrefsUtil.getValue(LoginActivity.this,"ISCHECK",false)) {
            rememberPassword.setChecked(true);
            try {
                username = SharedPrefsUtil.getValue(LoginActivity.this, APPConfig.ACCOUNT,"");
                System.out.println("<<<<<<<<<<<<" + "账号" + username);
            } catch (Exception e) {
                // TODO: handle exception
            }
            usernameEdit.setText(username);
            try {
                password = SharedPrefsUtil.getValue(LoginActivity.this, APPConfig.PSW,"");;
                System.out.println("<<<<<<<<<<<<" + "密码" + password);
            } catch (Exception e) {
                // TODO: handle exception
            }
            passwordEdit.setText(password);

        }
    }

    //登录执行保存账号密码到本地
    public void initLogin() {
        //显示进度条
        username = usernameEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();

        if (rememberPassword.isChecked()) {
            try {
                SharedPrefsUtil.putAccount(LoginActivity.this,APPConfig.ACCOUNT, username);
            } catch (Exception e) {
                Toast.makeText(LoginActivity.this, "账号保存异常", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            try {
                SharedPrefsUtil.putPsw(LoginActivity.this,APPConfig.PSW, password);
            } catch (Exception e) {
                Toast.makeText(LoginActivity.this, "密码保存异常", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    public void loginCheck() {
        //获取账号 密码
        username = usernameEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        if (username.equals("") || password.equals("")) {
            Toast.makeText(LoginActivity.this, "账号密码不能为空！", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(LoginActivity.this, "登录成功!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_sign:
                initLogin();
                loginCheck();
                break;

            case R.id.user_forget:
                Intent intentF = new Intent(LoginActivity.this, ForgetPswActivity.class);
                startActivity(intentF);
                break;

            case R.id.user_regist:

                Intent intentR = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentR);
                break;
        }
    }
}

