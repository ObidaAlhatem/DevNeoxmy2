package com.DevNeoxmy.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeamMemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_member);

        Intent intent = getIntent();
        TeamMemberInfo developer = (TeamMemberInfo) intent.getSerializableExtra("developer");

        ((TextView)findViewById(R.id.profileName)).setText(developer.getUserName());
        ((TextView)findViewById(R.id.country)).setText(developer.getCountry());
        ((TextView)findViewById(R.id.title)).setText(developer.getTitle());
        ((TextView)findViewById(R.id.Division)).setText(developer.getDivision());
        ((ImageView)findViewById(R.id.profilePhoto)).setImageResource(getResources().getIdentifier(developer.getProfileImageUrl(), "drawable", getPackageName()));

        findViewById(R.id.facebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FACEBOOK_URL="https://www.facebook.com/Dev.Neoxmy2";
                String FACEBOOK_PAGE_ID="Dev.Neoxmy2";
                PackageManager packageManager = getPackageManager();
                try {
                    int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) { //newer versions of fb app
                        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + FACEBOOK_URL));
                        startActivity(i);
                    } else { //older versions of fb app
                        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + FACEBOOK_PAGE_ID));
                        startActivity(i);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Intent i =  new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL));
                    startActivity(i);
                }
            }
        });

        findViewById(R.id.twitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //https://twitter.com/Dev_Neoxmy2

                Intent intent;
                try{
                    // Get Twitter app
                    getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=Dev_Neoxmy2"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // If no Twitter app found, open on browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Dev_Neoxmy2"));
                }
                startActivity(intent);
            }
        });

        findViewById(R.id.skype).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });
    }




}
