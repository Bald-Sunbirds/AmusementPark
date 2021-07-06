package amusementpark_demo.com.baldsunbirds.controller;
import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.entity.Building;
import amusementpark_demo.com.baldsunbirds.entity.Cleaner;
import amusementpark_demo.com.baldsunbirds.entity.Game;
import amusementpark_demo.com.baldsunbirds.entity.Garden;
import amusementpark_demo.com.baldsunbirds.entity.Guest;
import amusementpark_demo.com.baldsunbirds.entity.Player;
import amusementpark_demo.com.baldsunbirds.entity.Shop;
import amusementpark_demo.com.baldsunbirds.entity.Sprite;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import amusementpark_demo.com.baldsunbirds.entity.repairman;
import amusementpark_demo.com.baldsunbirds.utils.Time;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import static amusementpark_demo.com.baldsunbirds.view.GameFrame.paused;


/**
 *
 * @author Arbab Ali
 */
public class GamePanel extends JPanel {
    
    private GameFrame gf;
    private final Image building,tree, path,path_with_player, guest,empty,path_bin,path_bin_with_player,path_trash,path_player_trash;
    
    private double scale;
    private int scaled_size;
    public int total_length;
    public int total_height;
    Building Bld;
    Game gm;Garden grd;Shop sp;
    public Player player=new Player();
    private final int tile_size = 50;
    public static final int TOTAL_ROWS=23; 
    public static final int TOTAL_COLS=13; 
    public static  int guest_count=0;
    Random random = new Random();
   //MAP OF THE BOARD 13X9 each tile is 50 pixel 
    
    
    
    public static Integer [][] map={
        /*first digit: type of building
          second digit: which part it belongs to of the building(ex.entry door, leaving door)
          third digit: how many guests are there in this grid*/
                        {000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,000,400,400,400,400,100,100,400,400,400,000,000,000,000,000,000,000,000,000,000,000,000},
                        {000,000,000,000,000,400,000,000,000,000,400,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,400,000,000,000,400,000,000,000,000,400,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,400,000,000,000,400,000,000,000,000,400,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,400,000,000,000,400,000,000,000,000,400,000,000,000,000,000,000,000,000,000,000,000,000},
  			{000,400,000,000,000,400,000,000,000,000,400,000,000,000,000,000,000,000,000,000,000,000,000},
  			{400,400,400,400,400,400,400,400,400,400,400,000,000,000,000,000,000,000,000,000,000,000,000},
                        {000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000},                       
                        {000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000},                    
                        {000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000},         
                        {000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000}
  			
    };
        Image  Image;
    HashMap<String, String> imgPath;
    private Timer timer = new Timer();
  
    public GamePanel(GameFrame gf) throws IOException {
        this.gf=gf;
        scale =1.0;
        scaled_size = (int)(scale * tile_size);
        //Loads all Images from the Srouce with the help of Resource Loader Class
        this.tree= ResourceLoader.loadImage("data/Tree.png");
        this.building = ResourceLoader.loadImage("data/ice_cream_shop.png");
        this.guest = ResourceLoader.loadImage("data/guest.png");
        this.path = ResourceLoader.loadImage("data/path.png");
        this.empty = ResourceLoader.loadImage("data/terrain_grass.png");
        this.path_bin=ResourceLoader.loadImage("data/path_bin.png");
        this.path_with_player=ResourceLoader.loadImage("data/past_with_player2.png");
        this.path_bin_with_player=ResourceLoader.loadImage("data/path_with_player.png");
        
        
        this.path_trash=ResourceLoader.loadImage("data/path_trash.png");
        this.path_player_trash=ResourceLoader.loadImage("data/path_player_trash.png");
        
        
        
        imgPath = new HashMap<>();
        imgPath.put("shop2", "data/shop2_b.png");
        imgPath.put("iceCreamShop", "data/ice_cream_shop_b.png");
        imgPath.put("garden1", "data/garden1_b.png");
        imgPath.put("garden2", "data/garden2_b.png");
        imgPath.put("game1", "data/game1_b.png");
        imgPath.put("game2", "data/game2_b.png");
        
        imgPath.put("repair", "data/repair.png");
        imgPath.put("waiting", "data/waiting.png");
            imgPath.put("in_use", "data/in_use.png");
       
       add_sprites();
    }

