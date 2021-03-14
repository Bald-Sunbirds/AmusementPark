package amusementpark_demo.com.baldsunbirds.view;

import amusementpark_demo.com.baldsunbirds.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends BaseFrame {

    public MenuFrame() {
        super();

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel title = new JLabel(Constants.TITLE+" v1.0");
        title.setBounds(280, 50, 225, 100);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(title);

        JButton startBtn = new JButton("Start");
        startBtn.setBounds(325, 200, 150, 50);
        startBtn.addActionListener(getActionListener(1));
        panel.add(startBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(325, 280, 150, 50);
        exitBtn.addActionListener(getActionListener(0));
        panel.add(exitBtn);
    }


}
