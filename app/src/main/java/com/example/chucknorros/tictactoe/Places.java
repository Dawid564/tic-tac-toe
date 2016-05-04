package com.example.chucknorros.tictactoe;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

class Places extends Button {

    private boolean symbol = true;
    private boolean isClicked = false;


    public Places(Context context) {
        super(context);
    }

    // set default settings
    public void setDefaults(){
        symbol = true;
        isClicked = false;
        this.setBackgroundColor(Color.rgb(0, 0, 0));
        this.setEnabled(true);
    }

    //set image for button and change every important variable
    public void setSymbol(boolean symbolCheck){
        if(symbolCheck){
            //this.setBackgroundColor(Color.rgb(255, 0, 0));
            this.setBackgroundResource(R.drawable.sharp);
            symbol = false;
            isClicked = true;
            this.setEnabled(false);
        }else{
            //this.setBackgroundColor(Color.rgb(0,255,0));
            this.setBackgroundResource(R.drawable.round);
            symbol = true;
            isClicked = true;
            this.setEnabled(false);
        }
    }

    public boolean checkSymbol(){
        return symbol;
    }

    public boolean tagClick(){
        if(isClicked){
            return false;
        }else{
            return true;
        }
    }

    public void helpClickable(){
        this.setEnabled(false);
    }
}
