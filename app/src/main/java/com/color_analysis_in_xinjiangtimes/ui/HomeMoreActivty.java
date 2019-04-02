package com.color_analysis_in_xinjiangtimes.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.adapter.OneNavigationAdapter;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.module.news.NewDatas;
import com.color_analysis_in_xinjiangtimes.module.news.ShowApi;
import com.color_analysis_in_xinjiangtimes.network.Networks;
import com.color_analysis_in_xinjiangtimes.network.ProgressRequestCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * author 万强
 * date 16/5/11 下午8:08
 */
public class HomeMoreActivty extends TextHeaderActivity {
    public String wordkey="";
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_m);
    }

    @Override
    public void initTitleBar() {
        wordkey = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initHeaderStyle(HeaderStyle.LEFT, wordkey);
    }
    @Override
    public void initView() {
        getZuqiu(wordkey);
    }

    private void initdate(List<NewDatas> contentlist) {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.m_recyclerview);
        mRecyclerView.setAdapter(new OneNavigationAdapter(HomeMoreActivty.this,contentlist));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    public void getZuqiu(String key){
        Map<String, Object> insetInfo = new HashMap<>();
        insetInfo.put("showapi_appid","60321");
        insetInfo.put("showapi_sign","1194092438024fc388b9559d8ed3d25c");
        insetInfo.put("title",key);
        insetInfo.put("page","1");
        insetInfo.put("needHtml","1");
        insetInfo.put("needAllList","0");
        insetInfo.put("maxResult","20");
        Call<ShowApi> call = Networks.getInstance().getNewsData(insetInfo);
        call.enqueue(new ProgressRequestCallback<ShowApi>(this,"正在加载...") {
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
