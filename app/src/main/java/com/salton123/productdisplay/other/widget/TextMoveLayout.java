package com.salton123.productdisplay.other.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/9/6.
 */

public class TextMoveLayout  extends ViewGroup
{
    public TextMoveLayout(Context paramContext)
    {
        super(paramContext);
    }

    public TextMoveLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public TextMoveLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}

    protected void onMeasure(int paramInt1, int paramInt2)
    {
        super.onMeasure(paramInt1, paramInt2);
        int modeWidth = View.MeasureSpec.getMode(paramInt1);
        int sizeWidth = View.MeasureSpec.getSize(paramInt1);
        int modeHeight = View.MeasureSpec.getMode(paramInt2);
        int sizeHeight = View.MeasureSpec.getSize(paramInt2);
//        if (modeHeight ==MeasureSpec.AT_MOST){
//            if (modeWidth!=MeasureSpec.AT_MOST){
//                return;
//            }
//        }
//        if (j == 1073741824) {
//            if (i != 1073741824) {
//                break label70;
//            }
//        }
//        for (;;)
//        {
//            setMeasuredDimension(paramInt1, paramInt2);
//            return;
//            if (j == Integer.MIN_VALUE)
//            {
//                paramInt1 = Math.min(100, paramInt1);
//                break;
//            }
//            paramInt1 = 100;
//            break;
//            label70:
//            if (i == Integer.MIN_VALUE) {
//                paramInt2 = Math.min(100, paramInt2);
//            } else {
//                paramInt2 = 100;
//            }
//        }
    }
}
