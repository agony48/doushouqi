package com.color_analysis_in_xinjiangtimes.ui.classFragment2;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.adapter.OneNavigationAdapter;
import com.color_analysis_in_xinjiangtimes.module.news.NewDatas;
import com.color_analysis_in_xinjiangtimes.module.news.ShowApi;
import com.color_analysis_in_xinjiangtimes.network.Networks;
import com.color_analysis_in_xinjiangtimes.network.ProgressRequestCallback;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class Hragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        getZuqiu(view);
        return view;
    }
    private void initView(View parentView,List<NewDatas> contentlist) {
        RecyclerView mRecyclerView = (RecyclerView) parentView.findViewById(R.id.one_recyclerview);
        mRecyclerView.setAdapter(new OneNavigationAdapter(getActivity(),contentlist));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }

    public void getZuqiu(final View parentView){
        Map<String, Object> insetInfo = new HashMap<>();
        insetInfo.put("showapi_appid","60321");
        insetInfo.put("showapi_sign","1194092438024fc388b9559d8ed3d25c");
        insetInfo.put("title","最热");
        insetInfo.put("page","1");
        insetInfo.put("needHtml","1");
        insetInfo.put("needAllList","0");
        insetInfo.put("maxResult","20");
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
                    initView(parentView,contentlist);
                }
            }

            @Override
            public void onFailureCallback(Call<ShowApi> call, Throwable t) {

            }
        });
    }
}
