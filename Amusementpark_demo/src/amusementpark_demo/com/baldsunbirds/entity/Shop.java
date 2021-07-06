/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import amusementpark_demo.com.baldsunbirds.utils.Position;


/**
 *
 * @author ywz610
 */
public class Shop extends Building{

    
    public Shop(Position p,Integer Widht,Integer Height ,Integer health, Integer cost, Integer time_to_build,String imagePath,Integer ind){   
             super(p,Widht,Height,health,cost,time_to_build,imagePath);
    }

}