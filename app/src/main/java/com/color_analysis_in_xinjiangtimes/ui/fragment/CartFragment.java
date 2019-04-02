package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.adapter.HomeNavigationAdapter;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity4;
import com.color_analysis_in_xinjiangtimes.view.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc ${购物车}
 */
public class CartFragment extends BaseFragment {

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        initView(view);
        HeaderView(view);
        return view;
    }
    private FlyBanner bannerView;

    public void HeaderView(View parentView) {
        bannerView = (FlyBanner) parentView.findViewById(R.id.view_pager);
        List<Integer> imageInt = new ArrayList<Integer>();
        bannerView.setImages(imageInt);
        initNavigationView(parentView);
    }
    /*
    初始化导航栏
     */
    private void initNavigationView(View parentView) {
        RecyclerView mRecyclerView = (RecyclerView) parentView.findViewById(R.id.home_nav_recyclerview);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL));
        mRecyclerView.setAdapter(new HomeNavigationAdapter(getActivity()));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    }



    private void initView(View parentView) {
        parentView.findViewById(R.id.cart_1).setOnClickListener(this);
        parentView.findViewById(R.id.cart_2).setOnClickListener(this);
        parentView.findViewById(R.id.cart_3).setOnClickListener(this);
        parentView.findViewById(R.id.cart_4).setOnClickListener(this);
        parentView.findViewById(R.id.cart_5).setOnClickListener(this);
        parentView.findViewById(R.id.cart_6).setOnClickListener(this);
        parentView.findViewById(R.id.cart_7).setOnClickListener(this);

        parentView.findViewById(R.id.d_1).setOnClickListener(this);
        parentView.findViewById(R.id.d_2).setOnClickListener(this);
        parentView.findViewById(R.id.d_3).setOnClickListener(this);
        parentView.findViewById(R.id.d_4).setOnClickListener(this);
        parentView.findViewById(R.id.d_5).setOnClickListener(this);
        parentView.findViewById(R.id.d_6).setOnClickListener(this);
        parentView.findViewById(R.id.d_7).setOnClickListener(this);


        parentView.findViewById(R.id.f_1).setOnClickListener(this);
        parentView.findViewById(R.id.f_2).setOnClickListener(this);
        parentView.findViewById(R.id.f_3).setOnClickListener(this);
        parentView.findViewById(R.id.f_4).setOnClickListener(this);
        parentView.findViewById(R.id.f_5).setOnClickListener(this);
        parentView.findViewById(R.id.f_6).setOnClickListener(this);

        parentView.findViewById(R.id.p3_1).setOnClickListener(this);
        parentView.findViewById(R.id.p3_2).setOnClickListener(this);
        parentView.findViewById(R.id.p3_3).setOnClickListener(this);
        parentView.findViewById(R.id.p3_4).setOnClickListener(this);
        parentView.findViewById(R.id.p3_5).setOnClickListener(this);

        parentView.findViewById(R.id.p5_1).setOnClickListener(this);
        parentView.findViewById(R.id.p5_2).setOnClickListener(this);
        parentView.findViewById(R.id.p5_3).setOnClickListener(this);
        parentView.findViewById(R.id.p5_4).setOnClickListener(this);

        parentView.findViewById(R.id.s_1).setOnClickListener(this);
        parentView.findViewById(R.id.s_2).setOnClickListener(this);
        parentView.findViewById(R.id.s_3).setOnClickListener(this);

        parentView.findViewById(R.id.j_3).setOnClickListener(this);
        parentView.findViewById(R.id.j_2).setOnClickListener(this);
        parentView.findViewById(R.id.j_1).setOnClickListener(this);

        parentView.findViewById(R.id.c_3).setOnClickListener(this);
        parentView.findViewById(R.id.c_2).setOnClickListener(this);
        parentView.findViewById(R.id.c_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        super.onClick(v);
        switch (v.getId()){
            case R.id.cart_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq.do?vt=5&clientType=0");
                break;
            case R.id.cart_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq/lr.do?vt=5&clientType=0");
                break;
            case R.id.cart_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq/betTrend.do?vt=5&clientType=0");
                break;
            case R.id.cart_4:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq/dxjo.do?vt=5&clientType=0");
                break;
            case R.id.cart_5:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq.do?vt=5&flag=blue_zs&clientType=0");
                break;
            case R.id.cart_6:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq/history.do?vt=5&clientType=0");
                break;
            case R.id.cart_7:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/ssq/historyzs.do?vt=5&clientType=0");
                break;
            case R.id.d_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt.do?vt=5&clientType=0");
                break;
            case R.id.d_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt/lr.do?vt=5&clientType=0");
                break;
            case R.id.d_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt/betTrend.do?vt=5&clientType=0");
                break;
            case R.id.d_4:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt/dxjo.do?vt=5&clientType=0");
                break;
            case R.id.d_5:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt.do?vt=5&flag=blue_zs&clientType=0");
                break;
            case R.id.d_6:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt/history.do?vt=5&clientType=0");
                break;
            case R.id.d_7:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/dlt/historyzs.do?vt=5&clientType=0");
                break;

            case R.id.f_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d.do?vt=5&clientType=0");
                break;
            case R.id.f_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d/hzzs.do?vt=5&clientType=0");
                break;
            case R.id.f_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d/kdzs.do?vt=5&clientType=0");
                break;
            case R.id.f_4:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d/dxjo.do?vt=5&clientType=0");
                break;
            case R.id.f_5:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d/bdwzs.do?vt=5&clientType=0");
                break;
            case R.id.f_6:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/fc3d/historyzs.do?vt=5&clientType=0");
                break;
            case R.id.p3_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl3/dwzs.do?vt=5&clientType=0");
                break;
            case R.id.p3_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl3/hzzs.do?vt=5&clientType=0");
                break;
            case R.id.p3_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl3/dxjo.do?vt=5&clientType=0");
                break;
            case R.id.p3_4:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl3/historyzs.do?vt=5&clientType=0");
                break;
            case R.id.p3_5:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl3/bdwzs.do?vt=5&clientType=0");
                break;
            case R.id.p5_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl5.do?vt=5&clientType=0");
                break;
            case R.id.p5_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl5/sum.do?vt=5&clientType=0");
                break;
            case R.id.p5_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl5/dxjo.do?vt=5&clientType=0");
                break;
            case R.id.p5_4:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/pl5/div3.do?vt=5&clientType=0");
                break;
            case R.id.s_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/sd11x5/jbzs2.do?vt=5&clientType=0");
                break;
            case R.id.s_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/sd11x5/r3mayl.do?vt=5&clientType=0");
                break;
            case R.id.s_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/sd11x5/r5mayl.do?vt=5&clientType=0");
                break;
            case R.id.j_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/xk3/jbzs.do?vt=5&clientType=0");
                break;
            case R.id.j_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/xk3/hzzs.do?vt=5&clientType=0");
                break;
            case R.id.j_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/xk3/hmyl.do?vt=5&clientType=0");
                break;
            case R.id.c_1:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/cqssc/5xjbzs.do?vt=5&clientType=0");
                break;
            case R.id.c_2:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/cqssc/yl/3xzhiyl.do?vt=5&clientType=0");
                break;
            case R.id.c_3:
                intent = new Intent(getActivity(), WebActivity4.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.aicai.com/zst/cqssc/yl/2xzhiyl.do?vt=5&clientType=0");
                break;

        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
