
package Grafik;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* @author Robin */
public class MainMenu extends JPanel{
           
        private int state=0;
        private Rectangle startBut;
        private Rectangle quitBut;
        private Image fieldBackGround;
        private Image player1Pic;
        private Image player2Pic;
        private String startStr, quitStr;
        Main theMain;
        Field plan;
        Ball boll;
    public MainMenu(Main x,Field y){ 
      
      this.theMain=x;
      this.plan=y;
      boll = new Ball();
      startStr = "START";
      quitStr = "QUIT";
      startBut = new Rectangle(50, 150, 100, 50);
      quitBut = new Rectangle(200, 150, 100, 50);
      fieldBackGround = new ImageIcon("BeachBackground.png").getImage();
      player1Pic = new ImageIcon("player1.png").getImage();
      player2Pic = new ImageIcon("player2.png").getImage();
      addMouseListener(new mouseInput());
      setVisible(true);
      
    }
    
        public void paint(Graphics g){
            
            Graphics2D g2 = (Graphics2D) g;            
            g.drawImage(fieldBackGround, 0, 0, null);
            g2.draw(startBut);                        
            g2.draw(quitBut);            
            g.drawImage(player1Pic, 620, 300, null);
            g.drawImage(player2Pic, 700, 300, null);            
            Font gameTitle = new Font("Comic Sans MS", Font.BOLD, 50);
            g.setFont(gameTitle);
            g.setColor(Color.BLACK);
            g.drawString("CELEB VOLLEYBOLL!", 50, 100);
            Font butStr = new Font("Comic Sans MS", Font.BOLD, 25);
            g.setFont(butStr);
            g.drawString(startStr, 58, 190);
            g.drawString(quitStr, 215, 190);
                        
        }
        public class mouseInput implements MouseListener{
    //Hittar våra X och Y kordinater för våran muspekare
    //Lägger ut kordinaterna där mitt mouseevent ska utföra något
        public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        //StartButton
        if(mouseX >= 50 && mouseX <= 150 ){
            if(mouseY >= 150 && mouseY <= 200){               
               state=1;
               theMain.setChange(state);
               System.out.println("PLAY GAME!!");
            }
        }
        //quit button
        if(mouseX >= 200 && mouseX <= 300){
            if(mouseY >= 150 && mouseY <= 200){                
                state=2;
                theMain.setChange(state);
                System.out.println("QUIT GAME!!");
            }
        }
        if(mouseX >= 0 && mouseX <= 100){
                if(mouseY >= 400 && mouseY <= 450){
                    plan.p1Serve();
                    System.out.println("P1SERVE");
                     
                }
            }
            //Player 2 serve
            if(mouseX >= 695 && mouseX <= 795){
                if(mouseY >= 400 && mouseY <= 450){
                    plan.p2Serve();
                    System.out.println("P2Serve!");
                    
                }                
            }
            //Quit game
            if(mouseX >= 350 && mouseX <= 450){
                if(mouseY >= 400 && mouseY <= 450){
                    state=2;
                    theMain.setChange(state);
                    System.out.println("QUIT GAME!");
                }
            }
        
    }
        @Override
        public void mouseClicked(MouseEvent e) {
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
    }
                 
}
