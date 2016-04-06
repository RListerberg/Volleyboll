
package Grafik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javafx.scene.shape.Circle;

/* @author Robin */
public class Ball {
    
    private int bRadius = 20;
    private int ballx = 405;
    private int bally = 200;
    private double vballx = 1.5;
    private double vbally = 1;    
    private double gravity = 5;
    private double bTime = 0.2;
    private double energyLoss = 0.65;
    private double xFriktion = 0.9;
    private int intcolor=0;
     
// lägger till flera konstruktorer för multipla bollar
    public Ball(){
    }
    
    public Ball(int i, int j) {
        ballx = i;
        bally = j;
    }
               
    public void movement(){
    //Här placerar du koden för tidsstyrda händelser
    //lägger till bollens alla yttre kanter för spelplanen
    //sätter upp kanterna i xLed med hjälp av x positioner och xhastighet
    if(ballx + vballx > 800 - bRadius-1){
        ballx = 800 - bRadius - 1;
        vballx = - vballx;
    }else if(ballx + vballx < 0 + bRadius){
                ballx = 0+bRadius;
                vballx = -vballx;
    }else{
            ballx += vballx;
    }
    //lägger till friktion varje gång bollen tar i marken
    if(bally == 400 - bRadius - 1){
        vballx *= xFriktion;
        if(Math.abs(vballx) < 0.8){
            vballx = 0;
        }
    }
    //Gravitationen påverkar bollen i y-led samt att vi har bestämt våran mark
    if(bally > 400 - bRadius -1){
        bally = 400 -bRadius - 1;
        vbally *= energyLoss;
        vbally = -vbally;
    }else{
        //Hastighetsöknings i yLed
        vbally += gravity * bTime;
        //postions formel
        bally += vbally * bTime + 0.5*gravity*bTime*bTime; 
    }
    }
    //SKAPA EN SET METOD SOM SKICKAR VÅRAN ÄNDRING I RIKTNINGEN
    public int getX(){
        return ballx;  
    }
    public int getY(){
        return bally;
    }
    public int getRadie(){
        return bRadius;
    }
    public double getVx(){
        return vballx;
    }
    public double getVy(){
        return vbally;
    }
    public void setVy(double vbally){
        this.vbally = vbally;
    }
    public void setVx(double vballx){
        this.vballx = vballx;
    }
     public Rectangle getBounds() {
        return new Rectangle(ballx, bally, bRadius, bRadius);
    }
    public void paint(Graphics g){    
        //Bollen
        if(intcolor==0){
         g.setColor(Color.BLUE);}else{
         g.setColor(Color.RED);  
        }
        g.fillOval(ballx-bRadius, bally-bRadius, bRadius*2, bRadius*2);
    }
}
