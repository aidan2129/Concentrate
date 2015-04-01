/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;


import static concentrate.Concentrate.updateScore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Aidan
 */
public class Card extends JButton implements ActionListener {
    public ImageIcon bgImg;
    public ImageIcon faceImg;
    public int cardVal;
    private boolean faceUp;
    public int width;
    public int height;

    public Card(int cardNum)
    {
        cardVal  = cardNum + 1;
        faceUp = true;
        this.addActionListener(this);
        try
        {
            faceImg = new javax.swing.ImageIcon(getClass().getResource("/resources/images/c" + cardVal + ".gif"));
            bgImg = new javax.swing.ImageIcon(getClass().getResource("/resources/images/b1fv.gif"));
        }
        catch(Exception e){
            System.out.println("image could not be found");
        }
        setActionCommand(String.valueOf(cardVal));
        setIcon(bgImg);
    }  
    
    @Override
    public int getWidth()
    {
        return bgImg.getIconWidth();
    }
    
    @Override
    public int getHeight()
    {
        return bgImg.getIconHeight();
    }

 
    public int getNumber()
    {
        return cardVal;
    }
    
    public void setFaceUp(){
        setIcon(faceImg);
        faceUp = true;
    }
    
    public void setFaceDown(){
        setIcon(bgImg);
        faceUp = false;
    }    
    
    public boolean faceUp(){
        return faceUp;
    }
    
    @Override
    public String toString()
    {
        return "Num: " + cardVal + "; " + super.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
