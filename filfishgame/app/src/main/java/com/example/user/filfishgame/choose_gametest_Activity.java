package com.example.user.filfishgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.ArrayList;

public class choose_gametest_Activity extends AppCompatActivity {
    Button Time_Up_Button;
    RadioButton rb1, rb2, rb3,rb4;
    RadioGroup RGP;
    public int counter;
    DataBaseHelpr db = new DataBaseHelpr(this);
    TextView textView,textView2,Time_Text;
    int i, nextnumber,n = 0;
    int C_Change_E_int1 = intentforint.C_Change_E_int;
    int PUT = intentforint.putchooseintforint;
    String answer;
    intentforint in =new intentforint();
    ArrayList HightEnglishErrorword = MathtestActivity.EnglishErrorword;
    ArrayList HightChineseErrorword = MathtestActivity.ChineseErrorword;
    private static int Starttime=10;
    public volatile boolean exit = false;
    Handler handler;//退出函數
    CountDownTimer yourCountDownTimer;

    private String list2[] = {
                                "能夠:有能力的", "關於", "演員", "以後", "再一次","再一次","年齡","同意","空氣","全部:所有"
                                ,"天","死的","決定","書桌","死去","挖","骯髒的","盤子","狗","門"
                                ,"結束","享受","進入","橡皮擦","理由","眼睛","臉","失敗or不及格","風扇","快速的"
                                ,"遲到","懶惰","學習","左邊","檸檬","信件","生命","喜歡","線","獅子"
                                ,"機器人","房間","跑","悲傷的","安全的","沙拉","存","說","看","分享"
                                ,"非常","影片","聲音","起來","想要","週","寫","年","你","動物園"};//題目
    private String answerlist[]={
                                "able", "about", "actor", "after", "again","again","age","agree","air","all"
                                ,"day","dead","decide","desk","die","dig","dirty","dish","dog","door"
                                ,"end","enjoy","enter","eraser","reason","eye","face","fail","fan","fast"
                                ,"last","lazy","learn","left","lemon","letter","life","like","line","lion"
                                ,"robot","room","run","sad","safe","salad","save","say","see","share"
                                ,"very","video","voice","wake","want","week","write","year","you","zoo"
                                };
    private String list[] =  {"b", "a", "c","d","c","a","a","b","c","b"
                             ,"d","d","a","c","b","c","a","b","c","d"
                             ,"d","b","c","a","c","b","a","b","c","c"
                             ,"c","b","a","b","c","c","c","a","b","c"
                             ,"a","c","b","a","a","b","c","a","c","b"
                             ,"d","b","d","a","d","a","b","a","d","b"};//正確答案

    private String A_ans[] = {"不能夠", "關於", "前天", "很久之前","兩次","再一次","安寧","不同意","汽油","不全部"
                             ,"前天","活","決定","椅子","活者","洞","骯髒的","旋轉","貓","金門"
                             ,"還沒結束","之前","出口","橡皮擦","藉口","鼻子","臉","不失敗","粉絲","龜速的"
                             ,"早到","勤勞","學習","上面","注意聽","信封","油水","喜歡","條","狐狸"
                             ,"機器人","客廳","慢跑","悲傷的","安全的","醬油","退","說","盲","募款"
                             ,"極端","電影","小聲","起來","不想","週","畫","年","他","花園"};

    private String B_ans[] = {"能夠:有能力的","不相關", "幾天前", "之後","六次","拒絕","拒絕","同意","二氧化碳","全部:所有"
                             ,"幾天前","生病","考慮","電燈","死去","擰","乾淨的","盤子","狼","窗"
                             ,"開頭","享受","出水","筆","很難","眼睛","腳","失敗or不及格","窗","速度"
                             ,"提早","懶惰","清潔","左邊","橘子","郵票","想法","討厭","線","海豚"
                             ,"機械","廚房","跑","興奮","危險","沙拉","刪除","閉嘴","海洋","分享"
                            ,"小力","影片","狗叫聲","躺","對","月","寫","你","我","動物園"};

    private String C_ans[] = {"無法", "這個", "演員", "好久以前","再一次","第二次","回絕","回絕","空氣","一點點"
                             ,"小時","感冒","思考","書桌","在世","挖","黏黏","玻璃杯","狗","玻璃"
                             ,"倒數","不舒服","進入","鉛筆盒","理由","耳朵","成功","成功","風扇","快速的"
                             ,"遲到","睡覺","怠惰","下面","檸檬","信件","生命","超級討厭","袋子","獅子"
                             ,"機車","房間","飛","快樂的","危機","沙茶","存","聽","看","享福"
                             ,"大力","光電","音樂","飛起來","不想要","時","圖","月","它","海洋"};

