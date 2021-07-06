package amusementpark_demo.com.baldsunbirds.view;


import amusementpark_demo.com.baldsunbirds.controller.GamePanel;
import amusementpark_demo.com.baldsunbirds.controller.MenuPanel;
import amusementpark_demo.com.baldsunbirds.controller.NaviPanel;
import amusementpark_demo.com.baldsunbirds.entity.Guest;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import amusementpark_demo.com.baldsunbirds.utils.Position;
import amusementpark_demo.com.baldsunbirds.utils.Velocity;


public class GameFrame extends BaseFrame implements MouseListener {
    
    private NaviPanel naviBar;
    private MenuPanel menuBar;
    private GamePanel gameArea;
    private Float currFund = 750f;
    public static Boolean paused=true;
    private final int FPS = 5;
   boolean controlStatus=false;

    
    public GameFrame()  {
        super();
        Timer newFrameTimer;
        System.out.println("Game starts");
       // frame.setLayout(new BorderLayout());
        // the info box
        naviBar = new NaviPanel(this);
        naviBar.setPreferredSize(new Dimension(800, 100));
        naviBar.setLayout(null);
        naviBar.init();
        frame.add(naviBar, BorderLayout.NORTH);
        naviBar.setBackground(Color.gray);
        
        
        // for the build(pop up window)
        menuBar = new MenuPanel(this);
        menuBar.setPreferredSize(new Dimension(200, 450));
        menuBar.setLayout(null);
        menuBar.init();
        frame.add(menuBar, BorderLayout.EAST);
        menuBar.setBackground(Color.ORANGE);
        
        
        try {
            // game engine
            gameArea = new GamePanel(this);
        } catch (IOException ex) {
            System.out.println("BOARD ERROR : ");
            ex.getStackTrace();
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     
   
        gameArea.setLayout(new FlowLayout());
        gameArea.setPreferredSize(new Dimension(1150,650));
       // gameArea2.add(gameArea);
        gameArea.addMouseListener(this);
//        gameArea.addKeyListener(this);
        frame.add(gameArea, BorderLayout.CENTER);
       
        gameArea.setBackground(Color.GREEN);
        
        naviBar.updateFundTxt(currFund); // test
        frame.setResizable(false);
      
   
         
       
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setVisible(true); 
       frame.pack();
       
        System.out.println("dimENSION:"+(int)dim.getWidth()+","+(int)dim.getHeight());
      //  frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight()-20);
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener("frame"));
        newFrameTimer.start();
    }

    public void start()
    {
        this.paused=!paused;
    }
    
    public void addFund(Float amount) {
        this.currFund += amount;
        naviBar.updateFundTxt(currFund);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
        //takes mouse click co-ordinates and checks if point is touch any object or item other than grass 
        //gameArea.isTouchingPath(e.getPoint());
        int x=e.getX()/50;
        int y=e.getY()/50;
        // if select from the pop window, update from here
        if(menuBar.hasItem==true){  
            naviBar.updateFundTxt(currFund);
            try {
                // the changePath method will detect the bound and the grid
                // if no errors, it will paint the item
               if(menuBar.isWorker){
                   if(gameArea.searchPath(y, x))
                        gameArea.createWorker(x,y,menuBar.index);
                   else
                        JOptionPane.showMessageDialog(null, "the worker needs path ");
               }
               else{
                   
               
                if(gameArea.changePath(menuBar.index,y,x)){ 
                    currFund=currFund-menuBar.cost;
                    naviBar.updateFundTxt(currFund);
                };
                }
            } catch (IOException ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            } 
            menuBar.hasItem=false;
            menuBar.isWorker=false;

        }
        //System.out.println(e.getX()+","+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void setCurrFund(float currFund){
        this.currFund=currFund;
    }
    public float getCurrFund(){
        return currFund;
    }
    
    
    class NewFrameListener  implements ActionListener {

        public NewFrameListener(String frame) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!paused){
             
                // gameArea.Guest_comming();
                 gameArea.refresh();
                 
            }
        }
    }
    
}

