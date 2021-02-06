
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* Author:  Mr. J. Merritt (adapted from old eLearning version)

/*Class TicTacEvent basically runs the game.
Sets up listeners for the game (thread to run game), changes icons,
checks for tic-tac-toes, determines the winner
 */
public class TicTacEvent implements ItemListener, ActionListener, Runnable {

    TicTac gui;                                         // object for the GUI
    ImageIcon a = new ImageIcon("XTicTac.jpg");         // pics
    ImageIcon b = new ImageIcon("OTicTac.jpg");
    int clicks = 0;                                     // how many clicks have occured
    int win = 0;                                        // is it a win yet?
    int[][] check = new int[3][3];                      // 2D array to check
    int winsX ;                                         // gets the wins for x
    int winsO ;                                         // gets the wins for o
    int ties ;                                          // gets the ties

    // initialize TicTac game
    public TicTacEvent(TicTac in,int xInc,int oInc,int tInc) {          //associates the two files to be used together
        winsX = xInc;                                                   //gives xInc a value so it can be used in displaying
        winsO = oInc;                                                   //gives oInc a value so it can be used in displaying
        ties = tInc;                                                    //gives tInc a value so it can be used in displaying
        gui = in;
        for (int row = 0; row <= 2; row++) {                            // initialize check 2D array to 0's
            for (int col = 0; col <= 2; col++) {
                check[row][col] = 0;
            }
        }
    }

    // if an action occurs on a button
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("1")) {           // options for each button 1-9
            b1();
        }
        if (command.equals("2")) {
            b2();
        }
        if (command.equals("3")) {
            b3();
        }
        if (command.equals("4")) {
            b4();
        }
        if (command.equals("5")) {
            b5();
        }
        if (command.equals("6")) {
            b6();
        }
        if (command.equals("7")) {
            b7();
        }
        if (command.equals("8")) {
            b8();
        }
        if (command.equals("9")) {
            b9();
        }
        
        if (command.equals("Reset")) {       // this resets the following variables if button is pressed
            winsX = 0;
            winsO = 0;
            ties = 0;
            display();
            
        }
        
    }
    
    

    // doc only b1 -- set icon to x or o
    void b1() {
        clicks = clicks + 1;                // count clicks
        if ((clicks % 2) == 1) {
            gui.boxes[0][0].setIcon(a);     // set to x or y
            check[0][0] = 1;
        } else {
            gui.boxes[0][0].setIcon(b);     //check 2D array determines if x or o
            check[0][0] = 2;
        }
        winner();                           // call to determine if a winner
    }

    void b2() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[0][1].setIcon(a);
            check[0][1] = 1;
        } else {
            gui.boxes[0][1].setIcon(b);
            check[0][1] = 2;
        }
        winner();
    }

    void b3() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[0][2].setIcon(a);
            check[0][2] = 1;
        } else {
            gui.boxes[0][2].setIcon(b);
            check[0][2] = 2;
        }
        winner();
    }

    void b4() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[1][0].setIcon(a);
            check[1][0] = 1;
        } else {
            gui.boxes[1][0].setIcon(b);
            check[1][0] = 2;
        }
        winner();
    }

    void b5() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[1][1].setIcon(a);
            check[1][1] = 1;
        } else {
            gui.boxes[1][1].setIcon(b);
            check[1][1] = 2;
        }
        winner();
    }

    void b6() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[1][2].setIcon(a);
            check[1][2] = 1;
        } else {
            gui.boxes[1][2].setIcon(b);
            check[1][2] = 2;
        }
        winner();
    }

    void b7() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[2][0].setIcon(a);
            check[2][0] = 1;
        } else {
            gui.boxes[2][0].setIcon(b);
            check[2][0] = 2;
        }
        winner();
    }

    void b8() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[2][1].setIcon(a);
            check[2][1] = 1;
        } else {
            gui.boxes[2][1].setIcon(b);
            check[2][1] = 2;
        }
        winner();
    }

    void b9() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            gui.boxes[2][2].setIcon(a);
            check[2][2] = 1;
        } else {
            gui.boxes[2][2].setIcon(b);
            check[2][2] = 2;
        }
        winner();
    }

    // determine winner...look for 3 x's or 3 o's
    void winner() {
        for (int x = 0; x <= 2; x++) {
            if ((check[x][0] == check[x][1]) && (check[x][0] == check[x][2])) {
                if (check[x][0] == 1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");
                    win = 1;
                    winsX = winsX + 1;                      //this tallys the number of wins 
                    display ();
                    
                } else if (check[x][0] == 2) {
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    winsO = winsO + 1;                      //this tallys the number of wins 
                    display ();
                }
            }
        }

        for (int x = 0; x <= 2; x++) {
            if ((check[0][x] == check[1][x]) && (check[0][x] == check[2][x])) {
                if (check[0][x] == 1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");
                    win = 1;
                    winsX = winsX + 1;                      //this tallys the number of wins 
                    display ();
                } else if (check[0][x] == 2) {
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    winsO = winsO + 1;                      //this tallys the number of wins 
                    display ();                
                }
            }
        }

        if (((check[0][0] == check[1][1]) && (check[0][0] == check[2][2]))
                || ((check[2][0] == check[1][1]) && (check[1][1] == check[0][2]))) {
            if (check[1][1] == 1) {
                JOptionPane.showMessageDialog(null, "X is the winner");
                win = 1;
                winsX = winsX + 1;                      //this tallys the number of wins 
                display ();
                
            } else if (check[1][1] == 2) {
                JOptionPane.showMessageDialog(null, "O is the winner");
                win = 1;
                winsO = winsO + 1;                      //this tallys the number of wins 
                display ();            
            }
        }
        // no win but clicks is 9...tie game
        if ((clicks == 9) && (win == 0)) {
            JOptionPane.showMessageDialog(null, "The game is a tie");
            ties = ties + 1;                           //this tallys the number of ties 
            display ();
        }
    }

    
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int display ()                                            //this displays the x and o wins, and the ties
    {    
        int displayVal = 0;
        
        TicTac test = new TicTac(winsX,winsO,ties);                  //this allows the data to be used
        test.blank.setText("Number of X Wins: 0" + winsX + "\n");
        test.blank.append("Number of O Wins: 0" + winsO + "\n");
        test.blank.append("Number of Ties: " + ties + "\n");
        
        return displayVal;    
    }
    
}
