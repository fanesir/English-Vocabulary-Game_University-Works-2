package com.example.user.filfishgame;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Calendar;

public class GameOverActivity extends AppCompatActivity {
    int getscoreint;
    int k;
    String s;
    ArrayList EnglishErrorword = MathtestActivity.EnglishErrorword;
    ArrayList ChineseErrorword = MathtestActivity.ChineseErrorword;
    TextView scoretextView, datatext,ChineseErrow,EnglishErrow;
    String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        scoretextView = (TextView) findViewById(R.id.scoretextView);
        datatext = (TextView) findViewById(R.id.datatext);
        EnglishErrow=(TextView)findViewById(R.id.EnglishErrow);
        ChineseErrow=(TextView)findViewById(R.id.ChineseErrow);

        Intent it = getIntent();
        Bundle bd = it.getExtras();//傳來的方法
        getscoreint = bd.getInt("putscore");//傳來的方法
        scoretextView.setText("" + getscoreint);//成績


        for( k =0;k<EnglishErrorword.size();k++){
            ChineseErrow.append(""+ChineseErrorword.get(k));
            ChineseErrow.append("\n");

            EnglishErrow.append(""+EnglishErrorword.get(k));
            EnglishErrow.append("\n");

        }


       //"" + getscoreint
        datatext.setText(mydate);
        //shareline();

    }


    public void shareline(View v){


        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain"); //文字檔類型
        shareIntent.putExtra(Intent.EXTRA_TEXT, mydate+"我的英文遊戲分數:"+getscoreint); //傳送文字
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        startActivity(Intent.createChooser(shareIntent, "請點擊Line"));
    }




    public void gobackmenu(View v) {

        Intent welcome = new Intent(GameOverActivity.this, Menubutton.class);
        startActivity(welcome);
    }

}
/*
Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setClassName(PACKAGE_NAME, CLASS_NAME);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "發訊息");
        startActivity(intent);
 */