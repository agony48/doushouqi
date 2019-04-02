package com.color_analysis_in_xinjiangtimes.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @auther Kalen
 * @time 16/5/30 下午2:24
 * @des 自动换行LinearLayout
 */
public class AutoLinearLayout extends LinearLayout {

    public AutoLinearLayout(Context context) {
        super(context);
    }

    public AutoLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int margin;

    private boolean mutiselect;

    public void setMutiselect(boolean pMutiselect){
        this.mutiselect = pMutiselect;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public OnConditionClickListener mConditionClickListener;

    public void setConditionClickListener(OnConditionClickListener mConditionClickListener){
        this.mConditionClickListener = mConditionClickListener;
    }
    public interface OnConditionClickListener {
        public void onConditionClick(boolean select, Object object);
    }

    public void initEvents(){
        if (getChildCount() == 0) {
            return;
        }
        for (int i=0;i<getChildCount();i++) {
            final TextView textView = (TextView) getChildAt(i);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Log.e("mutiselect",""+mutiselect);
//                    mutiselect=true;
                    if (mutiselect){
                        v.setSelected(!v.isSelected());
                    } else {
                        clearConditionClick();
                        v.setSelected(true);
                    }

                    if (mConditionClickListener != null){
                        mConditionClickListener.onConditionClick(v.isSelected(),v.getTag());
                    }

                }
            });
        }
    }

    /**
     * 清除所有规格选中状态
     */
    public void clearConditionClick() {
        if (getChildCount() == 0) {
            return;
        }
        for (int i=0;i<getChildCount();i++) {
            TextView textView = (TextView) getChildAt(i);
            textView.setSelected(false);
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AutoLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int size = 0;

    private boolean isWeight = false;

    public void setIsWeight(boolean isWeight) {
        this.isWeight = isWeight;
    }

    public void setRowSize(int size) {
        this.size = size;
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = l;
        int top = 0;
        int right = 0;
        int bottom = 0;
        for (int index = 0; index < getChildCount(); index++) {

            View childView = getChildAt(index);
            int childHeight = childView.getMeasuredHeight();
            right = left + calculateWidth(childView);
            bottom = (top + childHeight);
            childView.layout(left, top, right, bottom);
            if (isReturnRowLayout(index + 1, calculateWidth(childView) + right + margin, r)) {
                left = l;
                top = top + calculateHeight(childView);
            } else {
                left += calculateWidth(childView) + margin;
            }

        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        final int height = MeasureSpec.getSize(heightMeasureSpec);
        int rowHeight = 0;
        int totalHeight = 0;
        int rowX = 0;
        for (int index = 0; index < getChildCount(); index++) {
            View childView = getChildAt(index);
            LayoutParams layoutParams = (LayoutParams) childView.getLayoutParams();
            int childWidth = layoutParams.width > 0 ? layoutParams.width
                    : width;
            int childHeight = layoutParams.height > 0 ? layoutParams.height
                    : height;

            int childWidthMode = layoutParams.width > 0 ? MeasureSpec.EXACTLY
                    : MeasureSpec.AT_MOST;
            int childHeightMode = layoutParams.height > 0 ? MeasureSpec.EXACTLY
                    : MeasureSpec.AT_MOST;
            childView.measure(
                    MeasureSpec.makeMeasureSpec(width, childWidthMode),
                    MeasureSpec.makeMeasureSpec(200, childHeightMode));
            rowHeight = Math.max(calculateHeight(childView), rowHeight);
Log.i("auto", rowHeight+"");
            if (isReturnRowMeasure(index + 1, rowX + calculateWidth(childView), width)) {
                totalHeight += rowHeight;
                rowHeight = 0;
                rowX = 0;
            } else {
                rowX += calculateWidth(childView) + margin;
            }
        }

        totalHeight += rowHeight + (getPaddingTop() + getPaddingBottom());
Log.d("auto", totalHeight+"-");
        setMeasuredDimension(widthMeasureSpec,
                resolveSize(totalHeight, heightMeasureSpec));
    }

    private int calculateWidth(View childView) {
        if (isWeight) {
            return (getMeasuredWidth() - (size - 1) * margin) / size;
        }
        return childView.getMeasuredWidth();
    }

    private int calculateHeight(View childView) {
        return childView.getMeasuredHeight() + margin;
    }


    private boolean isReturnRowMeasure(int index, int totalWidth, int width) {
        if (isWeight) {
            if (index == 0) {
                return false;
            }
            return index % size == 0;
        }
        return totalWidth > width;

    }

    private boolean isReturnRowLayout(int index, int rowX, int right) {
        if (isWeight) {
            return index % size == 0;
        }
        return rowX > right;
    }
}
