package com.example.administrator.liwushuo.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by liuhui on 2016/9/20.
 *
 */
public class CubeTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        if (position < -1) {//看不到的一页 *
            page.setScaleX(1);
            page.setScaleY(1);
        } else if (position <= 1) {
            if (position < 0) {//滑出的页 0.0 ~ -1 *
                float scaleFactor = (1 - MIN_SCALE) * (0 - position);
                page.setScaleX(1 - scaleFactor);
                page.setScaleY(1 - scaleFactor);
            } else {//滑进的页 1 ~ 0.0 *
                float scaleFactor = (1 - MIN_SCALE) * (1 - position);
                page.setScaleX(MIN_SCALE + scaleFactor);
                page.setScaleY(MIN_SCALE + scaleFactor);
            }
        } else {//看不到的另一页 *
            page.setScaleX(1);
            page.setScaleY(1);
        }


    }

}
