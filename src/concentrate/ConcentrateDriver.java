/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aidan
 */

package concentrate;


import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class ConcentrateDriver
{
    private Concentrate game;
    private GameButtonPanel panel;

    private GameButtonListener buttonListener;
    
    public ConcentrateDriver(String frameTitle)
    {
        panel = new GameButtonPanel();
        game = panel.game;
        
        SwingUtilities.invokeLater(
            new Runnable()
            {
                public void run(){
                    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
                    createGUI();
                }
            });
    }
    

     public void createGUI() {  

    }
    
    public static void main(String[] args)
    {
        ConcentrateDriver driver = new ConcentrateDriver("Concentrate");
        driver.game.playGame();
        System.exit(0);
    }
}