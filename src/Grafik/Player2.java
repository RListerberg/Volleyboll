
package Grafik;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/* @author Robin */
public class Player2 {
    //instansvariabler för spelare2    
    private int pGravity = 2;
    private int player2x, player2y;
    private int p2dx, p2dy;
    private Image player2Pic;
         
    public Player2(){        
        player2Pic = new ImageIcon("player2.png").getImage();                
        player2x = 700;
        player2y = 300;                
    }
    //sätter upp olika Get och Set metoder för spelarens rörelse och position
    public Image getImage(){
        return player2Pic;
    }
    //Vill skapa en Boolean som gör min move metod till false
    public void move(){              
       moveX();
       moveY();                     
    }
    public void moveX(){
        player2x =  getPlayer2x(p2dx);
    }
    public void moveY(){
        player2y =  getPlayer2y(p2dy); 
    }
    public int getX() {
        return player2x;
    }
    public int getY() {                
        return player2y;
    }
     public void setYS(int p2dy){
        this.p2dy = p2dy;
    }
    public void setXS(int p2dx){
        this.p2dx = p2dx;
    }
    public void setY(){
        this.player2y += pGravity;
    }  
    public void setPos(int x, int y){
        this.player2x =x;
        this.player2y =y;
    }
     public void keyPressed(KeyEvent e) {
            //Player2 kontroller
            int key = e.getKeyCode();
        
            if(key==KeyEvent.VK_UP && player2y == 300 && player2y >= 300){                
                setYS(-10);                                
            }            
            if(key==KeyEvent.VK_LEFT){
                setXS(-5);                
            }
            if(key==KeyEvent.VK_RIGHT){               
                setXS(5);               
            }
     }
     public void keyReleased(KeyEvent e){
            
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
            p2dy = 0;
            }
            if (key == KeyEvent.VK_DOWN) {
            p2dy = 0;
            }
            if (key == KeyEvent.VK_LEFT) {
            p2dx = 0;
            }
            if (key == KeyEvent.VK_RIGHT) {
            p2dx = 0;
            }
     }
     //Spelarens rörelsebegränsningar
    public int getPlayer2x(int dx) {
       int move=dx+player2x;
     if(move <= 410){
        move=410;
    }else if(move >= 730){
        move=730;
    }
        return move;
    }
    public int getPlayer2y(int dy) {
     int move=dy+player2y;     
    if(move <= 0){
        move=0;
    }else if(move >= 300){
        move=300;
    }
        return move;
    }
                   
}
