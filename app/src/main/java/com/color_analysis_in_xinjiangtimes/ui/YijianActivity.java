package com.color_analysis_in_xinjiangtimes.ui;

import android.view.View;

import com.color_analysis_in_xinjiangtimes.R;

/**
 * date 2017-05-27 16:44:13
 * desc ${关于我们}
 */
public class YijianActivity extends TextHeaderActivity {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_yijian);
    }

    @Override
    public void initTitleBar() {
        initHeaderStyle(HeaderStyle.BOTH, "意见反馈","提交");
    }

    @Override
    public void initView() {
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShortToast("意见已提交");
                finish();
            }
        });
    }
}
