package com.example.user.filfishgame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivityGame extends AppCompatActivity {
    private Flyingflsh gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new Flyingflsh(this);
        setContentView(gameView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        },0,Interval);
    }
}