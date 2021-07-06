package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 *
 * @author ywz610
 */
public class Game extends Building{

    
    public Game(Position p,Integer Widht,Integer Height ,Integer health, Integer cost, Integer time_to_build,String imagePath,Integer ind){   
             super(p,Widht,Height,health,cost,time_to_build,imagePath);
    }

}
