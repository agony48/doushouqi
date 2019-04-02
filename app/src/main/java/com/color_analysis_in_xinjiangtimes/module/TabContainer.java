package com.color_analysis_in_xinjiangtimes.module;

import android.app.Activity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.color_analysis_in_xinjiangtimes.R;
import java.util.ArrayList;

public class TabContainer implements OnTabSelectListener {


    public static  final  int CART_REQUEST_CODE = 1000;

    private Activity activity;

    private int currentPosition;

    private OnTabSelectListener selectListener;

    private int[] mIconUnselectIds = {
            R.mipmap.home_bottm_select_1, R.mipmap.home_bottm_select_2
            , R.mipmap.home_bottm_select_5,
            R.mipmap.home_b_4};
//    private int[] mIconUnselectIds = {
//            R.mipmap.global_label_bookshelf_normal, R.mipmap.global_label_home_select, R.mipmap.home_bottm_pass_3,
//            R.mipmap.home_bottm_pass_4, R.mipmap.home_bottm_pass_5};

    private int[] mIconSelectIds = {
            R.mipmap.home_bottm_select_1, R.mipmap.home_bottm_select_2
            , R.mipmap.home_bottm_select_5,
            R.mipmap.home_b_4};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private CommonTabLayout commonTabLayout;

    public TabContainer(Activity activity, int resourceID) {

        this.activity= activity;
        this.currentPosition=0;
        String[] mTitles = activity.getResources().getStringArray(R.array.home_tabs_array);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout = (CommonTabLayout) activity.findViewById(resourceID);
        commonTabLayout.setTabData(mTabEntities);

    }

    public void setOnTabSelectListener(TabContainer.OnTabSelectListener selectListener) {
        this.selectListener = selectListener;
        commonTabLayout.setOnTabSelectListener(this);
    }

//    public  void setLabel(int position,int number){
//        if(number==0){
////        commonTabLayout.removeAllViews();
//            commonTabLayout.hideMsg(position);
//        }else{
//            commonTabLayout.showMsg(position,number);
//            commonTabLayout.setMsgMargin(position,-10,0);
//        }
//
//    }
    /**
     * 当页码未3、4时判断是否登录，若未登录，跳转至登录页面
     *
     * @param position
     */
    @Override
    public void onTabSelect(int position) {
        commonTabLayout.setCurrentTab(position);
        if (selectListener != null) {
            selectListener.onTabSelect(position);
        }
        currentPosition = position;
    }


    @Override
    public void onTabReselect(int position) {

    }

    public interface OnTabSelectListener {
        void onTabSelect(int position);
    }
}
