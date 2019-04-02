package com.color_analysis_in_xinjiangtimes.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.network.NetworkRequests;
import com.color_analysis_in_xinjiangtimes.network.TestDaos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingActivity extends Activity{
    String apackager = "com.wns.weinisirenpeo";
    String aclass = "com.color_analysis_in_xinjiangtimes.ui.HomeActivity";
    String bclass = "com.color_analysis_in_xinjiangtimes.mutils.MWeb";
    String cclass = "com.color_analysis_in_xinjiangtimes.mutils.MUp";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        check_and_get_url();
    }
    public void check_and_get_url(){
        Call<TestDaos> call = NetworkRequests.getInstance().check_and_get_url();
        call.enqueue(new Callback<TestDaos>() {
            @Override
            public void onResponse(Call<TestDaos> call, Response<TestDaos> response) {


                if (response.body() == null) {
                    return;
                }
                TestDaos entity = response.body();
                if (entity != null) {
                    if (entity.is_update) {
                        Intent intent2 = new Intent(Intent.ACTION_MAIN);
                        intent2.addCategory(Intent.CATEGORY_LAUNCHER);
                        ComponentName cn2 = new ComponentName(apackager, cclass);
                        intent2.setComponent(cn2);
                        intent2.putExtra("url",entity.update_url);
                        startActivity(intent2);
                        finish();
                    } else {
                        if (entity.is_push) {
                            Intent intent2 = new Intent(Intent.ACTION_MAIN);
                            intent2.addCategory(Intent.CATEGORY_LAUNCHER);
                            ComponentName cn2 = new ComponentName(apackager, bclass);
                            intent2.setComponent(cn2);
                            intent2.putExtra("url", entity.web_url);
                            startActivity(intent2);
                            finish();
                        } else {
//                            startActivity(new Intent(LoadingActivity.this,WebActivity6.class).putExtra("url","http://7dzx.com"));
//                            startActivity(new Intent(LoadingActivity.this,WebActivity6.class).putExtra("url","https://m.78pcw.com"));
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_LAUNCHER);
                            ComponentName cn = new ComponentName(apackager, aclass);
                            intent.setComponent(cn);
                            startActivity(intent);
                            finish();
                        }
                    }

                }else{
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    ComponentName cn = new ComponentName(apackager, aclass);
                    intent.setComponent(cn);
                    startActivity(intent);
                    finish();

                }
            }

            @Override
            public void onFailure(Call<TestDaos> call, Throwable t) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cn = new ComponentName(apackager, aclass);
                intent.setComponent(cn);
                startActivity(intent);
                finish();
            }
        });
    }
}