package amusementpark_demo.com.baldsunbirds.view;

import amusementpark_demo.com.baldsunbirds.controller.GamePanel;
import amusementpark_demo.com.baldsunbirds.controller.MenuPanel;
import amusementpark_demo.com.baldsunbirds.controller.NaviPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameFrame extends BaseFrame implements MouseListener {
    
    private NaviPanel naviBar;
    private MenuPanel menuBar;
    private GamePanel gameArea;
    private Float currFund = 750f;
    
    public GameFrame() {
        super();
        System.out.println("Game starts");

        // the info box
        naviBar = new NaviPanel(this);
        naviBar.setPreferredSize(new Dimension(800, 100));
        naviBar.setLayout(null);
        naviBar.init();
        
        frame.add(naviBar, BorderLayout.NORTH);
        naviBar.setBackground(Color.gray);
        
        
        // for the build(pop up window)
        menuBar = new MenuPanel(this);
        menuBar.setPreferredSize(new Dimension(200, 450));
        menuBar.setLayout(null);
        menuBar.init();
        frame.add(menuBar, BorderLayout.EAST);
        menuBar.setBackground(Color.ORANGE);
        
        
        // game engine
        gameArea = new GamePanel();
        gameArea.setPreferredSize(new Dimension(650, 450));
        gameArea.addMouseListener(this);
        frame.add(gameArea, BorderLayout.CENTER);
        gameArea.setBackground(Color.GREEN);
        
        naviBar.updateFundTxt(currFund); // test
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX()+","+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
