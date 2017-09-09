package com.salton123.productdisplay.other.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.facade.FacadeActivity;
import com.salton123.productdisplay.function.EmuiActivity;
import com.salton123.productdisplay.pickup.BeautyActivity;
import com.salton123.productdisplay.pickup.CateActivity;
import com.salton123.productdisplay.pickup.FocusActivity;
import com.salton123.productdisplay.property.BatteryActivity;
import com.salton123.productdisplay.utils.ScreenUtils;


/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 21:31
 * ModifyTime: 21:31
 * Description:
 */
public class BaseActivity extends AppCompatActivity {

//    public void hideBottomUIMenu() {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB && Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            getWindow().getDecorView().setSystemUiVisibility(View.GONE);
//        }else{
//            getWindow().getDecorView().setSystemUiVisibility(View.VISIBLE);
//        }
//    }

    /**
     * 隐藏虚拟按键，并且设置成全屏
     */
    protected void hideBottomUIMenu(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB && Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
            decorView.setSystemUiVisibility(uiOptions);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
    }

    protected void onCreate(@Nullable Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        hideBottomUIMenu();
    }

    public void onMenuItemClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {
            case R.id.menu_stop_ll:
            case R.id.menu_close_iv:
            default:
                return;
            case R.id.slide_menu1:
                startActivity(new Intent(this, FacadeActivity.class));
                return;
            case R.id.slide_menu2:
                startActivity(new Intent(this, BeautyActivity.class));
                return;
            case R.id.slide_menu3:
                startActivity(new Intent(this, CateActivity.class));
                return;
            case R.id.slide_menu4:
                startActivity(new Intent(this, FocusActivity.class));
                return;
            case R.id.slide_menu5:
                startActivity(new Intent(this, EmuiActivity.class));
                return;
            case R.id.slide_menu6:
                startActivity(new Intent(this, BatteryActivity.class));
                return;
        }
//        startActivity(new Intent(this, SlugActivity.class));
    }

    protected void onRestart()
    {
        super.onRestart();
        hideBottomUIMenu();
    }

    protected void onResume()
    {
        super.onResume();
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
    }

//    public void startActivityWithTransition(View paramView, Class<?> paramClass)
//    {
//        int[] arrayOfInt = new int[2];
//        paramView.getLocationOnScreen(arrayOfInt);
//        arrayOfInt[0] += paramView.getWidth() / 2;
//        arrayOfInt[1] += paramView.getHeight() / 2;
//        paramView = new Intent(this, paramClass);
//        paramView.putExtra("EXTRA_TRANSITION_POINT", arrayOfInt);
//        mStartActivity(paramView);
//        startActivity(paramView);
//    }


}
