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

public class MathtestActivity extends AppCompatActivity {
    DataBaseHelpr db = new DataBaseHelpr(this);
    TextView textView4,textViewx,yelloscore;
    intentforint myintent;
    Button Math_button_Time_up2;
    TextView Math_TextView;
    int allscore,counter;
    EditText ansText;
    int ii=6;
    private static int Starttime=10;
   static ArrayList<String>  EnglishErrorword = new ArrayList<>();
    static ArrayList<String>  ChineseErrorword = new ArrayList<>();
    CountDownTimer yourCountDownTimer;

    String[] readomWord = {
            "能力", "關於", "演員", "以後", "再一次","再一次","年齡","同意","空氣","全部"
            ,"已經","也","總是","和","生氣","螞蟻","任何","蘋果","上臂","問:邀請",
            "遠離","寶貝","後面","袋子","麵包店","球","樂團","銀行","蝙蝠","海灘"
            ,"豆子","熊","床","蜜蜂","牛肉","在...之前","鐘","帶子","長椅","大的"
            ,"鳥","咬","黑色","吹","藍色","小船","身體","煮","書本","無聊",
            "老闆","箱子","男孩","麵包","小昆蟲","公車","奶油","買","籠子","蛋糕",
            "露營","能夠","帽子","汽車","卡片","關心","拿","貓","捕抓","椅子"
            ,"改變","便宜","欺騙","檢查","城市","課:班級","清潔","時鐘","關上","日期"
            ,"天","死的","決定","桌子","死去","挖","骯髒的","盤子","狗","門"
            ,"往下","開車","司機","鴨子","每一","耳朵","早","吃","蛋","其他"
            ,"結束","享受","進入","橡皮擦","理由","眼睛","臉","失敗","風扇","快速的"
            ,"感覺","打架","填滿","地板","飛行","忘記","狐狸","自由免費","青蛙","水果"
            ,"好笑的","未來","遊戲","瓦斯","得到","女孩","給","好的","很好的","綠色"
            ,"健身房","頭髮","火腿","高興","有","哈囉","幫忙","這裡","嗨","打"
            ,"熱的","旅館","如何","趕快","點子","如果","進入.....裡","牛仔褲","工作","加入"
            ,"跳","只是","保持","鑰匙","殺死","親吻","風箏","無尾熊","土地","最後的"
            ,"遲到","懶惰","學習","左邊","檸檬","信件","生命","喜歡","直線","獅子"
            ,"生活","喜愛","幸運","郵件","很多的","地圖","數學","也許可能","菜單","牛奶"
            ,"錯過","金錢","拖把","更多的","移動","電影","音樂","名字","自然","需要"
            ,"新的","好的","晚上","沒有人","鼻子","護士","辦公室","老的","唯一","打開"
            ,"其他的","包裏","公園","派對","付錢","豬","披薩","計畫","玩","池塘"
            ,"鍋子","力量","推","安靜","小考","收音機","下雨","紅色","米","有錢的"
            ,"機器人","房間","跑","悲傷的","安全的","沙拉","存","說","看","分享"
            ,"形狀","購物","測","坐","尺寸","天空","煙霧","歌曲","抱歉","湯"
            ,"星星","停留","糖","太陽","游泳","計程車","茶","隊伍","十","他們"
            ,"這個","老虎","時間","工具","碰觸","玩具","旅遊","試試","向上","使用"
            ,"非常","影片","聲音","起來","想要","週","寫","年","你","動物園"
    };
    String[] answear =    {
            "able", "about", "actor", "after", "again","again","age","agree","air","all",
            "already","also","aways","and","angry","ant","any","apple","arm","ask"
            ,"away","baby","back","bag","bakery","ball","band","bank","bat","beach"
            ,"bean","bear","bed","bee","beef","before","bell","belt","bench", "big",
            "bird","bite","black","blow","blue","boat","body","boil","book","boring"
            ,"boss","box","boy","bread","bug","bus","butter","buy","cage","cake"
            ,"camp","can","cap","car","card","care","carry","cat","catch","chair"
            ,"change","cheap","cheat","check","city","class","clean","clock","close","date"
            ,"day","dead","decide","desk","die","dig","dirty","dish","dog","door"
            ,"down","drive","driver","duck","each","ear","early","eat","egg","else"
            ,"end","enjoy","enter","even","excuse","eye","face","fail","fan","fast"
            ,"feel","fight","fill","floor","fly","forget","fox","free","frog","fruit"
            ,"funny","future","game","gas","get","girl","give","good","great","green"
            ,"gym","hair","ham","happy","have","hello","help","here","hi","hit"
            ,"hot","hotel","how","hurry","idea","if","into","jeans","job","join"
            ,"jump","just","keep","key","kill","kiss","kite","koala","land","last"
            ,"last","lazy","learn","left","lemon","letter","life","like","line","lion"
            ,"live","love","lucky","mail","many","map","math","maybe","menu","milk"
            ,"miss","money","mop","more","move","movie","music","name","nature","need"
            ,"new","nice","night","nobody","nose","nurse","office","old","only","open"
            ,"other","package","park","party","pay","pig","pizza","plan","play","pond"
            ,"pot","power","push","quiet","quiz","radio","rain","red","rice","rich"
            ,"robot","room","run","sad","safe","salad","save","say","see","share"
            ,"shape","shop","side","sit","size","sky","smoke","song","sorry","soup"
            ,"star","stay","sugar","sun","swim","taxi","tea","team","ten","they"
            ,"this","tiger","time","tool","touch","toy","trip","try","up","use"
            ,"very","video","voice","wake","want","week","write","year","you","zoo"//270個
    };//答案
    private static int WELOCOME_TIME = 500;
    private static final int REQUEST_CODE = 1;
    int n;
    intentforint in =new intentforint();