    private String D_ans[] = {"無力", "關係","快速", "以後","在兩次","進去","體重","拒絕","空汙","好多"
                              ,"天","死的","書桌","理由","快樂的","音樂","圖","飛起來","成功","門"
                              ,"結束","光電","思考","在世","信件","遲到","理由","郵票","分享","橘子"
                              ,"機車","花園","還沒結束","悲傷的","刪除","狗叫聲","黏黏","怠惰","安全的","機器人"
                              ,"信封","光電","飛起來","不舒服","沙茶","生命","六次","興奮","懶惰","線"
                              ,"非常","下面","聲音","光電","想要","時","不想要","橘子","你","園"};




    private String Eng_A_ans[] = {"accle", "about", "anster", "after","asing","again","age","asree","axo","ass"
            ,"day","dase","decide","dbek","dxe","dsg","dirty","dsih","dbg","door"
            ,"end","ensjor","etner","eraser","ressad","ese","face","faiia","fbn","fceet"
            ,"vast","lacy","learn","seft","leson","letter","sife","like","lenien","lsoon"
            ,"robot","rerm","rsn","sad","safe","saffe","sevvn","say","sge","shree"
            ,"vrey","viedo","voceie","wake","awwmt","week","wtire","year","ycu","zao"};

    private String Eng_B_ans[] = {"able","aboct", "acator", "asfter","asain","asing","aga","agree","asr","all"
            ,"das","dead","desidx","dsek","die","ddg","dyiry","dish","dsg","dosr"
            ,"eed","enjoy","enser","erasrr","reaoss","eye","fase","fail","favn","fsat"
            ,"lsat","lazy","clearn","left","lenom","ltteer","lide","link","line","lison"
            ,"rabot","rasm","run","sand","seaf","salad","seva","sgy","sen","share"
            ,"vssery","video","voiec","wkae","wsant","wbbk","write","yaer","yau","zoo"};

    private String Eng_C_ans[] = {"bbalc", "acoct", "actor", "befort","again","asing","asa","axgree","air","ass"
            ,"dat","dast","decisse","desk","dce","dig","dsrny","dlash","dog","dassr"
            ,"esd","esjoy","enter","ersear","reason","ebe","fasse","facxil","fan","fast"
            ,"last","lasty","lesean","cceft","lemon","lestter","life","lck","lnie","lion"
            ,"rabbout","room","ruun","sgend","seffe","salaad","save","szy","see","sarhe"
            ,"very","vedio","voice","wklane","want","wcck","wrtie","yecr","you","zco"};

    private String Eng_D_ans[] = {"bsalc", "acasct", "fsctor", "after","aganin","gaing","asea","axgers","aer","abss"
            ,"day","dead","debccisse","degk","dace","dijg","dssrny","adlash","dong","door"
            ,"end","esjoys","eanter","exrsear","rceason","cebe","fasseg","facxill","fans","fastone"
            ,"lasta","lastys","leseanx","cceftc","lemvon","lesttera","lifey","lcdk","lnige","liodn"
            ,"rabboutd","xroom","ruund","hgend","seaffe","salaasd","saveme","szys","seeag","sarhes"
            ,"very","veio","voice","wlane","want","weacck","Ortie","yescr","you","zcoc"};






