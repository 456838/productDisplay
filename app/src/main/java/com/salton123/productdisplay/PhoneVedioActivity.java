package com.salton123.productdisplay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.PhoneVideoView;
import com.salton123.productdisplay.utils.ScreenUtils;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:50
 * ModifyTime: 20:50
 * Description:
 */
public class PhoneVedioActivity extends BaseActivity {
    private PhoneVideoView mVideoView;

    private String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + R.raw.phone_vedio;
    }

    private void initEvent() {
        mVideoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ScreenUtils.setTouchTime(PhoneVedioActivity.this, System.currentTimeMillis());
                Intent intent = new Intent(PhoneVedioActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                return false;
            }
        });
    }

    private void initView() {
        mVideoView = (PhoneVideoView) findViewById(R.id.video_view);
        mVideoView.setVideoURI(Uri.parse(getVideoPath()));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == 3) {
                            mVideoView.setBackgroundColor(0);
                        }
                        return true;
                    }
                });
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        mVideoView.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle paramBundle) {
        getWindow().setFlags(128, 128);
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_phone_vedio);
        initView();
        initEvent();
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoView != null) {
            mVideoView.suspend();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mVideoView.isPlaying()) ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mVideoView.pause();
    }
}
