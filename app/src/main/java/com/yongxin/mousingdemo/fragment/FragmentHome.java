package com.yongxin.mousingdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yongxin.mousingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunaifu on 2017/4/28.
 */
public class FragmentHome  extends BaseFragment{

    private View view;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private long exitTime = 0;
    private FragmentPagerAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void initView() {

    }
}
