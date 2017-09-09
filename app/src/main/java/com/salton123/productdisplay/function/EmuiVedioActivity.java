package com.salton123.productdisplay.function;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.PhoneVideoView;
import com.salton123.productdisplay.utils.ScreenUtils;

import java.util.Timer;
import java.util.TimerTask;

import static com.salton123.productdisplay.R.id.go_back_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.rl_parent;
import static com.salton123.productdisplay.R.id.slide_menu_iv;
import static com.salton123.productdisplay.R.id.video_view;
import static com.salton123.productdisplay.R.layout.activity_emui_vedio;
import static com.salton123.productdisplay.R.raw.clone_mode;
import static com.salton123.productdisplay.R.raw.eye_mode;
import static com.salton123.productdisplay.R.raw.screenshot_mode;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */
@Deprecated
public class EmuiVedioActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView ivBack;
    private ImageView ivCloseMenu;
    private ImageView ivSlide;
    private DrawerLayout mDrawerLayout;
    private PhoneVideoView mVideoView;
    private RelativeLayout rlParent;
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        public void run() {
            ScreenUtils.setTouchTime(EmuiVedioActivity.this.getApplicationContext(), System.currentTimeMillis());
        }
    };

    private  Uri currentURI ;

    private String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + R.raw.student_mode;
    }

    private String getVideoPath2() {
        return "android.resource://" + getPackageName() + "/" + R.raw.pay_mode;
    }

    private String getVideoPath3() {
        return "android.resource://" + getPackageName() + "/" + R.raw.eye_mode;
    }

    private String getVideoPath4() {
        return "android.resource://" + getPackageName() + "/" + R.raw.clone_mode;
    }

    private String getVideoPath5() {
        return "android.resource://" + getPackageName() + "/" + screenshot_mode;
    }

    private void initEvent() {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
    }

    private void initView() {
        this.mDrawerLayout = ((DrawerLayout) findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView) findViewById(go_back_iv));
        this.ivSlide = ((ImageView) findViewById(slide_menu_iv));
        this.ivCloseMenu = ((ImageView) findViewById(menu_close_iv));
        this.rlParent = ((RelativeLayout) findViewById(rl_parent));
        this.mVideoView = ((PhoneVideoView) findViewById(video_view));
        this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer paramAnonymousMediaPlayer) {
                paramAnonymousMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    public boolean onInfo(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2) {
                        if (paramAnonymous2Int1 == 3) {
                            EmuiVedioActivity.this.mVideoView.setBackgroundColor(0);
                        }
                        return true;
                    }
                });
            }
        });
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer paramAnonymousMediaPlayer) {
                ScreenUtils.setTouchTime(EmuiVedioActivity.this, System.currentTimeMillis());
            }
        });

        switch (getIntent().getIntExtra("mode", 1)) {
            case 1:
                currentURI = Uri.parse(getVideoPath());
                break;
            case 2:
                currentURI = Uri.parse(getVideoPath2());
                break;
            case 3:
                currentURI = Uri.parse(getVideoPath3());
                break;
            case 4:
                currentURI = Uri.parse(getVideoPath4());
                break;
            case 5:
                currentURI = Uri.parse(getVideoPath5());
                break;
        }
        Log.e("aa","currentURI="+currentURI.getPath());
        this.mVideoView.setVideoURI(currentURI);
    }

    public void onClick(View paramView) {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId()) {
            default:
                finish();
                return;
            case slide_menu_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
        }

    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(activity_emui_vedio);
        initView();
        initEvent();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mVideoView != null) {
            this.mVideoView.suspend();
        }
        if (this.timerTask != null) {
            this.timerTask.cancel();
        }
        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    protected void onResume() {
        super.onResume();
        if (!this.mVideoView.isPlaying()) {
            this.mVideoView.start();
        }
    }
}