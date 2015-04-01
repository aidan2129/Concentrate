/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Aidan
 */
/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Submit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jButton1)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
*/


package concentrate;

import static concentrate.HighscoreManager.scores;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    public Leaderboard(){   
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
    public void createGUI() 
    {           

        textArea = new JTextArea(hm.getHighscoreString());
        textArea.setEditable(false);
        pack();
     
    }    
    //below creates the main panel for the textarea to populate
    public void createpanels(){
        mainPnl.setLayout(new GridLayout(10, 1));   
        mainPnl.add(textArea);
        window.add(mainPnl, BorderLayout.CENTER);
        window.setLocation(800, 400); 
    }  

    private static final Logger LOG = Logger.getLogger(Concentrate.class.getName());

    //main class made for testing my leaderboards code output 
    public static void main(String[] args){  
        Leaderboard Leaderboard = new Leaderboard(); 
        HighscoreManager hm = new HighscoreManager();
        System.out.print(hm.getHighscoreString());
    }

    //actionPreformed is not nesscasary in this section as there are no additional
    //buttons in the leaderboard but is an abstract method so must be featured
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
