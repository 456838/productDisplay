package com.salton123.productdisplay.pickup;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.go_back_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.home_slide_right_iv;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent_bg;
import static com.salton123.productdisplay.R.mipmap.cate_contrast_bg;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:53
 * ModifyTime: 20:53
 * Description:
 */

@Deprecated
public class ContrastActivity extends BaseActivity
{
  private RelativeLayout bgParent;
  private ImageView ivBack;
  private ImageView ivClose;
  private ImageView ivSlide;
  private DrawerLayout mDrawerLayout;
  
  private void initEvent()
  {
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ContrastActivity.this.finish();
      }
    });
    this.ivSlide.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ScreenUtils.setTouchTime(ContrastActivity.this, System.currentTimeMillis());
        ContrastActivity.this.mDrawerLayout.openDrawer(5);
      }
    });
    this.ivClose.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ScreenUtils.setTouchTime(ContrastActivity.this, System.currentTimeMillis());
        ContrastActivity.this.mDrawerLayout.closeDrawer(5);
      }
    });
  }
  
  private void initView()
  {
    this.ivBack = ((ImageView)findViewById(go_back_iv));
    this.ivSlide = ((ImageView)findViewById(home_slide_right_iv));
    this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
    this.mDrawerLayout.setDrawerLockMode(1);
    this.ivClose = ((ImageView)findViewById(menu_close_iv));
    this.bgParent = ((RelativeLayout)findViewById(rl_parent_bg));
    if (getIntent().getBooleanExtra("flagCate", false)) {
      this.bgParent.setBackgroundResource(cate_contrast_bg);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_contrast);
    initView();
    initEvent();
  }
}