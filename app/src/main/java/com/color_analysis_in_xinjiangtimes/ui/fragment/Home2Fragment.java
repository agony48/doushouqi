package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.adapter.Home2NavigationAdapter;
import com.color_analysis_in_xinjiangtimes.adapter.Home2NavigationAdapter2;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.view.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/*
 * author 万强
 * date 16/5/10 上午10:22
 * desc 首页
 */
public class Home2Fragment extends BaseFragment {
    private View parentView;
    private FlyBanner bannerView;
    public static Home2Fragment newInstance() {
        Home2Fragment fragment = new Home2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home, container, false);
        bannerView = (FlyBanner) parentView.findViewById(R.id.view_pager);
        List<Integer> imageInt = new ArrayList<Integer>();
//        imageInt.add(R.mipmap.o_banner_1);
        imageInt.add(R.mipmap.o_banner_2);
        bannerView.setImages(imageInt);
        initNavigationView(parentView);
        return parentView;
    }
    /*
    初始化导航栏
     */
    private void initNavigationView(View parentView) {
        //蓝球
        RecyclerView mRecyclerView = (RecyclerView) parentView.findViewById(R.id.home_nav_recyclerview);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL));
        mRecyclerView.setAdapter(new Home2NavigationAdapter(getActivity()));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        //足球
        RecyclerView mRecyclerView2 = (RecyclerView) parentView.findViewById(R.id.home_nav_recyclerview2);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL));
        mRecyclerView2.setAdapter(new Home2NavigationAdapter2(getActivity()));
        mRecyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    }
}