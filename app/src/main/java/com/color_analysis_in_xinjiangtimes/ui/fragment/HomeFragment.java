package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.HomeMoreActivty;
import com.color_analysis_in_xinjiangtimes.view.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/*
 * author 万强
 * date 16/5/10 上午10:22
 * desc 首页
 */
public class HomeFragment extends BaseFragment {
    private View parentView;
    private FlyBanner img_banner;
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.activity_home_tiyu, container, false);
        img_banner = (FlyBanner) parentView.findViewById(R.id.img_banner);
        List<Integer> imageInt = new ArrayList<Integer>();
        imageInt.add(R.mipmap.new_b1);
        imageInt.add(R.mipmap.new_b2);
        imageInt.add(R.mipmap.new_b3);
        img_banner.setImages(imageInt);
        parentView.findViewById(R.id.btn_1).setOnClickListener(this);
        parentView.findViewById(R.id.btn_2).setOnClickListener(this);
        parentView.findViewById(R.id.btn_3).setOnClickListener(this);
        parentView.findViewById(R.id.btn_4).setOnClickListener(this);
        parentView.findViewById(R.id.btn_5).setOnClickListener(this);
        parentView.findViewById(R.id.btn_6).setOnClickListener(this);
        parentView.findViewById(R.id.btn_7).setOnClickListener(this);
        parentView.findViewById(R.id.btn_8).setOnClickListener(this);
        return parentView;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent =null;
        switch (v.getId()){
            case R.id.btn_1:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_2:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_3:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_4:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_5:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_6:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_7:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
            case R.id.btn_8:
                intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, ((Button)v).getText().toString());
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}