    String s;
    //傳來的方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);
        //textView4 = (TextView) findViewById(R.id.textView4);

        db=new DataBaseHelpr(this);
        ansText = (EditText) findViewById(R.id.editText);
        textViewx=(TextView)findViewById(R.id.textView5);
        yelloscore=(TextView)findViewById(R.id.yelloscore);

        Math_TextView=(TextView)findViewById(R.id.Math_TextView);
        Math_button_Time_up2=(Button)findViewById(R.id.Math_button_Time_up);
        Math_button_Time_up2.setVisibility(View.INVISIBLE);

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
                Math_button_Time_up2.performClick();
                textViewx.setText(""+readomWord[n]);


            }
        }, Starttime);





    }

    public void buttonans(View v ){
        s = ansText.getText().toString();//輸入的答案

        if (s.equals(answear[n])==true) {
            Toast.makeText(MathtestActivity.this, "回答正確", Toast.LENGTH_SHORT).show();

            in.givscore(10);
            in.notgivten(10);
            in.gotscorezero(30);
            //allscore=allscore+10;
           yourCountDownTimer.cancel();//清除時間
            yelloscore.setText(""+in.sum);


        } else {
            Toast.makeText(MathtestActivity.this, "回答錯誤_答案是:"+answear[n], Toast.LENGTH_SHORT).show();
            Cursor data =db.getData();

            EnglishErrorword.add(answear[n]);
            ChineseErrorword.add(readomWord[n]);
            String ErroewWore=answear[n]+"▶"+readomWord[n];//
            Edd_Errow_Word(ErroewWore);
            yourCountDownTimer.cancel();//清除時間
            in.givscore(0);
            in.notgivten(5);
            in.gotscorezero(30);
        }
        //textView4.setText("傳入的數字"+answear[n]);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent scoreyellow = new Intent(MathtestActivity.this, MainActivityGame.class);
                startActivity(scoreyellow);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELOCOME_TIME);





    }
    public void Edd_Errow_Word(String EWord){
        Boolean result = db.insertData(EWord);

    }
    public void Run_Time_Button() {//計時器倒數20秒
        Math_button_Time_up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Run_Time_Button
                yourCountDownTimer = new CountDownTimer(20000,1000) {
                    public void onTick(long millisUntilFinished) {
                        Math_TextView.setText("倒數計時: " + millisUntilFinished / 1000+"秒");
                        counter--;
                    }

                    public void onFinish() {
                        Toast.makeText(MathtestActivity.this, "時間到!"+"回答錯誤_答案是:"+answear[n], Toast.LENGTH_SHORT).show();
                        Cursor data =db.getData();

                        EnglishErrorword.add(answear[n]);
                        ChineseErrorword.add(readomWord[n]);
                        String ErroewWore=answear[n]+"▶"+readomWord[n];//
                        Edd_Errow_Word(ErroewWore);
                        yourCountDownTimer.cancel();//清除時間
                        in.givscore(0);
                        in.notgivten(5);
                        in.gotscorezero(30);
                        Intent scoreyellow = new Intent(MathtestActivity.this, MainActivityGame.class);
                        startActivity(scoreyellow);
                    }
                }.start();
            }
        });
    }

    public void Atuo_Run_Time(){//自動按下計時器
        Math_button_Time_up2.setPressed(true);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Math_button_Time_up2.setPressed(false);
            }
        }, 50);
    }



}

/*

public class JF01 {
  public static void main(String args[])
  {
      int n,i,k,j,p,m;
      for(n=1; n<=1; n++) //n在最外层控制行数
      {
          for(i=1; i<=5;i++)
             System.out.print(i+" ");
             System.out.print("\n");
          for(k=1; k<=4;k++)
             System.out.print(k+" ");
             System.out.print("\n");
             for(j=1; j<=3;j++)
             System.out.print(j+" ");
             System.out.print("\n");
             for(p=1; p<=2;p++)
             System.out.print(p+" ");
             System.out.print("\n");
              for(m=1; m<=1;m++)
             System.out.print(m+" ");
             System.out.print("\n");

     }
 }
 }
public class JF01 {
  public static void main(String args[])
  {
      int n,i,k,j,p,m;
      for(n=1; n<=1; n++) //n在最外层控制行数
      {
          for(i=1; i<=1;i++)
             System.out.print("1");
             System.out.print("\n");
          for(k=1; k<=2;k++)
             System.out.print("2"+" ");
             System.out.print("\n");
             for(j=1; j<=3;j++)
             System.out.print("3"+" ");
             System.out.print("\n");
             for(p=1; p<=4;p++)
             System.out.print("4"+" ");
             System.out.print("\n");
              for(m=1; m<=5;m++)
             System.out.print("5"+" ");
             System.out.print("\n");

     }
 }
 }



 */