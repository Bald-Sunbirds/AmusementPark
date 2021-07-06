/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.controller.GamePanel;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_COLS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_ROWS;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
public class GuestTest {
    GameFrame gf=null;
          
   GamePanel Game;
    public GuestTest() throws IOException {
        this.Game = new GamePanel(gf);
          }
    
    @BeforeClass
    public static void setUpClass() {
        GamePanel.map[3][3]=500;
        GamePanel.map[0][0]=401;
         //create path on map so that we can check moveX function
          GamePanel.map[0][1]=400;
          
          //create path on map so that we can check moveY function
          GamePanel.map[1][0]=400;
          
       
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
     * Test of moveX method, of class Sprite.
     */
    @Test
    public void testMoveX() {
        System.out.println("moveX");
        int dir = 1;
        Guest instance=(Guest)Game.player.myCharacters.get(0);
        int x=instance.getP().getX();
        int y=instance.getP().getY();
     //move frwd one time if path exist and we have set path to be exist   
        
        instance.moveX(dir);
        assertEquals(x+dir,instance.getP().getX());
       assertEquals(y,instance.getP().getY());
       
       
       //MOVING BACKWARD when no backward so remain same
        dir=-1;
        x=instance.getP().getX(); //get latest  x position
        y=instance.getP().getY(); //get latest y position
        instance.moveX(dir);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals(x+dir,instance.getP().getX());
       assertEquals(y,instance.getP().getY());
     
       
    }

    /**
     * Test of moveY method, of class Sprite.
     */
    @Test
    public void testMoveY() {
        System.out.println("moveY");
        int dir = 1;
        Guest instance=(Guest)Game.player.myCharacters.get(0);
        int x=instance.getP().getX();
        int y=instance.getP().getY();
     //move frwd one time if path exist and we have set path to be exist   
        
        instance.moveY(dir);
        assertEquals(x,instance.getP().getX());
       assertEquals(y+dir,instance.getP().getY());
       
       
       //MOVING BACKWARD when no backward so remain same
        dir=-1;
        x=instance.getP().getX(); //get latest  x position
        y=instance.getP().getY(); //get latest y position
        instance.moveY(dir);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals(x,instance.getP().getX());
       assertEquals(y+dir,instance.getP().getY());
     
      
    }
    
    /**
     * Test of moveX method, of class Guest.
     */
 
//    /**
//     * Test of moveXY method, of class Sprite.
//     */
//    @Test
//    public void testMoveXY() {
//        System.out.println("moveXY");
//        Sprite instance = null;
//        instance.moveXY();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of move_to_gate method, of class Sprite.
//     */
//    @Test
//    public void testMove_to_gate() {
//        System.out.println("move_to_gate");
//        Sprite instance = null;
//        instance.move_to_gate();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of near_building method, of class Sprite.
//     */
//    @Test
//    public void testNear_building() {
//        System.out.println("near_building");
//        Sprite instance = null;
//        boolean expResult = false;
//        boolean result = instance.near_building();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of waiting_list method, of class Sprite.
//     */
//    @Test
//    public void testWaiting_list() {
//        System.out.println("waiting_list");
//        Sprite instance = null;
//        boolean expResult = false;
//        boolean result = instance.waiting_list();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of enter_building method, of class Sprite.
//     */
//    @Test
//    public void testEnter_building() {
//        System.out.println("enter_building");
//        Sprite instance = null;
//        instance.enter_building();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of move method, of class Sprite.
//     */
//    @Test
//    public void testMove() {
//        System.out.println("move");
//        Sprite instance = null;
//        instance.move();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of change_pos_in_MAP method, of class Sprite.
     */
    @Test
    public void testChange_pos_in_MAP() {
        System.out.println("change_pos_in_MAP");
        Integer x = 2;
        Integer y = 2;
        Guest instance=(Guest)Game.player.myCharacters.get(0);
        
       // System.out.println("instance vlaues"+instance.getP().getX()+","+instance.getP().getY());
        
        instance.change_pos_in_MAP(x, y);
     //   System.out.println("instance vlaues"+instance.getP().getX()+","+instance.getP().getY());
        
        int actualValue=GamePanel.map[2][2];
        //GOOD CASE
        assertEquals(401,actualValue);
        
        //BAD CASE
        //when x and y both are equal to edges
        x=TOTAL_ROWS;//23
        y=TOTAL_COLS;//
        System.out.println("x="+x +" y= "+ y);
        instance.change_pos_in_MAP(x, y);
        actualValue=GamePanel.map[y-1][x-1];
        assertEquals(0,actualValue);
        //WHEN VALUE IS MORE THAN ROW WE PUT IT ON LAST ELEMENT OF X 
        x=TOTAL_ROWS+1;
        y=0;
        instance.change_pos_in_MAP(x, y);
        actualValue=GamePanel.map[0][TOTAL_ROWS-1];
        assertEquals(0,actualValue);
        
    }

    /**
     * Test of searchPath method, of class Sprite.
     */
    @Test
    public void testSearchPath() {
        System.out.println("searchPath");
        int y = 3;
        int x = 3;
        Guest instance = new  Guest(new Position(0,0),gf);
        boolean expResult = true;
        boolean result = instance.searchPath(y, x);
        assertEquals(expResult, result);
    
    }

    
}
