package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 * EXTENDS BASE CLASS and add attirbutes of building 
 * @author Arbab Ali
 */
public class Building  extends Base {
    private Integer Health;
    private Integer Cost;
    private Integer time_to_build;
    private Map<String, Image> imgs;
   
    
    public Building(Position p,Integer Widht,Integer Height ,Integer health, Integer cost, Integer time_to_build,String imagePath) {
         super(p,  Widht,  Height);
      
        Health = health;
        Cost = cost;
        this.time_to_build = time_to_build;
        
        imgs = new HashMap<>();

        BufferedImage image = null;
        image = (BufferedImage) ResourceLoader.loadImage(imagePath);
        imgs.put("first", image.getSubimage(0, 0, 78, 90)); 
        imgs.put("second", image.getSubimage(78, 0, 78, 90)); 
        imgs.put("third", image.getSubimage(0, 90, 78, 90)); 
        imgs.put("forth", image.getSubimage(78, 90, 78, 90)); 

    }

    public Integer getHealth() {
        return Health;
    }

    public void setHealth(Integer health) {
        Health = health;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }

    public Integer getTime_to_build() {
        return time_to_build;
    }

    public void setTime_to_build(Integer time_to_build) {
        this.time_to_build = time_to_build;
    }
    
    @Override
    public void draw(Graphics gr,Integer ind) {
        String imgName="";
        System.out.println(ind);
    switch(ind%10){
        case 0: 
                imgName="third";break;
        case 1 :
                imgName="forth"; break;
        case 2 :
                imgName="first"; break;
        case 3 :
                imgName="second"; break;
    }
        gr.drawImage(imgs.get(imgName), p.getX(), p.getY(), width, height, null);
    }

}

