/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import java.awt.Graphics;
import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Arbab Ali
 */
public class Player  {
     public ArrayList<Sprite> myCharacters;
    public  ArrayList<Building> myBuildings;
    private final Image building, guest, path,   empty;

    public Player() throws IOException {
        this.building = ResourceLoader.loadImage("data/ice_cream_shop.png");
        this.guest = ResourceLoader.loadImage("data/guest.png");
        this.path = ResourceLoader.loadImage("data/terrain_path.png");
        this.empty = ResourceLoader.loadImage("data/terrain_grass.png");
        this.myCharacters=new ArrayList();
        this.myBuildings=new ArrayList();
    }

    public ArrayList<Sprite> getMyCharacters() {
        return myCharacters;
    }

    public void setMyCharacters(ArrayList<Sprite> myCharacters) {
        this.myCharacters = myCharacters;
    }

    public ArrayList<Building> getMyBuildings() {
        return myBuildings;
    }

    public void setMyBuildings(ArrayList<Building> myBuildings) {
        this.myBuildings = myBuildings;
    }
    
   public void add_Charachter(Sprite s)
    {
        myCharacters.add(s);
    }
   public void add_buildings(Building b)
   {
       myBuildings.add(b);
   }
   
   public void draw_Charachters(Graphics g,Integer tile){
       for (Sprite s: myCharacters)
       {
           s.draw(g, tile);
           
           tile+=tile;
       }
   }
   public void move_guests(){
       for (Sprite s: myCharacters)
       {
           
                s.move();
           
       }
   }
   public void draw_Buildinigs(Graphics g,Integer tile){
       for (Building s: myBuildings)
       {
           s.draw(g, tile);
           
           tile+=tile;
       }
   }
}
