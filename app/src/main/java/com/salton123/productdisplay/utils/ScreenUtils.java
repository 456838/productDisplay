package com.salton123.productdisplay.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 21:46
 * ModifyTime: 21:46
 * Description:
 */
public class ScreenUtils {

    public static int dip2px(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static int getLocalTime(Context paramContext)
    {
        return paramContext.getSharedPreferences("Honor_v9", 0).getInt("current_time", 60);
    }

    public static long getTouchTime(Context paramContext)
    {
        return paramContext.getSharedPreferences("Honor_v9", 0).getLong("last_touch_time", System.currentTimeMillis());
    }

    public static int px2dip(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static void setLocaTime(Context paramContext, int paramInt)
    {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("Honor_v9", 0).edit();
        editor.putInt("current_time", paramInt);
        editor.apply();
    }

    public static void setTouchTime(Context paramContext, long paramLong)
    {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("Honor_v9", 0).edit();
        editor.putLong("last_touch_time", paramLong);
        editor.apply();
    }
}
