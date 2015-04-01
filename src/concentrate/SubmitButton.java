/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;
import static concentrate.Concentrate.Point;
import static concentrate.Concentrate.gameBtn;
import static concentrate.HighscoreManager.scores;
import static concentrate.NamePrompt.submit;
import static concentrate.Score.nameField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//below is the submit button use in the name prompt to get the players name or set it to anonymus
public class SubmitButton implements ActionListener, KeyListener {

 
    JTextField nameInput;//the textfield the user will type their name into 

    public SubmitButton(JTextField nameField){

        
    }

    @Override
    public void actionPerformed(ActionEvent submitClicked) {
        HighscoreManager hm = new HighscoreManager();
        
        //the if else statement checks if the textbox is populated and if it is empty
        //replace the players name with anonymus
        if(nameField.getText().equals("")){
            String name = nameField.getText();
            hm.addScore("Anonymous",Point); 
        }
        else{
            String name = nameField.getText();
            hm.addScore(name,Point); 
        }
    }
 
  @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(null , "You've Submitted the name " + nameField.getText());
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}