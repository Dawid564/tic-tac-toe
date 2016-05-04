package com.example.chucknorros.tictactoe;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;

import java.lang.reflect.Type;

public class PlayerVsPlayer extends AppCompatActivity {

    private Winning winning = new Winning();

    private Places placesTab1[];
    private Places placesTab2[];
    private Places placesTab3[];

    private boolean helperCheck = false;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vs_player);

        createLayout();
    }

    private void createLayout(){
        //create container for button
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linear1);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linear2);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linear3);

        //show line of buttons
        placesTab1 = new Places[3];
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        for(int i=0; i<3; i++){
            placesTab1[i] = new Places(this);
            placesTab1[i].setLayoutParams(new LinearLayout.LayoutParams(width, height));
            placesTab1[i].setDefaults();
            final int j = i;
            placesTab1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(placesTab1[j].tagClick()){
                        if (helperCheck) {
                            //round green
                            placesTab1[j].setSymbol(false);
                            helperCheck = false;
                            // set tag button
                            winning.firstAnswerRound(j);
                            //check if win
                            if(winning.checkResultRound()){
                                Toast.makeText(PlayerVsPlayer.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        } else {
                            //sharp
                            placesTab1[j].setSymbol(true);
                            helperCheck = true;

                            //set tag button
                            winning.firstAnswerSharp(j);
                            //check if win
                            if(winning.checkResultSharp()){
                                Toast.makeText(PlayerVsPlayer.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        }
                        //Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            linearLayout1.addView(placesTab1[j]);
        }

        placesTab2 = new Places[3];
        for(int i=0; i<3; i++){
            placesTab2[i] = new Places(this);
            placesTab2[i].setLayoutParams(new LinearLayout.LayoutParams(width, height));
            placesTab2[i].setDefaults();
            final int j = i;
            placesTab2[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(placesTab2[j].tagClick()){
                        if(helperCheck){
                            placesTab2[j].setSymbol(false);
                            helperCheck = false;

                            //set tag button
                            winning.secondAnswerRound(j);
                            if(winning.checkResultRound()){
                                Toast.makeText(PlayerVsPlayer.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        }else{
                            placesTab2[j].setSymbol(true);
                            helperCheck = true;

                            //set tag button
                            winning.secondAnswerSharp(j);
                            //check if win
                            if(winning.checkResultSharp()){
                                Toast.makeText(PlayerVsPlayer.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        }
                        //Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            linearLayout2.addView(placesTab2[i]);
        }

        placesTab3 = new Places[3];
        for(int i=0; i<3; i++) {
            placesTab3[i] = new Places(this);
            placesTab3[i].setLayoutParams(new LinearLayout.LayoutParams(width, height));
            placesTab3[i].setDefaults();
            final int j = i;
            placesTab3[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(placesTab3[j].tagClick()){
                        if (helperCheck){
                            placesTab3[j].setSymbol(false);
                            helperCheck = false;

                            //set tag button
                            winning.threeAnswerRound(j);
                            if(winning.checkResultRound()){
                                Toast.makeText(PlayerVsPlayer.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        }else{
                            placesTab3[j].setSymbol(true);
                            helperCheck = true;

                            //set tag button
                            winning.threeAnswerSharp(j);
                            //check if win
                            if(winning.checkResultSharp()){
                                Toast.makeText(PlayerVsPlayer.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                        }
                        //Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            linearLayout3.addView(placesTab3[i]);
        }
    }

    //reset values to restart game
    public void resetButton(View v){
        for(int i=0; i<3; i++){
            placesTab1[i].setDefaults();
            placesTab2[i].setDefaults();
            placesTab3[i].setDefaults();
            placesTab1[i].setText("");
            placesTab2[i].setText("");
            placesTab3[i].setText("");
        }
        winning.zeros();
    }

    // set enabled button when game is over
    public void enabledButton(boolean en){
        for(int i=0; i<3; i++){
            placesTab1[i].setEnabled(en);
        }
        for(int i=0; i<3; i++){
            placesTab2[i].setEnabled(en);
        }
        for(int i=0; i<3; i++){
            placesTab3[i].setEnabled(en);
        }
    }
}
