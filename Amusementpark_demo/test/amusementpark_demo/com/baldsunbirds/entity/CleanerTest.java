/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.controller.GamePanel;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arbab Ali
 */
public class CleanerTest {
   
    public CleanerTest() throws IOException {
         
    }
    
    @BeforeClass
    public static void setUpClass() {

  
          
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
         
    }

    /**
     * Test of possible_path_list method, of class Cleaner.
     */
    @Test
    public void testHorizontalPossible_path_list() throws IOException {
        System.out.println("x possible_path_list");
        //SETING UP  
        GameFrame gf=null;
     GamePanel Game;
   
        GamePanel.map[0][0]=400;
         //create path on map so that we can check moveX function
          GamePanel.map[0][1]=400+1400;
          
          //create path on map so that we can check moveY function
          GamePanel.map[0][2]=100;
          
          Game = new GamePanel(gf);
         Cleaner instance = null;
           
        for (Sprite s:Game.player.myCharacters){
            if(s.Identity_num==1400){
             instance = (Cleaner)s;
             break;
            }
      
        }
       //  System.out.println("pos: "+  instance.p.getY()+" "+instance.p.getX());
       
         int []resultSet=instance.possible_path_list();
        assertEquals(0,resultSet[0]);
        assertEquals(0,resultSet[1]);
        assertEquals(1,resultSet[2]);
        assertEquals(1,resultSet[3]);
    }
    /**
     * Test of possible_path_list method, of class Cleaner.
     */
    @Test
    public void testVerticalPossible_path_list() throws IOException {
        System.out.println("y possible_path_list");
          //SETING UP  
            GameFrame gf=null;
            GamePanel Game;
   
        GamePanel.map[1][0]=400;
         //create path on map so that we can check moveX function
          GamePanel.map[2][0]=400+1400;
          
          //create path on map so that we can check moveY function
          GamePanel.map[3][0]=100;
         
         
          Game = new GamePanel(gf);
          
         Cleaner instance = null;
           
        for (Sprite s:Game.player.myCharacters){
            if(s.getP().getX()==0 && s.getP().getY()==2){
             instance = (Cleaner)s;
             break;
            }
      
        }
       // System.out.println("pos: "+  instance.p.getY()+" "+instance.p.getX());
         int []resultSet=instance.possible_path_list();
    
        assertEquals(1,resultSet[0]);
        assertEquals(1,resultSet[1]);
        assertEquals(0,resultSet[2]);
        assertEquals(0,resultSet[3]);
    }
      /**
     * Test of possible_path_list method, of class Cleaner.
     */
    @Test
    public void testAllPossible_path_list() throws IOException {
        System.out.println("both possible_path_list");
         //SETING UP  
               GameFrame gf=null;
            GamePanel Game;
        GamePanel.map[1][1]=400+1400;
        GamePanel.map[1][0]=100;
        GamePanel.map[0][1]=400;  
        GamePanel.map[1][2]=400;
        GamePanel.map[2][1]=100;
          Game = new GamePanel(gf);
         Cleaner instance = null;
           
        for (Sprite s:Game.player.myCharacters){
            if(s.getP().getX()==1 && s.getP().getY()==1){
             instance = (Cleaner)s;
             break;
            }
      
        }
         int []resultSet=instance.possible_path_list();
              for(int s:resultSet)
        {
            System.out.print(s+",");
        }
        assertEquals(1,resultSet[0]);
        assertEquals(1,resultSet[1]);
        assertEquals(1,resultSet[2]);
        assertEquals(1,resultSet[3]);
    }
    /**
     * Test of move method, of class Cleaner.MOVES BACK AND FORTH IN X DIRECTION 
     */
    @Test
    public void testMoveX() throws IOException {
        System.out.println("moveX");
        //SETING UP  
        GameFrame gf=null;
     GamePanel Game;
   
        GamePanel.map[0][0]=400;
         //create path on map so that we can check moveX function
          GamePanel.map[0][1]=400+1400;
          
          //create path on map so that we can check moveY function
          GamePanel.map[0][2]=100;
          
          Game = new GamePanel(gf);
         Cleaner instance = null;
           
        for (Sprite s:Game.player.myCharacters){
             if(s.getP().getX()==1 && s.getP().getY()==0){
             instance = (Cleaner)s;
             break;
            }
      
        }
       //  System.out.println("pos: "+  instance.p.getY()+" "+instance.p.getX());
       //
       instance.move();
        int actualX=instance.getP().getX();
        int actualY=instance.getP().getY();
  
        assertEquals(2,actualX);
     assertEquals(0,actualY);
      instance.move();
            actualX=instance.getP().getX();
         actualY=instance.getP().getY();
  
         assertEquals(1,actualX);
     assertEquals(0,actualY);
     

    }
    /**
     * Test of move method, of class Cleaner.MOVES BACK AND FORTH IN Y DIRECTION 
     */
    @Test
    public void testMoveY() throws IOException {
        System.out.println("moveY");
        //SETING UP  
     //SETING UP  
            GameFrame gf=null;
            GamePanel Game;
   
        //create path on map so that we can check moveX function
          GamePanel.map[6][1]=400+1400;
          
       
         
          Game = new GamePanel(gf);
          
         Cleaner instance = null;
           
        for (Sprite s:Game.player.myCharacters){
            if(s.getP().getX()==1 && s.getP().getY()==6){
             instance = (Cleaner)s;
             break;
            }
        }
       //  System.out.println("pos: "+  instance.p.getY()+" "+instance.p.getX());
       //
       instance.move();
        int actualX=instance.getP().getX();
        int actualY=instance.getP().getY();
  
        assertEquals(1,actualX);
     assertEquals(7,actualY);
      instance.move();
            actualX=instance.getP().getX();
         actualY=instance.getP().getY();
  
         assertEquals(1,actualX);
     assertEquals(6,actualY);
     

    }
    
}
