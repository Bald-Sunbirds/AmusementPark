/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.entity;

import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_COLS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_ROWS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.guest_count;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.map;



import static amusementpark_demo.com.baldsunbirds.utils.WaitingList.wlist;
import static amusementpark_demo.com.baldsunbirds.utils.RepairList.rlist;

import amusementpark_demo.com.baldsunbirds.utils.Search;
import amusementpark_demo.com.baldsunbirds.utils.Cost;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.utils.Velocity;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Arbab Ali
 */
public abstract class Sprite extends Base {
      Velocity vel;
    Integer Identity_num; // Number to put on map for guest ->10 for cleanr ->11 for repairman->12
 
    private static int[][] direction = { {0, -1},{0, 1}, {-1, 0}, {1, 0}};
    int[] myList = new int[4]; 
    Random random = new Random();
    int r; int step=0;

    public boolean arrive=false;
    public boolean has_list=false;

    int listInd=0;
    public List<Integer> listX = new ArrayList<>();
    public List<Integer> listY = new ArrayList<>();
    
    
    int move_in_Building=0;
    Cost cst;
    private boolean throw_rubbish=false;
    public int mood=100;
    
    private boolean path_bin = false;
    private boolean path_trash = false;
    
    GameFrame gf;
    private boolean use=false;
    
    
    
    public Sprite(Position p,Velocity v, Integer width, Integer height, Image baseImage,Integer id, GameFrame gf) {
        super(p, width, height, baseImage);
        this.vel=v;
        this.Identity_num=id;
        this.gf = gf;
    }
    public void moveX(int dir)
    {

        if(this.getP().getX()+dir<TOTAL_ROWS){ ///edge condition
           if(searchPath(p.getY(),p.getX()+dir)){
            if(this.getP().getY()<TOTAL_COLS) {
                
                change_pos_in_MAP(p.getX() + dir, p.getY());
               this.setP(new Position(p.getX() + dir, p.getY()));
            }
           }else{
                 //   System.out.println("ENTER BUILDING");
                }

        }else{

            this.setP(new Position(0,p.getY())); //if edge then go back to 0
            change_pos_in_MAP(p.getX(),p.getY()); //also change the positon on MAP grid

        }
    }
    public void moveY( int dir)
    {

         if(this.getP().getX()<TOTAL_ROWS){ ///edge condition
            if(this.getP().getY()+dir<TOTAL_COLS) {
               if(searchPath(p.getY()+dir,p.getX())){
                change_pos_in_MAP(p.getX(), p.getY() + dir);
               this.setP(new Position(p.getX() , p.getY()+dir));
                }
                else{
                   // System.out.println("ENTER BUILDING");
                }
            }

        }else{

           // this.setP(new Position(0,p.getY())); //if edge then go back to 0
            change_pos_in_MAP(p.getX(),p.getY()); //also change the positon on MAP grid

        }
    }
 
    
    

    
    public void moveXY(){
       /* for(int i=0; i <4;i++){
        myList[i]=0;
        }
        
        for(int i=0; i <4;i++){ 
            int tx = p.getX() + direction[i][0];
            int ty = p.getY()+ direction[i][1];
            System.out.println("tx: "+tx + " ty: "+ty);
            if(tx<TOTAL_ROWS && ty<TOTAL_COLS  && tx>0 && ty>0){
                if(searchPath(ty,tx)){ myList[i]=1;}
            }      
        }
        
        
       boolean changePath=false;
       while(changePath==false){
       int r=random.nextInt(4);
       if(myList[r]==1){
        change_pos_in_MAP(p.getX() + direction[r][0], p.getY()+ direction[r][1]);
        changePath=true;
               System.out.println("change to: " + p.getX() + direction[r][0]+" "+p.getY()+ direction[r][1]);
       }
       }*/
       
       for(int i=0; i <4;i++){
        myList[i]=0;
        }
        if(p.getY()+1<TOTAL_COLS  ){
           if(searchPath(p.getY()+1,p.getX())){
           myList[0]=1;
        }}
                     
        
         if(  p.getY()-1>=0)
             {if(searchPath(p.getY()-1,p.getX()))
             { myList[1]=1;}
             
            }
        
        if(  p.getX()+1<TOTAL_ROWS){
                        if(searchPath(p.getY(),p.getX()+1) )    {myList[2]=1; }               
        }
         if(  p.getX()-1>=0){
                    if(searchPath(p.getY(),p.getX()-1) ){     myList[3]=1;               
            }
                   
        }
         int temp=-1;
         while(temp==-1)
         { r=random.nextInt(4);
        if(myList[r]==1){temp=1;}   
         }

        switch(r)
        {
         case 0: 
                change_pos_in_MAP(p.getX(), p.getY() + 1);
                this.setP(new Position(p.getX() , p.getY()+1));
             break;
         case 1: 
                change_pos_in_MAP(p.getX(), p.getY() -1);
               this.setP(new Position(p.getX() , p.getY()-1));
            break;
         case 2: 
                          change_pos_in_MAP(p.getX() +1, p.getY());
               this.setP(new Position(p.getX() + 1, p.getY()));
             break;
         case 3: 
                             change_pos_in_MAP(p.getX() -1, p.getY());
               this.setP(new Position(p.getX() - 1, p.getY()));
             break;
        }
        step+=1;

       //
       if(throw_rubbish)
       {  
            r=random.nextInt(4);
                     //  25 %  try to throw rubbish
            if(r==1){ 
           if(map[p.getY()][p.getX()]/100==5){       //if there is a rubbish bin ->throw rubbish  
                  throw_rubbish=false;
           }
           else{
             //if there is no rubbish bin ->throw rubbish into the path
               map[p.getY()][p.getX()]=map[p.getY()][p.getX()]%10+100;
              throw_rubbish=false;
           }
            
           }
           
       }

    }
    
