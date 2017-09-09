package com.salton123.productdisplay.pickup;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.salton123.productdisplay.R;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.PreviewVideoView;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.pickup_take_photo_iv;
import static com.salton123.productdisplay.R.id.pickup_tisicon_iv;
import static com.salton123.productdisplay.R.id.pickup_tistext_iv;
import static com.salton123.productdisplay.R.id.video_view;
import static com.salton123.productdisplay.R.raw.pickup_focus;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:53
 * ModifyTime: 20:53
 * Description:
 */
public class FocusActivity extends BaseActivity {
    private TranslateAnimation animation;
    private ImageView ivFocus;
    private ImageView ivIcon;
    private ImageView ivText;
    private LinearLayout llcontrol;
    private PreviewVideoView mVideoView;

    private String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + pickup_focus;
    }

    private void initEvent() {
        this.ivFocus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ScreenUtils.setTouchTime(FocusActivity.this, System.currentTimeMillis());
                Intent intent = new Intent(FocusActivity.this, SampleActivity.class);
                FocusActivity.this.startActivity(intent);
                FocusActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.ivText = ((ImageView) findViewById(pickup_tistext_iv));
        this.ivIcon = ((ImageView) findViewById(pickup_tisicon_iv));
        this.ivFocus = ((ImageView) findViewById(pickup_take_photo_iv));
        this.llcontrol = ((LinearLayout) findViewById(R.id.control_show_ll));
        this.mVideoView = ((PreviewVideoView) findViewById(video_view));
        this.mVideoView.setVideoURI(Uri.parse(getVideoPath()));
        this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer paramAnonymousMediaPlayer) {
                paramAnonymousMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    public boolean onInfo(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2) {
                        if (paramAnonymous2Int1 == 3) {
                            FocusActivity.this.mVideoView.setBackgroundColor(0);
                        }
                        return true;
                    }
                });
            }
        });
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer paramAnonymousMediaPlayer) {
                FocusActivity.this.ivIcon.setVisibility(View.VISIBLE);
                FocusActivity.this.ivText.setVisibility(View.VISIBLE);

                FocusActivity.this.llcontrol.setVisibility(View.VISIBLE);
//                FocusActivity.access$402(FocusActivity.this, new TranslateAnimation(0.0F, 0.0F, 0.0F, 10.0F));
                animation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 10.0F);
                FocusActivity.this.animation.setDuration(1000L);
                FocusActivity.this.animation.setRepeatCount(-1);
                FocusActivity.this.ivIcon.startAnimation(FocusActivity.this.animation);
            }
        });
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_focus);
        initView();
        initEvent();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mVideoView != null) {
            this.mVideoView.suspend();
        }
        if (this.animation != null) {
            this.animation.cancel();
        }
    }

    protected void onResume() {
        super.onResume();
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        if (!this.mVideoView.isPlaying()) {
            this.ivIcon.setVisibility(View.GONE);
            this.ivText.setVisibility(View.GONE);
            this.llcontrol.setVisibility(View.GONE);
            this.mVideoView.start();
        }
    }

    protected void onStop() {
        super.onStop();
        this.ivText.setVisibility(View.GONE);
        this.ivIcon.setVisibility(View.GONE);
    }
}
