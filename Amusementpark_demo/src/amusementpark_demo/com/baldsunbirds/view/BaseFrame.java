package amusementpark_demo.com.baldsunbirds.view;

import amusementpark_demo.com.baldsunbirds.utils.Constants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BaseFrame {

    public final JFrame frame;

    public BaseFrame() {
        frame = new JFrame(Constants.TITLE);
        frame.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setVisible(true);
    }

    public ActionListener getActionListener(int op) {
        switch (op) {
            case 0:
                return e -> msgConfirm("Do u wanna leave?");
            case 1:
                return e -> new GameFrame();
            default:
                return e -> System.out.println("Building...");
        }
    }
    
    public boolean msgConfirm(String msg) {
        int select = JOptionPane.showConfirmDialog(frame,
                msg,
                "Really?",
                JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.YES_OPTION) {
            doExit();
            return true;
        }
        return false;
    }

    public void doExit() {
        System.out.println("Exit game");
        frame.dispose();
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
}
