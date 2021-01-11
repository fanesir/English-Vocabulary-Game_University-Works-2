package com.example.user.filfishgame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Newsmessage extends AppCompatActivity {
RecyclerView newsrecy;
    FirebaseDatabase NewsDatabase;
    DatabaseReference NewsReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsmessage);


        newsrecy=(RecyclerView)findViewById(R.id.newsrecy);

        newsrecy.setHasFixedSize(true);
        newsrecy.setLayoutManager(new LinearLayoutManager(this));

        NewsDatabase = FirebaseDatabase.getInstance();
        NewsReference=NewsDatabase.getReference("Newsmenu");
    }
    protected void onStart() {

        super.onStart();
    FirebaseRecyclerAdapter<gamemodel,GameRecyHolder>firebaseRecyclerAdapter=
            new FirebaseRecyclerAdapter<gamemodel, GameRecyHolder>(
                    gamemodel.class,
                    R.layout.bewsrecy_ui,
                    GameRecyHolder.class,
                    NewsReference
            ) {
                @Override
                protected void populateViewHolder(GameRecyHolder viewHolder, gamemodel model, int position) {
                viewHolder.SetRecyview(
                        getApplicationContext(),
                        model.getNewsmeg());

                }
            };

        newsrecy.setAdapter(firebaseRecyclerAdapter);

    }







    public static class GameRecyHolder extends RecyclerView.ViewHolder{
        View GameRecyOnClick;
        private TextView GameNewText;

        public GameRecyHolder(View itemView) {
            super(itemView);



            GameRecyOnClick = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }


        public void SetRecyview(
                Context ctx,
                String newsmeg
        ){
            TextView Newstitle = GameRecyOnClick.findViewById(R.id.recytext_ui);
            Newstitle.setText(newsmeg);
        }


    }


}
