/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_COLS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_ROWS;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Velocity;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arbab Ali
 */
public class Cleaner  extends Sprite{
    public static   Image cleanerImage=ResourceLoader.loadImage("data/cleaner_with_path.png");
    public static int  id =1400;

    private Position base_pos;
     
    int dir=1;
    public Cleaner(Position p, GameFrame gf) {
        
        super(p,new Velocity(1,1), 40, 60, cleanerImage,id, gf);
      base_pos=p;
      
    }
    public int[] possible_path_list()
    {
        int[] myList=new int[4];
          for(int i=0; i <4;i++){
        myList[i]=0;
        }
        if(base_pos.getY()+1<TOTAL_COLS  ){
           if(searchPath(p.getY()+1,p.getX())){
           myList[0]=1;
        }}
                     
        
         if(  base_pos.getY()-1>=0)
             {if(searchPath(p.getY()-1,p.getX()))
             { myList[1]=1;}
             
            }
        
        if(  base_pos.getX()+1<TOTAL_ROWS){
                        if(searchPath(p.getY(),p.getX()+1) )    {myList[2]=1; }               
        }
         if(  base_pos.getX()-1>=0){
                    if(searchPath(p.getY(),p.getX()-1) ){     myList[3]=1;               
            }
                   
        }
         return myList;
    }
    
    @Override
    public void move()
    { 
           boolean is_y=false;
           
           int [] path_list=possible_path_list();
//           for(int e:path_list){
//               System.out.print(e);   
//           }
//           System.out.println("++++++++++");
           is_y= path_list[1]!=0 && path_list[0]!=0;
           
           if(is_y){
               
               moveY(dir);
           }else{
               moveX(dir);
           }
           
               dir=-1*dir;
    }
       
}
