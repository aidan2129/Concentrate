/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Aidan
 */

//below is the panel taht all the buttons will be displayed on
public class GameButtonPanel extends JPanel {

  Concentrate game;

  public GameButtonPanel(ArrayList<Card> shuffleButtons) {
    int numPerLine = (int) (Math.sqrt(Concentrate.numCards));

    setLayout(new GridLayout(numPerLine, numPerLine));
    setOpaque(false);
  }

  public GameButtonPanel() {
    int numPerLine = (int) (Math.sqrt(Concentrate.numCards));

    setLayout(new GridLayout(numPerLine, numPerLine));
    setOpaque(false);
  }
}
