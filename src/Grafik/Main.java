


package Grafik;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Robin
 */public class Main extends JFrame{
              
       public static enum STATE {MainMenu, Play, Quit};
       private int change=0;
       public static STATE state = STATE.MainMenu;
       private Field plan = new Field();
       private MainMenu menu = new MainMenu(this,plan);
       
            
     public Main(){
          //Min spelplans fönsterStorlek
          this.setSize(800, 480);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                
          setResizable(false);          
          setTitle("Celeb VolleyBoll!");
          add(menu);                   
          setVisible(true);
          repaint();
     }
          //Bestämmer vilken JPanel som visas
     public void setChange(int x){
         change=x;
         if(change == 0){add(menu);}
         if(change == 1){
            add(plan);
            plan.revalidate();}
         if(change == 2){System.exit(1);}
     }
     
 public static void main(String[] args){
             
   Main main = new Main();
   
         
 }      
}
