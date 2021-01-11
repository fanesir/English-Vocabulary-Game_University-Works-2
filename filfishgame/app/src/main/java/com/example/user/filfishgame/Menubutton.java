package com.example.user.filfishgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Menubutton extends AppCompatActivity {
    Button wordbutton, gamebutton, newdata,Errow_Button;
    private static int start_TIME = 1000;
    private static int start_TIME2 = 2000;
    private static int start_TIME3 = 3000;

    intentforint putint = new intentforint();
    MathtestActivity pputint = new MathtestActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubutton);
        wordbutton = (Button) findViewById(R.id.wordbutton);//選擇題
        gamebutton = (Button) findViewById(R.id.gamebutton);//填充題
        newdata = (Button) findViewById(R.id.wordbutton);
        Errow_Button=(Button)findViewById(R.id.Errow_Button);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        wordbutton.setVisibility(View.GONE);
        gamebutton.setVisibility(View.GONE);
        Errow_Button.setVisibility(View.GONE);
        newdata.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {//2
            @Override
            public void run() {
                gamebutton.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                gamebutton.startAnimation(animation);
            }
        }, start_TIME);

        new Handler().postDelayed(new Runnable() {//3最後的
            @Override
            public void run() {
                wordbutton.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                wordbutton.startAnimation(animation);
            }
        }, start_TIME2);

    new Handler().postDelayed(new Runnable() {//4
            @Override
            public void run() {
                Errow_Button.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                Errow_Button.startAnimation(animation);
            }
        }, start_TIME3);
    }


    public void news(View v) {
        Intent welcome = new Intent(Menubutton.this, Newsmessage.class);
        startActivity(welcome);
    }

    public void gotogame(View v) {
        putint.notgivten(0);
        putint.putchooseint(55);//隨便傳一個數字到putchooseint裡面避免程式跟選擇題搞混
        Intent game = new Intent(Menubutton.this, MainActivityGame.class);
        putint.gotscorezero(999);//當按下Menubutton的gotogamebutton會傳送999讓分數歸0
        putint.Put_C_Change_E_int(2);
        pputint.EnglishErrorword.clear();
        pputint.ChineseErrorword.clear();
        startActivity(game);
    }

    public void choosegame(View v){
        putint.notgivten(0);//輸入錯誤規0
        Intent game = new Intent(Menubutton.this, MainActivityGame.class);
        putint.gotscorezero(999);//當按下Menubutton的gotogamebutton會傳送999讓分數0
        putint.putchooseint(30);
        putint.Put_C_Change_E_int(2);
        pputint.EnglishErrorword.clear();//英文錯誤陣列清空
        pputint.ChineseErrorword.clear();//中文錯誤陣列清空
        startActivity(game);
    }
    public void C_Change_E(View v){
        putint.notgivten(0);//輸入錯誤規0
        Intent game = new Intent(Menubutton.this, MainActivityGame.class);
        putint.gotscorezero(999);//當按下Menubutton的gotogamebutton會傳送999讓分數0
        putint.putchooseint(30);
        putint.Put_C_Change_E_int(31);
        pputint.EnglishErrorword.clear();//英文錯誤陣列清空
        pputint.ChineseErrorword.clear();//中文錯誤陣列清空
        startActivity(game);
    }


    public void gotoerrow(View v){
    Intent Errow_word = new Intent(Menubutton.this, Errow_Activity.class);
    startActivity(Errow_word);
    }


}
