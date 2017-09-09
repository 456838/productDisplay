package com.salton123.productdisplay.utils;

import android.content.Context;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 21:45
 * ModifyTime: 21:45
 * Description:
 */
public class DensityUtil {
    public static int dip2px(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static int px2dip(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

}
