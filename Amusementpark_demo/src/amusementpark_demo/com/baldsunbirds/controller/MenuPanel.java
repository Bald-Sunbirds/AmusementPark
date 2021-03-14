package amusementpark_demo.com.baldsunbirds.controller;

import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import javax.swing.*;

public class MenuPanel extends JPanel {
    
    private GameFrame gf;
    public MenuPanel(GameFrame gf) {
        this.gf = gf;
    }
    
    public void init() {
        JButton gameBtn = new JButton("Games");
        gameBtn.setBounds(25, 25, 120, 50);
        gameBtn.addActionListener(gf.getActionListener(666));
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
}
