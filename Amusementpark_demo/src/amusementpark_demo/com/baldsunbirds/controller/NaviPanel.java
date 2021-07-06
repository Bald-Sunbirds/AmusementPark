package amusementpark_demo.com.baldsunbirds.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NaviPanel extends JPanel {

    private int height;
    private int width;
    private int y;
    private GameFrame gf;
    JLabel fundSt;
    
    
    public NaviPanel(GameFrame gf) {
           this.gf = gf;
    }
    
    public void init() {
        JButton extBtn = new JButton("Exit");
        extBtn.setBounds(50, 30, 60, 30);
        extBtn.addActionListener(gf.getActionListener(0));
        this.add(extBtn);
        
        fundSt = new JLabel("Current fund: $xxx.xx");
        fundSt.setBounds(180, 30, 200, 30);
        this.add(fundSt);
        
        JButton startBtn = new JButton("Start");
        startBtn.setBounds(630, 15, 100, 60);
        startBtn.addActionListener((ActionEvent e) -> {
            gf.start();
        });
        this.add(startBtn);
    }
    
    public void updateFundTxt(float fund) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        fundSt.setText("Current fund: $" + fund);
    }

}
