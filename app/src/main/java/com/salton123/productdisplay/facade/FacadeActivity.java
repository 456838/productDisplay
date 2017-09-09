package com.salton123.productdisplay.facade;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.PreviewVideoView;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.anim.facade_circle_scale;
import static com.salton123.productdisplay.R.id.facade_back_iv;
import static com.salton123.productdisplay.R.id.facade_black_rb;
import static com.salton123.productdisplay.R.id.facade_blue_rb;
import static com.salton123.productdisplay.R.id.facade_gold_rb;
import static com.salton123.productdisplay.R.id.facade_red_rb;
import static com.salton123.productdisplay.R.id.facade_rg;
import static com.salton123.productdisplay.R.id.facade_slide_iv;
import static com.salton123.productdisplay.R.id.go_back_iv;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent;
import static com.salton123.productdisplay.R.id.slide_menu_iv;
import static com.salton123.productdisplay.R.id.video_view;
import static com.salton123.productdisplay.R.mipmap.facade_back_black_bg;
import static com.salton123.productdisplay.R.mipmap.facade_back_blue_bg;
import static com.salton123.productdisplay.R.mipmap.facade_back_gold_bg;
import static com.salton123.productdisplay.R.mipmap.facade_back_red_bg;
import static com.salton123.productdisplay.R.mipmap.facade_black_bg;
import static com.salton123.productdisplay.R.mipmap.facade_blue_bg;
import static com.salton123.productdisplay.R.mipmap.facade_gold_bg;
import static com.salton123.productdisplay.R.mipmap.facade_red_bg;
import static com.salton123.productdisplay.R.mipmap.facade_slide_black_bg;
import static com.salton123.productdisplay.R.mipmap.facade_slide_blue_bg;
import static com.salton123.productdisplay.R.mipmap.facade_slide_gold_bg;
import static com.salton123.productdisplay.R.mipmap.facade_slide_red_bg;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */

