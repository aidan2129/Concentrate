/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concentrate;

import static concentrate.Concentrate.Point;

/**
 *
 * @author Aidan
 */
public class ScoresTest {

    /**
     * @param args the command line arguments
     */
    public static String name;
    public static void main(String[] args) {
        HighscoreManager hm = new HighscoreManager();
        name = "hello world";
        Point = 70;
        if(name.length() < 20){
            hm.addScore(name,Point);
        }else{
            System.out.println("Sorry this name is to long" );
        }
    }
    
}
