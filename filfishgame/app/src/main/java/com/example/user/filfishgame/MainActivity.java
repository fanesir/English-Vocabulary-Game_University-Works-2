package com.example.user.filfishgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView startimageView;
    private static int WELOCOME_TIME = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startimageView= (ImageView) findViewById(R.id.startimageView);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        startimageView.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(MainActivity.this, Menubutton.class);
                startActivity(welcome);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELOCOME_TIME);


    }
}
