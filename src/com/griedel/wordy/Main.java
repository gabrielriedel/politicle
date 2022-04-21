package com.griedel.wordy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {
        Main m = new Main();
        JFrame f = new JFrame();
        f.setEnabled(true);
        JPanel p = new JPanel();
        p.setRequestFocusEnabled(true);
        p.setEnabled(true);
        f.setSize(400, 700);
        f.add(p);
        p.setSize(400, 700);
        JPanel gamePanel = new JPanel();
        Wordy w = new Wordy("junk");
        GameBoardCanvas canvas = new GameBoardCanvas(w);
        canvas.setSize(400, 575);
        gamePanel.setSize(400, 575);
        gamePanel.add(canvas);
        gamePanel.setBackground(Color.WHITE);
        JPanel inputPanel = new JPanel();
        JButton yes = new JButton("YES");
        //yes.setBounds(50,50, 40, 40);
        JButton no = new JButton("NO");
        // yes.setBounds(50,80, 40, 40);
        // inputPanel.setSize(400, 200);
        // inputPanel.setBackground(Color.GRAY);


        JTextField inputField = new JTextField(7);

        //inputField.setColumns(7);
        //inputField.setText();
        //inputField.setFocusable(true);
        //inputField.setEditable(true);
        //inputField.setEnabled(true);

        //inputPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        //f.setFocusableWindowState(true);
        inputField.setBounds(200, 400, 10, 100);
        inputPanel.add(inputField);
        //inputPanel.setEnabled(true);
        //inputPanel.setRequestFocusEnabled(true);

//        inputField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                System.out.println("The entered text is: " + inputField.getText());
//            }
//        });


        //inputField.setVisible(true);

        p.add(inputPanel);
        p.add(gamePanel);
        p.add(yes);
        p.add(no);


        GameController game = new GameController(canvas);

        p.setVisible(true);
        f.setVisible(true);
        String wordle = game.newGame();
//        String wordle = game.setGovWord();

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)  {
                String temp = inputField.getText();
                System.out.println(temp);
                try {
                    game.tryNewGuess(temp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputField.setText("");

            }
        });

        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("YES BUTTON CLICKED");
                //  game.newGame();
//                canvas.setWord(word);
                canvas.setInitializeBoard(true);
                game.setGovWord();

                canvas.repaint();
            }
        });

        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("NO BUTTON CLICKED");
                canvas.setWordNull();
                canvas.clearGame();
                canvas.thanksPlay();
                canvas.repaint();
            }
        });

        //game.play();
        // inputField.requestFocusInWindow();
        //inputField.requestFocus();
        //inputField.setCaret(new DefaultCaret());
        //inputField.setCaretPosition(inputField.getDocument().getLength() - 1);

//        f.addWindowListener( new WindowAdapter() {
//            public void windowOpened( WindowEvent e ){
//                inputField.requestFocus();
//                inputField.setEnabled(true);
//                inputField.setEditable(true);
//            }
//        });

//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                inputField.grabFocus();
//                inputField.requestFocus();//or inWindow
//            }
//        });


    }


}

