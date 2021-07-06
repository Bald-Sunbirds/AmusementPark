/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchTest {
    public static Integer [][] testlist0={
        {0,   0,  0,    0, 0} ,
        {0,  500, 400,400, 0} ,
        {0,  0,  0, 400,  400} ,
        {400,400,400,400,400},
        {500, 0,  0,  0,   0} ,
         };
    public static Integer [][] testlist1={
  			{0,0,0,0,0,0,0,0,0,400,0,0,0},
  			{0,0,0,0,0,0,0,0,0,500,0,0,0},
  			{0,0,0,0,0,0,0,0,0,400,0,0,0},
                        {0,0,0,0,0,0,0,0,0,400,0,0,0},
  			{0,0,0,0,0,0,400,400,400,400,0,0,0},
  			{0,0,0,0,400,400,400,0,0,0,0,0,0},
  			{0,0,0,400,400,0,0,0,0,0,0,0,0},
  			{0,0,0,400,400,400,0,0,0,0,0,0,0},
  			{500,400,400,400,0,0,0,0,0,0,0,0,0},
         };

    public SearchTest() {
    }
    
    
    /**
     * Test of dfs method, of class Search.
     */
     @Test
    public void testDfs() {
        System.out.println("dfs");
        int x = 1;
        int y = 1;
        int goalX = 4;
        int goalY = 0;
        Search instance = new Search(testlist0);
        instance.dfs(x, y, goalX, goalY);

        
        ///IS GOAL FOUND IN DFS
      int finalX=instance.listx.get(instance.listx.size()-1);
        assertEquals(goalX,finalX);
        
      int finalY=instance.listy.get(instance.listy.size()-1);
        
      assertEquals(goalY,finalY);
      
        System.out.println("original location is: "+y +" "+x);
        System.out.println("aim to: "+goalY  +" "+goalX);
        System.out.println("size is: "+instance.listx.size());
        System.out.println("==============");
        for(int i=0;i<instance.listx.size();i++){
                System.out.println(instance.listy.get(i)+" "+instance.listx.get(i));
        }
        System.out.println("==============");
    }
    
    
    
    @Test
    public void testDfs2() {
        System.out.println("dfs");
        int x = 0;
        int y = 9;
        int goalX = 8;
        int goalY = 0;
        Search instance = new Search(testlist1);
  
        instance.dfs(x, y, goalX, goalY);
        
          
        ///IS GOAL FOUND IN DFS
      int finalX=instance.listx.get(instance.listx.size()-1);
        assertEquals(goalX,finalX);
        
      int finalY=instance.listy.get(instance.listy.size()-1);
        
      assertEquals(goalY,finalY);
      
        System.out.println("original location is: "+y +" "+x);
        System.out.println("aim to: "+goalY  +" "+goalX);
        System.out.println("size is: "+instance.listx.size());
        System.out.println("==============");
        for(int i=0;i<instance.listx.size();i++){
                System.out.println(instance.listx.get(i)+" "+instance.listy.get(i));
        }
      System.out.println("==============");
        
   
    }
    
}
