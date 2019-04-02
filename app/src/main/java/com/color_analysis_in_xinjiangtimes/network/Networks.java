package com.color_analysis_in_xinjiangtimes.network;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networks {
    public static final String BASE_URL = "http://route.showapi.com/";
    public static Interfaces service;
    public static Interfaces getInstance(){
        if (service == null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(intercepeter).addInterceptor(httpLoggingInterceptor).cookieJar(new CookieJar() {
                private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
                private HttpUrl oldUrl = null;
                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.clear();
                    oldUrl = url;
                    cookieStore.put(url, cookies);
                }
                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(oldUrl);
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            }).build();
            GsonBuilder builder = new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            builder.setFieldNamingStrategy(new AnnotateNaming());
            Gson gson = builder.create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            service = retrofit.create(Interfaces.class);
        }
        return service;
    }
    private static Interceptor intercepeter = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Response response = chain.proceed(originalRequest);
                return response;
        }
    };
}
