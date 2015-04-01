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

import static concentrate.NamePrompt.submit;
import java.io.*;
import java.util.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
//this is the main class that manages the class and creates, updates and retrives the scores in a file
public class HighscoreManager {
    //the arraylist sets how the scores should be stored
    public static ArrayList<Score> scores;
    //this variable below sets the scores data file name for the scores to be stored
    private static final String HIGHSCORE_FILE = "scores.dat";


    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager() {
        scores = new ArrayList<>();
    }
    
    //the load score file function loads the score file to retrive the data from it
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }
    
    public void updateScoreFile() {
            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
                outputStream.writeObject(scores);
            } catch (FileNotFoundException e) {
                System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
            } catch (IOException e) {
                System.out.println("[Update] IO Error: " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("[Update] Error: " + e.getMessage());
                }
            }
    }
    
    //sort is calling on the sortComparotor class to set and organise scores
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    
    
    public void addScore(String name, int score) {
        if(name.length() < 20){
            loadScoreFile();
            scores.add(new Score(name, score));
            updateScoreFile();
            Leaderboard Leaderboard = new Leaderboard(); 
            Leaderboard.dispose();
            NamePrompt promptForName = new NamePrompt();
            promptForName.setEnabled(false);
            submit.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "The name you have Entered is to long keep it under 20 characters", "Concentration ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    
    public String getHighscoreString() {
        String highscoreString = "";
	int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
}

