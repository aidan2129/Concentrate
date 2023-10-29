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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public final class Leaderboard extends JFrame implements ActionListener {

  HighscoreManager hm = new HighscoreManager();
  private final JFrame window = new JFrame("Concentrate");
  private static final int WINDOW_WIDTH = 400;
  private static final int WINDOW_HEIGHT = 250;
  private final Panel mainPnl = new Panel();
  JPanel pane = new JPanel();
  JScrollPane scrollPane;
  JTextArea textArea = new JTextArea(50, 80);
  JTabbedPane tabbedPane = new JTabbedPane();

  //below is the leaderboard function which creates the gui and the panel for the leaderboard
  public Leaderboard() {
    createGUI();
    createpanels();
    window.setLayout(new BorderLayout());
    window.setTitle("Leaderboard");
    window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    window.setResizable(false);
    window.setVisible(true);
    pane.setLayout(new BorderLayout());
    scrollPane = new JScrollPane(textArea);
    pane.add(scrollPane, BorderLayout.CENTER);
    tabbedPane.addTab("Scores", null, pane, "");
    window.add(tabbedPane);
  }

  //this is the create gui function which sets the textares the scores will be displayed on
  public void createGUI() {
    textArea = new JTextArea(hm.getHighscoreString());
    textArea.setEditable(false);
    pack();
  }

  //below creates the main panel for the textarea to populate
  public void createpanels() {
    mainPnl.setLayout(new GridLayout(10, 1));
    mainPnl.add(textArea);
    window.add(mainPnl, BorderLayout.CENTER);
    window.setLocation(800, 400);
  }

  public static void main(String[] args) {
    new Leaderboard();
    HighscoreManager hm = new HighscoreManager();
    System.out.print(hm.getHighscoreString());
  }

  //actionPreformed is not nesscasary in this section as there are no additional
  //buttons in the leaderboard but is an abstract method so must be featured
  @Override
  public void actionPerformed(ActionEvent ae) {}
}
