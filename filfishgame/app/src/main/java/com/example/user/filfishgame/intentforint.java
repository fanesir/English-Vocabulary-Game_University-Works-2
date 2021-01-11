package com.example.user.filfishgame;

import android.support.v7.app.AppCompatActivity;

public class intentforint extends AppCompatActivity {
    static   int i;
    static int sum;
    static Boolean Erroscore;
  static int sumaa,gamebuttonint,putchooseintforint,C_Change_E_int;


  public int givscore(int b){
        sum = b;
        return sum;
        //this.sum=sum;
    }
    public int notgivten(int aa){
        sumaa = aa;
        return sumaa;
        //this.sum=sum;
    }

    public int gotscorezero(int aaa){
        gamebuttonint = aaa;
        return gamebuttonint;
        //this.sum=sum;
    }

    public Integer anser(){
        return sum;
    }

    public int putchooseint(int aa){
        putchooseintforint = aa;
        return putchooseintforint;
        //this.sum=sum;
    }
    public int Put_C_Change_E_int(int aa){
        C_Change_E_int = aa;
        return C_Change_E_int;
        //this.sum=sum;
    }


}
