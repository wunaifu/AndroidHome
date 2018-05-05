package com.yongxin.mousingdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yongxin.mousingdemo.R;
import com.yongxin.mousingdemo.activity.MousingHistoryActivity;
import com.yongxin.mousingdemo.activity.ResetPhoneActivity;
import com.yongxin.mousingdemo.activity.ResetPswActivity;
import com.yongxin.mousingdemo.activity.SuggestActivity;
import com.yongxin.mousingdemo.activity.UserMessageActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunaifu on 2017/4/28.
 */
public class FragmentMe  extends BaseFragment implements View.OnClickListener{

    private ImageView persionLeft;
    private ImageView persionShare;
    private ImageView persionImage;
    private TextView fragmentTextView;
    private TextView persionName;
    private TextView persionSign;

    private LinearLayout persionInfo;
    private LinearLayout persionMouseHistory;
    private LinearLayout persionPhone;
    private LinearLayout persionPassSet;
    private LinearLayout persionSuggest;
    private LinearLayout persionAbout;
    private LinearLayout persionQuit;

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);

        persionImage = (ImageView) view.findViewById(R.id.persion_image);
        persionName = (TextView) view.findViewById(R.id.persion_name);
        persionSign = (TextView) view.findViewById(R.id.persion_sign);
        persionInfo = (LinearLayout) view.findViewById(R.id.persion_info);
        persionMouseHistory = (LinearLayout) view.findViewById(R.id.persion_mouse);
        persionPhone = (LinearLayout) view.findViewById(R.id.persion_phone);
        persionPassSet = (LinearLayout) view.findViewById(R.id.persion_pass_set);
        persionSuggest = (LinearLayout) view.findViewById(R.id.persion_suggest);
        persionAbout = (LinearLayout) view.findViewById(R.id.persion_about);
        persionQuit = (LinearLayout) view.findViewById(R.id.persion_quit);

        persionShare = (ImageView) view.findViewById(R.id.top_right);
        fragmentTextView = (TextView) view.findViewById(R.id.fragment_text_view);
        persionLeft = (ImageView) view.findViewById(R.id.top_left);

        persionLeft.setVisibility(View.INVISIBLE);

        persionShare.setOnClickListener(this);
        persionImage.setOnClickListener(this);
        persionInfo.setOnClickListener(this);
        persionMouseHistory.setOnClickListener(this);
        persionPhone.setOnClickListener(this);
        persionPassSet.setOnClickListener(this);
        persionSuggest.setOnClickListener(this);
        persionAbout.setOnClickListener(this);
        persionQuit.setOnClickListener(this);
        return view;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击用户
            case R.id.persion_info:
                Intent p_info = new Intent(getActivity(), UserMessageActivity.class);
                getActivity().startActivity(p_info);
                break;
            //点击头像
            case R.id.persion_image:
                Intent p_image = new Intent(getActivity(), UserMessageActivity.class);
                getActivity().startActivity(p_image);
                break;
            //捕鼠记录
            case R.id.persion_mouse:
                Intent p_mouse = new Intent(getActivity(), MousingHistoryActivity.class);
                getActivity().startActivity(p_mouse);
                break;
            //手机
            case R.id.persion_phone:
                Intent p_phone = new Intent(getActivity(), ResetPhoneActivity.class);
                getActivity().startActivity(p_phone);
                break;

            //问题反馈
            case R.id.persion_suggest:
                Intent p_suggest = new Intent(getActivity(), SuggestActivity.class);
                getActivity().startActivity(p_suggest);
                break;
            //密码设置
            case R.id.persion_pass_set:
                Intent p_pass_set = new Intent(getActivity(), ResetPswActivity.class);
                getActivity().startActivity(p_pass_set);
                break;
            //关于
            case R.id.persion_about:
                Toast.makeText(getActivity(), "此功能开发中", Toast.LENGTH_LONG).show();
                break;
            //退出
            case R.id.persion_quit:
                Toast.makeText(getActivity(), "退出", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                break;
        }
    }
}
