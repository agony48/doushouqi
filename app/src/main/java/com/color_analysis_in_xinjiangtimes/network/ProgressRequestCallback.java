package com.color_analysis_in_xinjiangtimes.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.color_analysis_in_xinjiangtimes.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author lishan
 * @date 16/7/27
 * @version 1.0
 */
public  abstract class ProgressRequestCallback<T> implements Callback<T> {

    private ProgressDialog dialog;
    private Context context;

    public ProgressRequestCallback(Context context) {
        this.context = context;
    }

    public ProgressRequestCallback(Context context, String message) {
        this.context = context;
//        dialog = ProgressDialog.show(context, "", message, true, false);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        hideProgress();
        onResponseCallback(call, response);
    }
    public abstract void onResponseCallback(Call<T> call, Response<T> response);
    public abstract void onFailureCallback(Call<T> call , Throwable t);
    private void hideProgress() {
        if (dialog!=null){
            dialog.dismiss();
            dialog = null;
        }
    }
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("progressRequestCallback","t->"+t);
        Toast.makeText(context,context.getString(R.string.tips_server_exception_str),Toast.LENGTH_SHORT).show();
        hideProgress();
        onFailureCallback(call, t);
    }
}
