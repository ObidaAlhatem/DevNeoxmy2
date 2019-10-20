package com.DevNeoxmy.startup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;

public class OurServicesActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerFragment playerFragment;
    private YouTubePlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_services);

        playerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment);
        playerFragment.initialize(getString(R.string.youtubeAPIKey), this);

        ///////////////////////////////////////////////////////////////////////////
        final Button design= (Button)findViewById(R.id.design);
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(OurServicesActivity.this, DesignPicsActivity.class);
                startActivity(intent);
            }
        });

        final Button programming= (Button)findViewById(R.id.programming);
        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(OurServicesActivity.this, DevelopingAppsActivity.class);
                startActivity(intent);
            }
        });

        final Button videos= (Button)findViewById(R.id.videos);
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServicesActivity.this, VideosActivity.class);
                startActivity(intent);
            }
        });

        final Button money= (Button)findViewById(R.id.money);
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(OurServicesActivity.this, ProfitStrategiesActivity.class);
                startActivity(intent);
            }
        });
        final Button others= (Button)findViewById(R.id.others);
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(OurServicesActivity.this, OtherServicesActivity.class);
                startActivity(intent);
            }
        });
        final Button askforservice= (Button)findViewById(R.id.askforservice);
        askforservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(OurServicesActivity.this, askforserviceActivity.class);
                //startActivity(intent);
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        mPlayer = youTubePlayer;

        //Enables automatic control of orientation
        mPlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //Show full screen in landscape mode always
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

        //System controls will appear automatically
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if (!b) {
            mPlayer.loadVideo(getString(R.string.youtubeVideo_id));
        }
        else
        {
            mPlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        mPlayer = null;
    }

}
