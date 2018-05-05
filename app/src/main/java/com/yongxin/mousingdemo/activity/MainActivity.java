package com.yongxin.mousingdemo.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yongxin.mousingdemo.R;
import com.yongxin.mousingdemo.fragment.FragmentAdd;
import com.yongxin.mousingdemo.fragment.FragmentHome;
import com.yongxin.mousingdemo.fragment.FragmentMe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //声明对象
    //上下文
    private Context mContext;
    //
    private RelativeLayout rlHome;
    //fragment类对象
    private FragmentHome fragmentHome;
    //单选按钮
    private RadioButton rbtnHome;

    //
    private RelativeLayout rlAdd;
    //fragment类对象
    private FragmentAdd fragmentAdd;
    // 单选按钮
    private RadioButton rbtnAdd;

    //
    private RelativeLayout rlMe;
    //fragment类对象
    private FragmentMe fragmentMe;
    //单选按钮
    private RadioButton rbtnMe;
    //导航fragment列表
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment转换
        findView();
        initView();
        initNav();
        initFragment();

    }

    //获取控件
    public void findView(){
        rlHome= (RelativeLayout) findViewById(R.id.rlHome);
        rlAdd= (RelativeLayout) findViewById(R.id.rlAdd);
        rlMe= (RelativeLayout) findViewById(R.id.rlMe);

        rbtnHome= (RadioButton) findViewById(R.id.rbtnHome);
        rbtnAdd= (RadioButton) findViewById(R.id.rbtnAdd);
        rbtnMe= (RadioButton) findViewById(R.id.rbtnMe);
    }

    //初始化控件
    private void initView(){

    }

    //初始化导航栏
    private  void initNav(){
        rlHome.setOnClickListener(this);
        rlAdd.setOnClickListener(this);
        rlMe.setOnClickListener(this);
    }

    //初始化fragment类
    private void initFragment(){
        fragmentHome = new FragmentHome();
        fragmentAdd = new FragmentAdd();
        fragmentMe = new FragmentMe();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(fragmentHome);
        mFragmentList.add(fragmentAdd);
        mFragmentList.add(fragmentMe);

        FragmentManager fm =getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();

        ft.add(R.id.fl_content,fragmentHome);
        ft.add(R.id.fl_content,fragmentAdd);
        ft.add(R.id.fl_content,fragmentMe);

        hideAllFragment();
        showFragment(fragmentHome);
        ft.commit();

    }

    //显示指定的Fragment
    private void showFragment(Fragment fragment){
        // 获取Fragment管理器
        FragmentManager fm = getFragmentManager();
        // 获取Fragment事物对象
        FragmentTransaction ft= fm.beginTransaction();
        //显示
        ft.show(fragment);
        //提交
        ft.commit();
    }

    //隐藏Fragment
    private void hideAllFragment(){
        // 获取Fragment管理器
        FragmentManager fm = getFragmentManager();
        // 获取Fragment事物对象
        FragmentTransaction ft= fm.beginTransaction();
        for (Fragment fragment:mFragmentList){
            ft.hide(fragment);
        }
        //提交
        ft.commit();
    }

    //改变单选按钮的状态
    private void changeRadioButtonState(boolean A, boolean B, boolean C) {
        rbtnHome.setChecked(A);
        rbtnAdd.setChecked(B);
        rbtnMe.setChecked(C);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.rlHome:
                changeRadioButtonState(true,false,false);
                hideAllFragment();
                showFragment(fragmentHome);
                break;
            case R.id.rlAdd:
                changeRadioButtonState(false,true,false);
                hideAllFragment();
                showFragment(fragmentAdd);
                break;
            case R.id.rlMe:
                changeRadioButtonState(false,false,true);
                hideAllFragment();
                showFragment(fragmentMe);

                break;
            default:
                break;
        }

    }
}
