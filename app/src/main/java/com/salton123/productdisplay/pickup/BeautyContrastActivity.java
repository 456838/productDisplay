package com.salton123.productdisplay.pickup;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.beatury_go_back_iv;
import static com.salton123.productdisplay.R.id.beatury_slide_iv;
import static com.salton123.productdisplay.R.id.contrast_bg;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.layout.activity_beauty_contrast;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_01;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_02;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_03;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_04;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_05;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_06;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_07;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_08;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_09;
import static com.salton123.productdisplay.R.mipmap.beauty_contrast_10;
import static com.salton123.productdisplay.R.mipmap.beauty_source;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */

@Deprecated
public class BeautyContrastActivity extends BaseActivity
        implements View.OnClickListener
{
    private int bgId;
    private ImageView ivBack;
    private ImageView ivBackground;
    private ImageView ivCloseMenu;
    private ImageView ivSlide;
    private DrawerLayout mDrawerLayout;

    private void initEvent()
    {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
    }

    private void initView()
    {
        this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView)findViewById(beatury_go_back_iv));
        this.ivSlide = ((ImageView)findViewById(beatury_slide_iv));
        this.ivCloseMenu = ((ImageView)findViewById(menu_close_iv));
        this.ivBackground = ((ImageView)findViewById(contrast_bg));
        switch (this.bgId)
        {

            case 0:
                this.ivBackground.setBackgroundResource(beauty_source);
                return;
            case 1:
                this.ivBackground.setBackgroundResource(beauty_contrast_01);
                return;
            case 2:
                this.ivBackground.setBackgroundResource(beauty_contrast_02);
                return;
            case 3:
                this.ivBackground.setBackgroundResource(beauty_contrast_03);
                return;
            case 4:
                this.ivBackground.setBackgroundResource(beauty_contrast_04);
                return;
            case 5:
                this.ivBackground.setBackgroundResource(beauty_contrast_05);
                return;
            case 6:
                this.ivBackground.setBackgroundResource(beauty_contrast_06);
                return;
            case 7:
                this.ivBackground.setBackgroundResource(beauty_contrast_07);
                return;
            case 8:
                this.ivBackground.setBackgroundResource(beauty_contrast_08);
                return;
            case 9:
                this.ivBackground.setBackgroundResource(beauty_contrast_09);
                return;
            case  10:
                this.ivBackground.setBackgroundResource(beauty_contrast_10);
                break;
        }

    }

    public void onClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {
            default:
                return;
            case beatury_slide_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case beatury_go_back_iv:
                finish();
                break;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(activity_beauty_contrast);
        this.bgId = getIntent().getIntExtra("bgId", 0);
        Log.e("bgId", "bgId = " + this.bgId);
        initView();
        initEvent();
    }
}
