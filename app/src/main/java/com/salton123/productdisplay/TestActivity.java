package com.salton123.productdisplay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.salton123.productdisplay.other.widget.PhoneVideoView;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */
public class TestActivity   extends AppCompatActivity
{
    private PhoneVideoView mVideoView;

    private String getVideoPath()
    {
        return "android.resource://" + getPackageName() + "/" + 2131099660;
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968629);
        this.mVideoView = ((PhoneVideoView)findViewById(2131492969));
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
                            TestActivity.this.mVideoView.setBackgroundColor(0);
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
                paramAnonymousMediaPlayer.start();
            }
        });
        this.mVideoView.start();
    }
}
