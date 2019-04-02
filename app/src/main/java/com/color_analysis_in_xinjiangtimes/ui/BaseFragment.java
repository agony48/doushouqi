package com.color_analysis_in_xinjiangtimes.ui;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.anthonycr.grant.PermissionsManager;

/**
 * author 万强
 * date 16/5/10 上午10:22
 * desc ${Fragment基类}
 */
public class BaseFragment extends Fragment implements View.OnClickListener {



    /**
     * mToast  限制只能出现一个提示，当窗口关闭时，立即关闭Toast
     * date 16/7/13 下午13:33
     * author 李珊
     */
    private Toast mToast;

    /**
     * Toast 短时间提示信息
     * @param text
     */
    public void showShortToast(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if(mToast==null){
            mToast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
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

    @Override
    public void onClick(View v) {
    }

    //因为权限管理类无法监听系统，所以需要重写onRequestPermissionResult方法，更新权限管理类，并回调结果。这个是必须要有的。
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
        Log.e("ACTI","--->"+permissions.toString());
    }
}
