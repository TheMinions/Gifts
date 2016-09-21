package com.example.administrator.liwushuo.utils;


import android.text.format.DateFormat;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class TimePaserUtils {

    private static final String TAG = TimePaserUtils.class.getSimpleName();

    public static CharSequence getWeek(long time){
        Log.e(TAG, "getWeek: "+time );
        return DateFormat.format("MM月dd日 EEEE",time);
    }
    public static CharSequence getTime(long time){

        return DateFormat.format("kk:mm",time);
    }


}
