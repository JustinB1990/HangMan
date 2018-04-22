package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Game play = new Game();
        boolean gameCompleted = false;
        String userGuess = null;
        String gameAnswer = null;
        String hiddenAnswer = null;
        int numberOfWrongAnswers = 0;
        try {
            gameAnswer = play.newGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hiddenAnswer = play.createHiddenWord(gameAnswer);

        System.out.print("This is a game of Hangman where the subject is a popular Movie Title.\n");
        System.out.print("Make 3 wrong answers and you lose the game!\n");
        while (!(gameCompleted) && (numberOfWrongAnswers < 3)) {
            System.out.print(hiddenAnswer + "\n");
            userGuess = play.userGuess(hiddenAnswer);

            hiddenAnswer = play.compareGuessToMovieTitle(userGuess, gameAnswer, hiddenAnswer);
            gameCompleted = play.checkGameCompletion(gameAnswer, hiddenAnswer);

            numberOfWrongAnswers = play.getWrongAnswers();
            if(!gameCompleted && numberOfWrongAnswers < 2){
                System.out.println("Keep guessing!");
            }

        }
        if(gameCompleted){
            System.out.println("You WON! the movie was: " + hiddenAnswer);
        }

        if(numberOfWrongAnswers > 2){
            System.out.println("Sorry, you lost! The Movie was: " + gameAnswer);
        }
    }
}
