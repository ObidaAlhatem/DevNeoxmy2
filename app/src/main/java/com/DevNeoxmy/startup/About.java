package com.DevNeoxmy.startup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;

public class About extends AppCompatActivity {
    ImageButton fb;
    ImageButton twiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("About");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fb = findViewById(R.id.fb);
        twiter = findViewById(R.id.twiter);

        //open team page on Facebook
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Dev.Neoxmy2"));
                startActivity(fbIntent);


            }
        });
        //open team page on Twitter

        twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twiterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Dev_Neoxmy2"));
                startActivity(twiterIntent);

            }
        });


    }
}
