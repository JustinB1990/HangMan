package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    String movieTitle;
    int wrongAnswers = 0;
    ArrayList<String> guessesMade = new ArrayList<String>();
    int randomNum;

    public String newGame() throws IOException {
        // This method will choose a random movie from our Movie list and store it in movieTitle
        BufferedReader reader = new BufferedReader(new FileReader("movielist.txt"));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        int movieNum = (int) (Math.random() * lines);
        movieTitle = Files.readAllLines(Paths.get("movielist.txt")).get(movieNum);

        return movieTitle;

    }

    public String userGuess(String hiddenAnswer) {

        // This method will display the hidden word, take in a user's guess and check to see if there are any letters that match that guess.
        boolean validInput = false;
        boolean repeatedAnswer = true;
        String usersGuess = null;

        while (!validInput && repeatedAnswer) {
            System.out.println("Please guess a letter: ");
            Scanner input = new Scanner(System.in);
            usersGuess = input.nextLine();
            int strLength = usersGuess.length();
            int arrLength = guessesMade.size();

            if(strLength == 1){
                validInput = true;
                for(int i = 0; i < arrLength; i++){
                    String previousGuess = guessesMade.get(i);
                    if(usersGuess.equals(previousGuess)){
                        validInput = false;
                        repeatedAnswer = true;
                        System.out.println("You have already guessed the letter: '" + usersGuess + "'\n" + hiddenAnswer + "\n");
                    } else {
                        repeatedAnswer = false;
                    }
                }
            } else {
                System.out.println("The guess you made can't be used.\n");
            }

        }
        guessesMade.add(usersGuess);
        return usersGuess;
    }

    public String compareGuessToMovieTitle(String userGuess, String movieTitle, String hiddenWord) {
        // This method will compare the answer our user gives and compare it to the real answer.
        boolean guessNotInAnswer = true;

        for (int i = 0; i < movieTitle.length(); i++) {
            if (userGuess.equals(movieTitle.substring(i, i + 1))) {
                hiddenWord = hiddenWord.substring(0, i) + userGuess + hiddenWord.substring(i + 1);
                guessNotInAnswer = false;
            }
        }

        if (guessNotInAnswer) {
            System.out.println("The letter '" + userGuess + "' is not in the Movie Title.");
            wrongAnswers = wrongAnswers + 1;
            int remainingGuesses = 3 - wrongAnswers;
            if(wrongAnswers < 3) {
                System.out.println("Number of remaining guesses: " + remainingGuesses);
            }
        }

        return hiddenWord;

    }

    public boolean checkGameCompletion(String titleAnswer, String hiddenAnswer) {

        boolean gameCompleted = false;

        if (titleAnswer.equals(hiddenAnswer)) {
            gameCompleted = true;
        }

        return gameCompleted;

    }


    public String createHiddenWord(String titleAnswer) {

        // This method is used to initialize the hidden word changing all of the letters to dashes.
        int length = titleAnswer.length();
        String hiddenWord = "";
        for (int i = 0; i < length; i++) {

            if (titleAnswer.charAt(i) != ' ') {
                hiddenWord = hiddenWord + "-";
            } else {
                hiddenWord = hiddenWord + " ";
            }
        }

        return hiddenWord;

    }

    public int getWrongAnswers() {
        return this.wrongAnswers;
    }

}


