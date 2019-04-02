package com.color_analysis_in_xinjiangtimes.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

/**
 * Created by Administrator on 2016/12/9.
 */
public class PermissionUtils {

    private static PermissionUtils permissionUtils;
    public static synchronized PermissionUtils getInstance() {
        if (permissionUtils == null) {
            permissionUtils = new PermissionUtils();
        }
        return permissionUtils;
    }
    /**
     * 作用：用户是否同意打开权限
     * @return true 同意 false 拒绝
     */
    public static boolean isPermission(Activity mC, String permissions) {
        PackageManager pm = mC.getPackageManager();
        boolean permission = (PackageManager.PERMISSION_GRANTED ==
                pm.checkPermission(permissions, "packageName"));
        if (permission) {
            return true;
        }else {
            return false;
        }
    }
    public void showMyPermissionsDialog(final Activity mContext,String permissionNames) {
        showMessageOKCancel(mContext,"在设置-应用-第三城+权限中开启"+permissionNames+"权限，以正常使用"+permissionNames+"功能",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //跳转设置页
                                goToAppSettings(mContext);
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //取消 不作任何处理
//                                mContext.finish();
                                break;
                        }

                    }
                });
    }
    private void showMessageOKCancel(Activity mContext, String message, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(mContext)
                .setMessage(message)
                .setPositiveButton("OK", listener)
                .setNegativeButton("Cancel", listener)
                .create()
                .show();
    }
    public static final int REQUEST_APP_SETTINGS = 1;
    /**
     * 应用设置页
     */
    private void goToAppSettings(Activity mContext) {
        Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + mContext.getPackageName()));
        myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
//        myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivityForResult(myAppSettings, REQUEST_APP_SETTINGS);
    }
}
