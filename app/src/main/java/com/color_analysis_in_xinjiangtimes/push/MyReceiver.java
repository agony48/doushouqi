package com.color_analysis_in_xinjiangtimes.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.utils.AppUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;
/**
 * 自定义接收器
 * <p/>
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
//        Log.d(TAG, "[MyReceiver] onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
//            Log.e(TAG, "[MyReceiver] 接收Registration Id : " + regId);
            //send the Registration Id to your server...

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
//            Log.e(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            processCustomMessage(context, bundle);
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
//            Log.e(TAG, "[MyReceiver] 接收到推送下来的通知");
//            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
//            Log.e(TAG, "[MyReceiver] 用户点击打开了通知");
            //打开自定义的Activity

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
//            Log.e(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
//            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
//            Log.e(TAG, "[MyReceiver]" + intent.getAction() + " connected state change to " + connected);
        } else {
//            Log.e(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
        }
    }
    // 打印指定的 extra 数据
    private static String messageType(Bundle bundle) {
        String sb = "";
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                    continue;
                }
                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();
                    while (it.hasNext()) {
                        String myKey = it.next().toString();
                        if(TextUtils.equals(myKey,"messageType")){
                            sb = json.optString(myKey);
                        }
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Get message extra JSON error!");
                }
            }
        }
        return sb.toString();
    }
    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                    Log.i(TAG, "This message has no Extra data");
                    continue;
                }
                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();

                    while (it.hasNext()) {
                        String myKey = it.next().toString();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Get message extra JSON error!");
                }

            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }
    /**
     * 强制下线
     * @param context
     * @param bundle
     */
    private void processCustomMessage(Context context, Bundle bundle) {
        String extraMessage = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        try {
            if (!TextUtils.isEmpty(extraMessage)) {
                PushMessageService messageService = PushMessageService.getService(context);
                Gson gson = new Gson();
                PushMessage messageEntity = gson.fromJson(extraMessage, PushMessage.class);
                if (messageEntity == null) {
                    return;
                }
                if (AppUtils.isAppRunning(context) && useable(messageEntity)) {
//                    messageEntity.setAlertMessage(message);
                    messageEntity.setAlertMessage(message);
                    dispatchMessage(context, messageEntity);
                    displayNotification(context,messageEntity);
                    messageService.insert(messageEntity);
//                    List<PushMessage> datas = messageService.getAllMessage("1");
//                    for (PushMessage temp:datas){
//                        Log.i("tag",temp.getMessageType());
//                    }
                }
            }
        } catch (Exception e) {
//            SharePreHelper.getIns().setBug(message);
        }
    }


    private boolean useable(PushMessage pushMessage) {
        return true;
    }
    private void dispatchMessage(Context context, PushMessage message) {
        Intent mIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.MESSAGE_EXTRA, message);
        mIntent.setAction(Constant.MESSAGE_BROADCASET_ACTION);
        mIntent.putExtras(bundle);
        context.sendBroadcast(mIntent);
    }
    private void displayNotification(Context context, PushMessage message) {
        if (message == null) {
            return;
        }
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n = new Notification(R.mipmap.ic_launcher, message.getAlertMessage(), System.currentTimeMillis());
//        Notification n = new Notification();
        n.defaults = Notification.DEFAULT_SOUND;
        n.defaults |= Notification.DEFAULT_VIBRATE;
        n.flags |= Notification.FLAG_AUTO_CANCEL;
        Intent i = new Intent(context, NotificationBroadcastReceiver.class);
        i.setAction(Constant.MESSAGE_BROADCASET_ACTION);
        Bundle extra = new Bundle();
        extra.putSerializable(Constant.MESSAGE_EXTRA, message);
        i.putExtras(extra);
        PendingIntent contentIntent = PendingIntent.getBroadcast(
                context,
                R.string.app_name,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT);
//        n.setLatestEventInfo(
//                context,
//                context.getResources().getString(R.string.app_name),
//                message.getAlertMessage(),
//                contentIntent);
        nm.notify(R.string.app_name, n);
    }
}
