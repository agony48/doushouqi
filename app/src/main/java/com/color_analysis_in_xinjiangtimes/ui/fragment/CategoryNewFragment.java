package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.adapter.Home2NavigationAdapter2;
import com.color_analysis_in_xinjiangtimes.adapter.OneNavigationAdapter;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.news.NewDatas;
import com.color_analysis_in_xinjiangtimes.module.news.ShowApi;
import com.color_analysis_in_xinjiangtimes.network.Networks;
import com.color_analysis_in_xinjiangtimes.network.ProgressRequestCallback;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.HomeMoreActivty;
import com.color_analysis_in_xinjiangtimes.ui.SearchActivity;
import com.color_analysis_in_xinjiangtimes.view.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc 分类${分类}
 */
public class CategoryNewFragment extends BaseFragment  {
    static ViewPager viewPager;
    private FlyBanner img_banner;
    private  RecyclerView mRecyclerView;
    private ImageView next_id0,next_id1,next_id2,next_id3;
    public static CategoryNewFragment newInstance(){
        CategoryNewFragment fragment = new CategoryNewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catenew_4fragment, null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.m_recyclerview);
        next_id0 = (ImageView) view.findViewById(R.id.next_id0);
        next_id1 = (ImageView) view.findViewById(R.id.next_id1);
        next_id2 = (ImageView) view.findViewById(R.id.next_id2);
        next_id3 = (ImageView) view.findViewById(R.id.next_id3);
        next_id0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, "威尼斯人");
                startActivity(intent);
            }
        });
        next_id1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, "猎豹");
                startActivity(intent);
            }
        });
        next_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, "大象");
                startActivity(intent);
            }
        });
        next_id3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, "狗狗");
                startActivity(intent);
            }
        });
        img_banner = (FlyBanner) view.findViewById(R.id.img_banner);
        List<Integer> imageInt = new ArrayList<Integer>();
        imageInt.add(R.mipmap.bannn);
        img_banner.setImages(imageInt);
        initNavigationView(view);
        view.findViewById(R.id.eee_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        img_banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), HomeMoreActivty.class);
                intent.putExtra(Constant.STRING_EXTRA, "威尼斯人");
                startActivity(intent);
            }
        });
        getZuqiu();
        return view;
    }
    /*
    初始化导航栏
     */
    private void initNavigationView(View parentView) {
        //足球
        RecyclerView mRecyclerView2 = (RecyclerView) parentView.findViewById(R.id.home_nav_recyclerview2);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL));
        mRecyclerView2.setAdapter(new Home2NavigationAdapter2(getActivity()));
        mRecyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    }


    private void initdate(List<NewDatas> contentlist) {
        mRecyclerView.setAdapter(new OneNavigationAdapter(getActivity(),contentlist));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }

    public void getZuqiu(){
        Map<String, Object> insetInfo = new HashMap<>();
        insetInfo.put("showapi_appid","60321");
        insetInfo.put("showapi_sign","1194092438024fc388b9559d8ed3d25c");
        insetInfo.put("title","威尼斯人");
        insetInfo.put("page","1");
        insetInfo.put("needHtml","1");
        insetInfo.put("needAllList","0");
        insetInfo.put("maxResult","10");
        Call<ShowApi> call = Networks.getInstance().getNewsData(insetInfo);
        call.enqueue(new ProgressRequestCallback<ShowApi>(getActivity(),"正在加载...") {
            @Override
            public void onResponseCallback(Call<ShowApi> call, Response<ShowApi> response) {

                if (response.body() == null) {
                    return;
                }
                ShowApi entity = response.body();
                if (entity != null) {
                    List<NewDatas> contentlist = entity.showapi_res_body.pagebean.contentlist;
                    initdate(contentlist);
                }
            }

            @Override
            public void onFailureCallback(Call<ShowApi> call, Throwable t) {

            }
        });
    }
}

