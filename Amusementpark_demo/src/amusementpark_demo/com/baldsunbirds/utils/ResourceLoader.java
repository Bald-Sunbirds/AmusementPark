/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.utils;

/**
 *
 * @author Arbab Ali
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class ResourceLoader {
    public static InputStream loadResource(String resName){
        return ResourceLoader.class.getClassLoader().getResourceAsStream(resName);
    }
    
    public static Image loadImage(String resName) {
          URL url = null;
          BufferedImage res=null;
        try{
         url = ResourceLoader.class.getClassLoader().getResource(resName);
           res=ImageIO.read(url);
       
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage()+"\n"+ex.getStackTrace());
        }
        return res;
    }
}
