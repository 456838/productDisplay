package com.salton123.productdisplay.property;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.PreviewVideoView;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.go_back_iv;
import static com.salton123.productdisplay.R.id.go_quick_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent;
import static com.salton123.productdisplay.R.id.slide_menu_iv;
import static com.salton123.productdisplay.R.id.video_view;
import static com.salton123.productdisplay.R.layout.activity_slug;
import static com.salton123.productdisplay.R.raw.memoey_4g1;
import static com.salton123.productdisplay.R.raw.memoey_4g2;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */
public class SlugActivity  extends BaseActivity
        implements View.OnClickListener
{
    private ImageView ivBack;
    private ImageView ivCloseMenu;
    private ImageView ivQuick;
    private ImageView ivSlide;
    private DrawerLayout mDrawerLayout;
    private PreviewVideoView mVideoView;
    private RelativeLayout rlParent;

    private String getVideoPath()
    {
        return "android.resource://" + getPackageName() + "/" + memoey_4g1;
    }

    private String getVideoPath2()
    {
        return "android.resource://" + getPackageName() + "/" + memoey_4g2;
    }

    private void initEvent()
    {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.ivQuick.setOnClickListener(this);
    }

    private void initView()
    {
        this.mDrawerLayout = ((DrawerLayout)findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView)findViewById(go_back_iv));
        this.ivSlide = ((ImageView)findViewById(slide_menu_iv));
        this.ivCloseMenu = ((ImageView)findViewById(menu_close_iv));
        this.mVideoView = ((PreviewVideoView)findViewById(video_view));
        this.rlParent = ((RelativeLayout)findViewById(rl_parent));
        this.ivQuick = ((ImageView)findViewById(go_quick_iv));
        this.mVideoView.setVideoURI(Uri.parse(getVideoPath()));
        this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
            {
                paramAnonymousMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener()
                {
                    public boolean onInfo(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                        if (paramAnonymous2Int1 == 3) {
                            SlugActivity.this.mVideoView.setBackgroundColor(0);
                        }
                        return true;
                    }
                });
            }
        });
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
            {
                ScreenUtils.setTouchTime(SlugActivity.this, System.currentTimeMillis());
        SlugActivity.this.rlParent.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(SlugActivity.this.rlParent, "alpha", new float[] { 0.0F, 1.0F });
                objectAnimator.setDuration(400L);
                objectAnimator.setRepeatCount(0);
                objectAnimator.start();
            }
        });
    }

    public void onClick(View paramView)
    {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {
            case slide_menu_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case go_back_iv:
                finish();
                return;
            case go_quick_iv:
                this.rlParent.setVisibility(View.GONE);
                this.mVideoView.setVideoURI(Uri.parse(getVideoPath2()));
                this.mVideoView.start();
                this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
                    {
                        ScreenUtils.setTouchTime(SlugActivity.this, System.currentTimeMillis());
                        SlugActivity.this.ivQuick.setVisibility(View.GONE);
                    }
                });
                return;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(activity_slug);
        initView();
        initEvent();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (this.mVideoView != null) {
            this.mVideoView.suspend();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!this.mVideoView.isPlaying())
        {
            this.mVideoView.start();
            this.rlParent.setVisibility(View.GONE);
        }
    }
}
