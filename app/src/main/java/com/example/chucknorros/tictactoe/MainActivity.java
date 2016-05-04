package com.example.chucknorros.tictactoe;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlayerVsPlayer(View v){
        Intent startIntent = new Intent(this, PlayerVsPlayer.class);
        startActivity(startIntent);
    }

    public void startPlayerVsAI(View v){
        Intent startIntent = new Intent(this, PlayerVsAI.class);
        startActivity(startIntent);
    }
}
