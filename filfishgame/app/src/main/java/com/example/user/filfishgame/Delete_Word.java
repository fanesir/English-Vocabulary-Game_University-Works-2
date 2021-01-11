package com.example.user.filfishgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Word extends AppCompatActivity {
    EditText editText_delete,ed_Ch_Text_delete;
    DataBaseHelpr deletedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__word);
        editText_delete=(EditText)findViewById(R.id.ed_Eng_Text_delete);
        ed_Ch_Text_delete=(EditText)findViewById(R.id.ed_Ch_Text_delete);
        deletedb = new DataBaseHelpr(this);
    }

    public void deleword_button(View v){
        String de_engleword = editText_delete.getText().toString();
        String de_chleword  = ed_Ch_Text_delete.getText().toString();
        String All_Delete_Word=de_engleword+"▶"+de_chleword;
        deletedb.deleteTitle(All_Delete_Word);

        Intent welcome = new Intent(this, Menubutton.class);
        startActivity(welcome);
    }

}
