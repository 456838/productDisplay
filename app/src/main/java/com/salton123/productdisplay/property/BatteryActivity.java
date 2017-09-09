package com.salton123.productdisplay.property;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.battery_game_iv;
import static com.salton123.productdisplay.R.id.battery_game_touch_iv;
import static com.salton123.productdisplay.R.id.battery_go_back_iv;
import static com.salton123.productdisplay.R.id.battery_music_iv;
import static com.salton123.productdisplay.R.id.battery_music_touch_iv;
import static com.salton123.productdisplay.R.id.battery_mv_iv;
import static com.salton123.productdisplay.R.id.battery_mv_touch_iv;
import static com.salton123.productdisplay.R.id.battery_slide_menu_iv;
import static com.salton123.productdisplay.R.id.battery_tis_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.layout.activity_battery;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:53
 * ModifyTime: 20:53
 * Description:
 */
public class BatteryActivity  extends BaseActivity
        implements View.OnClickListener
{
    private int count = 0;
    private boolean flagGameLeft = true;
    private boolean flagGameRight = true;
    private boolean flagMusicLeft = true;
    private boolean flagMusicRight = true;
    private boolean flagMvLeft = true;
    private boolean flagMvRight = true;
    private int indexGame = 1;
    private int indexMusic = 1;
    private int indexMv = 1;
    private ImageView ivBack;
    private ImageView ivClose;
    private ImageView ivGame;
    private ImageView ivGameTouch;
    private ImageView ivMusic;
    private ImageView ivMusicTouch;
    private ImageView ivMv;
    private ImageView ivMvTouch;
    private ImageView ivSlide;
    private ImageView ivTis;
    private DrawerLayout mDrawerLayout;
    private ObjectAnimator oaT;

    private void initEvent()
    {
        this.ivBack.setOnClickListener(this);
        this.ivSlide.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
        this.ivMusicTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        this.ivMvTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        this.ivGameTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    private void initView()
    {
        this.ivBack = ((ImageView)findViewById(battery_go_back_iv));
        this.ivSlide = ((ImageView)findViewById(battery_slide_menu_iv));
        this.ivMusic = ((ImageView)findViewById(battery_music_iv));
        this.ivMv = ((ImageView)findViewById(battery_mv_iv));
        this.ivGame = ((ImageView)findViewById(battery_game_iv));
        this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
        this.ivClose = ((ImageView)findViewById(menu_close_iv));
        this.ivTis = ((ImageView)findViewById(battery_tis_iv));
        this.ivMusicTouch = ((ImageView)findViewById(battery_music_touch_iv));
        this.ivMvTouch = ((ImageView)findViewById(battery_mv_touch_iv));
        this.ivGameTouch = ((ImageView)findViewById(battery_game_touch_iv));
        this.oaT = ObjectAnimator.ofFloat(this.ivTis, "translationX", new float[] { 0.0F, -40.0F });
        this.oaT.setDuration(1000L);
        this.oaT.setRepeatCount(-1);
        this.oaT.start();
    }

    public void onClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {
            default:
                return;
            case battery_slide_menu_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case battery_go_back_iv:
                finish();
                return;

        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(activity_battery);
        initView();
        initEvent();
    }
}
