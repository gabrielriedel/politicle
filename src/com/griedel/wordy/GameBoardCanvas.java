package com.griedel.wordy;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class GameBoardCanvas extends Canvas {
    private final Wordy w;
    //private final GameController c;
    private String mainTitle;
    private int x;
    private int y;
    private int tempX;
    private boolean initializeBoard = false;
    private boolean youLose;
    private boolean youWin;
    private boolean clearGame;
    private boolean thanksPlay;
    private boolean wrongSize;
    private Map<String, Integer> hm;


    // private String guess;
    private String word;
    private ArrayList<String> guesses;

    public GameBoardCanvas(Wordy w) {
        this.w = w;

    }

    public void setInitializeBoard(boolean b) {
        this.initializeBoard = b;
        this.guesses = new ArrayList<String>();
        this.hm = new HashMap<String, Integer>();
        createMapX();
        createMapY();

    }

    public void mainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public void youLose() {
        this.youLose = true;
    }

    public void paintMainTitle(Graphics g, String mainTitle) {

        // Setting font and title for main game title
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimeNewRoman", Font.PLAIN, 20));
        g.drawString(mainTitle, 150, 20);
    }

    public void drawKeyboardChars(Graphics g)
    {
        int x = 59;
        int y = 435;
        g.drawString("q", x, y);
        x += 30;
        g.drawString("w", x-1, y+1);
        x += 30;
        g.drawString("e", x, y+1);
        x += 30;
        g.drawString("r", x+1, y+1);
        x += 30;
        g.drawString("t", x+1, y+1);
        x += 30;
        g.drawString("y", x, y);
        x += 30;
        g.drawString("u", x, y+1);
        x += 30;
        g.drawString("i", x+2, y+3);
        x += 30;
        g.drawString("o", x, y+1);
        x += 30;
        g.drawString("p", x, y);
        x =74;
        y = 465;
        g.drawString("a", x, y);
        x += 30;
        g.drawString("s", x, y);
        x += 30;
        g.drawString("d", x, y+2);
        x += 30;
        g.drawString("f", x+1, y+2);
        x += 30;
        g.drawString("g", x, y-1);
        x += 30;
        g.drawString("h", x, y+2);
        x += 30;
        g.drawString("j", x+2, y);
        x += 30;
        g.drawString("k", x, y+2);
        x += 30;
        g.drawString("l", x+2, y+3);
        x = 100;
        y = 495;
        g.drawString("z", x+3, y);
        x += 30;
        g.drawString("x", x+3, y);
        x += 30;
        g.drawString("c", x+4, y);
        x += 30;
        g.drawString("v", x+4, y);
        x += 30;
        g.drawString("b", x+4, y+2);
        x += 30;
        g.drawString("n", x+4, y);
        x += 30;
        g.drawString("m", x, y);




    }

    public void createMapX()
    {
        // First row of char map
        hm.put("Q", 55);
        hm.put("W", 85);
        hm.put("E", 115);
        hm.put("R", 145);
        hm.put("T", 175);
        hm.put("Y", 205);
        hm.put("U", 235);
        hm.put("I", 265);
        hm.put("O", 295);
        hm.put("P", 325);
        //Second row of char map
        hm.put("A", 70);
        hm.put("S", 100);
        hm.put("D", 130);
        hm.put("F", 160);
        hm.put("G", 190);
        hm.put("H", 220);
        hm.put("J", 250);
        hm.put("K", 280);
        hm.put("L", 310);
        //Third row of char map
        hm.put("Z", 100);
        hm.put("X", 130);
        hm.put("C", 160);
        hm.put("V", 190);
        hm.put("B", 220);
        hm.put("N", 250);
        hm.put("M", 280);

    }

    public void createMapY()
    {
        // First row of char map
        hm.put("Qa", 420);
        hm.put("Wa", 420);
        hm.put("Ea", 420);
        hm.put("Ra", 420);
        hm.put("Ta", 420);
        hm.put("Ya", 420);
        hm.put("Ua", 420);
        hm.put("Ia", 420);
        hm.put("Oa", 420);
        hm.put("Pa", 420);
        //Second row of char map
        hm.put("Aa", 450);
        hm.put("Sa", 450);
        hm.put("Da", 450);
        hm.put("Fa", 450);
        hm.put("Ga", 450);
        hm.put("Ha", 450);
        hm.put("Ja", 450);
        hm.put("Ka", 450);
        hm.put("La", 450);
        //Third row of char map
        hm.put("Za", 480);
        hm.put("Xa", 480);
        hm.put("Ca", 480);
        hm.put("Va", 480);
        hm.put("Ba", 480);
        hm.put("Na", 480);
        hm.put("Ma", 480);

    }

    public boolean containsMultiple(String word)
    {
        int count = 0;
        for(int i = 0; i < word.length(); i++)
        {
            for(int k = 0; k < word.length(); k++) {
                if (word.charAt(i) == word.charAt(k)) {
                    count += 1;
                }
            }
            count -= 1;
        }
        if (count > 1)
            return true;
        else
            return false;
    }

    public int quantityContainsChars(String guess, String a)
    {
        int count = 0;
     for(int i = 0; i < guess.length(); i++){
         if(guess.charAt(i) == guess.charAt(guess.indexOf(a)))
         {
          count++;
         }
     }
     return count;
    }


    private void drawBoard(Graphics g, String word) {
        int width = 40;
        int height = 40;
        int b = 50;
        int row = 5;
        int dif = word.length() - 5;
        int dist = dif * 20;
        int a = 80 - dist;
        int temp = a;
        int difRemove = 20 * dif;
        this.x = 95 - difRemove;
        tempX = x;
        this.y = 75;
        if(word.length() > 6)
        {
            row = 6;
        }
        if (word.length() == 7) {
            a = 30;
            temp = a;
            x = 45;
            tempX = 45;

        }
        for (int i = 0; i <= row; i++) {
            for (int k = 0; k < word.length(); k++) {
                g.drawRect(a, b, width, height);
                a += 50;
            }
            a = temp;
            b += 50;
        }

        int w = 55;
        int z = 420;
        for (int k = 0; k <= 9; k++)
        {
         g.drawRect(w, z, 20, 20);
         w+=30;
        }
        w = 70;
        z= 450;
        for (int k = 0; k <= 8; k++)
        {
            g.drawRect(w, z, 20, 20);
            w+=30;
        }
        w = 100;
        z = 480;
        for (int k = 0; k <= 6; k++)
        {
            g.drawRect(w, z, 20, 20);
            w+=30;
        }
        drawKeyboardChars(g);


//        g.drawString("q", w, z);
//        int
    }

    public static boolean isInDictionary(String word, Scanner dictionary){

        ArrayList<String> dictionaryList = new ArrayList<String>();
        for(int i = 0; dictionary.hasNextLine() != false; i++){
            ++i;
            dictionaryList.add(dictionary.nextLine());
            System.out.println(dictionaryList.get(i));
            if(dictionaryList.get(i) == word){
                return true;
            }
        }

        return false;

    }

    public boolean isInList(String guess) throws java.io.IOException
    {
        File f1=new File("5word.txt"); //Creation of File Descriptor for input file
        String[] words=null;  //Intialize the word Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        String input = guess;   // Input word to be searched
        int count=0;   //Intialize the word to zero
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            //s = br.readLine();
            words=s.split(" ");  //Split the word using space
            for (String test : words)
            {

                test = test.toUpperCase(Locale.ROOT);
                if (test.equals(input))   //Search for the given word
                {
                    count++;    //If Present increase the count by one
                }
            }
        }
        fr.close();
        if(count!=0)  //Check for count not equal to zero
        {
            return true;
        }
        else
        {
            return false;
        }



    }

    public boolean validWord(String guess) throws FileNotFoundException {
        //try {
            if(isInDictionary(guess, new Scanner(new File("5word.txt")))){
                return true;
            }
            else
                return false;
       // }
//        catch (FileNotFoundException e) {
//             TODO Auto-generated catch block
//            e.printStackTrace();
//
//        }

    }

    public boolean validWords(String guess)
    {
        Scanner dict = null;
        try {
        dict = new Scanner(new File("5word.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    };
        if(isInDictionary(guess, dict))
        {
            return true;
        }
        else
            return false;

    }


    public void tryGuess(String word, String guess) throws java.io.IOException {
        this.word = word;
        if(guess.length() == word.length() && isInList(guess)) {

            guesses.add(guess);
        }
        else
        {
            wrongSize();
        }
        if(guesses.size() >= 6)
        {
            youLose();
        }
    }

    public void youWin() {
        this.youWin = true;
    }

    public void wrongSize()
    {
        this.wrongSize = true;
    }

    public void setWordNull()
    {
        this.word = null;
    }

    public void drawWrongSize(Graphics g)
    {
        g.drawString("INVALID GUESS...TRY AGAIN", 60, 410);
    }

    private void drawYouLose(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("YOU LOSE...THE WORD WAS " + word, 30, 540);
        g.setColor(Color.BLACK);
        word  = null;
        g.drawString("Would you like to play again?", x = 60, y = 570);
    }

    private void drawYouWin(Graphics g) {
        if(word.length() == 5)
        {
            x= 38;
        }
        else if (word.length() == 6)
        {
            x= 30;
        }
        else if (word.length() == 7)
        {
            x= 25;
        }
        g.setColor(Color.GREEN);
        g.drawString("YOU WIN...THE WORD WAS " + word, x, 540);
        g.setColor(Color.BLACK);
        g.drawString("Would you like to play again?", x = 60, y = 570);
        word = null;
        //System.out.println("YOU WIN");
    }

    public void clearGame() {
        this.clearGame = true;

    }



    private void drawClearGame(Graphics g) {
        g.clearRect(0, 0, 400, 500);
    }

    public void thanksPlay() {
        this.thanksPlay = true;
    }

    private void drawThanksPlay(Graphics g) {
        g.drawString("Thank you for playing", 100, 100);
        g.drawString("Created by Gabe Riedel", 90, 200);
        g.drawString("Class of 2022", 130, 225);
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    private void drawCharacters(Graphics g, String word, ArrayList<String> guesses) {
        String tempChar;
        String tempChar2;
        String tempLetter;

      //  System.out.println(containsMultiple(word));


        for (String guess: guesses) {
            String tempGuess = guess;
            int countDuplicates = 0;

            for (int i = 0; i < word.length(); i++) {
                String letter = guess.substring(i, i+1);

                g.setColor(Color.BLACK);
//                tempChar = guess.substring(i, i+1);
//                tempChar2 = guess.substring(i, i+1) + "a";
                int tempLocationX = hm.get(letter);
                int tempLocationY = hm.get(letter + "a");
                if (word.contains(letter)) {

                    if (word.charAt(i) == guess.charAt(i)) {
                        countDuplicates++;
                        g.setColor(Color.GREEN);
                        g.drawString(letter, x, y);
                        g.fillRect(tempLocationX,tempLocationY, 20, 20);
                        g.setColor(Color.BLACK);
                        drawKeyboardChars(g);
                        tempChar = "d";
                        tempChar2 = "da";



                    } else {
                        if(quantityContainsChars(word, letter) >= quantityContainsChars(guess, letter)) {
                            g.setColor(Color.ORANGE);
                            g.drawString(letter, x, y);
                            g.fillRect(tempLocationX, tempLocationY, 20, 20);
                            g.setColor(Color.BLACK);
                            drawKeyboardChars(g);
                        }
                        else
                        {
                         countDuplicates++;
                         System.out.println("Count Duplicates: " + countDuplicates);
                         if(countDuplicates <= quantityContainsChars(word, letter)) {
                             g.setColor(Color.ORANGE);
                             g.drawString(letter, x, y);
                             g.fillRect(tempLocationX, tempLocationY, 20, 20);
                             g.setColor(Color.BLACK);
                             drawKeyboardChars(g);
                         }
                         else
                         {
                             g.setColor(Color.BLACK);
                             g.drawString(letter, x, y);
                             g.setColor(Color.GRAY);
                             g.fillRect(tempLocationX,tempLocationY, 20, 20);
                             g.setColor(Color.BLACK);
                             drawKeyboardChars(g);
                         }
                        }
                    }
                } else {
                    g.setColor(Color.BLACK);
                    g.drawString(letter, x, y);
                    g.setColor(Color.GRAY);
                    g.fillRect(tempLocationX,tempLocationY, 20, 20);
                    g.setColor(Color.BLACK);
                    drawKeyboardChars(g);

                }
                x += 50;

            }
            y += 50;
            x = tempX;
        }
    }

    public void paint(Graphics g) {

        if (clearGame) {
            drawClearGame(g);
            clearGame = false;
        }

        // Setting font and title for main game title
        if (initializeBoard) {
            drawClearGame(g);
            paintMainTitle(g, mainTitle);
            drawBoard(g, word);
            initializeBoard = false;
        }
        paintMainTitle(g, mainTitle);
        if(word != null) {
            drawBoard(g, word);
        }


//        for (eachguess:eacguesslist) {
//            drawBoard(g, eachguess);
//        }

        if (word != null && !guesses.isEmpty()) {
            drawCharacters(g, word, guesses);
            //word = null;
        }

        if (youWin) {
            youLose = false;
            drawYouWin(g);
            youWin = false;
        }

        if (youLose) {
            drawYouLose(g);
            youLose = false;
        }

        if(wrongSize)
        {
            drawWrongSize(g);
            wrongSize = false;
        }



        if (thanksPlay) {
            drawThanksPlay(g);
            thanksPlay = false;
        }

    }
}



