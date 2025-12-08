package com.activityandfragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.splash_img);
        Glide.with(SplashActivity.this).asGif().load("https://i.pinimg.com/originals/d7/b8/a1/d7b8a1ef2376e41a54c648350418bcd4.gif").placeholder(R.mipmap.ic_launcher).into(image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,DateTimeActivity2.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }
}