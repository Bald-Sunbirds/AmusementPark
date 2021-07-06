/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.utils;

import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_COLS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.TOTAL_ROWS;
import static amusementpark_demo.com.baldsunbirds.controller.GamePanel.map;
import java.util.ArrayList;
import java.util.List;


public class Search {
    private static int nodeNum = 0;
    private static Integer[][] graph;         //        right  up  
    private static int[][] direction = {  {0, -1}, {1, 0},{0, 1}, {-1, 0}};
    private static Integer[][] visited;
    public  boolean findPath=false;
   public List<Integer> listx = new ArrayList<>();
   public List<Integer> listy = new ArrayList<>();
    public Search() {}

    public Search(Integer[][] graph) {
        this.graph = graph;
        visited = new Integer[graph.length][graph[0].length];
    }

    public int getNodeNum() {
        return nodeNum;
    }

  

    private void initializeVisited() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++)
                visited[i][j] = 0;
        }
    }

    
    public void dfs(int x, int y,int goalX,int goalY) {
        nodeNum = 0;
        initializeVisited();
        dfsTrace(x, y, goalX,goalY);
        int tmpNum=nodeNum;
         for(int i=nodeNum;i>0;i--){
             if( ( Math.abs(listx.get(i)-listx.get(i-1)) + Math.abs(listy.get(i)-listy.get(i-1))  )>1 ){
                 listx.remove(i-1);listy.remove(i-1);
                 tmpNum--;
             }
         }

            for(int i=0;i<=tmpNum;i++){
                System.out.println(listx.get(i)+"   "+listy.get(i));
         }

    }


    private void dfsTrace(int x, int y,int goalX,int goalY) {

        visited[x][y] = 1;  

        listx.add(x);listy.add(y);
        int i=0;
            if(x==goalX && y == goalY){
            System.out.println("end");
            findPath=true;
            }
        while(i < direction.length  && findPath==false) {
            int tx = x + direction[i][0];
            int ty = y + direction[i][1];
           if (tx >= 0 && ty >= 0 && tx < graph.length && ty < graph[0].length &&
                  (graph[tx][ty] /100 ==4 ||graph[tx][ty] /100 ==5||graph[tx][ty] /100 ==1||graph[tx][ty] /100 ==18||graph[tx][ty] /100 ==19)  && visited[tx][ty] == 0) {
               
             nodeNum++;
             dfsTrace(tx, ty,goalX,goalY);
            }
            i+=1;
        }
        
    }   
    }
