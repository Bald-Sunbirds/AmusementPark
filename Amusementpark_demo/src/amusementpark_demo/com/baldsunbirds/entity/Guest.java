/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import java.awt.Image;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Velocity;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Guest class extends Sprite 
 * @author Arbab Ali
 */
public class Guest extends Sprite {
    public  static   Image guestImage = ResourceLoader.loadImage("data/guest.png");

      
    public Guest(Position p, GameFrame gf) {
        
        super(p,new Velocity(1,1), 40, 60, guestImage,100, gf);
    }
    
}