    private static int WELOCOME_TIME = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gametest_);
        handler = new Handler();
        RGP = (RadioGroup) findViewById(R.id.RGP);
        textView = (TextView) findViewById(R.id.textView);
        Time_Text =(TextView)findViewById(R.id.textView2);
        Time_Up_Button=(Button)findViewById(R.id.Time_Up_Button);
        Time_Up_Button.setVisibility(View.INVISIBLE);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        Atuo_Run_Time();

        Intent it = getIntent();
        Bundle bd = it.getExtras();//傳來的方法
        n = bd.getInt("number");



        RGP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        answer = "a";
                        break;

                    case R.id.rb2:
                        answer = "b";
                        break;

                    case R.id.rb3:
                        answer = "c";
                        break;

                    case R.id.rb4:
                        answer = "d";
                        break;


                }

            }


        });

        new Handler().postDelayed(new Runnable() {//點進來之後馬上顯示單字
            @Override
            public void run() {
                Run_Time_Button();

                Time_Up_Button.performClick();
                if(C_Change_E_int1==31){
                    textView.setText(list2[n]);
                    rb1.setText(Eng_A_ans[n]);
                    rb2.setText(Eng_B_ans[n]);
                    rb3.setText(Eng_C_ans[n]);
                    rb4.setText(Eng_D_ans[n]);
                }

                else if(PUT==30) {
                    textView.setText(answerlist[n]);
                    rb1.setText(A_ans[n]);
                    rb2.setText(B_ans[n]);
                    rb3.setText(C_ans[n]);
                    rb4.setText(D_ans[n]);
                }


            }


        }, Starttime);






        /*
 final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Run_Time_Button();

                Time_Up_Button.performClick();
                if(C_Change_E_int1==31){
                    textView.setText(list2[n]);
                    rb1.setText(Eng_A_ans[n]);
                    rb2.setText(Eng_B_ans[n]);
                    rb3.setText(Eng_C_ans[n]);
                    rb4.setText(Eng_D_ans[n]);
                }

                else if(PUT==30) {
                    textView.setText(answerlist[n]);
                    rb1.setText(A_ans[n]);
                    rb2.setText(B_ans[n]);
                    rb3.setText(C_ans[n]);
                    rb4.setText(D_ans[n]);
                }
            handler.postDelayed(this, 1000);
        }
    };
 */
    }
    public void yes_or_no_button(View v){
        if (answer == list[n]) {
            Toast toast9 = Toast.makeText(choose_gametest_Activity.this,
                    "正確答案", Toast.LENGTH_LONG);
            toast9.show();
            in.givscore(10);
            in.notgivten(10);
            in.gotscorezero(30);
            yourCountDownTimer.cancel();
            RGP.clearCheck();
        }
        else
        {
            Toast toast9 = Toast.makeText(choose_gametest_Activity.this,
                    "錯誤 答案是:"+answerlist[n]+"_"+list2[n]+"_"+list[n], Toast.LENGTH_LONG);
            toast9.show();
            HightEnglishErrorword.add(answerlist[n]);
            HightChineseErrorword.add(list2[n]);
            String ErroewWore=answerlist[n]+"▶"+list2[n];
            Boolean result = db.insertData(ErroewWore);
            yourCountDownTimer .cancel();
            in.givscore(0);
            in.notgivten(5);
            in.gotscorezero(30);
            RGP.clearCheck();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent scoreyellow = new Intent(choose_gametest_Activity.this, MainActivityGame.class);



                startActivity(scoreyellow);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELOCOME_TIME);


    }


   public void Run_Time_Button() {//計時器倒數十秒

        Time_Up_Button.setOnClickListener(new View.OnClickListener()

           {
               @Override
               public void onClick (View v){//Run_Time_Button
                    yourCountDownTimer = new CountDownTimer(10000, 1000) {
                   public void onTick(long millisUntilFinished) {
                       Time_Text.setText("倒數計時: " + millisUntilFinished / 1000 + "秒");
                       counter--;
                   }

                   public void onFinish() {

                       Toast toast10 = Toast.makeText(choose_gametest_Activity.this,
                               "時間到!!", Toast.LENGTH_LONG);
                       Toast toast9 = Toast.makeText(choose_gametest_Activity.this,
                               "錯誤 答案是:" + answerlist[n] + "_" + list2[n] + "_" + list[n], Toast.LENGTH_LONG);
                       toast9.show();
                       toast10.show();
                       HightEnglishErrorword.add(answerlist[n]);
                       HightChineseErrorword.add(list2[n]);
                       String ErroewWore = answerlist[n] + "▶" + list2[n];
                       Boolean result = db.insertData(ErroewWore);

                       in.givscore(0);
                       in.notgivten(5);
                       in.gotscorezero(30);
                       RGP.clearCheck();
                       Intent scoreyellow = new Intent(choose_gametest_Activity.this, MainActivityGame.class);
                       startActivity(scoreyellow);
                        Run_Stop_Time();


                   }
               }.start();

           }
           });
       }



public void Run_Stop_Time(){
    yourCountDownTimer .cancel();
}

    public void Atuo_Run_Time(){//自動按下計時器
    Time_Up_Button.setPressed(true);
    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            Time_Up_Button.setPressed(false);
        }
    }, 50);
}

    interface Surfacing {
        double area();        // 計算面積的方法
        double PI = 3.14159;  // 定義常數
    }




    }






