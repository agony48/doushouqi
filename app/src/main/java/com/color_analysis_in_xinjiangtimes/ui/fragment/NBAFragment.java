package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity2;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc 分类${分类}
 */
public class NBAFragment extends BaseFragment  {
    public static NBAFragment newInstance() {
        NBAFragment fragment = new NBAFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nba, null);
        initView(view);
        return view;
    }
    private void initView(View view) {
        view.findViewById(R.id.me_6).setOnClickListener(this);
        view.findViewById(R.id.me_5).setOnClickListener(this);
        view.findViewById(R.id.me_4).setOnClickListener(this);
        view.findViewById(R.id.me_3).setOnClickListener(this);
        view.findViewById(R.id.me_2).setOnClickListener(this);
        view.findViewById(R.id.me_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent = null;
        switch (v.getId()){
            case R.id.me_1:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/zuqiu/yingchao/");
                break;
            case R.id.me_2:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/zuqiu/xijia/");
                break;
            case R.id.me_3:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/lanqiu/nba/");
                break;
            case R.id.me_4:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/zuqiu/yijia/");
                break;
            case R.id.me_5:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/zuqiu/dejia/");
                break;
            case R.id.me_6:
                intent = new Intent(getActivity(), WebActivity2.class);
                intent.putExtra(Constant.STRING_EXTRA, "http://m.24zbw.com/live/zuqiu/fajia/");
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}

