/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.utils;

import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import amusementpark_demo.com.baldsunbirds.controller.NaviPanel;

public class Cost {

    public static Float cost=0f;
   public Cost() {

    }
   
    
   public void setFund(int ind){
       System.out.println("222222121212");
        Float cost=0f;
        switch (ind){
            case 2:cost=25f ; break; 
            case 3:cost=20f ; break; 
            case 6:cost=10f ; break; 
            case 7:cost=15f ; break; 
            case 8:cost=20f ; break; 
            case 9:cost=25f ; break;
            case 10:cost=-25f ; break;
        }

         this.cost=cost;     
                System.out.println(cost);
      }
      public Float getFund(){
      return cost;
      }
   
    }
            


    
