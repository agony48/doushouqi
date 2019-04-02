package com.color_analysis_in_xinjiangtimes.ui;

import android.view.View;
import android.widget.Button;

import com.color_analysis_in_xinjiangtimes.R;

/**
 * author 李珊
 * date 2017-04-24 11:18:47
 * desc ${注册 手机号码+验证码}
 */
public class RegisterActivity extends TextHeaderActivity {
    private Button loginView;
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_regist);
    }
    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.LEFT, "", "");
    }

    @Override
    public void initView() {
        loginView = (Button) findViewById(R.id.login_next_);loginView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.login_next_:
                showShortToast("注册成功");
                finish();
                break;
        }
    }

}
