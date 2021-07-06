package amusementpark_demo.com.baldsunbirds.entity;

import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.guest_count;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.map;
import amusementpark_demo.com.baldsunbirds.utils.Cost;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.utils.ResourceLoader;
import amusementpark_demo.com.baldsunbirds.utils.Search;
import amusementpark_demo.com.baldsunbirds.utils.Velocity;
import amusementpark_demo.com.baldsunbirds.view.GameFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


  import static amusementpark_demo.com.baldsunbirds.utils.RepairList.rlist;
/**
 *
 * @author Arbab Ali
 */
public class repairman  extends Sprite{
   public  static   Image repairmanImage=ResourceLoader.loadImage("data/repair_with_path.png");
    public static int  id = 1500;
   int ind=0;
   int tmpstep=0;
   
   public boolean repair=false;
    int ar_x,ar_y;
   
    public repairman(Position p, GameFrame gf) {        
        super(p,new Velocity(1,1), 40, 60, repairmanImage,id, gf);
    }
    
    private void create_list_for_building(int x,int y){
        Search g2 = new Search(map);
        g2.dfs( p.getY(),p.getX(),x,y);  //(local position X, local position Y, aim position X, aim position Y )
        listX= new ArrayList<Integer>(g2.listx); //listx and listy will give you a list of path to arrive the aim
        listY=new ArrayList<Integer>(g2.listy);

        has_list=true;
    } 
    
    public void move_to_desitnation(int x,int y){     
         if(p.getX()==y && p.getY()==x){ 
              arrive=true;
          }
         else{
          change_pos_in_MAP(listY.get(listInd),listX.get(listInd));
          this.setP(new Position(listY.get(listInd),listX.get(listInd)));

          listInd+=1;
         }
    }
  private void needRepair(){
     for (int row=0; row < rlist.length; row++)
{
    for (int col=0; col < rlist[row].length; col++)
    {
        if(rlist[row][col]==2)
                {   
                     ar_x=row;
                     ar_y=col;
                    repair=true;
                }
    }
}

  }
    
   public void move()
    {
        if(arrive){ 
            change_state(p.getX()+1,p.getY(),-6000);
            
            //need to wait some times
            
                        cst=new Cost();
                        cst.setFund(10);
                        gf.addFund(cst.getFund());
            arrive=false;
            repair=false;
            has_list=false;
            rlist[p.getY()][p.getX()+1]=0;
            //delete this repair man

   
        }
        else if(!repair){
           moveXY(); 
           needRepair();

        }
        //move to gate <- guest
        else if(!arrive && repair){
             if(!has_list){
             create_list_for_building(ar_x,ar_y-1);
             
             }
          else{
             
              move_to_desitnation(ar_x,ar_y-1);
             }
        }


    }
}
   

   
