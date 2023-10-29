/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;

/**
 *
 * @author Aidan
 */
import static concentrate.Concentrate.updateScore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

//this is a custom button listner which is added to each button to allow
//me to add a waiting stage and cause the delay between the first and
//the second button that is pressed
public class GameButtonListener implements ActionListener {

  public Card button; // Button that was pressed
  public Object lock; // Object used to synchronize the button
  public boolean waiting; // Whether waiting for action or not

  public GameButtonListener() {
    lock = new Object();
  }

  /*
   * Gets the reference to the button that was clicked on.
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    button = (Card) event.getSource();
    waiting = false;

    synchronized (lock) {
      lock.notifyAll();
    }
    updateScore();
  }

  public JButton waitForButton() {
    waiting = true;
    try {
      synchronized (lock) {
        while (waiting == true) lock.wait();
      }
    } catch (InterruptedException e) {}
    return button;
  }
}
