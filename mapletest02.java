package ch03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class mapletest02 extends JFrame {
	double hunt;
	String st;
	int hp=452;
	int mp=452;
	int level=1;
	String war="전사";
	String mag="마법사";
	String arr="궁수";
	String thi="도적";
	int i=0;
	int j;
	
	JScrollPane scrollPane;
	Graphics gs;
	JButton b;
	JButton b1;
	JButton leftselect;
	JButton rightselect;
	BufferedImage img04;
	JTextField tf;
	ImageIcon icon01=new ImageIcon("selectbutton_okey.png"); 
	ImageIcon icon02=new ImageIcon("selectbutton_not.png");
	ImageIcon icon03=new ImageIcon("select_left.png");
	ImageIcon icon04=new ImageIcon("select_right.png");
	Container con;
	  	JPanel jp =new JPanel();
	  	JPanel jp1 =new JPanel();
	  	JLabel jl=new JLabel();
	  
	  	
         
	public mapletest02(){
		
		
	
	jpaneltest();
	jbuttontest();
	//con.add(tf);
	con.add(b);
	con.add(b1);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("maplemade2");	
	this.setBounds(0,0,0,0);
	this.setSize(960,760);
	this.setVisible(true);//창열기
	//frame02.schedule(frame02_1, 1,100);
	
	
	}
	private Timer frame02=new Timer();

private TimerTask frame02_1=new TimerTask(){

	public void run(){
		 System.out.println("타이머2");
		repaint();
		//add(new mapletest04(c, str,mp,hp,level));
	}
	
};	

	
	
   
	

	public void jbuttontest(){
		
		con=getContentPane();
		b=new JButton(icon01);
		b1=new JButton(icon02);
		leftselect=new JButton(icon03);
		rightselect=new JButton(icon04);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				i++;
				repaint();
				 if(i==2){
					 JButton b= (JButton) e.getSource();
					 dispose();
					 
					 mapletest03 mp3=new mapletest03(j, st,mp,hp,100,528,0,level,hunt);
			        }
				st=tf.getText();
				
		        
		       
				
				}
			
			 
			 
		});
		
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i!=0){
					i--;
					repaint();
				}
				else if(i==0){
				JButton b= (JButton) e.getSource();
				 dispose(); 
				 add(new mapletest01());
				}
			}
			 
			 
		});
		leftselect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				j--;
		        if(j==-1){
		        	j=3;
		        	
		        }
		        repaint();
				
				}
			
			 
			 
		});
		rightselect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				j++;
				repaint();
				
				}
			
			 
			 
		});
		
		
	}
    public void jpaneltest(){
    	con=getContentPane();
    	tf= new JTextField("이름을 입력하시오");
    	
    }
    


	
	public void paint (Graphics g){
		//g.drawString("이미지 그리기", 100, 80);//100,80 위치에 글씨입력
		
		Image img = Toolkit.getDefaultToolkit().getImage("map_select.png");//배경이미지 삽입 
	//	Image img01= Toolkit.getDefaultToolkit().getImage("char_warrior.png");
		g.drawImage(img, 100, 100, 800, 600,this);// 이미지 수정
	//	g.drawImage(img01, 450, 370, 50, 70,this);
		con.setLayout(null);
		b.setSize(50, 29);
		b.setLocation(700, 331);
		b.setOpaque(false);
		
		b1.setSize(50, 29);
		b1.setLocation(752, 331);
		b1.setOpaque(false);
		
		if(i==0){
			
			con.remove(rightselect);
			con.remove(leftselect);
		Image img02= Toolkit.getDefaultToolkit().getImage("char_name.png");
		Image img03= Toolkit.getDefaultToolkit().getImage("select_notokey.png");	
		g.drawImage(img02, 680, 200, 150,150,this);
		g.drawImage(img03, 700, 350, 120,50,this);
		con.add(tf);
		tf.setBounds(690, 247, 110, 37);
		tf.setBackground(Color.orange);
		
		}
		else if(i==1){
			
		Image img04= Toolkit.getDefaultToolkit().getImage("select_menu01.png");
		Image img05= Toolkit.getDefaultToolkit().getImage("select_notokey.png");
		Image img06= Toolkit.getDefaultToolkit().getImage("select_left.png");
		Image img07= Toolkit.getDefaultToolkit().getImage("select_right.png");
		g.drawImage(img04, 680, 200, 150,150,this);
		g.drawImage(img05, 700, 350, 120,50,this);
		g.drawImage(img06, 685, 270, 30,30,this);
		g.drawImage(img07, 790, 270, 28,27,this);
		if(j==0){
			Image img08= Toolkit.getDefaultToolkit().getImage("char_warrior.png");
			g.drawImage(img08, 450, 370, 50, 70,this);
			Font drawFont= new Font("war", Font.BOLD, 14);
			g.setFont(drawFont);
			g.drawString(war, 735, 290);
			
		}
		else if(j==1){
			
			Image img09= Toolkit.getDefaultToolkit().getImage("char_arrow.png");
			g.drawImage(img09, 451, 370, 67, 70,this);
			Font drawFont= new Font("arr", Font.BOLD, 14);
			g.setFont(drawFont);
			g.drawString(arr, 735, 290);
			
		}
		else if(j==2){
			Image img10= Toolkit.getDefaultToolkit().getImage("char_magic.png");
			g.drawImage(img10, 451, 370, 77, 70,this);
			Font drawFont= new Font("mag", Font.BOLD, 14);
			g.setFont(drawFont);
			g.drawString(mag, 731, 290);
			
		}
		else if(j==3){
			Image img11= Toolkit.getDefaultToolkit().getImage("char_theif.png");
			g.drawImage(img11, 450, 370, 50, 70,this);
			Font drawFont= new Font("thi", Font.BOLD, 14);
			g.setFont(drawFont);
			g.drawString(thi, 735, 290);
			
		}
		else if(j==4){
			j=0;
			repaint();
			
		}
		con.add(leftselect);
		leftselect.setSize(31,35);
		leftselect.setLocation(679, 238);
		con.add(rightselect);
		rightselect.setSize(31,35);
		rightselect.setLocation(780, 236);
		//leftselect.setOpaque(false);
		con.remove(tf);
		
		}
		
		
		
		//g.drawImage(img02, 485, 420, 12,11,this);
		//g.drawImage(img03, 463, 382, 40,39,this);
		
		
		
	//	b.setLocation(200, 500);
	//    g.drawImage(icon01.getImage(), 705, 347, 100,60,this);
	    
		g.dispose();
	}
	
	
	
		
}
