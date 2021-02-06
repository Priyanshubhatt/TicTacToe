/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Programmer:  Priyanshu Bhatt
 * Date:  Monday, October 26, 2020
 * Program Name:  Tic Tac Game
 * Program Description: This is a tic tac toe game. Its like a classic 
 * game of tic tac toe, that keeps track of the score of the player, along
 * with the ties. It also has a reset button to reset the scores Each game 
 * has its own twist to show each programmers personality, along with their 
 * programming skills. My display has a glitchy theme, that is because
 * I am a fan of editing photos and videos, and adding these glitchy
 * effects to them. 
 */

import java.awt.*;
import javax.swing.*;

// setup TicTac board
public class TicTac extends JFrame {

    int winsX = 0;
    int winsO = 0;
    int ties = 0;

    JPanel row1 = new JPanel();                                            //initialize board and arrays
    JButton[][] boxes = new JButton[3][3];                                 //array of buttons!
    JTextArea blank = new JTextArea();                                     //where the total wins go
    JOptionPane win = new JOptionPane("Winner");             
    ImageIcon back = new ImageIcon("backgroundTicTac.jpg");                //image for the button
    Button resetB = new Button("Reset");                                   //reset button to reset stats
    

    // different option of setting up grid of buttons
    public TicTac(int xInc, int oInc, int tInc) {
        
        super("Tic Tac Toe");
        
        winsX = winsX + xInc;                                             //stores the number of wins
        winsO = winsO + oInc;
        ties = ties + tInc;
        
        TicTacEvent tictac = new TicTacEvent(this,winsX,winsO,ties);     //run the TicTacEvent object in background
        
        setSize(750, 900);                                               //sets the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int name = 0;
        String newname;

        FlowLayout layout1 = new FlowLayout(4, 50, 50);                  //layout of the frame
        row1.setLayout(layout1);                                         //sets the layout

        for (int x = 0; x <= 2; x++) {                                   //creates and adds the buttons
            for (int y = 0; y <= 2; y++) {
                name = name + 1;
                newname = Integer.toString(name);
                boxes[x][y] = new JButton(newname);
                boxes[x][y].setIcon(back);
                boxes[x][y].setPreferredSize(new Dimension(175,175));   //sets the size of buttone
                row1.add(boxes[x][y]);                                  //displays the boxes
            }
        }
        
        blank.setText("Number of X Wins: 0" + "\n");               //Displays the lines
        blank.append("Number of Y Wins: 0" + "\n");
        blank.append("Number of Ties: 0" + "\n");
                
        blank.setPreferredSize(new Dimension(195,85));             //sets the size of the frame
        row1.add(blank);                                           //add the text area to the display

        resetB.addActionListener(tictac);                          //gets informed if button was pressed
        resetB.setPreferredSize(new Dimension(50,25));             //sets size
        row1.add(resetB);                                          //adds reset button

        add(row1);                                                 //this adds everything together
        
        
        for (int x = 0; x <= 2; x++) {                             //for loop to get informed what button got clicked
            for (int y = 0; y <= 2; y++) {
                boxes[x][y].addActionListener(tictac);             //makes the program ready to handle mouse clicks
            }
        }
        setVisible(true);                                          //shows the FlowLayout on the screen
    }
    

    public static void main(String[] arguments) {
        TicTac frame = new TicTac(0,0,0);                          //runs the screen layout class
    }
}
