package com.baldsunbirds.view;

import com.baldsunbirds.utils.Constants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BaseFrame {

    protected final JFrame frame;
    //protected final JPanel panel;

    public BaseFrame() {
        frame = new JFrame(Constants.TITLE);
        frame.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setVisible(true);
    }

    protected ActionListener getActionListener(int op) {
        switch (op) {
            case 0:
                return e -> doExit();
            case 1:
                return e -> new GameFrame();
            default:
                return null;
        }
    }

    protected void doExit() {
        System.out.println("Exit game");
        frame.dispose();
    }
}