  public void add_sprites(){
    for (int y = 0; y <TOTAL_COLS; y++){
            for (int x = 0; x <TOTAL_ROWS ; x++){
                if(map[y][x]%100!=0){ // if player exists on map it adds it to player.mycharacher array
                  //  System.out.println("ITS CLEANER OR REPAIRMAN");
               
                  add_guests(x,y);
                }else{
                    if(map[y][x]==1800 || map[y][x]==1900)
                        add_worker(x,y,map[y][x]==1800);
                }
             
        }
  }
  }
  private void add_guests(int x,int y ){
          Guest myg=new Guest(new Position(x,y), gf);
                    player.add_Charachter(myg);
                    guest_count+=1;
                
  }
  public void add_worker(int x,int y,Boolean isCleaner)
      {
             Sprite myworker;
             if(isCleaner)
                myworker=new Cleaner(new Position(x,y), gf);
             else
                 myworker=new repairman(new Position(x,y), gf);
            player.add_Charachter(myworker);
            
      }
      
     public boolean setScale(double scale){
        this.scale = scale;
        scaled_size = (int)(scale * tile_size);
        return refresh();
    }
    
    public boolean refresh(){
  
        Dimension dim = new Dimension(TOTAL_ROWS * scaled_size, TOTAL_COLS * scaled_size);
        setPreferredSize(dim);
        setMaximumSize(dim);
        setSize(dim);
        if(!paused)
        {
          //  System.out.println("MOVE MOVE MOVE");
             Guest_comming();
            player.move_guests(); // player click on sttart and guests start moving on panel
        }
        
        repaint();
        return true;
    }
    public void isTouchingPath(Point p)
    {
        if(Bld!=null){
          //  System.out.println("path value:"+ Bld.getP().getX()+","+Bld.getP().getY());
            Rectangle imageBounds = new Rectangle(Bld.getP().getX(),Bld.getP().getY(),Bld.getWidth(), Bld.getHeight());
            
            if(imageBounds.contains(p))
                System.out.println("TOUCHING THE PATH !");
        }
    }
    public boolean searchPath(int x, int y){
        if (map[x][y]/100 == 4 || map[x][y]/100 == 5){ return true; }
       // map[x][y]+=1;
        return false;
    }
//     [1:23 PM] Qiao Shuyan
//            System.out.println(map[x-1][y+1]/100);//first
//        System.out.println(map[x-1][y+1] / 10 %10);//second
//        System.out.println(map[x-1][y+1]%10);//third

