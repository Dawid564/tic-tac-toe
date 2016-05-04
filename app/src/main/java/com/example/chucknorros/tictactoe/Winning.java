package com.example.chucknorros.tictactoe;


public class Winning {
    private LogicAI ai = new LogicAI();

    private int resultTabRound[][] = new int[3][3];
    private int resultTabSharp[][] = new int[3][3];

    //after user press any button check if win game

    {
        for (int r = 0; r < 3; r++) {
            for (int l = 0; l < 3; l++) {
                resultTabRound[r][l] = -1;
                resultTabSharp[r][l] = -1;
            }
        }
    }

    public void zeros() {
        {
            for (int r = 0; r < 3; r++) {
                for (int l = 0; l < 3; l++) {
                    resultTabRound[r][l] = -1;
                    resultTabSharp[r][l] = -1;
                }
            }
        }
    }

    // all below is for round
    public void firstAnswerRound(int i) {
        if (i == 0) {
            resultTabRound[0][0] = 1;
        }
        if (i == 1) {
            resultTabRound[0][1] = 1;
        }
        if (i == 2) {
            resultTabRound[0][2] = 1;
        }
    }

    public void secondAnswerRound(int i) {
        if (i == 0) {
            resultTabRound[1][0] = 1;
        }
        if (i == 1) {
            resultTabRound[1][1] = 1;
        }
        if (i == 2) {
            resultTabRound[1][2] = 1;
        }
    }

    public void threeAnswerRound(int i) {
        if (i == 0) {
            resultTabRound[2][0] = 1;
        }
        if (i == 1) {
            resultTabRound[2][1] = 1;
        }
        if (i == 2) {
            resultTabRound[2][2] = 1;
        }
    }

    public boolean checkResultRound() {
        // set condition for horizontal
        if (resultTabRound[0][0] == 1 && resultTabRound[0][1] == 1 && resultTabRound[0][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabRound[1][0] == 1 && resultTabRound[1][1] == 1 && resultTabRound[1][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabRound[2][0] == 1 && resultTabRound[2][1] == 1 && resultTabRound[2][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }

        // set condition for vertical
        if (resultTabRound[0][0] == 1 && resultTabRound[1][0] == 1 && resultTabRound[2][0] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabRound[0][1] == 1 && resultTabRound[1][1] == 1 && resultTabRound[2][1] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabRound[0][2] == 1 && resultTabRound[1][2] == 1 && resultTabRound[2][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }

        // set condition for diagonal
        if (resultTabRound[0][0] == 1 && resultTabRound[1][1] == 1 && resultTabRound[2][2] == 1) {
            zeros();
            return true;
        }
        if (resultTabRound[0][2] == 1 && resultTabRound[1][1] == 1 && resultTabRound[2][0] == 1) {
            zeros();
            return true;
        }
        return false;
    }


    // all below is for sharp
    public void firstAnswerSharp(int i) {
        if (i == 0) {
            resultTabSharp[0][0] = 1;
        }
        if (i == 1) {
            resultTabSharp[0][1] = 1;
        }
        if (i == 2) {
            resultTabSharp[0][2] = 1;
        }
    }

    public void secondAnswerSharp(int i) {
        if (i == 0) {
            resultTabSharp[1][0] = 1;
        }
        if (i == 1) {
            resultTabSharp[1][1] = 1;
        }
        if (i == 2) {
            resultTabSharp[1][2] = 1;
        }
    }

    public void threeAnswerSharp(int i) {
        if (i == 0) {
            resultTabSharp[2][0] = 1;
        }
        if (i == 1) {
            resultTabSharp[2][1] = 1;
        }
        if (i == 2) {
            resultTabSharp[2][2] = 1;
        }
    }

    public boolean checkResultSharp() {
        // set condition for horizontal
        if (resultTabSharp[0][0] == 1 && resultTabSharp[0][1] == 1 && resultTabSharp[0][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabSharp[1][0] == 1 && resultTabSharp[1][1] == 1 && resultTabSharp[1][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabSharp[2][0] == 1 && resultTabSharp[2][1] == 1 && resultTabSharp[2][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }

        // set condition for vertical
        if (resultTabSharp[0][0] == 1 && resultTabSharp[1][0] == 1 && resultTabSharp[2][0] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabSharp[0][1] == 1 && resultTabSharp[1][1] == 1 && resultTabSharp[2][1] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabSharp[0][2] == 1 && resultTabSharp[1][2] == 1 && resultTabSharp[2][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }

        // set condition for diagonal
        if (resultTabSharp[0][0] == 1 && resultTabSharp[1][1] == 1 && resultTabSharp[2][2] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        if (resultTabSharp[0][2] == 1 && resultTabSharp[1][1] == 1 && resultTabSharp[2][0] == 1) {
            ai.tabZeros();
            zeros();
            return true;
        }
        return false;
    }
}