    private void create_list(){
        Search g2 = new Search(map);
        g2.dfs( p.getY(),p.getX(),8,0);  //(local position X, local position Y, aim position X, aim position Y )
        listX= new ArrayList<Integer>(g2.listx); //listx and listy will give you a list of path to arrive the aim
        listY=new ArrayList<Integer>(g2.listy);
        has_list=true;
    } 
    
    public void move_to_gate(){                
          change_pos_in_MAP(listY.get(listInd),listX.get(listInd));
          this.setP(new Position(listY.get(listInd),listX.get(listInd)));
          if(p.getX()==0 && p.getY()==8){
          arrive=true;
          guest_count--;
          }
          listInd+=1;
    }
    
    
    public boolean near_building(){
                 
    if(p.getX()+1<TOTAL_ROWS ){

        int mapfirst=map[p.getY()][p.getX()+1] /100 ;
        int mapSec=map[p.getY()][p.getX()+1]/ 10 %10 ;
        if(mapfirst!=4 &&mapfirst!=5 && mapfirst!=0  && mapfirst!=1
                && mapSec== 0 ){
             return true;
        }
    }
    /*if(p.getY()-1>0){
        int mapfirst=map[p.getY()-1][p.getX()] /100 ;
        int mapSec=map[p.getY()-1][p.getX()]/ 10 %10 ;
        if(mapfirst!=4 &&mapfirst!=5 && mapfirst!=0 
            && mapSec== 0 ){
             return true;
        }
    }*/
        return false;
    
    }
    
    public boolean waiting_list(){
        if(wlist[p.getY()][p.getX()+1]==2){
            mood-=10;
            return true;// need to wait
        }
        return false;//doesn't need to wait
    }
    
    public void enter_building(){
         int buildingType=map[p.getY()][p.getX()+1]/100;
         if( map[p.getX()+1][p.getY()]<6000){
         if(buildingType==8 || buildingType==9 ||(buildingType>20 && buildingType<50))
            forGames();
          else
            otherBuilding(buildingType);
         }
    }

    
    public void forGames(){
     if(use|| !waiting_list() ){
            switch(move_in_Building){ /// do not consider when we can not find the leaving path after leaving door

                case 0: 
                    if(!use){
                        mood+=30;
                        cst=new Cost();
                        cst.setFund(2);
                        gf.addFund(cst.getFund());
                        
                    

                         map[p.getY()][p.getX()] --;
                         wlist[p.getY()][p.getX()+1]+=1;
                        //if(wlist[p.getY()][p.getX()+1]==2)
                            // change_state1(p.getX()+1,p.getY());
                        use=true;
                        }
                    else{
                        if(wlist[p.getY()][p.getX()+1]==2){
                              move_in_Building+=1;
                              if(map[p.getY()][p.getX()+1]<2000){
                                  change_state(p.getX()+1,p.getY(),2000);
                                  //System.out.println("2222222233333");
                              }
                        }
                    }
                        break;
                case 1:  
                        move_in_Building+=1;

                        break;
                case 2:  
                        move_in_Building+=1;
  

                        break;
                case 3:  
                        move_in_Building=0;
                       // if(wlist[p.getY()][p.getX()+1]==2)
                                                //change_state2(p.getX()+1,p.getY());
                        wlist[p.getY()][p.getX()+1]-=1;
                       /* if(wlist[p.getY()][p.getX()+1]==0){
                            change_state2(p.getX()+1,p.getY());
                            System.out.println("go out");
                        }*/
                                                rlist[p.getY()][p.getX()+1]+=1;

 
                        change_state(p.getX()+1,p.getY(),-2000);
                        if( rlist[p.getY()][p.getX()+1]==2){
                          change_state(p.getX()+1,p.getY(),6000);
                          System.out.println("===================");
    
                           System.out.println( map[p.getX()+1][p.getY()]);


                          System.out.println("===================");
                        }
                        map[p.getY()-1][p.getX() + 3]+=1;
                        this.setP(new Position(p.getX() + 3, p.getY()-1));
                        use=false;
                        

                        break;
            
            }                
 

              //wait some sec and guest disapear
            //go to the next grid or go back
            
        }
    
    
    
    }
    
