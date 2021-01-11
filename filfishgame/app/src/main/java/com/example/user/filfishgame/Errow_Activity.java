package com.example.user.filfishgame;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;//

public class Errow_Activity extends AppCompatActivity {
    ListView listeng;
    private static final String TAG="ListviewActivity";
    DataBaseHelpr mDataBaseHelpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errow_);
        listeng=(ListView)findViewById(R.id.listeng);
        mDataBaseHelpr = new DataBaseHelpr(this);
        popuListview();
    }
    private void popuListview(){
        Cursor data = mDataBaseHelpr.getData();
        ArrayList<String>listDATA = new ArrayList<>();
        while (data.moveToNext()){
            listDATA.add(data.getString(1));

        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listDATA);
        listeng.setAdapter(adapter);
    }
    public void delete_buttonn(View v){
        Intent Errow_word = new Intent(this, Delete_Word.class);
        startActivity(Errow_word);

    }

}
