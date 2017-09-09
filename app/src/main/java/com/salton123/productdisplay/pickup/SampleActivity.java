package com.salton123.productdisplay.pickup;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.go_back_iv;
import static com.salton123.productdisplay.R.id.go_contrast_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.home_slide_right_iv;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:53
 * ModifyTime: 20:53
 * Description:
 */
public class SampleActivity  extends BaseActivity
        implements View.OnClickListener
{
    private Handler handler = new Handler();
    private ImageView ivBack;
    private ImageView ivCloseMenu;
    private ImageView ivContrast;
    private ImageView ivSlide;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout rlParent;

    private void initEvent()
    {
        this.ivBack.setOnClickListener(this);
        this.ivSlide.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.ivContrast.setOnClickListener(this);
    }

    private void initView()
    {
        this.ivBack = ((ImageView)findViewById(go_back_iv));
        this.ivSlide = ((ImageView)findViewById(home_slide_right_iv));
        this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivCloseMenu = ((ImageView)findViewById(menu_close_iv));
        this.ivContrast = ((ImageView)findViewById(go_contrast_iv));
        this.rlParent = ((RelativeLayout)findViewById(rl_parent));
        this.handler.postDelayed(new Runnable()
        {
            public void run()
            {
//                setVisibility(8) -> setVisibility(View.GONE)
//                setVisibility(0) -> setVisibility(View.VISIBLE)
                SampleActivity.this.rlParent.setVisibility(View.VISIBLE);
                ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(SampleActivity.this.rlParent, "alpha", new float[] { 0.0F, 1.0F });
                localObjectAnimator.setDuration(400L);
                localObjectAnimator.setRepeatCount(0);
                localObjectAnimator.start();
            }
        }, 1000L);
    }

    public void onClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {

            case home_slide_right_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case go_back_iv:
                finish();
                return;
            case go_contrast_iv:
                startActivity(new Intent(this, ContrastActivity.class));
                finish();
                break;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_sample);
        initView();
        initEvent();
    }
}
