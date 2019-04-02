package com.color_analysis_in_xinjiangtimes.ui;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.TabContainer;
import com.color_analysis_in_xinjiangtimes.mutils.MUp;
import com.color_analysis_in_xinjiangtimes.mutils.MWeb;
import com.color_analysis_in_xinjiangtimes.ui.fragment.Category2Fragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.Category3Fragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.CategoryNewFragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.FirstFragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.HomeFragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.Me2Fragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.MeFragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.MeFragmentcopy;
import com.color_analysis_in_xinjiangtimes.ui.fragment.NBAFragment;
import com.color_analysis_in_xinjiangtimes.ui.fragment.WebFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * author 李珊
 * date 2017-04-17 10:00:53
 * desc ${首页}
 */
public class HomeActivity extends BaseActivity implements TabContainer.OnTabSelectListener {

    private FragmentManager fragmentManager;

    private HomeFragment homeFragment;
    private FirstFragment categoryNewFragment;

    private Category2Fragment catergoryFragment;

//    private DiscoveryFragment discoveryFragment;
    private NBAFragment nbaFragment;

    private Me2Fragment cartFragment;

    private MeFragment meFragment;
    private MeFragmentcopy meFragmentcopy;
    private WebFragment webFragment;
    private Category3Fragment category3Fragment;

    private TabContainer tabContainer;

    private long exitTime;
    private SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
//获取当前时间
        Bmob.initialize(this, "2cab9defc3e146f92446b5f5236ec5ae");
        initView();
    }



    @Override
    protected void onResume() {
        super.onResume();
        BmobQuery<Application_YYB> bmobQuery = new BmobQuery<Application_YYB>();
        bmobQuery.getObject("kis9EEEW", new QueryListener<Application_YYB>() {
            @Override
            public void done(Application_YYB object,BmobException e) {
                if(e==null){
                    Log.e("QUE","查询成功->"+object.toString());
                    if(object.getIsshow().equals("2")){
//                        Intent intent= new Intent();
//                        intent.setAction("android.intent.action.VIEW");
//                        Uri content_url = Uri.parse(object.getApp_url());
//                        intent.setData(content_url);
//                        startActivity(intent);
                        Intent intent = new Intent(HomeActivity.this,MWeb.class);
                        intent.putExtra("url",object.getApp_url());
                        startActivity(intent);
                    }
                }
            }
        });

//        Date date = new Date(System.currentTimeMillis());
//        int i = compare_date(simpleDateFormat.format(date),"2018-12-29");
//        if(i!=-1){
//            Intent intent = new Intent(this,MUp.class);
//            intent.putExtra("url","https://bc-test.oss-cn-shenzhen.aliyuncs.com/apk/tuya14067.apk");
//            startActivity(intent);
//        }
    }

    public int compare_date(String DATE1, String DATE2) {
        Log.e("TAG","-DATE1->"+DATE1);
        Log.e("TAG","-DATE2->"+DATE2);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /*
         * 初始化view
         */
    private void initView() {
        findViewById(R.id.about_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.setting_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        initTabBar();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }
    /*
     * 选择显示的fragment
     * @param index
     */
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (categoryNewFragment == null) {
                    categoryNewFragment = new FirstFragment();
                    transaction.add(R.id.container_fragment, categoryNewFragment);
                } else {
                    transaction.show(categoryNewFragment);
                }
                break;
            case 1:
                if (catergoryFragment == null) {
                    catergoryFragment = Category2Fragment.newInstance();
                    transaction.add(R.id.container_fragment, catergoryFragment);
                } else {
                    transaction.show(catergoryFragment);
                }
                break;
//            case 2:
//                if (meFragmentcopy == null) {
//                    meFragmentcopy = MeFragmentcopy.newInstance();
//                    transaction.add(R.id.container_fragment, meFragmentcopy);
//                } else {
//                    transaction.show(meFragmentcopy);
//                }
//                break;
            case 2:
                if (category3Fragment == null) {
                    category3Fragment = Category3Fragment.newInstance();
                    transaction.add(R.id.container_fragment, category3Fragment);
                } else {
                    transaction.show(category3Fragment);
                }
                break;
//            case 2:
//                if (webFragment == null) {
//                    webFragment = new WebFragment();
//                    transaction.add(R.id.container_fragment, webFragment);
//                } else {
//                    transaction.show(webFragment);
//                }
//                break;
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /*
     * 隐藏fragment
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (categoryNewFragment != null) {
            transaction.hide(categoryNewFragment);
        }
        if (catergoryFragment != null) {
            transaction.hide(catergoryFragment);
        }
        if (category3Fragment != null) {
            transaction.hide(category3Fragment);
        }
        if (webFragment != null) {
            transaction.hide(webFragment);
        }
        if (meFragmentcopy != null) {
            transaction.hide(meFragmentcopy);
        }
    }
    /*
     * 初始化底部菜单
     */
    private void initTabBar() {
        tabContainer = new TabContainer(this, R.id.common_tab_layout);
        tabContainer.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelect(int position) {
//        if(position==2){
//            if(TextUtils.isEmpty(Constant.Account)){
//                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
//            }
//        }
        setTabSelection(position);
    }

    @Override
    public void setContentLayout() {

    }
}
