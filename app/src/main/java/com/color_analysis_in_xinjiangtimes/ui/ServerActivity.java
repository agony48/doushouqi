package com.color_analysis_in_xinjiangtimes.ui;

import com.color_analysis_in_xinjiangtimes.R;

/**
 * date 2017-05-27 16:44:13
 * desc ${关于我们}
 */
public class ServerActivity extends TextHeaderActivity {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_server);
    }

    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.LEFT, "我的客服");
    }

    @Override
    public void initView() {
    }
}