@Deprecated
public class FacadeActivity extends BaseActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private int flag = 0;
    private Handler handler = new Handler();
    private int index = 1;
    private ImageView ivBack;
    private ImageView ivCloseMenu;
    private ImageView ivSlide;
    private ImageView mBack;
    private DrawerLayout mDrawerLayout;
    private ImageView mSlide;
    private PreviewVideoView mVideoView;
    private RelativeLayout rlParent;
    private RadioGroup tabGroup;

    private String getVideoPathBack1() {
        return "android.resource://" + getPackageName() + "/" + R.raw.blue_back;
    }

    private String getVideoPathBack2() {
        return "android.resource://" + getPackageName() + "/" + R.raw.black_back;
    }

    private String getVideoPathBack3() {
        return "android.resource://" + getPackageName() + "/" + R.raw.gold_back;
    }

    private String getVideoPathBack4() {
        return "android.resource://" + getPackageName() + "/" + R.raw.red_back;
    }

    private String getVideoPathGo1() {
        return "android.resource://" + getPackageName() + "/" + R.raw.blue_go;
    }

    private String getVideoPathGo2() {
        return "android.resource://" + getPackageName() + "/" + R.raw.black_go;
    }

    private String getVideoPathGo3() {
        return "android.resource://" + getPackageName() + "/" + R.raw.gold_go;
    }

    private String getVideoPathGo4() {
        return "android.resource://" + getPackageName() + "/" + R.raw.red_go;
    }

    private String getVideoPathSlideBack1() {
        return "android.resource://" + getPackageName() + "/" + R.raw.blue_slide_back;
    }

    private String getVideoPathSlideBack2() {
        return "android.resource://" + getPackageName() + "/" + R.raw.black_slide_back;
    }

    private String getVideoPathSlideBack3() {
        return "android.resource://" + getPackageName() + "/" + R.raw.gold_slide_back;
    }

    private String getVideoPathSlideBack4() {
        return "android.resource://" + getPackageName() + "/" + R.raw.red_slide_back;
    }

    private String getVideoPathSlideGo1() {
        return "android.resource://" + getPackageName() + "/" + R.raw.blue_slide_go;
    }

    private String getVideoPathSlideGo2() {
        return "android.resource://" + getPackageName() + "/" + R.raw.black_slide_go;
    }

    private String getVideoPathSlideGo3() {
        return "android.resource://" + getPackageName() + "/" + R.raw.gold_slide_go;
    }

    private String getVideoPathSlideGo4() {
        return "android.resource://" + getPackageName() + "/" + R.raw.red_slide_go;
    }

    private void initEvent() {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.tabGroup.setOnCheckedChangeListener(this);
        this.mSlide.setOnClickListener(this);
        this.mBack.setOnClickListener(this);
    }

    private void initView() {
        this.mDrawerLayout = ((DrawerLayout) findViewById(R.id.home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView) findViewById(R.id.go_back_iv));
        this.ivSlide = ((ImageView) findViewById(slide_menu_iv));
        this.ivCloseMenu = ((ImageView) findViewById(menu_close_iv));
        this.tabGroup = ((RadioGroup) findViewById(facade_rg));
        this.mSlide = ((ImageView) findViewById(facade_slide_iv));
        this.mBack = ((ImageView) findViewById(facade_back_iv));
        this.rlParent = ((RelativeLayout) findViewById(rl_parent));
        this.mVideoView = ((PreviewVideoView) findViewById(video_view));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == 3) {
                            mVideoView.setBackgroundResource(0);
                        }
                        return true;
                    }
                });
            }
        });
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer paramAnonymousMediaPlayer) {
                ScreenUtils.setTouchTime(FacadeActivity.this, System.currentTimeMillis());
                FacadeActivity.this.tabGroup.setVisibility(View.VISIBLE);
                FacadeActivity.this.ivBack.setVisibility(View.VISIBLE);
                FacadeActivity.this.ivSlide.setVisibility(View.VISIBLE);
            }
        });
        Animation localAnimation = AnimationUtils.loadAnimation(this, facade_circle_scale);
        this.mBack.startAnimation(localAnimation);
        this.mSlide.startAnimation(localAnimation);
    }

    //check
    private void setBlackBg() {
        switch (flag) {
            case 0:
                this.mVideoView.setBackgroundResource(facade_black_bg);
                return;
            case 1:
                this.mVideoView.setBackgroundResource(facade_back_black_bg);
                return;
            case 2:
                this.mVideoView.setBackgroundResource(facade_slide_black_bg);
                return;
        }
    }

    private void setBlueBg() {
        switch (this.flag) {
            case 0:
                this.mVideoView.setBackgroundResource(facade_blue_bg);
                return;
            case 1:
                this.mVideoView.setBackgroundResource(facade_back_blue_bg);
                return;
            case 2:
                this.mVideoView.setBackgroundResource(facade_slide_blue_bg);
                return;
        }

    }

    private void setGoldBg() {
        switch (this.flag) {
            case 0:
                this.mVideoView.setBackgroundResource(facade_gold_bg);
                return;
            case 1:
                this.mVideoView.setBackgroundResource(facade_back_gold_bg);
                return;
            case 2:
                this.mVideoView.setBackgroundResource(facade_slide_gold_bg);
                return;
        }

    }

    private void setRedBg() {
        switch (this.flag) {
            case 0:
                this.mVideoView.setBackgroundResource(facade_red_bg);
                return;
            case 1:
                this.mVideoView.setBackgroundResource(facade_back_red_bg);
                return;
            case 2:
                this.mVideoView.setBackgroundResource(facade_slide_red_bg);
                return;
        }

    }

    private void startVedioBack(int index) {
        this.flag = 0;
        rlParent.postDelayed(new Runnable() {
            @Override
            public void run() {
                rlParent.setVisibility(View.VISIBLE);
            }
        }, 3000L);
        switch (index) {
            case 1:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathBack1()));
                break;
            case 2:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathBack2()));
                break;
            case 3:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathBack3()));
                break;
            case 4:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathBack4()));
                break;
        }
        this.mVideoView.start();
    }

    private void startVedioSlideBack(int index) {
        this.flag = 0;
        rlParent.postDelayed(new Runnable() {
            @Override
            public void run() {
                rlParent.setVisibility(View.VISIBLE);
            }
        }, 3000L);
        switch (index) {
            case 1:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideBack1()));
                break;
            case 2:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideBack2()));
                break;
            case 3:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideBack3()));
                break;
            case 4:
                this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideBack4()));
                break;
        }
        this.mVideoView.start();
    }

    public void onBackPressed() {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (flag) {
            case 0:
                super.onBackPressed();
                break;
            case 1:
                this.tabGroup.setVisibility(View.GONE);
                this.ivBack.setVisibility(View.GONE);
                this.ivSlide.setVisibility(View.GONE);
                startVedioBack(this.index);
                break;
            case 2:
                this.tabGroup.setVisibility(View.GONE);
                this.ivBack.setVisibility(View.GONE);
                this.ivSlide.setVisibility(View.GONE);
                startVedioSlideBack(this.index);
                break;
        }
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (checkedId) {
            case facade_blue_rb:
                setBlueBg();
                index = 1;
                return;
            case facade_black_rb:
                setBlackBg();
                index = 2;
                return;
            case facade_gold_rb:
                setGoldBg();
                index = 3;
                return;
            case facade_red_rb:
                setRedBg();
                index = 4;
                return;
        }

    }

    public void onClick(View paramView) {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
//        :sswitch_data_0
//        .sparse-switch
//        0x7f0c006a -> :sswitch_2
//        0x7f0c006b -> :sswitch_0
//        0x7f0c0076 -> :sswitch_4
//        0x7f0c0077 -> :sswitch_3
//        0x7f0c00b0 -> :sswitch_1
        switch (paramView.getId()) {
            case facade_slide_iv://facade_slide_iv:I = 0x7f0c0076
                this.rlParent.setVisibility(View.GONE);
                this.tabGroup.setVisibility(View.GONE);
                this.ivBack.setVisibility(View.GONE);
                this.ivSlide.setVisibility(View.GONE);
                switch (index) {
                    case 1:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideGo1()));
                        break;
                    case 2:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideGo2()));
                        break;
                    case 3:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideGo3()));
                        break;
                    case 4:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathSlideGo4()));
                        break;
                }
                this.flag = 2;
                this.mVideoView.start();
                break;
            case slide_menu_iv:     //slide_menu_iv:I = 0x7f0c006b
                mDrawerLayout.openDrawer(5);
                break;
            case menu_close_iv:     //menu_close_iv:I = 0x7f0c00b0
                mDrawerLayout.closeDrawer(5);
                break;
            case go_back_iv:        //go_back_iv:I = 0x7f0c006a
                switch (flag) {
                    case 0:
                        finish();
                        break;
                    case 1:
                        this.tabGroup.setVisibility(View.GONE);
                        this.ivBack.setVisibility(View.GONE);
                        this.ivSlide.setVisibility(View.GONE);
                        startVedioBack(this.index);
                        break;
                    case 2:
                        this.tabGroup.setVisibility(View.GONE);
                        this.ivBack.setVisibility(View.GONE);
                        this.ivSlide.setVisibility(View.GONE);
                        startVedioSlideBack(this.index);
                        break;
                }
                break;
            case facade_back_iv:        //facade_back_iv:I = 0x7f0c0077
                this.rlParent.setVisibility(View.GONE);
                this.tabGroup.setVisibility(View.GONE);
                this.ivBack.setVisibility(View.GONE);
                this.ivSlide.setVisibility(View.GONE);
                switch (index) {
                    case 1:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathGo1()));
                        break;
                    case 2:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathGo2()));
                        break;
                    case 3:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathGo3()));
                        break;
                    case 4:
                        this.mVideoView.setVideoURI(Uri.parse(getVideoPathGo4()));
                        break;
                }

                this.flag = 1;
                this.mVideoView.start();
                break;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_facade);
        initView();
        initEvent();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mVideoView != null) {
            this.mVideoView.suspend();
        }
        this.handler.removeCallbacksAndMessages(null);
    }

    protected void onResume() {
        super.onResume();
        switch (this.index) {
            case 1:
                setBlueBg();
                return;
            case 2:
                setBlackBg();
                return;
            case 3:
                setGoldBg();
                return;
            case 4:
                setRedBg();
                return;
        }
    }
}
