package com.example.administrator.liwushuo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by liuhui on 2016/9/22.
 */
public class RewriterGridView extends GridView {

    public RewriterGridView(Context context) {
        super(context);
    }

    public RewriterGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RewriterGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//设置不滚动
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, measureSpec);
    }
}
