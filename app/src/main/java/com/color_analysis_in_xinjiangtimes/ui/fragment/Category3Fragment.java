package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.LoginActivity;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.HotFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc 分类${分类}
 */
public class Category3Fragment extends BaseFragment  {
    static ViewPager viewPager;
    private TextView name_tv;
    public static Category3Fragment newInstance() {
        Category3Fragment fragment = new Category3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catenew_3fragment, null);
        initView(view);
        return view;
    }
    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager3);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());

        name_tv = (TextView) view.findViewById(R.id.name_tv);
        view.findViewById(R.id.header_lt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.header_lt:
                if(TextUtils.isEmpty(Constant.Account)){
                   startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(Constant.Account)){
            name_tv.setText("威尼斯人");
        }else{
            name_tv.setText("请登录");
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentManager mManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(mManager);

        HotFragment fragment1 = new HotFragment();
        Bundle data1 = new Bundle();
        fragment1.setArguments(data1);
        adapter.addFrag(fragment1, "");

//        Fragment fragment2 = new Oragment();
//        Bundle data2 = new Bundle();
//        fragment2.setArguments(data2);
//        adapter.addFrag(fragment2, "足球");
//
//        Fragment fragment3 = new Tragment();
//        Bundle data3 = new Bundle();
//        fragment3.setArguments(data3);
//        adapter.addFrag(fragment3, "篮球");
//
//        Fragment fragment4 = new FOragment();
//        Bundle data4 = new Bundle();
//        fragment4.setArguments(data4);
//        adapter.addFrag(fragment4, "NBA");
//
//        Fragment fragment5 = new FIVragment();
//        Bundle data5 = new Bundle();
//        fragment5.setArguments(data5);
//        adapter.addFrag(fragment5, "其他");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}

