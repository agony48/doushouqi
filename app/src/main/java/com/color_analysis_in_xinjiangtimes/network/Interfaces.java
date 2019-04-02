package com.color_analysis_in_xinjiangtimes.network;

import com.color_analysis_in_xinjiangtimes.module.news.ShowApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Interfaces {

    /**
     * @return
     */
    @GET("109-35")
    Call<ShowApi> getNewsData(@QueryMap Map<String, Object> insetInfo);

}
