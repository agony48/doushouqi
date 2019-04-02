package com.color_analysis_in_xinjiangtimes.ui.fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.FIVEFragment;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.FOURFragment;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.ONEFragment;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.THREEFragment;
import com.color_analysis_in_xinjiangtimes.ui.classFragment.TWOFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc 分类${分类}
 */
public class Category2Fragment extends BaseFragment  {
    static ViewPager viewPager;
    public static Category2Fragment newInstance() {
        Category2Fragment fragment = new Category2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catenew_2fragment, null);
        initView(view);
        return view;
    }
    private void initView(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager2);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

//        <item>捕鱼达人</item>
//        <item>捕鱼技巧</item>
//        <item>捕鱼分享</item>
//        <item>捕鱼经验</item>
    private void setupViewPager(ViewPager viewPager) {
        FragmentManager mManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(mManager);

        Fragment fragment1 = new TWOFragment();
        Bundle data1 = new Bundle();
        fragment1.setArguments(data1);
        adapter.addFrag(fragment1, "全部");

        Fragment fragment2 = new ONEFragment();
        Bundle data2 = new Bundle();
        fragment2.setArguments(data2);
        adapter.addFrag(fragment2, "威尼斯酒店");

        Fragment fragment3 = new THREEFragment();
        Bundle data3 = new Bundle();
        fragment3.setArguments(data3);
        adapter.addFrag(fragment3, "小运河");

        Fragment fragment4 = new FOURFragment();
        Bundle data4 = new Bundle();
        fragment4.setArguments(data4);
        adapter.addFrag(fragment4, "石板路");

        Fragment fragment5 = new FIVEFragment();
        Bundle data5 = new Bundle();
        fragment5.setArguments(data5);
        adapter.addFrag(fragment5, "威记");

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

