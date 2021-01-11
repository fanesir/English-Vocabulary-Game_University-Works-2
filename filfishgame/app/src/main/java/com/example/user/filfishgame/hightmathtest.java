package com.example.user.filfishgame;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class hightmathtest extends AppCompatActivity {
    TextView textView4,textViewx,yelloscore,Hight_Math_TextView;
    Button button78,Hight_Hight_Math_button_Time;
    DataBaseHelpr db2 = new DataBaseHelpr(this);
    intentforint myintent;
    int allscore,counter;
    EditText ansText;
    MathtestActivity IntoWord;
    private static int Starttime=10;
    CountDownTimer yourCountDownTimer;
    String[] readomWord = {
                             "蘋果", "生命","獅子", "車子", "貓咪","國外的","動作","下午","動物","另一"
                            ,"任何人","任何東西","公寓","看起來...出現","環繞","羽球","香蕉","烤肉","棒球","籃子"
                            ,"籃球","廁所","因為","變成","臥房","相信","生日","書店","無聊","底部"
                            ,"早餐","兄弟","商人","蝴蝶","糖果","照相機","蠟燭","小心","慶祝","雞肉"
                            ,"巧克力","聖誕節","教室","衣服","電腦","課程","堂(表)兄弟姊妹","瘋狂","危險的","困難的"
                            ,"困難","龍","餃子","大象","橡皮擦","每個人","每件事物","經驗","工廠","有名的"
                            ,"十五","手指","結束","花","垃圾","眼鏡","外公","外婆","土地","芭樂"
                            ,"漢堡","英俊的","發生","快樂的","頭痛","健康","有用","功課","醫院","然而"
                            ,"丈夫","使人感興趣","網際網路","島嶼","夾克","廚房","無尾熊","語言","律師","圖書館"
                            ,"郵差","已婚的","會議","藥","早上","山","博物館","鄰居","報紙","沒有人"
                            ,"數字","軍官","橘色柳橙","在室外","包裡","紙","父母","鉛筆","圖畫","選手"
                            ,"有可能的","練習","問題","節目","開放","問題","兔子","準備好的(r開頭)","記得","記得"
                            ,"三明治","害怕","句子","歌手","微笑","有時候(加s)","某事物","聲音","特別","湯匙"
                            ,"胃","陌生人","草莓","夏天","驚奇","一起","明天","麻煩","颱風","通常"
                            ,"天氣","窗戶","擔心","昨天","好吃"
    };
    String[] answear = {     "apple", "life", "lion", "car", "cat","aborad","action","afternoon","animal","another"
                            ,"anyone","anything","apartment","appear","around","badminton","banana","barbecue","baseball","basket"
                             ,"basketball","bathroom","becaue","become","bedroom" ,"believe","birthday","bookstore","bored","bottom"
                             ,"breakfast","brother","businessman","butterfly","candy","camera","candle","careful","celebrate","chicken"
                             ,"chocolate","christmas","classroom","clothes","computer","course","cousin","crazy","dangerous","difficult"
                            ,"difficult","dragon","dumpling","elephant","eraser","everyone","everything","experience","factory","famous"
                            ,"fifteen","finger","finish","flower","garbage","glasses","grandfather","grandmother","ground","guava"
                            ,"hamburger","handsome","happen","happy","headache","health","helpful","homework","hospital","however"
                            ,"husband","interest","internet","island","jacket","kitchen","koala","language","lawyer","library"
                            ,"mailman","married","meeting","medicine","morning","mountain","museum","neighbor","newspaper","nobody"
                            ,"number","officer","orange","outside","package","paper","parent","pencil","picture","player"
                            ,"possible","practice","problem","program","public","question","rabbit","ready","ready","reporter"
                            ,"sandwich","scared","sentence","singer","smile","sometimes","something","sound","special","spoon"
                            ,"stomach","stranger","strawberry","summer","surprise","together","tomorrow","trouble","typhoon","usually"
                            ,"weather","window","worry","yesterday","yummy"


    };//答案
    private static int WELOCOME_TIME = 500;
    private static final int REQUEST_CODE = 1;
    int n;
    ArrayList HightEnglishErrorword = MathtestActivity.EnglishErrorword;
    ArrayList HightChineseErrorword = MathtestActivity.ChineseErrorword;

    intentforint in =new intentforint();

    String s;
    //傳來的方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hightmathtest);
        //textView4 = (TextView) findViewById(R.id.textView4);
        ansText = (EditText) findViewById(R.id.higheditText);
        textViewx=(TextView)findViewById(R.id.hightextView5);
        yelloscore=(TextView)findViewById(R.id.highyelloscore);
        button78=(Button)findViewById(R.id.button78);
        Hight_Math_TextView=(TextView)findViewById(R.id.Hight_Math_TextView);
        Hight_Hight_Math_button_Time=(Button)findViewById(R.id.Hight_Math_button_Time_up);
        Hight_Hight_Math_button_Time.setVisibility(View.INVISIBLE);

        //傳來的方法

        Intent it = getIntent();
        Bundle bd = it.getExtras();//傳來的方法
        n = bd.getInt("number");
        //int readomWordIndex = (int)Math.floor(Math.random() * 13);
        //String a = readomWord[readomWordIndex];
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Run_Time_Button();
                Hight_Hight_Math_button_Time.performClick();
                textViewx.setText(""+readomWord[n]);


            }
        }, Starttime);

        textViewx.setText(""+readomWord[n]);
        button78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonanss();
            }
        });
    }



    public void buttonanss(){
        s = ansText.getText().toString();//輸入的答案

        if (s.equals(answear[n])==true) {
            Toast.makeText(hightmathtest.this, "回答正確", Toast.LENGTH_SHORT).show();
            yourCountDownTimer.cancel();
            in.givscore(20);
            in.notgivten(10);
            in.gotscorezero(30);
            //allscore=allscore+10;
            yelloscore.setText(""+in.sum);


        } else {

            yourCountDownTimer.cancel();
            Toast.makeText(hightmathtest.this, "回答錯誤_答案:"+answear[n], Toast.LENGTH_SHORT).show();
            String ErroewWore=answear[n]+"▶"+readomWord[n];
            Boolean result = db2.insertData(ErroewWore);

            HightEnglishErrorword.add(answear[n]);
            HightChineseErrorword.add(readomWord[n]);

            in.givscore(0);
            in.notgivten(5);
            in.gotscorezero(30);


        }//HightEnglishErrorword HightChineseErrorword
        //textView4.setText("傳入的數字"+answear[n]);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent scoreyellow = new Intent(hightmathtest.this, MainActivityGame.class);
                startActivity(scoreyellow);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELOCOME_TIME);





    }
    public void Run_Time_Button() {//計時器倒數20秒
        Hight_Hight_Math_button_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Run_Time_Button
                yourCountDownTimer = new CountDownTimer(20000,1000) {
                    public void onTick(long millisUntilFinished) {
                        Hight_Math_TextView.setText("倒數計時: " + millisUntilFinished / 1000+"秒");
                        counter--;
                    }

                    public void onFinish() {
                        Toast.makeText(hightmathtest.this, "回答錯誤_答案:"+answear[n], Toast.LENGTH_SHORT).show();
                        String ErroewWore=answear[n]+"▶"+readomWord[n];
                        Boolean result = db2.insertData(ErroewWore);
                        yourCountDownTimer.cancel();
                        HightEnglishErrorword.add(answear[n]);
                        HightChineseErrorword.add(readomWord[n]);

                        in.givscore(0);
                        in.notgivten(5);
                        in.gotscorezero(30);
                        Intent scoreyellow = new Intent(hightmathtest.this, MainActivityGame.class);
                        startActivity(scoreyellow);
                    }
                }.start();
            }
        });
    }

}