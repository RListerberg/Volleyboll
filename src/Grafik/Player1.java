
package Grafik;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javafx.scene.shape.Circle;
import javax.swing.ImageIcon;


/* @author Robin */
public class Player1 {
    //instansvariabler för spelare1
    private int pGravity = 2;
    private int player1x, player1y;
    private int p1dx, p1dy;
    private Image player1Pic;
     
      public Player1(){
        player1Pic = new ImageIcon("player1.png").getImage();                
        player1x = 50;
        player1y = 300;        
    }
    //Get och set metoder för spelarens position och rörelse  
    public Image getImage(){
        return player1Pic;
    }
    //Vill skapa en Boolean som gör min move metod till false
    public void move(){                     
        moveX();
        moveY();                     
    }
    public void moveX(){
       player1x =  getPlayer1x(p1dx); 
    }
    public void moveY(){
       player1y = getPlayer1y(p1dy); 
    }    
    public int getX() {
        return player1x;
    }
    public int getY() {                
        return player1y;
    }
    public int getVy(){
        return p1dy;
    }
    public int getVx(){
        return p1dx;
    }
    public void setYS(int p1dy){
        this.p1dy = p1dy;
    }
    public void setXS(int p1dx){
        this.p1dx = p1dx;
    }
    public void setY(){
        this.player1y += pGravity;
    }
    public void setPos(int x, int y){
        this.player1x =x;
        this.player1y =y;
    }
    
     public void keyPressed(KeyEvent e) {
            //Player1 kontroller
            int key = e.getKeyCode();
        
            if(key==KeyEvent.VK_W && player1y == 300 && player1y >= 300){
                setYS(-10);
            }           
            if(key==KeyEvent.VK_A){
                setXS(-5);                
            }
            if(key==KeyEvent.VK_D){               
                setXS(5);               
            }
     }
     public void keyReleased(KeyEvent e){
            
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_W) {
            p1dy = 0;
            }
            if (key == KeyEvent.VK_S) {
            p1dy = 0;
            }
            if (key == KeyEvent.VK_A) {
            p1dx = 0;
            }
            if (key == KeyEvent.VK_D) {
            p1dx = 0;
            }
     }
     //Spelarens rörelsebegränsningar
    public int getPlayer1x(int dx) {
       int move=dx+player1x;
     if(move <= 0){
        move=0;
    }else if(move >= 340){
        move=340;
    }
        return move;
    }
    public int getPlayer1y(int dy) {
     int move=dy+player1y;     
    if(move <= 0){
        move=0;
    }else if(move >= 300){
        move=300;
    }
        return move;
    }
               
    }