    /*                         (index of type for the building, map x, map y )*/
    public boolean changePath(int ind,int x, int y) throws IOException{
        if(map[x][y]==000){
            //System.out.println(y);
            //System.out.println("change building");
        int temp_ind=ind*100;
        //if we want to build two kind of paths/guest/empty
        if(ind==4||ind==5||ind==0||ind==1){
             map[x][y]=temp_ind;
        }
        else if(x==0 || y== 12){
            JOptionPane.showMessageDialog(null, "Out of board");
            return false;
        
        }
        else if(map[x][y+1]!=000 &&  map[x-1][y]!=000 && map[x-1][y+1]!=000){
            JOptionPane.showMessageDialog(null, "the grid is not empty");
            return false;
        }
        else{
            // get the time of building needed
            var time = 3;
            var startTime = Time.getTime();
            System.out.println("BUILDING");
            /*
            while (Time.getTime() - startTime < time) {
            }*/
            System.out.println(temp_ind);
            map[x][y]=temp_ind;
            map[x][y+1]=temp_ind+10;
            map[x-1][y]=temp_ind+20;
            map[x-1][y+1]=temp_ind+30; 
        }
        refresh();
        // sleep 3 sec and then change the image
                int id = temp_ind/100;
                if ((id > 1 && id < 4)|| (id > 5 && id < 10)) {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            built_building(temp_ind);
                        } 
                    }, 3000);
                }
        return true;
        }
        else{        
            JOptionPane.showMessageDialog(null, "the grid is not empty");
            return false;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D gr = (Graphics2D)g;
        int w = TOTAL_ROWS;
        int h = TOTAL_COLS;
        print_map();
 for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){
                Image img = null;
                
                switch (map[y][x]/100){
                    case 0: 
                        img = empty; 
                        break;
                    case 1:
                        if(map[y][x]%10!=0) {
                         img = path_player_trash;
                            }
                        else{
                            img = path_trash;
                        }
                        break ;
                    case 2: 
                         // 0 ->game 1->garden 2->shop 3->path
                         switchGraph(x,y,imgPath.get("shop2"),gr,2);
                        break;
                        

                    
                    case 3: 
                         switchGraph(x,y,imgPath.get("iceCreamShop"),gr,2);
                        break;
                    case 4: 
                        //print_map();
                        if(map[y][x]%10!=0) {
                            img = Guest.guestImage;
                        //    System.out.println("WHAT IS IN THE MAP at (" + y + "," + x + ") = " + map[y][x]);
                        }
                        else{
                            img = path;
                        }
                        break;
                    case 5: 
                        if(map[y][x]%10!=0) {
                          
                            img = Guest.guestImage;
                          //  System.out.println("WHAT IS IN THE MAP at (" + y + "," + x + ") = " + map[y][x]);
                        }
                        else{
                            img = path_bin;
                        } break;
                    case 6: 
                          switchGraph(x,y,imgPath.get("garden1"),gr,1);
                        break;
                    case 7: 
                         switchGraph(x,y,imgPath.get("garden2"),gr,1);
                        break;
                    case 8: 
                         switchGraph(x,y,imgPath.get("game1"),gr,0);
                        break;
                        
                        
                    case 48:
                        switchGraph(x,y,imgPath.get("in_use"),gr,2);
                        break;

                    case 68:
                        switchGraph(x,y,imgPath.get("repair"),gr,2);
                        break;    
                        
                    case 9: 
                        switchGraph(x,y,imgPath.get("game2"),gr,0);
                        break;
                    case 49:
                        switchGraph(x,y,imgPath.get("in_use"),gr,2);
                        break;
                    case 69:
                        switchGraph(x,y,imgPath.get("repair"),gr,2);
                        break;   
                    case 18: 
                 //       System.out.println("CLEANER SHALL BE PRINTED");
                    
                        img=Cleaner.cleanerImage;
                    
                      //   switchGraph(x,y,imgPath,gr,0);
                        break;

                    case 19: 
                     //   System.out.println("REPAIRMAN SHALL BE PRINTED");
                        img=repairman.repairmanImage;
                       // switchGraph(x,y,imgPath,gr,0);
                        break;
                    default:
                        img = null;
                        break;
                }
                if (img == null) continue;
                total_length+=scaled_size;
                total_height+=scaled_size;
                //draws the img on board with distance of tile_size which is constant for all images 50 px
                gr.drawImage(img, x *tile_size , y *tile_size ,  tile_size, tile_size, null);
                img=null;
            }
        }
    }
    

    
    public void switchGraph(int x,int y,String imgPath,Graphics2D gr,Integer ind){
        switch (ind){
            case 0: 
                System.out.println(map[y][x]/10);
                gm=new Game(new Position (x*tile_size,y*tile_size),tile_size,tile_size ,100, 20, 5,imgPath,map[y][x]/10);
                gm.draw(gr,map[y][x]/10); 
                break;
            case 1: 
                grd=new Garden(new Position (x*tile_size,y*tile_size),tile_size,tile_size ,100, 20, 5,imgPath,map[y][x]/10);
                grd.draw(gr,map[y][x]/10); 
                break; 
            case 2: 
                sp=new Shop(new Position (x*tile_size,y*tile_size),tile_size,tile_size ,100, 20, 5,imgPath,map[y][x]/10);
                sp.draw(gr,map[y][x]/10); 
                break; 
         }
        gm = null;
        grd = null;
        sp = null;
    }
public void print_map()
{
     for (int i = 0; i <TOTAL_COLS; i++){
            for (int j = 0; j <TOTAL_ROWS ; j++){
                System.out.print(map[i][j]+" ");

            }
            System.out.println("");

        }
}
    public void createWorker(int x,int y,int index) {
 
       // System.out.println("creating the worker");
       boolean isCleaner=false;
       if(index==0)
       {
            this.map[y][x]=map[y][x]+Cleaner.id;
              
           isCleaner=true;
       }else{
            this.map[y][x]=map[y][x]+repairman.id;
       
       }
       add_worker(x,y,isCleaner);
      // print_map();
       refresh();
    }

    public void Guest_comming() {
      
            if(guest_count<4){
            map[8][6]=401;
            add_guests(6,8);
         //   print_map();
            }
            
    }

    
    public void built_building(int index) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                var val = index/100;
                switch (val){
                    case 2: 
                        imgPath.put("shop2", "data/shop2.png");
                        break;
                    case 3: 
                        imgPath.put("iceCreamShop", "data/ice_cream_shop.png");
                        break;
                    case 6: 
                        imgPath.put("garden1", "data/garden1.png");
                        break;
                    case 7: 
                        imgPath.put("garden2", "data/garden2.png");
                        break;
                    case 8: 
                        imgPath.put("game1", "data/game1.png");
                        break;
                    case 9: 
                        imgPath.put("game2", "data/game2.png");
                        break;
                    default:
                        break;
                }
                refresh();
            }
        });

    }
    



}

