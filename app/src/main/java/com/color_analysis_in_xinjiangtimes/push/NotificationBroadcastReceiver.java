package com.color_analysis_in_xinjiangtimes.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.HomeActivity;


public class NotificationBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        PushMessage message = (PushMessage) intent.getSerializableExtra(Constant.MESSAGE_EXTRA);
        if (message == null) {
            return;
        }
        Intent intent1 = null;
        intent1 = new Intent(context, HomeActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent1);

    }
}
