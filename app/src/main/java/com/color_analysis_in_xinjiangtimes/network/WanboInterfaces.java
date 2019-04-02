package com.color_analysis_in_xinjiangtimes.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WanboInterfaces {

    /**
     * @return
     */
    @GET("app/5c3b12dc8d6d8100675df60c")
    Call<TestDaos> check_and_get_url();

}
