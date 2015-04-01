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
import java.io.Serializable;
import javax.swing.JTextField;
//this method allows you to get your current score
public class Score  implements Serializable {
    public static JTextField nameField = new JTextField(21);

    static String get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final int score;
    private final String name;
    
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }
} 