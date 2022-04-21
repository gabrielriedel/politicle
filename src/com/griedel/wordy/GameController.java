package com.griedel.wordy;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class GameController {

    private final GameBoardCanvas gameBoard;
    private String word;

    public GameController(GameBoardCanvas gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String setGovWord()
    {
        this.word = Wordy.randomWord();
        word = word.toUpperCase();
        gameBoard.setWord(word);
        System.out.println(word);
        return word;
    }

    public String newGame()
    {
//        String word = Wordy.randomWord();
//        word = word.toUpperCase();
//        gameBoard.setWord(word);
        gameBoard.mainTitle("POLITICLE");
        gameBoard.setInitializeBoard(true);
        this.word = Wordy.randomWord();
        word = word.toUpperCase();
        gameBoard.setWord(word);
        System.out.println(word);
        return word;
//        System.out.println(word);
//        return word;
    }

    public void tryNewGuess(String guess) throws IOException {
//        int count = 0;
       // newGame();
        guess = guess.toUpperCase();
        gameBoard.tryGuess(word, guess);
        gameBoard.repaint();

//        while(!checkGuessLength(guess))
//        {
//            System.out.println("Invalid Guess");
//            System.out.println("ENTER ANOTHER GOVERNMENT WORD GUESS:: ");
//            Scanner tryAgain = new Scanner(System.in);
//            guess = tryAgain.nextLine();
//            guess = guess.toUpperCase();
//
//        }
//
        if (word.equals(guess)) {
            gameBoard.youWin();
//
            gameBoard.repaint();;
           // gameBoard.clearGame();
//
//
//            Scanner type = new Scanner(System.in);
//            System.out.println("Would you like to play again? (yes or no) :: ");
//            String again = type.nextLine();
//
//            // if yes, clear board and play again
//            if (again.equals("yes")) {
//
//
//                guess = "";
//                word = newGame();
//                gameBoard.setWord(word);
//                gameBoard.setInitializeBoard(true);
//                gameBoard.repaint();
//
//
//            }
//
//            // if no, end game
//            else {
//
//                gameBoard.clearGame();
//                gameBoard.thanksPlay();
//                //gameBoard.repaint();
//
//            }
        }
//
//        if (count == 5) {
//            // Print You Lose
//            gameBoard.youLose();
//            //gameBoard.repaint();
//
//            // prompts user to play again
//            Scanner types = new Scanner(System.in);
//            System.out.println("Would you like to play again? (yes or no) :: ");
//            String agains = types.nextLine();
//
//            // if yes, clear board and restart
//            // if no, end game
//            if (agains.equals("yes")) {
//
//
//                guess = "";
//                word = newGame();
//                gameBoard.setWord(word);
//                gameBoard.setInitializeBoard(true);
//                gameBoard.repaint();
//                count = 0;
//
//
//
//            } else {
//
//                gameBoard.clearGame();
//                gameBoard.thanksPlay();
//                //gameBoard.repaint();
//
//            }
//
//        }
//        count += 1;


    }

    public boolean checkGuessLength(String guess)
    {
        if(guess.length() != word.length())
        {
            return false;
        }
        else {
            return true;
        }
    }


//    public void play() {
//        boolean game = true;
//
//        //this.word = newGame();
//        int count = 0;
//        //loop runs for every turn
//
//
//
//        while (game) {
//             System.out.println(word);
//
//
//
//            //gameBoard.repaint();;
//
//
//
//
//            // Setting font and title for main game title
//
//
//            // prompt user for intitial guess
//            Scanner initial = new Scanner(System.in);
//
//            System.out.println("ENTER YOUR GOVERNMENT WORD GUESS:: ");
//            String guess = initial.nextLine();
//            guess = guess.toUpperCase();
//            while(!checkGuessLength(guess))
//            {
//                System.out.println("Invalid Guess");
//                System.out.println("ENTER ANOTHER GOVERNMENT WORD GUESS:: ");
//                Scanner tryAgain = new Scanner(System.in);
//                guess = tryAgain.nextLine();
//                guess = guess.toUpperCase();
//
//            }
//
//
//            gameBoard.tryGuess(word, guess);
//            gameBoard.repaint();
//            // if user guess cxorrectly, prompted with "YOU WIN" and ability to play again
//            if (word.equals(guess)) {
//                gameBoard.youWin();
//
//                gameBoard.repaint();;
//
//
//                Scanner type = new Scanner(System.in);
//                System.out.println("Would you like to play again? (yes or no) :: ");
//                String again = type.nextLine();
//
//                // if yes, clear board and play again
//                if (again.equals("yes")) {
//
//                    game = true;
//                    guess = "";
//                    word = newGame();
//                    gameBoard.setWord(word);
//                    gameBoard.setInitializeBoard(true);
//                    gameBoard.repaint();
//                    count = 0;
//
//                    continue;
//                }
//
//                // if no, end game
//                else {
//                    game = false;
//                    gameBoard.clearGame();
//                    gameBoard.thanksPlay();
//                    //gameBoard.repaint();
//                    break;
//                }
//            }
//
//            // case if user reaches 6 guesses
//
//
//            if (count == 5) {
//                // Print You Lose
//                gameBoard.youLose();
//                //gameBoard.repaint();
//
//                // prompts user to play again
//                Scanner types = new Scanner(System.in);
//                System.out.println("Would you like to play again? (yes or no) :: ");
//                String agains = types.nextLine();
//
//                // if yes, clear board and restart
//                // if no, end game
//                if (agains.equals("yes")) {
//
//                    game = true;
//                    guess = "";
//                    word = newGame();
//                    gameBoard.setWord(word);
//                    gameBoard.setInitializeBoard(true);
//                    gameBoard.repaint();
//                    count = 0;
//
//                    continue;
//
//                } else {
//                    game = false;
//                    gameBoard.clearGame();
//                    gameBoard.thanksPlay();
//                    //gameBoard.repaint();
//                    break;
//                }
//
//            }
//            count += 1;
//
//            // prompts user to enter next guess
//
//
//        }
//    }


//    public void play2(String guess) {
//        boolean game = true;
//
//        //this.word = newGame();
//        int count = 0;
//        //loop runs for every turn
//
//
//      //  while (game) {
//            System.out.println(word);
//
//
//            //gameBoard.repaint();;
//
//
//            // Setting font and title for main game title
//
//
//            // prompt user for intitial guess
//            //Scanner initial = new Scanner(System.in);
//
//            //System.out.println("ENTER YOUR GOVERNMENT WORD GUESS:: ");
//            //String guess = initial.nextLine();
//            guess = guess.toUpperCase();
////            while (!checkGuessLength(guess)) {
////                System.out.println("Invalid Guess");
////                System.out.println("ENTER ANOTHER GOVERNMENT WORD GUESS:: ");
////                Scanner tryAgain = new Scanner(System.in);
////                guess = tryAgain.nextLine();
////                guess = guess.toUpperCase();
////
////            }
//
//
//            gameBoard.tryGuess(word, guess);
//            gameBoard.repaint();
//            // if user guess cxorrectly, prompted with "YOU WIN" and ability to play again
//            if (word.equals(guess)) {
//                gameBoard.youWin();
//
//                gameBoard.repaint();
//                ;
//
//
//                Scanner type = new Scanner(System.in);
//                System.out.println("Would you like to play again? (yes or no) :: ");
//                String again = type.nextLine();
//
//                // if yes, clear board and play again
//                if (again.equals("yes")) {
//
//                    game = true;
//                    guess = "";
//                    word = newGame();
//                    gameBoard.setWord(word);
//                    gameBoard.setInitializeBoard(true);
//                    gameBoard.repaint();
//
//                   // continue;
//                }
//
//                // if no, end game
//                else {
//                    game = false;
//                    gameBoard.clearGame();
//                    gameBoard.thanksPlay();
//                    //gameBoard.repaint();
//                   // break;
//                }
//            }
//
//            // case if user reaches 6 guesses
//
//
//            if (count == 5) {
//                // Print You Lose
//                gameBoard.youLose();
//                //gameBoard.repaint();
//
//                // prompts user to play again
//                Scanner types = new Scanner(System.in);
//                System.out.println("Would you like to play again? (yes or no) :: ");
//                String agains = types.nextLine();
//
//                // if yes, clear board and restart
//                // if no, end game
//                if (agains.equals("yes")) {
//
//                    game = true;
//                    guess = "";
//                    word = newGame();
//                    gameBoard.setWord(word);
//                    gameBoard.setInitializeBoard(true);
//                    gameBoard.repaint();
//                    count = 0;
//
//                    //continue;
//
//                } else {
//                    game = false;
//                    gameBoard.clearGame();
//                    gameBoard.thanksPlay();
//                    //gameBoard.repaint();
//                    //break;
//                }
//
//            }
//            count += 1;
//
//            // prompts user to enter next guess
//
//
//        //}
//    }
}







