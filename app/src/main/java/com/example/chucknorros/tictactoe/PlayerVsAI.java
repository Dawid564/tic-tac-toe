package com.example.chucknorros.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayerVsAI extends AppCompatActivity {
    private Winning winning = new Winning();
    private LogicAI ai = new LogicAI();

    private Places placesTab1[];
    private Places placesTab2[];
    private Places placesTab3[];

    private boolean helperCheck = false;
    private int testingVar1 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vs_player);
        createLayout();
    }
    private void createLayout(){

        additional();
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
                            //never use
                            //round green
                            placesOne(j);
                            //placesTab1[j].setSymbol(false);
                            helperCheck = false;

                            // set tag button
                            winning.firstAnswerRound(j);
                            //check if win
                            if(winning.checkResultRound()){
                                Toast.makeText(PlayerVsAI.this, "Green WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            //sharp red
                            // player set only red
                            placesTab1[j].setSymbol(true);
                            helperCheck = false;

                            //set tag button
                            winning.firstAnswerSharp(j);
                            //check if win
                            if(winning.checkResultSharp()){
                                Toast.makeText(PlayerVsAI.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                            testingVar1 = ai.startGame(0, j);
                            if(testingVar1 != -1){
                                AIMasterRace(testingVar1);
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
                            //never use
                            placesTab2[j].setSymbol(false);
                            helperCheck = false;

                            //set tag button
                            winning.secondAnswerRound(j);
                            if(winning.checkResultRound()){
                                Toast.makeText(PlayerVsAI.this, "Green WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            //sharp red
                            placesTab2[j].setSymbol(true);
                            helperCheck = false;

                            //set tag button
                            winning.secondAnswerSharp(j);
                            //check if win
                            if(winning.checkResultSharp()){
                                Toast.makeText(PlayerVsAI.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                                enabledButton(false);
                            }
                            testingVar1 = ai.startGame(1,j);
                            if(testingVar1 != -1){
                                AIMasterRace(testingVar1);
                            }
                            //Toast.makeText(PlayerVsAI.this, "true " + testingVar1, Toast.LENGTH_SHORT).show();
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
                        placesTab3[j].setSymbol(true);
                        helperCheck = false;

                        //set tag button
                        winning.threeAnswerSharp(j);

                        //check if win
                        if(winning.checkResultSharp()){
                            Toast.makeText(PlayerVsAI.this, "SHARP WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                            enabledButton(false);
                        }

                        // set AI choose
                        testingVar1 = ai.startGame(2,j);
                        if(testingVar1 != -1){
                            AIMasterRace(testingVar1);
                        }
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
        ai.tabZeros();

    }

    public void placesOne(int j){
        placesTab1[j].setSymbol(false);
    }

    public void AIMasterRace(int select){
        if(select < 3){
            placesTab1[select].setSymbol(false);
            winning.firstAnswerRound(select);
            //check if win
            if(winning.checkResultRound()){
                Toast.makeText(PlayerVsAI.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                enabledButton(false);
            }
        }else if(select < 6){
            select = select - 3;
            placesTab2[select].setSymbol(false);
            winning.secondAnswerRound(select);
            if(winning.checkResultRound()){
                Toast.makeText(PlayerVsAI.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                enabledButton(false);
            }
        }else{
            select = select - 6;
            placesTab3[select].setSymbol(false);
            winning.threeAnswerRound(select);
            if(winning.checkResultRound()){
                Toast.makeText(PlayerVsAI.this, "ROUND WIN THE GAME!!", Toast.LENGTH_SHORT).show();
                enabledButton(false);
            }
        }
    }

    private void additional(){
        ai.tabZeros();
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
