package com.example.chucknorros.tictactoe;


import java.util.Random;

public class LogicAI {

    private Random rand = new Random();

    private int rowRand = 0;
    private int colRand = 0;
    private int[][] clickSum= new int[3][3];
    private int count = 0;

    // artificial intelligence
    public int startGame(int row, int column){
        if(count < 4){
            count++;
            rowRand = rand.nextInt(3);
            colRand = rand.nextInt(3);

            clickSum[row][column] = 1;

            while (clickSum[rowRand][colRand] == 1){
                rowRand = rand.nextInt(2);
                colRand = rand.nextInt(2);
            }

            clickSum[rowRand][colRand] = 1;

            if (rowRand == 0){
                return colRand;
            } else if (rowRand == 1){
                colRand = colRand + 3;
                return colRand;
            }else{
                colRand = colRand + 6;
                return colRand;
            }
        }
        return -1;
    }

    public void tabZeros(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                clickSum[i][j] = 0;
            }
        }
        count = 0;
    }
}
