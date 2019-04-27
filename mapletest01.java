package ch03;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;
import java.util.Random;
import org.omg.CORBA.PUBLIC_MEMBER;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.*;



public class mapletest01 extends JFrame{
	
	BufferedImage img = null;
	Container cp=getContentPane();
	//JPanel jpn=new JPanel();
	//JImagePanel jip= null;
	
	
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon selectmap;

	
	public mapletest01(){
		//아이콘
		icon =new ImageIcon("startmenu.png");
		JPanel panel=new JPanel();
			//public void paintComponent(Graphics g){
			//	g.drawImage(icon.getImage(), 150, 150, 100, 100, this);
				
				//g.drawImage(icon.getImage(), 10, 10, null);
				//setOpaque(false);
             // super.paintComponent(g);
			//}
		
		JButton button=new JButton(icon);
		//button.setLocation(100, 50);
		panel.add(button);
		//cp.add(button);
		scrollPane =new JScrollPane(panel);
		setContentPane(scrollPane);
		//아이콘
		button.addActionListener(new ActionListener() {
			
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				JButton b= (JButton) e.getSource();
				
				 dispose();
				 mapletest02 mp2=new mapletest02();
				// add();
				
			}
			
			
		});
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("maplemade");
		this.setBounds(0,0,0,0);
		this.setSize(960,760);
		this.setVisible(true);//창열기
		
		//배경
	}
	
	public void paint (Graphics g){
		//g.drawString("이미지 그리기", 100, 80);//100,80 위치에 글씨입력
		
		Image img = Toolkit.getDefaultToolkit().getImage("map_start.jpg");//배경이미지 삽입 
		
		g.drawImage(img, 100, 100, 800, 600,this);// 이미지 수정
		
		//g.dispose();
	}
}
	/*
	public void buffering(){
		try{
			BufferedImage image1=ImageIO.read(new File("map_start.jpg"));
			BufferedImage image2=ImageIO.read(new File("startmenu.png"));
		    int width =Math.max(image1.getWidth(),image2.getWidth() );
		    int height=image1.getHeight()+image2.getHeight();
		    BufferedImage mergedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics= (Graphics2D) mergedImage.getGraphics();
	        graphics.setBackground(Color.WHITE);
	        graphics.drawImage(image1, 0, 0, null);
	        graphics.drawImage(image2, 0, image1.getHeight(), null);
	        ImageIO.write(mergedImage, "png", new File("mergestart.png"));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	*/

/*
class JImagePanel extends JPanel {
private Image img;

	public JImagePanel(Image image) {
		// TODO Auto-generated constructor stub
	 this.img=img;
	}
	public void paintComponent(Graphics g){
		g.drawImage(this.img, 0, 0, this.getWidth(),this.getHeight(),this);
	}
	
}*/





















































	






 