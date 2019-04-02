package com.color_analysis_in_xinjiangtimes.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.anthonycr.grant.PermissionsManager;
import com.umeng.analytics.MobclickAgent;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc ${Activity基类}
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    /**
     * mToast  限制只能出现一个提示，当窗口关闭时，立即关闭Toast
     * date 16/7/13 下午13:33
     * author 李珊
     */
    private Toast mToast;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MApplication.getInstance().addCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MApplication.getInstance().removeCurrentActivity(this);
    }

    /**
     * Toast 短时间提示信息
     * @param text
     */
    public void showShortToast(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if(mToast==null){
            mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 关闭Toast
     */
    public void cancelToast(){
        if(mToast!=null){
            mToast.cancel();
        }
    }

    /**
     * 调起关闭Toast事件
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cancelToast();
    }



    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    //因为权限管理类无法监听系统，所以需要重写onRequestPermissionResult方法，更新权限管理类，并回调结果。这个是必须要有的。
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
    }

    public abstract void setContentLayout();
}
