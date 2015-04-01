/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;

import static concentrate.Concentrate.Point;
import static concentrate.Score.nameField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Aidan
 */
public class NamePrompt extends JFrame{
    public static JButton submit = new JButton("Submit");
    public NamePrompt(){
        JFrame prompt = new JFrame("Prompt");
        setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel("Please Enter your name for the leaderboard:");
        JPanel panelTop = new JPanel();
        panelTop.add(nameLabel);
        panelTop.add(nameField);
        submit.addActionListener(new SubmitButton(nameField));
        submit.addKeyListener(new SubmitButton(nameField));
        JPanel panelBottom = new JPanel();
        panelBottom.add(submit);
        //Add panelTop to JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        //JFrame set-up
        setTitle("Enter your Name");
        pack();
        setLocationRelativeTo(null);
        
    }
    
    public void actionPerformed(ActionEvent submitClicked) {
        submit.setEnabled(false);
    }

    public static void main(String[] args) {
        if(Point > 0){
            NamePrompt promptForName = new NamePrompt();
            promptForName.setVisible(true);
        }

    }
}