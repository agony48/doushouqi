package com.color_analysis_in_xinjiangtimes.ui;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.utils.AppUtils;

/**
 * author 李珊
 * date 2017-05-18 11:14:54
 * desc ${个人中心-设置}
 */
public class SettingActivity extends TextHeaderActivity{

    private TextView versionView, localVersionView;
    private LinearLayout submit;

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_setting);
    }

    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.LEFT, getString(R.string.title_setting_str));
    }

    @Override
    public void initView() {
        findViewById(R.id.cach_tv).setOnClickListener(this);
        findViewById(R.id.notification_tv).setOnClickListener(this);
        findViewById(R.id.address_tv).setOnClickListener(this);
        findViewById(R.id.yijian_tv).setOnClickListener(this);
        submit = (LinearLayout) findViewById(R.id.logout_lt);
        submit.setOnClickListener(this);
        findViewById(R.id.about_tv).setOnClickListener(this);
        findViewById(R.id.account_ll).setOnClickListener(this);
        findViewById(R.id.version_lt).setOnClickListener(this);
        versionView = (TextView) findViewById(R.id.version_tv);
        localVersionView = (TextView) findViewById(R.id.local_verison_tv);
        localVersionView.setText(getString(R.string.local_version_str, AppUtils.getVersionName(this)));
    }

    @Override
    public void performClick(View view) {
        super.performClick(view);
        if (view.getId() == R.id.about_tv) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return;
        }
        if (view.getId() == R.id.version_lt) {
            showShortToast("当前是最新版本");
            return;
        }
        if (view.getId() == R.id.cach_tv) {
            showShortToast("缓存清理完成");
            return;
        }
        if (view.getId() == R.id.logout_lt) {
            //退出
            finish();
            setResult(RESULT_OK);
            System.exit(0);
            return;
        }
        if (view.getId() == R.id.yijian_tv) {
            //退出
            showShortToast("客服电话：15882144023,详细可查看关于我们界面");
            return;
        }
    }
}
