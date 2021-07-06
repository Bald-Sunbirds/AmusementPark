/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Qiao
 */
public class ButtonItem{
    private ImageIcon icon;
    public JLabel text;
    public JButton button;

    public void setImage(Color cl,int x,int y,String s) throws IOException{
        Image image = createImage(cl,s);
        icon = new ImageIcon(image);
        button = new JButton(icon);
        button.setBounds(x,y,100,100);
    }
    public void setText(String s,float c,int x,int y){
        text = new JLabel(s+" cost: "+c);
        text.setBounds( x,y,200, 30);

    }
    
    private Image createImage(Color color,String s) throws IOException {
        int Height = 50;
        int Width = 50;
        //BufferedImage bImg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage bImg=(BufferedImage) ResourceLoader.loadImage(s);
        Graphics2D g2 = bImg.createGraphics();
        g2.setBackground(color);
        g2.clearRect(0, 0, Width, Height);
        g2.dispose();
        return bImg;
  }
}