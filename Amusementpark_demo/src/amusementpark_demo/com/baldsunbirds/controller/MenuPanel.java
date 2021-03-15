package amusementpark_demo.com.baldsunbirds.controller;

import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

import javax.swing.ImageIcon;

public class MenuPanel extends JPanel {
    
    private GameFrame gf;
    private ImageIcon icon1,icon2;
        JLabel text1,text2;
    public MenuPanel(GameFrame gf) {
        this.gf = gf;
    }
    
    public void init() {
        JButton gameBtn = new JButton("Games");
        gameBtn.setBounds(25, 25, 120, 50);
        //gameBtn.addActionListener(gf.getActionListener(666));
        gameBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
           games();
        }
        });
	this.add(gameBtn);
        
        
        JButton gardenBtn = new JButton("Gardens");
        gardenBtn.setBounds(25, 100, 120, 50);
        gardenBtn.addActionListener(gf.getActionListener(666));
        this.add(gardenBtn);
        JButton restaurantBtn = new JButton("Restaurants");
        restaurantBtn.setBounds(25, 175, 120, 50);
        restaurantBtn.addActionListener(gf.getActionListener(666));
        this.add(restaurantBtn);
        JButton pathBtn = new JButton("Paths");
        pathBtn.setBounds(25, 250, 120, 50);
        pathBtn.addActionListener(gf.getActionListener(666));
        this.add(pathBtn);
        JButton hireBtn = new JButton("Hire");
        hireBtn.setBounds(25, 325, 120, 50);
        hireBtn.addActionListener(gf.getActionListener(666));
        this.add(hireBtn);
    }
    
  private Image createImage(Color color) {
    int Height = 50;
    int Width = 50;
      
    BufferedImage bImg = new BufferedImage(Width, Height,
     BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = bImg.createGraphics();
    g2.setBackground(color);
    g2.clearRect(0, 0, Width, Height);
    g2.dispose();
    return bImg;
  }
  
  public void games(){

    JFrame frame1 = new JFrame("frame1");
    frame1.setLocation(200,50);
    frame1.setSize(500,500);
    frame1.setVisible(true);
    JButton button1,button2,button3;

    Image image1 = createImage(Color.green);
    Image image2 = createImage(Color.blue);
    icon1 = new ImageIcon(image1);
    icon2 = new ImageIcon(image2);
    JPanel jp=new JPanel();
    jp.setLayout(null);
    button1 = new JButton(icon1);
    button1.setBounds(100,50,100,100);
    button2 = new JButton(icon2);
    button2.setBounds(300,50,100,100);
    jp.add(button1);
    jp.add(button2);
    frame1.add(jp);
    text1 = new JLabel("Building1, cost:XX");
    text1.setBounds(100,150, 200, 30);
    jp.add(text1);
    text2 = new JLabel("Building2, cost:XX");
    text2.setBounds(300,150, 200, 30);
    jp.add(text2);
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            //return the index of building that you click

           frame1.dispose();          
       }
   });
    button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       frame1.dispose();          
   }
   });

}
  
  public void restaurants(){}
 
   public void paths(){}
   
   public void hire(){}
  
 }

