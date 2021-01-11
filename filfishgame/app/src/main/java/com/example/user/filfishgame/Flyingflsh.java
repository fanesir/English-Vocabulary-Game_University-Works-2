package com.example.user.filfishgame;

import android.app.Activity;
import android.app.Application;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Flyingflsh extends View  {
   View view;
//    Bitmap bitmap = Bitmap.createBitmap( view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);

    Flyingflsh customview;
    private Bitmap fish[] = new Bitmap[2];
    private Bitmap backgronudImage;
    private Paint scorepaint = new Paint();
    private Bitmap life[] = new Bitmap[2];
    private int fishx = 10;
    private int fishy,scorereset=0;
    private int fishspeed;


    private int cancaswidth, canvasHeight;
    Canvas canvas;
    private int yellowX, yellowY, yellowSpeed = 15;
    private Paint yellowpaint = new Paint();
    private int aaa = 39;
    private int greenX, greenY, greenSpeed = 10;
    private Paint greenPaint = new Paint();

    private int redX, redY, redSpeed = 8;
    private Paint redPaint = new Paint();

    private static int score=0;
    private static int lifeCounterofFish=3;
    int a1 = intentforint.sum;
    int a2 = intentforint.sumaa;
    int a3 = intentforint.gamebuttonint;
    int a4 = intentforint.putchooseintforint;






    private boolean touch = false;


    public Flyingflsh(Context context) {
        super(context);
        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.fish1);//更換圖片
        fish[1] = BitmapFactory.decodeResource(getResources(), R.drawable.fish2);//更換圖片2

        backgronudImage = BitmapFactory.decodeResource(getResources(), R.drawable.backgrow);

        yellowpaint.setColor(Color.YELLOW);//設定顏色
        yellowpaint.setAntiAlias(false);//是否鋸齒

        greenPaint.setColor(Color.GREEN);//設定顏色
        greenPaint.setAntiAlias(false);//是否鋸齒

        redPaint.setColor(Color.RED);//設定顏色
        redPaint.setAntiAlias(false);//是否鋸齒

        scorepaint.setColor(Color.WHITE);//文字
        scorepaint.setTextSize(30);//文字size

        scorepaint.setTypeface(Typeface.DEFAULT_BOLD);//字體型式
        scorepaint.setAntiAlias(true);//是否鋸齒

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.life);//生命
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.life_grey);//生命不見


        Paint transparentpainthack = new Paint();
        transparentpainthack.setAlpha(100);

        //lifacounterofFiat = 0;
        fishy = 550;
        score = score + a1;//當使用者答對題目會傳送數字過來

        if(a3==999){//當按下Menubutton的gotogamebutton會傳送999
            score=0;//讓分數歸0
        }
        if (a2 == 5) {//玩家輸入錯誤會傳送數字5過來
            lifeCounterofFish--;
        }

        if(lifeCounterofFish==0){
            lifeCounterofFish=3;

            Toast.makeText(getContext(), "game_over", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(((Activity) getContext()), GameOverActivity.class);

            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bd = new Bundle();
            bd.putInt("putscore", score);
            in.putExtras(bd);


            ((Activity) getContext()).startActivity(in);

        }
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cancaswidth = canvas.getWidth();//設定背景
        canvasHeight = canvas.getHeight();//設定背景
        canvas.drawBitmap(backgronudImage, 0, 0, null);

        int minFishY = fish[0].getHeight();
        int maxFishY = canvasHeight = fish[0].getHeight() * 10;

        fishy = fishy + fishspeed;

        if (fishy < minFishY) {
            fishy = minFishY;
        }
        if (fishy > maxFishY) {
            fishy = maxFishY;
        }
        fishspeed = fishspeed + 2;

        if (touch) {

            canvas.drawBitmap(fish[1], fishx, fishy, null);
            touch = false;
        } else {
            canvas.drawBitmap(fish[0], fishx, fishy, null);
        }

//---------------------------------------------黃色圈圈範圍-------------------------------------------
        yellowX = yellowX - yellowSpeed;

        if (hitBallChecker(yellowX, yellowY)) {//吃到求加十分
            int readomWordIndex = (int) Math.floor(Math.random() * 270);//亂數
            yellowX = -100;
            scorereset++;
            a3++;
            if(a4==30){//這個30是當按下選擇題按鈕會傳送數字過來判intent到哪裏去
                int readomWordIndexx = (int) Math.floor(Math.random() * 60);
                Intent in = new Intent(((Activity) getContext()), choose_gametest_Activity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bd = new Bundle();
                bd.putInt("number", readomWordIndexx);
                in.putExtras(bd);
                ((Activity) getContext()).startActivity(in);
            }
            else {
                Intent in = new Intent(((Activity) getContext()), MathtestActivity.class);

                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bd = new Bundle();
                bd.putInt("number", readomWordIndex);
                in.putExtras(bd);


                ((Activity) getContext()).startActivity(in);
            }

        }


        if (yellowX < 0) {
            yellowX = cancaswidth + 21;//背景從-21減下去一直往左邊減下來
            yellowY = (int)
                    Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;//Math取整數值___Math.floor(Math.random()*2); //回傳0或1
        }
        canvas.drawCircle(yellowX, yellowY, 25, yellowpaint);//圓形

//---------------------------------------------綠色圈圈範圍-------------------------------------------
        greenX = greenX - greenSpeed;

        if (hitBallChecker(greenX, greenY)) {//吃到求加二十分
            greenX = -100;
            scorereset++;
            a3++;
            int readomWordIndex = (int) Math.floor(Math.random() * 145);
            //亂數
            if(a4==30){//這個30是當按下選擇題按鈕會傳送數字過來判intent到哪裏去
                int readomWordIndexx = (int) Math.floor(Math.random() * 60);
                Intent in = new Intent(((Activity) getContext()), hight_choose_gametest_Activity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bd = new Bundle();
                bd.putInt("number", readomWordIndexx);
                in.putExtras(bd);
                ((Activity) getContext()).startActivity(in);

            }

            else {
                Intent in = new Intent(((Activity) getContext()), hightmathtest.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bd = new Bundle();
                bd.putInt("number", readomWordIndex);
                in.putExtras(bd);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Activity) getContext()).startActivity(in);
            }

        }

        if (greenX < 0) {
            greenX = cancaswidth + 21;
            greenY = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;//Math取整數值___Math.floor(Math.random()*2); //回傳0或1
        }//floor 產生亂數
        canvas.drawCircle(greenX, greenY, 25, greenPaint);//圓形


//---------------------------------------------綠色圈圈範圍-------------------------------------------
//---------------------------------------------紅色圈圈範圍-------------------------------------------
        redX = redX - redSpeed;

        if (hitBallChecker(redX, redY)) {
            scorereset++;
            redX = -500;
            lifeCounterofFish--;
            a3++;
            if (lifeCounterofFish == 0) {
                lifeCounterofFish=3;
                a3++;
                Toast.makeText(getContext(), "game_over", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(((Activity) getContext()), GameOverActivity.class);

                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bd = new Bundle();
                bd.putInt("putscore", score);


                in.putExtras(bd);
                ((Activity) getContext()).startActivity(in);
            }
        }

        if (redX < 0) {
            redX = cancaswidth + 21;
            redY = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;//Math取整數值___Math.floor(Math.random()*2); //回傳0或1
        }
        canvas.drawCircle(redX, redY, 30, redPaint);//圓形
//---------------------------------------------紅色圈圈範圍-------------------------------------------
        canvas.drawText("score :" + score, 20, 60, scorepaint);
        for (int i = 0; i < 3; i++) {
            int x = (int) (150 + life[0].getWidth() * 1.5 * i);
            int y = 30;


            if (i < lifeCounterofFish) {
                canvas.drawBitmap(life[0], x, y, null);
            } else {
                canvas.drawBitmap(life[1], x, y, null);
            }

        }


        Paint p;//圖片的方式
        p = new Paint();//圖片的方式
        //Bitmap b=BitmapFactory.decodeResource(getResources(), R.drawable.test);//圖片的方式
        p.setColor(Color.RED);//圖片的方式

        //canvas.drawBitmap(b, yellowX, yellowY, p);//圖片的方式


    }

    //繪製圓
    public boolean hitBallChecker(int x, int y) {//吃到球之後反映
        if (fishx < x && x < (fishx + fish[0].getWidth()) && fishy < y && y < (fishy + fish[0].getWidth())) {


            return true;
        }

        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {//使用者按下螢幕
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch = true;
            fishspeed = -20;

        }
        return true;
    }


}
