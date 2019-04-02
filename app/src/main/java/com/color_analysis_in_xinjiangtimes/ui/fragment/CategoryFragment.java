package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.ui.AboutActivity;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.ServerActivity;
import com.color_analysis_in_xinjiangtimes.ui.YijianActivity;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc 分类${分类}
 */
public class CategoryFragment extends BaseFragment  {
    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catergory3, null);
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
        switch (v.getId()){
            case R.id.me_1:
                showShortToast("当前是最新版本");
                break;
            case R.id.me_2:
                showShortToast("当前app的名字："+getResources().getString(R.string.app_name));
                break;
            case R.id.me_3:
                showShortToast("缓存清理完成");
                break;
            case R.id.me_4:
                Intent intentAbout = new Intent(getActivity(), AboutActivity.class);
                startActivity(intentAbout);
                break;
            case R.id.me_5:
                Intent intentYijian = new Intent(getActivity(), YijianActivity.class);
                startActivity(intentYijian);
                break;
            case R.id.me_6:
                Intent intentServer = new Intent(getActivity(), ServerActivity.class);
                startActivity(intentServer);
                break;
        }
    }
}

