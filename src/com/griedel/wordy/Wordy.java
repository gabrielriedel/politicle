package com.griedel.wordy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
public class Wordy extends JFrame{

    private final String word;
    public Wordy (String word)
    {
        this.word = word;
    }

    public void paint(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Enter a Government Word",90,20);
        int width = 40;
        int height = 40;
        int a = 80;
        int b = 50;
        for(int i = 0; i <= 5; i++)
        {
            g.drawRect(a, b, width, height);
            g.drawRect(a + 50, b, width, height);
            g.drawRect(a + 100, b, width, height);
            g.drawRect(a +150, b, width, height);
            g.drawRect(a + 200, b, width, height);
            b += 50;
        }


    }


    public void paint3(Graphics g){
        int a = 20;
        int b = 20;
        int x = 95;
        int y = 425;

        for(int i = 0; i <= 9; i++) {
            g.drawRect(a, b, x, y);
            x += 25;
        }
        y+= 25;
        x = 95;
        for(int k = 0; k <= 8; k++)
        {
            g.drawRect(a, b, x, y);
            x += 25;
        }

        y+= 25;
        x = 95;
        for(int j = 0; j <= 8; j++)
        {
            g.drawRect(a, b, x, y);
            x += 25;
        }

    }
    public boolean checkWin (String word, String guess)
    {
        if (word.equals(guess))
        {
            System.out.println();
            System.out.println("YOU GUESSED IT! THE WORD Was " + word);
            System.out.println();
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean checkWord(String guess)
    {
        return guess.length() == 5;
    }
    public void charLocation(String word, String guess, Graphics g)
    {
        int x = 100;
        int y = 70;

        for(int i = 0; i <= 4; i++)
        {
            if(word.contains(word.substring(i, i+1)))
            {
                if(word.charAt(i) == guess.charAt(i))
                {
                    g.setColor(Color.GREEN);
                    g.drawString(word.substring(i, i+1), x, y);
                }
                else
                {
                    g.setColor(Color.YELLOW);
                    g.drawString(word.substring(i, i+1), x, y);
                }
            }
            else
            {
                g.setColor(Color.BLACK);
                g.drawString(word.substring(i, i+1), x, y);
            }
            x += 50;
            y += 50;
        }
    }

    public void initUI(){
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static String randomWord() {
        Path filePath = Paths.get("GovWords");
        Charset charset = StandardCharsets.UTF_8;
        Random r = new Random();
        try
        {
            List<String> lines = Files.readAllLines(filePath, charset);
            int length = lines.size();
            int point = r.nextInt(lines.size());
            String word = lines.get(point);
            return word;
        }
        catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
            return "";
        }

    }




}