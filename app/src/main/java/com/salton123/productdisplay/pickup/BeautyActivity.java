package com.salton123.productdisplay.pickup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.TextMoveLayout;
import com.salton123.productdisplay.utils.DensityUtil;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.beatury_go_back_iv;
import static com.salton123.productdisplay.R.id.beatury_slide_iv;
import static com.salton123.productdisplay.R.id.beauty_bg_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.ll_parent;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent;
import static com.salton123.productdisplay.R.id.seekbar;
import static com.salton123.productdisplay.R.id.sure_bt_iv;
import static com.salton123.productdisplay.R.id.textLayout;
import static com.salton123.productdisplay.R.layout.activity_beauty;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_00;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_01;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_02;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_03;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_04;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_05;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_06;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_07;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_08;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_09;
import static com.salton123.productdisplay.R.mipmap.beauty_pic_10;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */
@Deprecated
public class BeautyActivity extends BaseActivity
        implements View.OnClickListener
{
    private int bgId = 0;
    private Handler handler = new Handler();
    private Intent intent;
    private ImageView ivBack;
    private ImageView ivBackground;
    private ImageView ivCloseMenu;
    private ImageView ivSlide;
    private ImageView ivSure;
    private ViewGroup.LayoutParams layoutParams;
    private DrawerLayout mDrawerLayout;
    private int mLeftMargin;
    private TextPaint mPaint;
    private LinearLayout mParentView;
    private SeekBar mSeekbar;
    private TextView moveText;
    private RelativeLayout rlParent;
    private int screenWidth;
    private TextMoveLayout textMoveLayout;

    private void getChildenLayoutParams()
    {
        this.mLeftMargin = ((ViewGroup.MarginLayoutParams)this.mParentView.getChildAt(0).getLayoutParams()).leftMargin;
        this.mSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImp());
    }

    private void initEvent()
    {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.ivSure.setOnClickListener(this);
        setMoveTextView();
        getChildenLayoutParams();
        setSeekBarValues();
    }

    private void initView()
    {
        this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView)findViewById(beatury_go_back_iv));
        this.ivSlide = ((ImageView)findViewById(beatury_slide_iv));
        this.ivCloseMenu = ((ImageView)findViewById(menu_close_iv));
        this.ivSure = ((ImageView)findViewById(sure_bt_iv));
        this.ivBackground = ((ImageView)findViewById(beauty_bg_iv));
        this.rlParent = ((RelativeLayout)findViewById(rl_parent));
        this.mSeekbar = ((SeekBar)findViewById(seekbar));
        this.mParentView = ((LinearLayout)findViewById(ll_parent));
    }

    private void setMoveTextLayout()
    {
        if (this.mPaint == null) {
            this.mPaint = new TextPaint();
        }
        float f = this.mPaint.measureText(this.moveText.getText().toString().trim());
        int i = (int)(this.mSeekbar.getProgressDrawable().getBounds().width() * this.mSeekbar.getProgress() / this.mSeekbar.getMax() - f / 2.0F + DensityUtil.px2dip(this, this.mLeftMargin));
        this.moveText.layout(i, 20, this.screenWidth, 80);
        this.moveText.setText(this.mSeekbar.getProgress() + "");
        switch (this.mSeekbar.getProgress())
        {
            default:
                return;
            case 0:
                this.ivBackground.setBackgroundResource(beauty_pic_00);
                return;
            case 1:
                this.ivBackground.setBackgroundResource(beauty_pic_01);
                return;
            case 2:
                this.ivBackground.setBackgroundResource(beauty_pic_02);
                return;
            case 3:
                this.ivBackground.setBackgroundResource(beauty_pic_03);
                return;
            case 4:
                this.ivBackground.setBackgroundResource(beauty_pic_04);
                return;
            case 5:
                this.ivBackground.setBackgroundResource(beauty_pic_05);
                return;
            case 6:
                this.ivBackground.setBackgroundResource(beauty_pic_06);
                return;
            case 7:
                this.ivBackground.setBackgroundResource(beauty_pic_07);
                return;
            case 8:
                this.ivBackground.setBackgroundResource(beauty_pic_08);
                return;
            case 9:
                this.ivBackground.setBackgroundResource(beauty_pic_09);
                return;
            case 10:
                this.ivBackground.setBackgroundResource(beauty_pic_10);
                break;
        }

    }

    private void setMoveTextView()
    {
        this.moveText = new TextView(this);
        this.moveText.setText("0");
        this.moveText.setTextColor(Color.rgb(0, 161, 229));
        this.moveText.setTextSize(16.0F);
        this.layoutParams = new ViewGroup.LayoutParams(this.screenWidth, 50);
        this.textMoveLayout = ((TextMoveLayout)findViewById(textLayout));
        this.textMoveLayout.addView(this.moveText, this.layoutParams);
        this.moveText.layout(5, 20, this.screenWidth, 80);
    }

    public void onClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {
            default:
                this.handler.postDelayed(new Runnable()
                {
                    public void run()
                    {
                        BeautyActivity.this.intent.putExtra("bgId", BeautyActivity.this.bgId);
                        BeautyActivity.this.startActivity(BeautyActivity.this.intent);
                        BeautyActivity.this.finish();
                    }
                }, 1000L);
                return;
            case beatury_slide_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case beatury_go_back_iv:
                finish();
                return;
            case sure_bt_iv:
                this.rlParent.setVisibility(View.GONE);
                return;
        }


    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(activity_beauty);
        this.intent = new Intent(this, BeautyContrastActivity.class);
        this.screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        initView();
        initEvent();
    }

    protected void onResume()
    {
        super.onResume();
        this.rlParent.setVisibility(View.VISIBLE);
    }

    public void setSeekBarValues()
    {
        this.mSeekbar.setEnabled(true);
        this.mSeekbar.setMax(10);
        this.mSeekbar.setProgress(0);
    }

    private class OnSeekBarChangeListenerImp
            implements SeekBar.OnSeekBarChangeListener
    {
        private OnSeekBarChangeListenerImp() {

        }

        public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
        {
            BeautyActivity.this.setMoveTextLayout();
            ScreenUtils.setTouchTime(BeautyActivity.this, System.currentTimeMillis());
        }

        public void onStartTrackingTouch(SeekBar paramSeekBar) {}

        public void onStopTrackingTouch(SeekBar paramSeekBar)
        {
            bgId =paramSeekBar.getProgress();
//            BeautyActivity.access$202(BeautyActivity.this, paramSeekBar.getProgress());
//            ScreenUtils.setTouchTime(BeautyActivity.this, System.currentTimeMillis());
        }
    }
}
