package com.color_analysis_in_xinjiangtimes.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;


public abstract class TextHeaderActivity extends BaseActivity implements View.OnClickListener {

    public enum HeaderStyle {
        BOTH, LEFT, RIGHT, NONE
    }

    /**
     * 右边按钮
     */
    public TextView right;

    /**
     * 左边按钮
     */
    public ImageButton left;


    public TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout();
        initTitleBar();
        initView();
    }


    /**
     * 初始化标题样式
     *
     * @param style
     * @param title
     */
    public void initHeaderStyle(HeaderStyle style, String title) {
        initHeaderView();
        updateHeaderStyle(style);
        View view = findViewById(R.id.title);
        if (view instanceof TextView) {
            ((TextView) view).setText(title);
        }
    }

    /**
     * 初始化标题样式
     * @param style
     * @param title
     * @param rightText
     */
    public void initHeaderStyle(HeaderStyle style, String title,String rightText) {
        initHeaderView();
        updateHeaderStyle(style);
        View view = findViewById(R.id.title);
        if (view instanceof TextView&&!TextUtils.isEmpty(title)) {
            ((TextView) view).setText(title);
        }

        if(!TextUtils.isEmpty(rightText)){
            right.setText(rightText);
        }

    }


    /**
     * 设置左侧按钮图片
     * @param resourceID
     */
    public void setLeftImg(int resourceID) {

        left.setImageResource(resourceID);
    }

    /**
     * 设置右侧按钮文字
     * @param resource
     */

    public void setRightText(String resource) {
        if(TextUtils.isEmpty(resource)){
            return;
        }

        right.setText(resource);
    }

    /**
     * 设置标题
     * @param resource
     */
    public void setTitle(String resource){
        title.setText(resource);
    }


    /**
     * 初始化HeaderView
     */
    private void initHeaderView() {
        title = (TextView) findViewById(R.id.title) ;
        left = (ImageButton) findViewById(R.id.back);
        left.setOnClickListener(this);
        right = (TextView) findViewById(R.id.right);
        right.setOnClickListener(this);

    }

    /**
     * 初始化标题样式
     */
    private void updateHeaderStyle(HeaderStyle style) {
        if (style == HeaderStyle.LEFT) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.VISIBLE);
        } else if (style == HeaderStyle.BOTH) {
            right.setVisibility(View.VISIBLE);
            left.setVisibility(View.VISIBLE);
        } else if (style == HeaderStyle.RIGHT) {
            right.setVisibility(View.VISIBLE);
            left.setVisibility(View.INVISIBLE);
        } else {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
        }
    }



    /**
     * 当Back或则右边按钮点击时调用
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back:
                onLeftClick(v);
                break;
            case R.id.right:
                onRightClick(v);
                break;
            default:
                performClick(v);
        }
    }

    /**
     * 点击按钮
     *
     * @param view
     */
    public void performClick(View view) {

    }


    /**
     * 右边点击按钮
     *
     * @param view
     */
    protected void onRightClick(View view) {

    }

    protected void onLeftClick(View view) {
        finish();
    }

    public abstract void setContentLayout();

    public abstract void initTitleBar();
    public abstract void initView();
}
