package com.color_analysis_in_xinjiangtimes.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.color_analysis_in_xinjiangtimes.R;

/**
 * 选中菜单
 * @author lishan
 * @date 16/7/27
 * @version 1.0
 */
public class Indicator extends View {

    private Paint mPaint; // 画指示符的paint
    private int mTop; // 指示符的top
    private int mLeft; // 指示符的left
    private int mWidth; // 指示符的width
    private int mHeight = 5; // 指示符的高度
    private int mColor; // 指示符的颜色
    private int mChildCount;

    private int position=0;

    public Indicator(Context context, AttributeSet attrs) {
        super(context, attrs);
//        setBackgroundColor(Color.TRANSPARENT);  // 必须设置背景，否则onDraw不执行

        // 获取自定义属性 指示符的颜色
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0);
        mChildCount= ta.getInt(R.styleable.Indicator_count,1);
        mColor = ta.getColor(R.styleable.Indicator_Indicator_color, Color.parseColor("#3cb1f7"));
        ta.recycle();

        // 初始化paint
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
    }

    public void  setChildCount(int childCount){
        this.mChildCount = childCount;
        postInvalidate();
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mTop = getMeasuredHeight(); // 测量的高度即指示符的顶部位置
        int width = getMeasuredWidth(); // 获取测量的总宽度
        int height = mTop + mHeight; // 重新定义一下测量的高度
        setMeasuredDimension(width, height);
    }
    public void scroll(int position) {
        this.position = position;
        mLeft = position * mWidth;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth(); // 获取测量的总宽度
        mWidth = width / mChildCount; // 指示符的宽度为总宽度/item的个数
        mLeft = position * mWidth;
        // 圈出一个矩形
        Rect rect = new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);
        canvas.drawRect(rect, mPaint); // 绘制该矩形
        super.onDraw(canvas);
    }


}
