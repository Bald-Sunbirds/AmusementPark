package com.baldsunbirds.view;

import com.baldsunbirds.controller.GamePanel;
import com.baldsunbirds.controller.MenuPanel;
import com.baldsunbirds.controller.NaviPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameFrame extends BaseFrame implements MouseListener {

    public GameFrame() {
        super();
        System.out.println("Game starts");


        NaviPanel naviBar = new NaviPanel();
        naviBar.setPreferredSize(new Dimension(800, 100));
        frame.add(naviBar, BorderLayout.NORTH);
        naviBar.setBackground(Color.BLUE);

        JPanel menuBar = new MenuPanel();
        menuBar.setPreferredSize(new Dimension(150, 450));
        frame.add(menuBar, BorderLayout.EAST);
        menuBar.setBackground(Color.ORANGE);

        JPanel gameArea = new GamePanel();
        gameArea.setPreferredSize(new Dimension(650, 450));
        frame.add(gameArea, BorderLayout.CENTER);
        gameArea.setBackground(Color.GREEN);
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
