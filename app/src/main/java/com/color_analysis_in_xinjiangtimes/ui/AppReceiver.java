package com.color_analysis_in_xinjiangtimes.ui;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

public class AppReceiver extends BroadcastReceiver {
    private final String TAG = this.getClass().getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        PackageManager pm = context.getPackageManager();
        Log.e(TAG, "--------ad" + intent.getDataString().substring(8));
        if(intent.getDataString().substring(8).equals("com.tc168.cp8yi")){
            Uri uri = Uri.fromParts("package", "com.kaijianglsActivity", null);
            Intent delintent = new Intent(Intent.ACTION_DELETE, uri);
            delintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(delintent);
        }
//
//        if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_ADDED)) {
//            String packageName = intent.getData().getSchemeSpecificPart();
//            Log.e(TAG, "--------安装成功" + packageName);
//            Toast.makeText(context, "安装成功" + packageName, Toast.LENGTH_LONG).show();
//        } else if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_REPLACED)) {
//            String packageName = intent.getData().getSchemeSpecificPart();
//            Log.e(TAG, "--------替换成功" + packageName);
//            Toast.makeText(context, "替换成功" + packageName, Toast.LENGTH_LONG).show();
//        } else if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_REMOVED)) {
//            String packageName = intent.getData().getSchemeSpecificPart();
//            Log.e(TAG, "--------卸载成功" + packageName);
//            Toast.makeText(context, "卸载成功" + packageName, Toast.LENGTH_LONG).show();
//        }
    }

}
