

package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class win extends JFrame {
	Image[] winlose=new Image[2]; 
	public win(){
		
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		this.setTitle("win");	
		this.setBounds(0,0,0,0);
		this.setSize(960,700);
		
		this.setVisible(true);//Ã¢¿­±â
		
		
		
		lose.schedule(lose1, 1,100);
		
		
		}
	Timer lose=new Timer();

	TimerTask lose1=new TimerTask(){

		public void run(){
			repaint();
			//add(new mapletest04(c, str,mp,hp,level));
		}
		
	};	

public void paint(Graphics g){
    winlose[0]= Toolkit.getDefaultToolkit().getImage("winlose//win.gif");
    g.drawImage(winlose[0], 200, 50, 500, 500,this);
    //winlose[1]= Toolkit.getDefaultToolkit().getImage("winlose//win.gif");
    
    
    
}
}