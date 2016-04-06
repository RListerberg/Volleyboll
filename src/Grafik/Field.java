
package Grafik;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Robin
 */
public class Field extends JPanel{
/**
 *
 * @author Robin
 */
    //instancevariables    
   // private Field plan = new Field();    
    private int xMax, yMax;
    private String p1Serve, p2Serve, quit;
    private Image fieldBackGround;
    private Image player1Pic;
    private Image player2Pic;
    private double bCollisionX, bCollisionY;
    Ball[] boll=new Ball[3];
    Player1 p1;
    Player2 p2;
    Ball b, b2, b3;    
    ArrayList<Integer> keysDown = new ArrayList<>();
    
    //Konstuktor
    public Field(){
        //Sätter upp storleken för våran volleybollplan
        setSize(800, 480);
        setBackground(Color.white);//planens bakgrundsfärg                
        p1 = new Player1();
        p2 = new Player2();
        p1Serve = "P1Serve";
        p2Serve = "P2Serve";
        quit = "Quit!";        
        boll[2] = new Ball(50, 100);                
        //spelarnas keyListeners                
        addKeyListener(new TAdapter());
        addComponentListener(c1);                
        fieldBackGround = new ImageIcon("BeachBackground.png").getImage();
        player1Pic = p1.getImage();
        player2Pic = p2.getImage();
        Controls c=new Controls();
        Timer tim=new Timer(10,c);         
        tim.start();
        setVisible(true);
    }
     public void p1Serve(){
        boll[2] = new Ball(250, 250);   
        p1.setPos(250,250);
     }
     //Detta är metoderna jag försöker anropa i mina Serveknappar
     public void p2Serve(){
        boll[2] = new Ball(550, 250);
        p2.setPos(550,250);
       
       // Controls c=new Controls();
       // Timer tim=new Timer(10,c);         
       // tim.start();
     }
    //Inre klass
    class Controls implements ActionListener{
    //Tidsstyrda händelser såsom gravitet och bollarnas rörelsemönster    
public void actionPerformed(ActionEvent e) {  
    
    boll[2].movement();
    //Spelarnas gravitation
    if(!(p1.getY() >= 300)){
        p1.setY();
    }
    if(!(p2.getY() >= 300)){
        p2.setY();
    }   
   p1.move();
   p2.move();   
   checkCollisions();//Anropa checkCollisions med objekt på spelplanen
   repaint();
}
 }
  //Kollitionsdetektor
    public void checkCollisions() {
    // Här skapar vi en osynlig kollisionsrektangel som läser av när objekten möts
//Hämta dimensionerna på player 1
        int w = player1Pic.getWidth(this);//Hämta player1 bredd
        int h = player1Pic.getHeight(this);//Hämta player1 höjd
//Hämtar dimensioner player 2
        int w2 = player2Pic.getWidth(this);
        int h2 = player2Pic.getHeight(this);        
      //Skapar osynliga "studsbegränsningar"  
      Rectangle rplayer2 = new Rectangle(p2.getX(), p2.getY(), w2, h2);      
      Rectangle rplayer1 = new Rectangle(p1.getX(), p1.getY(), w, h);//new Rectangle(p1.getX(), p1.getY(), w, h);//Använd klassen rectangle
      
      Rectangle net = new Rectangle(400, 200, 10, 200);
      //i awt-paketet för att skapa gränserna på player 1              
      //Hämta dimensionerna på bollarna          
            Rectangle rboll =  boll[2].getBounds();
                //Kolla om kollision föreligger
            if(net.intersects(rboll)){
                if(boll[2].getX() + boll[2].getRadie() > net.x + net.width){
                    bCollisionX = -boll[2].getVx();
                    boll[2].setVx(bCollisionX);
                }            
            }
            if (rplayer1.intersects(rboll)){                
                //intersects metod i klassen Rectangle som kollar om de två rectanglarna överlappar varandra                            
                //Byt håll på bollen med hjälp av getters och setters
                //änvänder intersection för att räkna ut vart på bollen vi träffar
               Rectangle insects = rplayer1.intersection(rboll);
               //Vänstersidan
               if(insects.x == rplayer1.x){
                   bCollisionX = -boll[2].getVx();
                   boll[2].setVx(bCollisionX);               
               }
               //Högersidan
               else if(insects.x + insects.width == rplayer1.x + rplayer1.width){                
                    bCollisionX = -boll[2].getVx();
                    boll[2].setVx(bCollisionX);
               }
               //Ovansidan
               if(insects.y == rplayer1.y){
                   bCollisionY = -boll[2].getVy();
                   boll[2].setVy(bCollisionY);
               }
               //Undersidan
               else if(insects.y + insects.width == rplayer1.y + rplayer1.width){
                   bCollisionY = -boll[2].getVy();
                   boll[2].setVy(bCollisionY);
               }
            }
            if (rplayer2.intersects(rboll)){                
                //intersects metod i klassen Rectangle som kollar om de två rectanglarna överlappar varandra                            
                //Byt håll på bollen med hjälp av getters och setters
                //rörelseändring beroende på vart bollen landar
               Rectangle insects = rplayer2.intersection(rboll);
               if(insects.x == rplayer2.x){
                   bCollisionX = -boll[2].getVx();
                   boll[2].setVx(bCollisionX);               
               }
               else if(insects.x + insects.width == rplayer2.x + rplayer2.width){                
                    bCollisionX = -boll[2].getVx();
                    boll[2].setVx(bCollisionX);
               }
               if(insects.y == rplayer2.y){
                   bCollisionY = -boll[2].getVy();
                   boll[2].setVy(bCollisionY);
               }
               else if(insects.y + insects.width == rplayer2.y + rplayer2.width){
                   bCollisionY = -boll[2].getVy();
                   boll[2].setVy(bCollisionY);
               }
            }
            
        }
    private class TAdapter extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            p1.keyPressed(e);
            p2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p1.keyReleased(e);
            p2.keyReleased(e);
        }
    }
public void paint(Graphics g){   
    //skapar en image och skickar över den till våran paint metod
    Image offScreen = createImage(getWidth(), getHeight());
    draw(offScreen.getGraphics());
    //ritar ut bilden från origo till max, använder null för att inte rita ut en bild föräns vi har en
    g.drawImage(offScreen, 0, 0, null);                     
}    
public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //bakgrunden
        g.drawImage(fieldBackGround, 0, 0, null);
        //Player1 och player2
        g2.drawImage(player1Pic, p1.getX(), p1.getY(), this);
        g2.drawImage(player2Pic, p2.getX(), p2.getY(), this);                        
        //nätet i mitten och knapparna på våran spelplan
        g.setColor(Color.BLACK);
        g.fillRect(400, 200, 10, 200);
        g.drawRect(0, 400, 100, 50);
        g.drawRect(695, 400, 100, 50);
        g.drawRect(350, 400, 100, 50);
        Font butStr = new Font("Comic Sans MS", Font.BOLD, 24);
        g.setFont(butStr);
        g.drawString(p1Serve, 2, 430);
        g.drawString(p2Serve, 698, 430);
        g.drawString(quit, 370, 430);
        boll[2].paint(g);
        //skapar en "fuskLoop" så våran paint metod körs om när vi flyttar karaktären
        repaint();
    }      
    ComponentListener c1 = new ComponentAdapter(){
        @Override
        public void componentResized(ComponentEvent e){
            
            xMax = e.getComponent().getSize().width;
            yMax = e.getComponent().getSize().height;
            e.getComponent().requestFocus();
            repaint();                    
                }
};   
       
       
};
   



