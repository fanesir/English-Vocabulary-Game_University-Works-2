package com.example.user.filfishgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class hight_choose_gametest_Activity extends AppCompatActivity {
    RadioButton Rb1, Rb2, Rb3,Rb4;
    RadioGroup RGP;
    TextView textView,textView2,Hight_Time_Text;
    DataBaseHelpr db = new DataBaseHelpr(this);
    Button Hight_Time_Up_Button;
    int i, nextnumber,n,counter ;
    String answer;
    intentforint in =new intentforint();
    ArrayList HightEnglishErrorword = MathtestActivity.EnglishErrorword;
    ArrayList HightChineseErrorword = MathtestActivity.ChineseErrorword;
    int C_Change_E_int1 = intentforint.C_Change_E_int;
    int PUT = intentforint.putchooseintforint;
    private static int Starttime=10;
    CountDownTimer yourCountDownTimer;
    private String list2[] = {
            "任何人","任何事","公寓","看起來...出現","環繞","羽球","香蕉","烤肉","棒球","籃子",
            "早餐","兄弟","商人","蝴蝶","糖果","照相機","蠟燭","小心","慶祝","雞"
            ,"困難","龍","餃子","大象","橡皮擦","每個人","每件事物","經驗","工廠","有名的"
            ,"漢堡","英俊的","發生","快樂的","頭痛","健康","有幫助的","家庭作業","醫院","然而"
            ,"三明治","害怕","句子","歌手","微笑","有時候","某事物","聲音","特別","湯匙"
            ,"胃","陌生人","草莓","夏天","驚奇","一起","明天","麻煩","颱風","通常"};//題目
    private String answerlist[]={
            "anyone","anything","apartment","appear","around","badminton","banana","barbecue","baseball","basket"
            ,"breakfast","brother","businessman","butterfly","candy","camera","candle","careful","celebrate","chicken"
            ,"difficult","dragon","dumpling","elephant","eraser","everyone","everything","experience","factory","famous"
            ,"hamburger","handsome","happen","happy","headache","health","helpful","homework","hospital","however"
            ,"sandwich","scared","sentence","singer","smile","sometimes","something","sound","special","spoon"
            ,"stomach","stranger","strawberry","summer","surprise","together","tomorrow","trouble","typhoon","usually"
    };
    private String list[] =  {
            "b", "a", "d","a","d","a","a","b","d","b"
            ,"a","b","a","c","b","c","a","b","c","a"
            ,"a","b","c","a","c","b","a","b","c","c"
            ,"c","b","a","b","a","c","c","a","b","c"
            ,"a","c","b","a","a","b","c","a","c","b"
            ,"d","b","d","a","d","a","b","a","d","b"};//正確答案

    private String A_ans[] = {
            "任何事", "任何事", "任何人", "看起來...出現","微笑","羽球","香蕉","麻煩","湯匙","慶祝"
            ,"早餐","快樂的","商人","一起","非常","微笑","蠟燭","有幫助的","每個人","雞"
            ,"困難","麻煩","明天","大象","注意聽","通常","每件事物","湯匙","有幫助的","明天"
            ,"三明治","三明治","健康","有時候","頭痛","驚奇","發生","家庭作業","慶祝","快樂的"
            ,"三明治","家庭作業","歌手","歌手","微笑","麻煩","陌生人","聲音","兄弟","糖果"
            ,"明天","草莓","驚奇","夏天","颱風","一起","每個人","麻煩","有幫助的","頭痛"};

    private String B_ans[] = {
            "任何人","慶祝", "草莓", "商人","三明治","草莓","胃","烤肉","有時候","籃子"
            ,"陌生人","兄弟","微笑","句子","糖果","歌手","微笑","小心","有時候","某事物"
            ,"特別","龍","頭痛","任何事","公寓","每個人","看起來...出現","經驗","環繞","香蕉"
            ,"烤肉","英俊的","棒球","快樂的","商人","兄弟","每個人","兄弟","醫院","糖果"
            ,"蝴蝶","橡皮擦","句子","每個人","每件事物","有時候","經驗","發生","大象","湯匙"
            ,"糖果","陌生人","小心","每個人","商人","英俊的","明天","蠟燭","蝴蝶","通常"};

    private String C_ans[] = {
            "胃", "陌生人", "草莓", "夏天","驚奇","一起","明天","麻煩","颱風","通常"
            ,"三明治","害怕","句子","蝴蝶","歌手","照相機","微笑","有時候","慶祝","某事物"
            ,"聲音","特別","餃子","然而","橡皮擦","醫院","家庭作業","有幫助的","工廠","快樂的"
            ,"漢堡","湯匙","任何人","任何事","公寓","健康","有幫助的","看起來...出現","環繞","然而"
            ,"羽球","害怕","香蕉","烤肉","棒球","籃子","某事物","早餐","特別","兄弟"
            ,"商人","蝴蝶","糖果","照相機","蠟燭","小心","慶祝","雞","有名的","然而"};

    private String D_ans[] = {
            "三明治", "害怕", "公寓", "通常","環繞","歌手","害怕","有時候","棒球","聲音"
            ,"特別","湯匙","困難","有名的","工廠","經驗","每件事物","每個人","橡皮擦","大象"
            ,"餃子","雞","慶祝","小心","蠟燭","照相機","糖果","蝴蝶","商人","兄弟"
            ,"早餐","雞","籃子","棒球","烤肉","香蕉","羽球","環繞","看起來...出現","公寓"
            ,"發生","英俊的","漢堡","蝴蝶","蠟燭","每件事物","家庭作業","歌手","大象","工廠"
            ,"胃","每個人","草莓","發生","驚奇","有時候","蝴蝶","工廠","颱風","快樂的"};



    private String  Eng_A_ans[] = {
            "aonyne", "anything", "arpatment", "appear","aunord","again","banana","bcrbecue","ballbase","ketbas"
            ,"breakfast","broonther","businessman","butterfcely","coandy","cmeara","candle","carfule","ceralebte","chicken"
            ,"difficult","darngo","dummpling","elephant","eerras","everoney","everything","experencei","ftoracy","fsmoau"
            ,"hambrgrue","hansomed","happen","hpapy","headache","hehalt","hellpfu","homework","hostpial","hoewevr"
            ,"sandwich","sarced","sencente","singer","smile","sommeties","sthinomeg","sound","sipecal","sopon"
            ,"mstoach","streangr","strrawbery","summer","sursprie","together","tormorow","trouble","tbroule","ualsuly"};

    private String  Eng_B_ans[] = {
            "anyone","anythihng", "apartmten", "appearrra","anurod","asing","bannanaa","barbecue","basekellball","basket"
            ,"fastbreak","brother","bausinessman","butterfley","candy","cahmersa","cadlen","careful","crateeleb","cckehin"
            ,"diffculti","dragon","dumplinggger","elentpha","eserra","everyone","everyingth","experience","facytor","fmoaus"
            ,"hambrurge","handsome","hapenp","happy","heachead","hleath","helupfl","howorkme","hospital","hvoweer"
            ,"sanicdwh","srecad","sentence","seingr","semil","sometimes","sthiomeng","snoud","spaecil","spoon"
            ,"sctomah","stranger","strrawbery","suemmr","sriurpse","tohgeter","tomorrow","trloube","trloube","usually"};

    private String  Eng_C_ans[] = {
            "anoyoe", "anythihgng", "apnt", "apppeaaar","asnd","asing","bananaxa","barbeecu","baball","betask"
            ,"brfaeakst","breother","bcsinaessmn","butterfly","candcly","camera","cadlen","cfuarel","celebrate","cehickn"
            ,"dciffiult","doragn","dumpling","elentpha","eraser","everonye","everngtyih","exiencpere","factory","famous"
            ,"hamburger","hasondme","hpenap","hyapp","hehadace","health","helpful","horkmwoe","hoitspal","however"
            ,"saicndwh","scared","scentene","sering","slemi","sometids","something","sdoun","special","sopon"
            ,"stoash","sgtraner","sawrry","surmme","sure","togerthe","towmorro","tblroue","tuble","ullsuea"};




    private String Eng_D_ans[] = {
            "anoyoeese", "agng", "apartment", "apaar","around","asg","bacxa","baau","baseball","bedsk"
            ,"brfaeast","brxer","bcsinzssmn","barfly","caney","camaa","cadlen","cerel","celebrate","cehickn"
            ,"dciffiult","doragn","dumpling","elentpha","eraser","evednye","everstyih","exieacpere","fxtory","fazus"
            ,"hafrger","hasxndme","hpcap","hym","heuce","heith","heuful","horyoe","hcspal","hxever"
            ,"saigh","scad","scentse","serdng","sami","sodids","sometanaseg","sdoan","spdial","sopxn"
            ,"stomach","sgtder","strawberry","surdme","surpdse","togeehe","taorro","tblxue","trouble","ullsuy"};





    private static int WELOCOME_TIME = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hight_choose_gametest_);

        RGP = (RadioGroup) findViewById(R.id.RGPP);
        textView = (TextView) findViewById(R.id.Hihht_TextView);
        Hight_Time_Up_Button=(Button)findViewById(R.id.Hight_Time_Up_Button);
        Hight_Time_Text = (TextView) findViewById(R.id.textView69);
        Hight_Time_Up_Button.setVisibility(View.INVISIBLE);
        Rb1 = (RadioButton) findViewById(R.id.Rb1);
        Rb2 = (RadioButton) findViewById(R.id.Rb2);
        Rb3 = (RadioButton) findViewById(R.id.Rb3);
        Rb4 = (RadioButton) findViewById(R.id.Rb4);
        Atuo_Run_Time();
        Intent it = getIntent();
        Bundle bd = it.getExtras();//傳來的方法
        n = bd.getInt("number");
        RGP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.Rb1:
                        answer = "a";
                        break;

                    case R.id.Rb2:
                        answer = "b";
                        break;

                    case R.id.Rb3:
                        answer = "c";
                        break;
                    case R.id.Rb4:
                        answer = "d";
                        break;


                }

            }


        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Run_Time_Button();
                Hight_Time_Up_Button.performClick();
                if(C_Change_E_int1==31){
                    textView.setText(list2[n]);
                    Rb1.setText(Eng_A_ans[n]);
                    Rb2.setText(Eng_B_ans[n]);
                    Rb3.setText(Eng_C_ans[n]);
                    Rb4.setText(Eng_D_ans[n]);
                }

                else if(PUT==30) {
                    textView.setText(answerlist[n]);
                    Rb1.setText(A_ans[n]);
                    Rb2.setText(B_ans[n]);
                    Rb3.setText(C_ans[n]);
                    Rb4.setText(D_ans[n]);
                }



            }
        }, Starttime);


    }
    public void hight_yes_or_no_button(View v){
        if (answer == list[n]) {
            Toast toast9 = Toast.makeText(hight_choose_gametest_Activity.this,
                    "正確答案", Toast.LENGTH_LONG);
            toast9.show();
            in.givscore(20);
            in.notgivten(10);
            in.gotscorezero(30);
            yourCountDownTimer .cancel();
            RGP.clearCheck();
        }
        else
        {
            Toast toast9 = Toast.makeText(hight_choose_gametest_Activity.this,
                    "錯誤"+answerlist[n]+ "_" +list2[n]+"_"+list[n], Toast.LENGTH_LONG);
            toast9.show();
            HightEnglishErrorword.add(answerlist[n]);
            HightChineseErrorword.add(list2[n]);
            String ErroewWore=answerlist[n]+"▶"+list2[n];
            Boolean result = db.insertData(ErroewWore);
            in.givscore(0);
            in.notgivten(5);
            in.gotscorezero(30);
            yourCountDownTimer.cancel();//清除時間
            RGP.clearCheck();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent scoreyellow = new Intent(hight_choose_gametest_Activity.this, MainActivityGame.class);



                startActivity(scoreyellow);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, WELOCOME_TIME);


    }
    public void Run_Time_Button() {//計時器倒數十秒
        Hight_Time_Up_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Run_Time_Button
                yourCountDownTimer = new CountDownTimer(10000,1000) {
                    public void onTick(long millisUntilFinished) {
                        Hight_Time_Text.setText("倒數計時: " + millisUntilFinished / 1000+"秒");
                        counter--;
                    }

                    public void onFinish() {
                        Toast toast10 = Toast.makeText(hight_choose_gametest_Activity.this,
                                "時間到!!", Toast.LENGTH_LONG);
                        Toast toast9 = Toast.makeText(hight_choose_gametest_Activity.this,
                                "錯誤"+answerlist[n]+ "_" +list2[n]+"_"+list[n], Toast.LENGTH_LONG);
                        toast9.show();
                        toast10.show();
                        HightEnglishErrorword.add(answerlist[n]);
                        HightChineseErrorword.add(list2[n]);
                        String ErroewWore=answerlist[n]+"▶"+list2[n];
                        Boolean result = db.insertData(ErroewWore);
                        in.givscore(0);
                        in.notgivten(5);
                        in.gotscorezero(30);
                        RGP.clearCheck();
                        Intent scoreyellow = new Intent(hight_choose_gametest_Activity.this, MainActivityGame.class);
                        startActivity(scoreyellow);
                        yourCountDownTimer .cancel();
                    }
                }.start();
            }
        });
    }
    public void Atuo_Run_Time(){//自動按下計時器
        Hight_Time_Up_Button.setPressed(true);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Hight_Time_Up_Button.setPressed(false);
            }
        }, 50);
    }



}

