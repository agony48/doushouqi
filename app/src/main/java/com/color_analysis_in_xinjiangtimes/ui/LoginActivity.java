package com.color_analysis_in_xinjiangtimes.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;


/**
 * author 李珊
 * date 2017-04-24 11:18:39
 * desc ${登录}
 */
public class LoginActivity extends TextHeaderActivity{
    private Button loginBtn;
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.LEFT, "", "");
    }

    @Override
    public void initView() {
        findViewById(R.id.regist_bt).setOnClickListener(this);
        findViewById(R.id.forget_tv).setOnClickListener(this);

        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.login_btn:
                Constant.Account = "asdasd";
                showShortToast("登录成功");
                setResult(RESULT_OK);
                finish();
                break;
            case R.id.regist_bt:
                Intent intent = new Intent(this, RegisterActivity.class);
//                startActivityForResult(intent, 100);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void performClick(View view) {
        super.performClick(view);
        switch (view.getId()){
            case R.id.regist_bt:
                break;
        }
    }


}
