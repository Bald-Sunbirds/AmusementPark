package amusementpark_demo.com.baldsunbirds.controller;

import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import amusementpark_demo.com.baldsunbirds.entity.ButtonItem;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import javax.swing.ImageIcon;

public class MenuPanel extends JPanel {
    
    private GameFrame gf;
    private ImageIcon icon1,icon2;
    private JLabel text1,text2;
    public boolean hasItem=false;
    public float cost;
    public int index;
    public boolean isWorker=false;
    public boolean worker_index;
    
    public MenuPanel(GameFrame gf) {
        this.gf = gf;
    }
    
    public void init() {
        int btnX = 40;
        int btnY = 50;
        int btnW = 120;
        int btnH = 50;
        int no = 0;
        int gap = 25;
      
        JButton gameBtn = new JButton("Games");
        gameBtn.setBounds(btnX, btnY+(btnY + gap)*(no++), btnW, btnH);
        gameBtn.addActionListener((ActionEvent e) -> {
            try {
                games();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
	this.add(gameBtn);
        JButton gardenBtn = new JButton("Gardens");
        gardenBtn.setBounds(btnX, btnY+(btnY + gap)*(no++), btnW, btnH);
        gardenBtn.addActionListener((ActionEvent e) -> {
            try {
                gardens();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.add(gardenBtn);
        JButton restaurantBtn = new JButton("Restaurants");
        restaurantBtn.setBounds(btnX, btnY+(btnY + gap)*(no++), btnW, btnH);
        restaurantBtn.addActionListener((ActionEvent e) -> {
            try {
                restaurants();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.add(restaurantBtn);
        JButton pathBtn = new JButton("Paths");
        pathBtn.setBounds(btnX, btnY+(btnY + gap)*(no++), btnW, btnH);
        pathBtn.addActionListener((ActionEvent e) -> {
            try {
                paths();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.add(pathBtn);
        JButton hireBtn = new JButton("Hire");
        hireBtn.setBounds(btnX, btnY+(btnY + gap)*(no++), btnW, btnH);
              hireBtn.addActionListener((ActionEvent e) -> {
            try {
                hire();
            } catch (IOException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.add(hireBtn);
    }
    

  /**
   * pop a new window to display the building of games
   * @throws IOException 
   */
  public void games() throws IOException{

    JFrame frame1 = new JFrame("frame1");
    frame1.setLocation(200,50);
    frame1.setSize(500,500);
    frame1.setVisible(true);
    frame1.setBackground(Color.GREEN);
    
    // display the items
    ButtonItem btm1=new ButtonItem();
    ButtonItem btm2=new ButtonItem(); 
    btm1.setImage(Color.green,100,50,"data/game1.png");
    btm2.setImage(Color.blue,300,50,"data/game2.png");
    JPanel jp=new JPanel();
    jp.setLayout(null);
    jp.add(btm1.button);jp.add(btm2.button);
    frame1.add(jp);
    float price1=200,price2=250;
    btm1.setText("game1",price1,100,150);
    btm2.setText("game2",price2, 300, 150);
    jp.add(btm1.text);
    jp.add(btm2.text);

    
    // the action of selectin a game building
    btm1.button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //return the index of building that you click
            getAction(price1,frame1);
            index=8;
       }
    });
    btm2.button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getAction(price2,frame1);
        index=9;         
    }
    });
    
    var game1 = new JLabel("<html><body><p align=\\\"center\\\">A game support guests to play <br>"
            + "and you can gain 25$/person.</p></body></html>");
    game1.setBounds(90, 170, 180, 60);
    game1.setForeground(Color.red);
    jp.add(game1);
    
    var game2 = new JLabel("<html><body><p align=\\\"center\\\">A game support guests to play <br>"
            + "and you can gain 30$/person.</p></body></html>");
    game2.setBounds(290, 170, 180, 60);
    game2.setForeground(Color.red);
    jp.add(game2);
}
/**
 * pop a new window to display the building of restaurants
 * @throws IOException 
 */
  public void restaurants() throws IOException{JFrame frame1 = new JFrame("frame1");
    frame1.setLocation(200,50);
    frame1.setSize(500,500);
    frame1.setVisible(true);
    frame1.setBackground(Color.GREEN);
    
    // display the main items
    ButtonItem btm1=new ButtonItem();
    ButtonItem btm2=new ButtonItem(); 
    btm1.setImage(Color.green,100,50,"data/ice_cream_shop.png");
    btm2.setImage(Color.blue,300,50,"data/shop2.png");
    JPanel jp=new JPanel();
    jp.setLayout(null);
    jp.add(btm1.button);jp.add(btm2.button);
    frame1.add(jp);
    float price1=200,price2=250;
    btm1.setText("icecream shop",price1,100,150);
    btm2.setText("shop2",price2, 300, 150);
    jp.add(btm1.text);
    jp.add(btm2.text);
    
    // the action of selecting
    btm1.button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //return the index of building that you click
            getAction(price1,frame1);
            index=3;
       }
   });
    btm2.button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getAction(price2,frame1);
        index=2;         
   }
   });
  
    var icecream = new JLabel("<html><body><p align=\\\"center\\\">Build a icecream shop,<br>"
            + "and one cone will be sold 8$.</p></body></html>");
    icecream.setBounds(90, 170, 180, 60);
    icecream.setForeground(Color.red);
    jp.add(icecream);
    
    var shop2 = new JLabel("<html><body><p align=\\\"center\\\">A shop to buy souvenirs<br>"
            + "and you can gain 20$/person(average).</p></body></html>");
    shop2.setBounds(290, 170, 180, 60);
    shop2.setForeground(Color.red);
    jp.add(shop2);
  
  }
 
  public void paths() throws IOException{
    JFrame frame4 = new JFrame("Paths");
    frame4.setLocation(200,50);
    frame4.setSize(500,500);
    frame4.setVisible(true);
    ButtonItem btm1=new ButtonItem();
    ButtonItem btm2=new ButtonItem(); 
    btm1.setImage(Color.green,100,50,"data/path.png");
    btm2.setImage(Color.blue,300,50,"data/path_bin.png");
    JPanel jp=new JPanel();

    jp.setLayout(null);
    jp.add(btm1.button);jp.add(btm2.button);
    frame4.add(jp);

    int price1=50,price2=200;
    btm1.setText("path",price1,100,150);btm2.setText("path with transhcan",price2, 300, 150);

    jp.add(btm1.text);jp.add(btm2.text);
    btm1.button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //return the index of building that you click
            getAction(price1,frame4);
            index=4;
       }
   });
    btm2.button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
            getAction(price2,frame4);
            index=5;         
   }
   });
    var pathDesc = new JLabel("<html><body><p align=\\\"center\\\">support path for guests <br>and your stuff</p></body></html>");
    pathDesc.setBounds(100, 170, 180, 60);
    pathDesc.setForeground(Color.red);
    jp.add(pathDesc);
    
    var binDesc = new JLabel("<html><body><p align=\\\"center\\\">support path for guests <br>"
            + "and your stuff,<br>"
            + "also including a bin<br>"
            + "which can increase mood of guests</p></body></html>");
    binDesc.setBounds(300, 170, 180, 120);
    binDesc.setForeground(Color.red);
    jp.add(binDesc);
   }
  
  public void gardens() throws IOException{JFrame frame1 = new JFrame("frame1");
    frame1.setLocation(200,50);
    frame1.setSize(500,500);
    frame1.setVisible(true);
    frame1.setBackground(Color.GREEN);
    ButtonItem btm1=new ButtonItem();
    ButtonItem btm2=new ButtonItem(); 
    btm1.setImage(Color.green,100,50,"data/garden1.png");
    btm2.setImage(Color.blue,300,50,"data/garden2.png");
    JPanel jp=new JPanel();
    jp.setLayout(null);
    jp.add(btm1.button);jp.add(btm2.button);
    frame1.add(jp);
    float price1=100,price2=150;
    btm1.setText("garden1",price1,100,150);btm2.setText("garden2",price2, 300, 150);

    jp.add(btm1.text);jp.add(btm2.text);
    

    btm1.button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //return the index of building that you click
            getAction(price1,frame1);
            index=6;
       }
   });
    btm2.button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getAction(price2,frame1);
        index=7;         
   }
   });
  
    var garden1 = new JLabel("<html><body><p align=\\\"center\\\">A beauty area,<br>"
            + "and the guest will pay 10$ to get in.</p></body></html>");
    garden1.setBounds(90, 170, 180, 60);
    garden1.setForeground(Color.red);
    jp.add(garden1);
    
    var garden2 = new JLabel("<html><body><p align=\\\"center\\\">A beauty area,<br>"
            + "and the guest will pay 15$ to get in.</p></body></html>");
    garden2.setBounds(290, 170, 180, 60);
    garden2.setForeground(Color.red);
    jp.add(garden2);
  
  }
    public void hire() throws IOException{
  
     JFrame frame4 = new JFrame("WORKERS");
    frame4.setLocation(200,50);
    frame4.setSize(500,500);
    frame4.setVisible(true);
    ButtonItem btm1=new ButtonItem();
    ButtonItem btm2=new ButtonItem(); 
    btm1.setImage(Color.green,100,50,"data/cleaner_with_path.png");
    btm2.setImage(Color.blue,300,50,"data/repair_with_path.png");
    JPanel jp=new JPanel();
    jp.setLayout(null);
    jp.add(btm1.button);jp.add(btm2.button);
    frame4.add(jp);

    int price1=50,price2=200;
    btm1.setText("cleaner",price1,100,150);
    btm2.setText("repairman",price2, 300, 150);

    jp.add(btm1.text);jp.add(btm2.text);
    btm1.button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //return the index of building that you click
            getAction(price1,frame4);
            isWorker=true;
            index=0;
       }
   });
    btm2.button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
            getAction(price2,frame4);
            isWorker=true;
            index=1;         
   }
   });
   
    var cleaner = new JLabel("<html><body><p align=\\\"center\\\">Hire a cleaner <br>"
            + "which will help you<br>"
            + "to clean the park.</p></body></html>");
    cleaner.setBounds(90, 170, 180, 90);
    cleaner.setForeground(Color.red);
    jp.add(cleaner);
    
    var repair = new JLabel("<html><body><p align=\\\"center\\\">Hire a cleaner <br>"
            + "which will help you<br>"
            + "to repair the building in your park.</p></body></html>");
    repair.setBounds(290, 170, 180, 90);
    repair.setForeground(Color.red);
    jp.add(repair);
  }
  
  public void getAction(float price, JFrame frame){
    if(gf.getCurrFund()>=price){
        // will be used in GameFrame, GameFrame will detect the value of these two 
        // and display the item via the different index
        hasItem=true; 
        cost=price;
        frame.dispose(); 
    }
    else{
        JOptionPane.showMessageDialog(null, "you don't have enough funds");
    }
   }
  
  /**
   * only for test
   * @param jLabel
   * @param longString
   * @throws InterruptedException 
   */
  public void JlabelSetText(JLabel jLabel, String longString) 
           throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
         char[] chars = longString.toCharArray();
         FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
         int start = 0;
         int len = 0;
         while (start + len < longString.length()) {
             while (true) {
                 len++;
                 if (start + len > longString.length())break;
                 if (fontMetrics.charsWidth(chars, start, len) 
                         > jLabel.getWidth()) {
                     break;
                 }
             }
             builder.append(chars, start, len-1).append("<br/>");
             start = start + len - 1;
             len = 0;
         }
         builder.append(chars, start, longString.length()-start);
         builder.append("</html>");
         jLabel.setText(builder.toString());
     }
  
 }


