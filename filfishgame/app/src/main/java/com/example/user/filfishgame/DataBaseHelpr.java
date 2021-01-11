package com.example.user.filfishgame;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseHelpr extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";//資料表
    public static final int VERSION = 1;
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";


    public DataBaseHelpr(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public boolean insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);


        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {//view 的
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean deleteTitle(String name){//刪除
    SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, COL_2 + "=?", new String[]{name}) > 0;

    }//
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey = " SELECT "+COL_1+" FROM "+TABLE_NAME+" WHERE "+COL_2+" = ' "+name+" ' ";
        Cursor data = db.rawQuery(qurey,null);
        return data;
    }

}