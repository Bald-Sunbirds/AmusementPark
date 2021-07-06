
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

/**
 * its a abstact class only usefull for inheritance 
 * @author Arbab Ali
 */
public abstract  class Base {
    Position p;
    Integer width;
    Integer height;
    Image  baseImage;

    public Base(Position p, Integer width, Integer height, Image baseImage) {
        this.p = p;
        this.width = width;
        this.height = height;
        this.baseImage = baseImage;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public Base(Position p, Integer width, Integer height) {
         
            baseImage=null;      
        this.p = p;
        this.width = width;
        this.height = height;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }

    public Position getP() {
        return p;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
    
      public void draw(Graphics g,Integer tile_size) {     
            g.drawImage(baseImage, p.getX()*tile_size, p.getY()*tile_size, width, height, null);
    }
    
}
