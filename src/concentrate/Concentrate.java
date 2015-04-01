/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aidan
 */
/*public class Concentrate extends javax.swing.JFrame {
  

    public Concentrate() {
        myInitComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void myInitComponents(){
        
    
    }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Concentrate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
*/

package concentrate;
import static concentrate.HighscoreManager.scores;
import static concentrate.Score.nameField;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Logger;
import javax.swing.*;


public final class Concentrate extends JFrame implements ActionListener {  
    //below are all the variables declared for the gui and the game program itself
    
    private final JFrame window = new JFrame("Concentrate");
    private  final int WINDOW_WIDTH = 330; 
    private  final int WINDOW_HEIGHT = 485; 
    private JButton exitBtn, scoresBtn;  
    public static ArrayList<Card> gameBtn;
    public static ArrayList<Card> currGameBtn;
    public static int Point = 46;//the number the the score starts from and goes down
    public static int numCards = 16;//num of cards that are in the game 
    public static JLabel Score;//label the scores text will be in
    public static GameButtonPanel gamePnl;//panel the cards will be displayed on
    private final Panel buttonPnl = new Panel(); //south panel the exit and scores button is on
    private final Panel scorePnl = new Panel(); //panel the sore will be displayed on 
    private GameButtonListener buttonListener; // Listener for the button actions

    Concentrate game;
  
    
    Random rand = new Random();
    private int cardVal = 16;


    //update score checks and sets the score on the main board 
    public static void updateScore() {
        Score.setText("Score: " + Point);

    }

    public Concentrate(){ 
        //below is calling the create gui function and set variables for it width and close operation
        createGUI();  
        createpanels(); 
        JOptionPane.showMessageDialog(null, "Welcome to Concentrate the aim of the game is to match "
                + "all 8 pairs of cards without missing a pair "
                + "to many times and see if you can get the highest score on the leaderboard."
                + " Click ok to Start the game", "Concentration " + CENTER, JOptionPane.INFORMATION_MESSAGE);     
        
        window.setTitle("Concentrate"); 
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
        window.setVisible(true);
        shuffleButtons();
        gamePnl = new GameButtonPanel();
        game = gamePnl.game;
        System.out.println(gamePnl);
        buttonListener = new GameButtonListener();
        
        // Adds each button to the actions listener
        for(Card c : gameBtn)
            c.addActionListener(buttonListener);//adds a buttonListner to each gameBtn
    }
    
    //createpanels sets diffrent panels within windows to add the
    //buttons and score on organised from top, main and bottom
    public void createpanels()
    {
        gameBtn = new ArrayList<>(numCards);
        gamePnl = new GameButtonPanel(shuffleButtons());
  
        //below adds the cards to the panel based on the number of them
        
        for(int i = 0; i < numCards; i++)
        {
            Card cb = new Card(i);
            gameBtn.add(cb); 
            
        }
        //below sets each of the card buttons a value they can compare each other to 
        gameBtn.get(0).setActionCommand("1");
        gameBtn.get(1).setActionCommand("2");
        gameBtn.get(2).setActionCommand("3");
        gameBtn.get(3).setActionCommand("4");
        gameBtn.get(4).setActionCommand("5");
        gameBtn.get(5).setActionCommand("6");
        gameBtn.get(6).setActionCommand("7");
        gameBtn.get(7).setActionCommand("8");
        gameBtn.get(8).setActionCommand("1");
        gameBtn.get(9).setActionCommand("2");
        gameBtn.get(10).setActionCommand("3");
        gameBtn.get(11).setActionCommand("4");
        gameBtn.get(12).setActionCommand("5");
        gameBtn.get(13).setActionCommand("6");
        gameBtn.get(14).setActionCommand("7");
        gameBtn.get(15).setActionCommand("8");

        
        buttonPnl.add(scoresBtn); 
        buttonPnl.add(exitBtn);
        //buttonPnl.add(resetButton);
        gamePnl.setLayout(new GridLayout(4, 4)); 
        buttonPnl.setLayout(new GridLayout(1, 0));
        scorePnl.add(Score);
        scorePnl.setLayout(new GridLayout(1, 0));
        window.add(scorePnl, BorderLayout.NORTH);
        window.add(gamePnl, BorderLayout.CENTER);
        window.add(buttonPnl, BorderLayout.SOUTH);
        window.setLocation(800, 400); 
        window.setResizable(false);
    }  
    
    public void createGUI() {  
        buttonListener = new GameButtonListener();
        Score = new JLabel("Score: " + Point);
        exitBtn = new JButton("Exit"); 
        exitBtn.addActionListener(this);
        scoresBtn = new JButton("Scores");  
        scoresBtn.addActionListener(this);
        
        //resetButton = new JButton("Reset"); 
        //resetButton.addActionListener(this);
    }   
    
    //Shuffle buttons takes the list of cards and shuffles them beofre they
    //are displayed on the panel
    public static ArrayList<Card> shuffleButtons() {
        Collections.shuffle(gameBtn);
        layoutButtons();
        return gameBtn;
    }
    
    public static void layoutButtons() {
        for (JButton button : gameBtn) {
            gamePnl.add(button);
        }
    }
    
    
    
    //the code below is for the lower menu buttons
    @Override
    public void actionPerformed(ActionEvent e) 
    {    
            //this is the exit button displayed onthe bottom of the gui
            if (exitBtn == e.getSource()) 
            { 
                System.exit(0);
            } 
            //this is the button at the botto of the gui which calls on the leaderboard frame
            if (scoresBtn == e.getSource()) 
            {     
                Leaderboard Leaderboard = new Leaderboard(); 
            }    
    } 
    

     
    //the playGame method sets all the game rules 
    public void playGame(){
        int PairsFound;
        JButton buttonPressed;//this uses my custom button listener to check which Card has been clicked on
        Card button1, button2; //this sets the two buttons that are to be compared
        
            PairsFound = 0;
            buttonPressed = null;
            // Loop until all the cards are matched.

            while(PairsFound != numCards / 2){
                
                // Wait for first card to be pressed
                buttonPressed = buttonListener.waitForButton();

                if(buttonPressed instanceof Card)
                {
                    button1 = (Card)buttonPressed;
                    button1.setFaceUp();
                }
                else
                {
                    if(buttonPressed.getActionCommand().equals(gameBtn))
                        System.out.println("button was"+ gameBtn +"pressed");
                    break;
                }
                
                // Wait for second card to be pressed
                buttonPressed = buttonListener.waitForButton();
                
                if(buttonPressed instanceof Card)
                {
                    button2 = (Card)buttonPressed;
                    button2.setFaceUp();
                    try {
                        Thread.sleep(700);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                else
                {
                    break;
                }

                // Unflip the cards if they are not equals or if they are the
                // same card (if they refer to the same object)
                if(button1.getActionCommand().equals(button2.getActionCommand())){
                    button1.setEnabled(false);// Hide the pair once found.
                    button2.setEnabled(false);
                    PairsFound++;
                }
                else
                {
                    ((Card)button1).setFaceDown();
                    ((Card)button2).setFaceDown();
                    Point = Point - 1;
                }
                                // If found all matching pairs.
                if(PairsFound == cardVal / 2)
                {
                    NamePrompt promptForName = new NamePrompt();
                    promptForName.setVisible(true); 
                    
                }
                if(Point == 0){
                    JOptionPane.showMessageDialog(null, "You have lost please try again", "Concentration ", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
    }

    private static final Logger LOG = Logger.getLogger(Concentrate.class.getName());

    public static void main(String[] args)
    {  
        Concentrate concentrate = new Concentrate(); 
        concentrate.playGame();
    }
}