      public void otherBuilding(int buildingType) {
       switch(move_in_Building){ /// do not consider when we can not find the leaving path after leaving door

                case 0: 
                        mood+=30;
                        cst=new Cost();
                        cst.setFund(2);
                        gf.addFund(cst.getFund());
                         map[p.getY()][p.getX()] --;
                         move_in_Building+=1;
  
                        break;
                case 1:  
                        move_in_Building+=1;

                        break;
                case 2:  
                        move_in_Building+=1;
  

                        break;
                case 3:  
                        move_in_Building=0;
                        if( buildingType==2 || buildingType==3)
                        {  throw_rubbish=true;} 
                        map[p.getY()-1][p.getX() + 3]=map[p.getY()-1][p.getX() + 3]+1;
                        this.setP(new Position(p.getX() + 3, p.getY()-1));            
                        break;
            
            }                
 
      
      
      }
      
      public void change_state(int x,int y,int c){
        map[y-1][x]+=c;
        map[y-1][x+1]+=c;
      }  
      

 public void move()
    {
        if(arrive){ 
        //guest should disappear

        }
        //move to gate <- guest
        else if(mood==0 && !arrive && move_in_Building ==0){
              //1.  create the list (!! step is a changable condition)
              //2. go to the gate with list
            if(!has_list){
                create_list();
                move_to_gate();
            }
            else{
                move_to_gate();
            }
        
        }
        // Normal move
        else if(!arrive){
            //if it has arrived to the grid near entry door of building-> ind //(x,y-1)=a0b OR// (x+1,y)=a0b, a !=4,5,0
            if(near_building() || move_in_Building !=0){
            enter_building();
            }
            else {
                moveXY(); 
                mood-=1;
            }
                  
        }
                System.out.println("mood: "+mood);
    }

     public void change_pos_in_MAP(Integer x ,Integer y)
    {
        
        
        if(x<TOTAL_ROWS){ //if postion to put is in not edge
            //System.out.println("DO YOU SEARCH HERE  CHECK #1");
            if(y<TOTAL_COLS) //if postion to put is not edge in both horizontal and vertical
            {
                //System.out.println("DO YOU SEARCH HERE  CHECK #2");
               if( searchPath(y,x)){
                  // int  temp_frwd_elem= map[y][x];//save previous digit   220
                  
                //System.out.println("DO YOU SEARCH HERE  CHECK #3");
                if(this.getClass()==Guest.class)  
                {   map[y][x]=map[y][x]+1;
                   map[this.getP().getY()][this.getP().getX()]=map[this.getP().getY()][this.getP().getX()]-1;// change the zero to old place
                }
                else if(this.getClass()==Cleaner.class)
                {        
                    
                    if(path_bin){
                      map[y][x]=1800+map[y][x]%10;
                      map[this.getP().getY()][this.getP().getX()]=map[this.getP().getY()][this.getP().getX()]%10+500;
                      path_bin=false;
                    }
                    else if(map[y][x]/100 == 5){
                          path_bin=true;       
                          map[y][x]=1800+map[y][x]%10;
                          map[this.getP().getY()][this.getP().getX()]=map[this.getP().getY()][this.getP().getX()]-1400;
                    }
                    else{
                          map[y][x]=1800+map[y][x]%10;
                          map[this.getP().getY()][this.getP().getX()]=map[this.getP().getY()][this.getP().getX()]-1400;
                    }
                        //map[y][x]=map[y][x]+1400;
                  
                  // int old_place=
                  // if (map[this.getP().getY()][this.getP().getX()] /100 ==4)
                 // change the zero to old place
                } else if (this.getClass()==repairman.class)
                {
                      map[y][x]= map[y][x]+1500;
                
                   map[this.getP().getY()][this.getP().getX()]=map[this.getP().getY()][this.getP().getX()]-1500;// change the zero to old place
             
                }
               }else{
                   
                //System.out.println("BUILDING FOUND ");
                   map[y][x]=map[y][x];
               }

            } else{
                
               // System.out.println("DO YOU SEARCH HERE   else CHECK #2");
                if(x<TOTAL_ROWS)
                {
                     //System.out.println("DO YOU SEARCH HERE    CHECK #4");
                    map[TOTAL_COLS-1][this.getP().getX()]=0;
                }
                else{
                 // System.out.println("DO YOU SEARCH HERE   else CHECK #4");
                    map[TOTAL_COLS-1][this.getP().getX()-1]=0;
                    
                }
            }
        }
        else{
           // System.out.println("DO YOU SEARCH HERE   else CHECK #1");
            if(y<TOTAL_COLS) //if horizontal edge is there then check if vertical edge
                map[this.getP().getY()][TOTAL_ROWS-1]=0;
            else{ //if both edges exists then put on one previous postion and
                map[TOTAL_COLS-1][TOTAL_ROWS-1]=0;
            }
        }
    }
    public boolean searchPath(int y, int x){
        //System.out.println("map["+y+"]"+"["+x+"]="+map[y][x]);
        if (map[y][x]/100 == 4 || map[y][x]/100 == 5 ||map[y][x]/100 == 1||map[y][x]/100 == 18||map[y][x]/100 == 19){ return true; }
        // map[x][y]+=1;
        return false;
    }
    

}









