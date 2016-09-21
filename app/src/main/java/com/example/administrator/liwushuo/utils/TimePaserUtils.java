package com.example.administrator.liwushuo.utils;


import android.text.format.DateFormat;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class TimePaserUtils {

    public static CharSequence getWeek(long time){

        return DateFormat.format("--   MM月dd日 --",time);
    }
    public static CharSequence getTime(long time){

        return DateFormat.format("--   MM月dd日 --",time);
    }

}
