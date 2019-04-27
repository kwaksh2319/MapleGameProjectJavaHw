package ch03;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class  mapletest03 extends JFrame implements KeyListener{


	int tmpr=0;
	int tmpl=0;
	int rightw=0;
    int leftw=0;
	int x=100;
	int	y=528;//케릭터의 현재 좌표
	int level=1;
	int level01=0;
	int level02=0;
	
	int hppre=113;
	
	int maxhp=hppre*(3+level);
	int hp=maxhp;
	int maxmp=hppre*(3+level);
	int mp=maxmp;
	int mp1;
	
	int maxhunteng;
	int hunyeng;
	
	boolean keyUp=false;
	boolean keyDown=false;
	boolean keyLeft=false;
	boolean keyRight=false;
	boolean Attack=false;
	boolean playerMove=false;
	boolean Skill01=false;
	boolean Skill02=false;
	boolean Skill03=false;
	boolean Skill04=false;
	boolean jumping=false;
	Thread th;
	Toolkit tk=Toolkit.getDefaultToolkit();

	int moveStatus; // 케릭터가 어디를 바라보는가? 우 좌  1/2
	int cnt;// 무한루프 카운트하기위한변수
//	private mapletest02 mp2=new mapletest02();
	int a=0;
	int b;
	int c;
	int d=0;
	
	int f=0;
	int char_jump=0;
	int skillin=0;
	int itemin=0;
	int equipin=0;
	int attack=0;
	int skill01=0;
	int skill02=0;
	int skill03=0;
	int skill04=0;
	int skill04_01=0;
	int skillmove1=0;
	int pre;
	int w=50 ;
	int h=65;
	int skillmove=0;
	int magicvolt;
	String str;
	JScrollPane scrollPane;
	JButton shop;
	JButton trade;
	JButton menu;
	JButton shortcut;
	JButton menuitem;
	JButton menuequip;
	JButton menustat;
	JButton menuskill;
	JButton stateautodivde;
	JButton stateup1;
	JButton stateup2;
	JButton stateup3;
	JButton stateup4;
	JButton skillselect0;
	JButton skillselect1;
	JButton skillselect2;
	JButton skillselect3;
	JButton skillselect4;
	Container con;
	Graphics gs;
	double hunt;
	JPanel jp =new JPanel();
	Image[] walkiconright=new Image[4];
	Image[] walkiconleft=new Image[4];
	
	Image[] portal=new Image[2];
	
	Image[] war_jump=new Image[3];
	Image[] arr_jump=new Image[3];
	Image[] magic_jump=new Image[3];
	Image[] theif_jump=new Image[3];
	
	Image[] cha_attack_war=new Image[11];
	Image[] cha_attack_arr=new Image[6];
	Image[] cha_attack_magic=new Image[2];
	Image[] cha_attack_theif=new Image[10];
	Image[] cha_attack_war_right=new Image[11];
	Image[] cha_attack_arr_right=new Image[6];
	Image[] cha_attack_magic_right=new Image[2];
	Image[] cha_attack_theif_right=new Image[10];
	
	Image[] cha_skill_war_right=new Image[8];
	Image[] cha_skill_war_left=new Image[8];
	Image[] cha_skill02_war_right=new Image[22];
	Image[] cha_skill02_war_left=new Image[22];
	Image[] cha_skill03_war=new Image[18];
	Image[] cha_skill04_war=new Image[17];
	
	
	
	Image[] cha_skill_arr_right=new Image[4];
	Image[] cha_skill_arr_left=new Image[4];
	Image[] cha_skill02_arr_right=new Image[15];
	Image[] cha_skill02_arr_left=new Image[15];
	Image[] cha_skill03_arr_right=new Image[16];
	Image[] cha_skill03_arr_left=new Image[16];
	Image[] cha_skill04_ball_arr_left=new Image[5];
	Image[] cha_skill04_ball_arr_right=new Image[5];
	Image[] cha_skill04_arr_left_pre=new Image[28];
	
	Image[] cha_skill04_arr_right_pre=new Image[28];
	
	
	
	Image[] cha_skill_magic_right=new Image[4];
	Image[] cha_skill_magic_left=new Image[4];
	
	Image[] cha_skill02_magic_right=new Image[6];
	Image[] cha_skill02_magic_left=new Image[6];
	
	Image[] cha_skill03_magic=new Image[9];
	
	Image[] cha_skill04_magic=new Image[19];
	
	Image[] cha_skill_theif_right=new Image[5];
	Image[] cha_skill_theif_left=new Image[5];
	Image[] cha_skill02_theif=new Image[8];
	Image[] cha_skill03_ball_theif=new Image[1];
	Image[] cha_skill03_theif_right=new Image[19];
	Image[] cha_skill03_theif_left=new Image[19];
	Image[] cha_skill04_theif=new Image[15];
	
	
	
	ImageIcon icon01=new ImageIcon("shopbutton.png"); 
	ImageIcon icon02=new ImageIcon("tradebutton.png");
	ImageIcon icon03=new ImageIcon("menubutton.png");
	ImageIcon icon04=new ImageIcon("shortcutbutton.png");
	ImageIcon icon05=new ImageIcon("game_menu_item.png");
	ImageIcon icon06=new ImageIcon("game_menu_equip.png");
	ImageIcon icon07=new ImageIcon("game_menu_stat.png");
	ImageIcon icon08=new ImageIcon("game_menu_skill.png");
	ImageIcon icon09=new ImageIcon("level_state_autodivde.png");
	ImageIcon icon10=new ImageIcon("level_state_up.png");
	ImageIcon icon11=new ImageIcon("skill_interface_select00.png");
	ImageIcon icon12=new ImageIcon("skill_interface_select01.png");
	ImageIcon icon13=new ImageIcon("skill_interface_select02.png");
	ImageIcon icon14=new ImageIcon("skill_interface_select03.png");
	ImageIcon icon15=new ImageIcon("skill_interface_select04.png");
 
	 
mapletest03(int j, String st, int mp1,int hp1,int x1,int y1,int moveState1,int level1,double hunt1){
	 addKeyListener(this);
	level=level1;
	x=x1;
	y=y1;
    c =j;
    hunt=hunt1;
    moveStatus=moveState1;
    str=st;
	mp=mp1;
	hp=hp1;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	this.setTitle("maplemade3");	
	this.setBounds(0,0,0,0);
	this.setSize(960,700);
	
	this.setVisible(true);//창열기
	
	jbuttontest();
	
	frame03.schedule(frame03_1, 1,100);
	
	
	}
private Timer frame03=new Timer();

private TimerTask frame03_1=new TimerTask(){

	public void run(){
		repaint();
		//add(new mapletest04(c, str,mp,hp,level));
	}
	
};




public void keyPressed(KeyEvent e){
	//키를 누르는순간
	
			
	switch(e.getKeyCode()){
	
	case KeyEvent.VK_LEFT:
		if(x>50){
		x-=4;
		}
		keyLeft=true;
		moveStatus=2;
		
		leftw++;
		
		repaint();
		break;
	case KeyEvent.VK_RIGHT:
		keyRight=true;
		if(x<800){
			x+=4;
		}
		moveStatus=1;
		
		rightw++;
		
		repaint();
		break;
	case KeyEvent.VK_UP:
		
		keyUp=true;
		if(x==800){
			frame03.cancel();
			mapletest04 mp4 =new mapletest04(c, str,mp,hp,70,y,moveStatus,level,hunt);	
			
			this.dispose();
			this.remove(this);
			
		
		
	     repaint();
		}
		break;
	case KeyEvent.VK_DOWN:
		keyDown=true;
		break;
	case KeyEvent.VK_X:
		Attack = true;
		attack++;
		repaint();
    
		break;
	case KeyEvent.VK_C:
		Timer jump01=new Timer();
		TimerTask jumped=new TimerTask(){
			public void run(){
		
if(char_jump<=8){		
	   jumping=true;

	   char_jump++;
		
		repaint();}
else if(char_jump>8){

		keyReleased(e);
		jump01.cancel();
		
	
}

		}
			
	};jump01.schedule(jumped, 0,60);	
       break;	
	case KeyEvent.VK_A:
		mp=mp-10;
	Timer wskl01=new Timer();
	TimerTask w01sk01=new TimerTask(){
			  public void run(){
		
		int mp2;
		mp2=15;
		
		mp1++;
	  if(mp1!=mp2&&mp1>1){
				
		 
		Skill01 = true;
		
		skill01++;
		skillmove++;	
		
		
	  }
	  
	  else if(mp1==mp2){
		  mp1=0;
		  Skill01=false;
		  keyReleased(e);
		  wskl01.cancel();
	  }
	  repaint();
			  }  
	};wskl01.schedule(w01sk01, 0,60);	  
			  
		  break;
		
	case KeyEvent.VK_S:
		mp=mp-20;
		Timer wskl02=new Timer();
		TimerTask w02sk02=new TimerTask(){
			  public void run(){
				  repaint();
				  int mp3;
				  mp3=40;
				  mp1++;
				 
		if(mp1!=mp3){
		
		Skill02 = true;
		skill02++;
		skillmove++;
		}
		  else if(mp1==mp3){
			  mp1=0;
			  Skill02=false;
			  keyReleased(e);
			  wskl02.cancel();
		  }
		
			  }  
		};wskl02.schedule(w02sk02, 0,60);	
         break;
	case KeyEvent.VK_D:
		mp=mp-30;
		Timer wskl03=new Timer();
		TimerTask w03sk03=new TimerTask(){
			  public void run(){
				  repaint();
				  int mp4;
				  mp4=42;
				  mp1++;
		if(mp1!=mp4){
		
		Skill03 = true;
		skill03++;
		skillmove++;
		}
		else if(mp1==mp4){
			  mp1=0;
			Skill03=false;
			 keyReleased(e);
			  wskl03.cancel();
		}
		repaint();
			  }  
					};wskl03.schedule(w03sk03, 0,60);	
         break;
	case KeyEvent.VK_F:
		mp=mp-40;
		 Timer wskl04=new Timer();
		TimerTask w04sk04=new TimerTask(){
			  public void run(){
			int mp5;
			mp5=33;
			mp1++;
	   if(skill04>19&&skill04<28){
				skill04_01++;
				skillmove++;
				if(skill04_01==5){
					skill04_01=0;
				}
	
			}
		if(mp1!=mp5){
		
		Skill04 = true;
		skill04++;
		
		
		skillmove++;
		}
		else if(mp1==mp5){
			mp1=0;
			Skill04=false;
			 keyReleased(e);
			  wskl04.cancel();
		}
		repaint();
			  }  
		};wskl04.schedule(w04sk04, 0,60);	 
		break;
         
	}
		

	
}

public void keyReleased(KeyEvent e){
	//누른 키를 떼는 순간
	


	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT:
		
		keyLeft=false;
		repaint();
		break;
	
	case KeyEvent.VK_RIGHT:
		keyRight=false;
		repaint();
		break;
	case KeyEvent.VK_UP:
		keyUp=false;
		break;
		
	case KeyEvent.VK_DOWN:
		keyDown=false;
		break;
   case KeyEvent.VK_C:
	   jumping=false;
	   char_jump=0;
	   repaint();
		break;	
	case KeyEvent.VK_X:
		Attack = false;
		repaint();
         break;
	case KeyEvent.VK_A:
		
		Skill01 = false;
		skill01=0;
		repaint();
	
     
         break;
	case KeyEvent.VK_S:
		Skill02 = false;
		skill02=0;
		
		repaint();
         break;
	case KeyEvent.VK_D:
		Skill03 = false;
		skill03=0;
		 skillmove1=0;
		repaint();
         break;
	case KeyEvent.VK_F:
		Skill04 = false;
		skill04=0;
		repaint();
         break;
	}	
		
}
	  
public void keyTyped(KeyEvent e){
	//누른키를 떼는 순간 unicode키의 경우 추가 이벤트
}


		
	
public void jbuttontest(){
		
		con=getContentPane();
		shop=new JButton(icon01);
		trade=new JButton(icon02);
		menu=new JButton(icon03);
		shortcut=new JButton(icon04);
		
		menuitem=new JButton(icon05);
		menuequip=new JButton(icon06);
		menustat=new JButton(icon07);
		menuskill=new JButton(icon08);
		
		stateautodivde=new JButton(icon09);
		stateup1=new JButton(icon10);
		stateup2=new JButton(icon10);
		stateup3=new JButton(icon10);
		stateup4=new JButton(icon10);
		
		skillselect0=new JButton(icon11);
		skillselect1=new JButton(icon12);
		skillselect2=new JButton(icon13);
		skillselect3=new JButton(icon14);
		skillselect4=new JButton(icon15);
		
		menuitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				itemin++;
				
				if(itemin==2){
					itemin=0;
					
				}
				repaint();
			}
		});
       menuequip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				equipin++;
				if(equipin==2){
					equipin=0;
				}
				repaint();
			}
		});
		menuskill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				skillin++;
				if(skillin==2){
					skillin=0;
				}
				repaint();
			}
		});
		
		
		menustat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f++;
				if(f==2){
					f=0;
				}
				repaint();
			}
		});
		
		
		shop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d++;
				if(d==2){
					d=0;
					
				}
				repaint();
			
				
			}
		});
		
		
		
		menu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 a++;
				 
					 if(a==2){
						 a=0;
					 }
					 
					 repaint();
			        }
				
					 
		});
		
		shortcut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				 add(new mapletest02());
			}
		});
	}

    
     
	
	public void paint (Graphics g){
		
		con.add(shop);
		shop.setSize(59,38);
		shop.setLocation(633, 600);
		con.add(trade);
		trade.setSize(58,38);
		trade.setLocation(693, 600);
		con.add(menu);
		menu.setSize(59,38);
		menu.setLocation(754, 600);
		con.add(shortcut);
		shortcut.setSize(56,38);
		shortcut.setLocation(815, 600);
		Image img = Toolkit.getDefaultToolkit().getImage("map_custom.png");//배경이미지 삽입 
		
		Image img01 = Toolkit.getDefaultToolkit().getImage("statebar.png");//배경이미지 삽입 
		Image barhp = Toolkit.getDefaultToolkit().getImage("hpbar.png");
		Image barmp = Toolkit.getDefaultToolkit().getImage("hpbar.png");
		Image barhunt = Toolkit.getDefaultToolkit().getImage("hpbar.png");
		g.drawImage(img, 20, 20, 860, 610,this);// 이미지 수정
		g.drawImage(img01, 20, 630, 858, 39,this);// 이미지 수정
		g.drawImage(barhp, 258, 648, 117, 17,this);
		g.drawImage(barmp, 375, 648, 117, 17,this);
		g.drawImage(barhunt, 496, 648, 127, 17,this);
		int hpp=hp/4;
		int mpp=mp/4;
		
		g.setColor(Color.red);
		g.fillRect(259, 650,hpp,12);
		
		g.setColor(Color.blue);
		g.fillRect(376, 650, mpp, 12);
		
		g.setColor(Color.YELLOW);
		g.fillRect(496, 650, (int)hunt, 12);
		int []leveldata=new int[100];
		if(level==10){
			level=0;
			level01=level01+1;
		}
		if(level01==10){
			level01=0;
			level02=level02+1;
		}
		leveldata[0]=level;
		leveldata[1]=level01;
		leveldata[2]=level02;
		
		String levelstr=""+leveldata[0];
		g.setFont(g.getFont().deriveFont(level, 14));
		g.setColor(Color.WHITE);
		g.drawString(levelstr,91,655);
		
		String levelstr01=""+leveldata[1];
		g.setFont(g.getFont().deriveFont(level01, 14));
		g.setColor(Color.WHITE);
		g.drawString(levelstr01,77,655);
		
		String levelstr02=""+leveldata[2];
		g.setFont(g.getFont().deriveFont(level02, 14));
		g.setColor(Color.WHITE);
		g.drawString(levelstr02,64,655);
		
		Font drawFont= new Font("str", Font.BOLD, 14);
		g.setFont(drawFont);
		g.setColor(Color.WHITE);
		g.drawString(str, 107, 655);
		
		
		 portal[0]= Toolkit.getDefaultToolkit().getImage("portal01.png");
		
		 g.drawImage(portal[0], 800, 500, 80, 100,this);// 이미지 수정
		
		
		
		
		if(a==0){
			con.remove(menuitem);
			con.remove(menuequip);
			con.remove(menustat);
			con.remove(menuskill);
		}
		if(a==1){
			con.add(menuitem);
			menuitem.setSize(68,30);
			menuitem.setLocation(750, 493);
			con.add(menuequip);
			menuequip.setSize(68,30);
			menuequip.setLocation(750, 520);
			con.add(menustat);
			menustat.setSize(68,30);
			menustat.setLocation(750, 545);
			con.add(menuskill);
			menuskill.setSize(68,30);
			menuskill.setLocation(750, 570);
			
			Image img02= Toolkit.getDefaultToolkit().getImage("game_menu.png");
			g.drawImage(img02, 750, 510, 82, 120,this);// 이미지 수정
			
			
		
		}
		
		if(d==1){
			Image img03= Toolkit.getDefaultToolkit().getImage("shop.png");
			g.drawImage(img03, 400, 200, 350, 300,this);// 이미지 수정
			
		}
		if(f==0){
			con.remove(stateautodivde);
			con.remove(stateup1);
			con.remove(stateup2);
			con.remove(stateup3);
			con.remove(stateup4);
		}
		if(f==1){
			con.add(stateautodivde);
			stateautodivde.setSize(68,35);
			stateautodivde.setLocation(274, 176);
			
			con.add(stateup1);
			stateup1.setSize(15,15);
			stateup1.setLocation(326, 225);
			
			con.add(stateup2);
			stateup2.setSize(15,15);
			stateup2.setLocation(326, 245);
			
			con.add(stateup3);
			stateup3.setSize(15,15);
			stateup3.setLocation(326, 265);
			
			con.add(stateup4);
			stateup4.setSize(15,15);
			stateup4.setLocation(326, 285);
			Image img04= Toolkit.getDefaultToolkit().getImage("level_state.png");
			g.drawImage(img04, 200, 200, 153, 140,this);// 이미지 수정
		}
		
		if(skillin==0){
			con.remove(skillselect0);
			con.remove(skillselect1);
			con.remove(skillselect2);
			con.remove(skillselect3);
			con.remove(skillselect4);
		}
		if(skillin==1){
			
			con.add(skillselect0);
			skillselect0.setSize(32,21);
			skillselect0.setLocation(195, 322);
			
			con.add(skillselect1);
			skillselect1.setSize(31,20);
			skillselect1.setLocation(224, 322);
			
			con.add(skillselect2);
			skillselect2.setSize(31,20);
			skillselect2.setLocation(254, 322);
			
			con.add(skillselect3);
			skillselect3.setSize(31,20);
			skillselect3.setLocation(284, 322);
			
			con.add(skillselect4);
			skillselect4.setSize(31,20);
			skillselect4.setLocation(313, 322);
			
			
			Image img05= Toolkit.getDefaultToolkit().getImage("skill_interface.png");
			g.drawImage(img05, 200, 350, 153, 200,this);// 이미지 수정
		}
		
		
		if(itemin==0){
			
		}
        if(itemin==1){
        	Image img06= Toolkit.getDefaultToolkit().getImage("item_interface.png");
			g.drawImage(img06, 20, 80, 153, 210,this);// 이미지 수정
		}
        
        
        if(equipin==0){
			
		}
		
        if(equipin==1){
        	Image img07= Toolkit.getDefaultToolkit().getImage("equip_interface.png");
			g.drawImage(img07, 20, 300, 158, 250,this);// 이미지 수정
		}
       
		
         
		if(c==0){
		   
			//Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
		//	g.drawImage(img08, x, y,  50, 65,this);
		
             if(moveStatus==0&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
            	 Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
	                g.drawImage(img08, x, y,  50, 65,this);
             }
			if(moveStatus==1&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyRight==false){Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
					                g.drawImage(img08, x, y,  50, 65,this);
				}
				
			else if(keyRight==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
		//	walkiconright[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
		    walkiconright[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk02_right.png");
			walkiconright[1]= Toolkit.getDefaultToolkit().getImage("war_walk//walk03_right.png");
			walkiconright[2]= Toolkit.getDefaultToolkit().getImage("war_walk//walk04_right.png");
			walkiconright[3]= Toolkit.getDefaultToolkit().getImage("war_walk//walk05_right.png");
			
			 if(rightw/5==0){
					w=50;
				  
				}
			 if(rightw/5==1){
				w=55;
			  
			}
			
			 if(rightw/5==2){
				 w=50;
			 }
			
			
			if(3<rightw/5){
				 w=50;
				 rightw=1;
			}
			g.drawImage(walkiconright[rightw/5], x, y,  w, h,this);
				}
			}
			
			else if(moveStatus==2&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyLeft==false){Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
				                 	g.drawImage(img08, x, y,  50, 65,this);
				
				
				}
					
				else if(keyLeft==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
		//	walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
		    walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk02_left.png");
			walkiconleft[1]= Toolkit.getDefaultToolkit().getImage("war_walk//walk03_left.png");
			walkiconleft[2]= Toolkit.getDefaultToolkit().getImage("war_walk//walk04_left.png");
			walkiconleft[3]= Toolkit.getDefaultToolkit().getImage("war_walk//walk05_left.png");
			     if(leftw/5==0){
			    	 w=50;
			     }
				 if(leftw/5==1){
					w=55;
				    }
				
				
				 if(leftw/5==2){
					 w=50;
				 }
				
				
				
				
				if(3<leftw/5){
					leftw=1;
					
				}
				g.drawImage(walkiconleft[leftw/5], x, y,  w, h,this);
				}
		
					
			
			}
			else if((moveStatus==0||moveStatus==1)&&jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
				war_jump[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
				war_jump[1]= Toolkit.getDefaultToolkit().getImage("war_walk//war_jump_right.png");
				war_jump[2]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
			int charwidth=50;
			if(char_jump/4==1){
				y=498;
				charwidth=60;
			}
			if(char_jump/4==2){
				y=528;
				charwidth=50;
			}
			if(char_jump/4>2){
				char_jump=0;
				
			}
				
				g.drawImage(war_jump[char_jump/4], x, y,  charwidth, 65,this);
			}
			else if(moveStatus==2&&jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
				war_jump[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
				war_jump[1]= Toolkit.getDefaultToolkit().getImage("war_walk//war_jump_left.png");
				war_jump[2]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
			int charwidth=50;
			if(char_jump/4==1){
				y=498;
				charwidth=60;
			}
			if(char_jump/4==2){
				y=528;
				charwidth=50;
			}
			if(char_jump/4>2){
				char_jump=0;
				
			}
				
				g.drawImage(war_jump[char_jump/4], x, y,  charwidth, 65,this);
			}
			else if(Attack==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				
				if(moveStatus==0||moveStatus==1){
					
				Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
                g.drawImage(img08, x, y,  50, 65,this);}
				else if(moveStatus==2){
				Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
	            g.drawImage(img08, x,y,  50, 65,this);}
				requestFocus();
				}
				
			    
			else if(Attack==true&&keyRight==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==2){
				cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left01.png");
				cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left02.png");
				cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left03.png");
				cha_attack_war[3]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left04.png");
				cha_attack_war[4]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left05.png");
				cha_attack_war[5]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left06.png");
				cha_attack_war[6]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left07.png");
				cha_attack_war[7]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left08.png");
				cha_attack_war[8]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left09.png");
				cha_attack_war[9]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left10.png");
				cha_attack_war[10]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left11.png");
				
				if(attack/6==0){
					if(attack==1){
						x=x-8;
						}
					
					
				
					w=85;
					
				}
				
				else if(attack/6==1){
					
				if(attack==6){
						x=x+8;
						}
				
				
					w=50;
				}
				else if(attack/6==2){
					if(attack==12){
						x=x-8;
						}
					
					
					w=85;
				}
				else if(attack/6==3){
					if(attack==18){
						x=x+4;
						}
					
					
					w=72;
				}
				else if(attack/6==4){
					w=55;
				}
				else if(attack/6==5){
					if(attack==180){
						x=x+4;
						}
					
					
					w=70;
				}
				else if(attack/6==6){
					w=50;
				}
				else if(attack/6==7){
					w=45;
				}
				else if(attack/6==8){
					w=80; h=70; y=528;//528
				}
				else if(attack/6==9){
					h=65;
					y=528;//528
				}
				else if(attack/6==10){
					if(attack==60){
						x=x-8;
						}
					
					w=70;
				}
				else if(attack/6>10){
					x=x+8;
					y=528;
					w=50;
					h=65;
					attack=1;
				}
				g.drawImage(cha_attack_war[attack/6], x, y,  w, h,this);
				requestFocus();
			}
			
			
				else if(moveStatus==0||moveStatus==1){
				cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right01.png");
				cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right02.png");
				cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right03.png");
				cha_attack_war_right[3]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right04.png");
				cha_attack_war_right[4]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right05.png");
				cha_attack_war_right[5]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right06.png");
				cha_attack_war_right[6]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right07.png");
				cha_attack_war_right[7]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right08.png");
				cha_attack_war_right[8]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right09.png");
				cha_attack_war_right[9]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right10.png");
				cha_attack_war_right[10]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right11.png");
				
				if(attack/6==0){
					if(attack==1){
						//x=x-8;
						}
				
					w=85;
					
				}
				
				else if(attack/6==1){
					
				if(attack==6){
						x=x+8;
						}
				
				
					w=50;
				}
				else if(attack/6==2){
					if(attack==12){
						x=x-8;
						}
					
					
					w=85;
				}
				else if(attack/6==3){
					if(attack==18){
						x=x+4;
						}
					
					
					w=72;
				}
				else if(attack/6==4){
					w=55;
				}
				else if(attack/6==5){
					if(attack==180){
						x=x+4;
						}
					
					
					w=70;
				}
				else if(attack/6==6){
					w=50;
				}
				else if(attack/6==7){
					w=45;
				}
				else if(attack/6==8){
					w=80; h=70; y=528;//528
				}
				else if(attack/6==9){
					h=65;
					y=528;//528
				}
				else if(attack/6==10){
					if(attack==60){
						x=x-8;
						}
					
					w=70;
				}
				else if(attack/6>10){
					x=x+8;
					y=528;
					w=50;
					h=65;
					attack=1;
				}
				g.drawImage(cha_attack_war_right[attack/6], x, y,  w, h,this);
				requestFocus();
			}
			
				
			}
			else if(Skill01==true&&Attack==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				
				if(moveStatus==0||moveStatus==1){
					cha_skill_war_right[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect01_right.png");
					cha_skill_war_right[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect02_right.png");
					cha_skill_war_right[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect03_right.png");
					cha_skill_war_right[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect04_right.png");
					cha_skill_war_right[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect05_right.png");
					cha_skill_war_right[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect06_right.png");
					cha_skill_war_right[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect07_right.png");
					cha_skill_war_right[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect08_right.png");
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right02.png");
					cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right03.png");
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=450;
					int skillsizex=x-55;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					if(skillmove/5==0){
						charsizew=85;
					   }
					if(skillmove/5==1){
						charsizew=50;
				   }
					if(skillmove/5==2){
						charsizew=85;
						  
						  
					   }
				   
					if(skill01/2>7){
						Skill01=false;
						skill01=0;
					}
					if(skillmove/5>2){
						Skill01=false;
						skillmove=0;
					}
					g.drawImage(cha_skill_war_right[skill01/2], x+70, y,  skillsizew, skillsizeh,this);
					
					g.drawImage(cha_attack_war_right[skillmove/5], x, y,  charsizew, h,this);
					
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill_war_left[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect01_left.png");
					cha_skill_war_left[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect02_left.png");
					cha_skill_war_left[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect03_left.png");
					cha_skill_war_left[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect04_left.png");
					cha_skill_war_left[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect05_left.png");
					cha_skill_war_left[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect06_left.png");
					cha_skill_war_left[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect07_left.png");
					cha_skill_war_left[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill01_effect08_left.png");
					
					
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=450;
					int skillsizex=x-55;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					
					cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left01.png");
					cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left02.png");
					cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left03.png");
					if(skillmove/5==0){
						charsizew=85;
					   }
					if(skillmove/5==1){
						charsizew=50;
				   }
					if(skillmove/5==2){
						charsizew=85;
						  
						  
					   }
				   
					if(skill01/2>7){
						skill01=0;
					}
					if(skillmove/5>2){
						skillmove=0;
					}
					g.drawImage(cha_skill_war_left[skill01/2], x-50, y,  skillsizew, skillsizeh,this);
					
					g.drawImage(cha_attack_war[skillmove/5], x, y, charsizew, h,this);
					
					
					requestFocus();
				}
			}
			else if(Skill02==true&&Attack==false&&Skill01==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill02_war_right[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect01_right.png");
					cha_skill02_war_right[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect02_right.png");
					cha_skill02_war_right[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect03_right.png");
					cha_skill02_war_right[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect04_right.png");
					cha_skill02_war_right[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect05_right.png");
					cha_skill02_war_right[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect06_right.png");
					cha_skill02_war_right[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect07_right.png");
					cha_skill02_war_right[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect08_right.png");
					cha_skill02_war_right[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect09_right.png");
					cha_skill02_war_right[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect10_right.png");
					cha_skill02_war_right[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect11_right.png");
					cha_skill02_war_right[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect12_right.png");
					cha_skill02_war_right[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect13_right.png");
					cha_skill02_war_right[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect14_right.png");
					cha_skill02_war_right[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect15_right.png");
					cha_skill02_war_right[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect16_right.png");
					cha_skill02_war_right[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect17_right.png");
					cha_skill02_war_right[17]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect18_right.png");
					cha_skill02_war_right[18]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect19_right.png");
					cha_skill02_war_right[19]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect20_right.png");
					cha_skill02_war_right[20]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect21_right.png");
					cha_skill02_war_right[21]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect22_right.png");
					int skillsizew=150;
					int skillsizeh=150;
					int skillsizey=443;
					int skillsizex=x+30;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
			
		
			
			cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right07.png");
			cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right08.png");
			cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_right09.png");
			if(skillmove/14==0){
				charsizew=50;
				charsizeh=65;
				charsizey=528;
			   }
		
			if(skillmove/14==2){
				charsizew=75;
				charsizeh=70;
				charsizey=530;    
				  
			   }
		   
			if(skill02/2>21){
				skill02=0;
			}
			if(skillmove/14>2){
				skillmove=0;
			}
			g.drawImage(cha_skill02_war_right[skill02/2], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
			
		  	g.drawImage(cha_attack_war[skillmove/14], x, charsizey,  charsizew, charsizeh,this);
			
					
					requestFocus();
				}
				else if(moveStatus==2){
		                    cha_skill02_war_left[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect01_left.png");
							cha_skill02_war_left[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect02_left.png");
							cha_skill02_war_left[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect03_left.png");
							cha_skill02_war_left[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect04_left.png");
							cha_skill02_war_left[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect05_left.png");
							cha_skill02_war_left[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect06_left.png");
							cha_skill02_war_left[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect07_left.png");
							cha_skill02_war_left[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect08_left.png");
							cha_skill02_war_left[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect09_left.png");
							cha_skill02_war_left[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect10_left.png");
							cha_skill02_war_left[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect11_left.png");
							cha_skill02_war_left[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect12_left.png");
							cha_skill02_war_left[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect13_left.png");
							cha_skill02_war_left[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect14_left.png");
							cha_skill02_war_left[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect15_left.png");
							cha_skill02_war_left[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect16_left.png");
							cha_skill02_war_left[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect17_left.png");
							cha_skill02_war_left[17]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect18_left.png");
							cha_skill02_war_left[18]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect19_left.png");
							cha_skill02_war_left[19]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect20_left.png");
							cha_skill02_war_left[20]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect21_left.png");
							cha_skill02_war_left[21]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill02_effect22_left.png");
							int skillsizew=150;
							int skillsizeh=150;
							int skillsizey=443;
							int skillsizex=x-120;
							int charsizew=w;
							int charsizeh=h;
							int charsizey=y;
							
				
					
					cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left07.png");
					cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left08.png");
					cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("war_attack//war_attack_left09.png");
					if(skillmove/14==0){
						charsizew=50;
						charsizeh=65;
						charsizey=528;
					   }
				
					if(skillmove/14==2){
						charsizew=75;
						charsizeh=70;
						charsizey=530;  
						  
					   }
				   
					if(skill02/2>21){
						skill02=0;
					}
					if(skillmove/14>2){
						skillmove=0;
					}
					g.drawImage(cha_skill02_war_left[skill02/2], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
					
				  	g.drawImage(cha_attack_war[skillmove/14], x, charsizey,  charsizew, charsizeh,this);
					
					
					requestFocus();
				}
			}
			else if(Skill03==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill03_war[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect01.png");
					cha_skill03_war[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect02.png");
					cha_skill03_war[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect03.png");
					cha_skill03_war[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect04.png");
					cha_skill03_war[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect05.png");
					cha_skill03_war[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect06.png");
					cha_skill03_war[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect07.png");
					cha_skill03_war[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect08.png");
					cha_skill03_war[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect09.png");
					cha_skill03_war[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect10.png");
					cha_skill03_war[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect11.png");
					cha_skill03_war[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect12.png");
					cha_skill03_war[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect13.png");
					cha_skill03_war[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect14.png");
					cha_skill03_war[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect15.png");
					cha_skill03_war[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect16.png");
					cha_skill03_war[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect17.png");
					cha_skill03_war[17]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect18.png");
					 Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
					int skillsizew=150;
					int skillsizeh=150;
					int skillsizey=443;
					int skillsizex=x-55;
					
				if(skill03/3==6){
				skillsizeh=180;
				//skillsizey=483;
			}
			if(skill03/3==7){
				skillsizeh=150;
				//skillsizey=483;
			}
			
		
			
			
		   
			if(skill03/3>17){
				skill03=0;
			}
			g.drawImage(img08, x, y,  w, h,this);
			g.drawImage(cha_skill03_war[skill03/3], skillsizex, skillsizey,   skillsizew, skillsizeh,this);
			
		  	
			
					
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill03_war[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect01.png");
					cha_skill03_war[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect02.png");
					cha_skill03_war[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect03.png");
					cha_skill03_war[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect04.png");
					cha_skill03_war[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect05.png");
					cha_skill03_war[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect06.png");
					cha_skill03_war[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect07.png");
					cha_skill03_war[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect08.png");
					cha_skill03_war[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect09.png");
					cha_skill03_war[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect10.png");
					cha_skill03_war[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect11.png");
					cha_skill03_war[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect12.png");
					cha_skill03_war[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect13.png");
					cha_skill03_war[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect14.png");
					cha_skill03_war[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect15.png");
					cha_skill03_war[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect16.png");
					cha_skill03_war[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect17.png");
					cha_skill03_war[17]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill03_effect18.png");
					 Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
					int skillsizew=150;
					int skillsizeh=150;
					int skillsizey=443;
					int skillsizex=x-55;
					
				if(skill03/3==6){
				skillsizeh=180;
				//skillsizey=483;
			}
			if(skill03/3==7){
				skillsizeh=150;
				//skillsizey=483;
			}
			
		
			
			
		   
			if(skill03/3>17){
				skill03=0;
			}
			g.drawImage(img08, x, y,  w, h,this);
			g.drawImage(cha_skill03_war[skill03/3], skillsizex, skillsizey,   skillsizew, skillsizeh,this);
					
					
					requestFocus();
				}
			}
			else if(Skill04==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill04_war[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect01.png");
					cha_skill04_war[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect02.png");
					cha_skill04_war[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect03.png");
					cha_skill04_war[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect04.png");
					cha_skill04_war[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect05.png");
					cha_skill04_war[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect06.png");
					cha_skill04_war[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect07.png");
					cha_skill04_war[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect08.png");
					cha_skill04_war[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect09.png");
					cha_skill04_war[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect10.png");
					cha_skill04_war[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect11.png");
					cha_skill04_war[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect12.png");
					cha_skill04_war[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect13.png");
					cha_skill04_war[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect14.png");
					cha_skill04_war[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect15.png");
					cha_skill04_war[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect16.png");
					cha_skill04_war[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect17.png");
				
					 Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
					int skillsizew=150;
					int skillsizeh=150;
					int skillsizey=450;
					int skillsizex=x-55;
					if(skill04/3==1){
						skillsizey=455;
						skillsizex=x;
					}
					if(skill04/3==2){
						skillsizew=180;
						skillsizeh=180;
						skillsizex=x+30;
						skillsizey=430;
					}
					if(skill04/3==3){
						skillsizew=200;
						skillsizeh=200;
						skillsizey=410;
						skillsizex=x+60;
					}
					if(skill04/3==4){
						skillsizew=220;
						skillsizeh=220;
						skillsizey=390;
						
						skillsizex=x+90;
					
				}
				if(skill04/3==5){
					skillsizew=240;
					skillsizeh=240;
					skillsizey=370;
					skillsizex=x+120;
				
			}
				if(skill04/3==6){
					skillsizew=260;
					skillsizeh=260;
					skillsizey=355;
					skillsizex=x+140;
				
			}
		
		
			
			
		   
			if(skill04/3>16){
				skill04=0;
			}
			g.drawImage(img08, x, y,  w, h,this);
			g.drawImage(cha_skill04_war[skill04/3], skillsizex, skillsizey,   skillsizew, skillsizeh,this);
			
		  	
			
					
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill04_war[0]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect01.png");
					cha_skill04_war[1]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect02.png");
					cha_skill04_war[2]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect03.png");
					cha_skill04_war[3]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect04.png");
					cha_skill04_war[4]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect05.png");
					cha_skill04_war[5]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect06.png");
					cha_skill04_war[6]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect07.png");
					cha_skill04_war[7]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect08.png");
					cha_skill04_war[8]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect09.png");
					cha_skill04_war[9]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect10.png");
					cha_skill04_war[10]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect11.png");
					cha_skill04_war[11]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect12.png");
					cha_skill04_war[12]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect13.png");
					cha_skill04_war[13]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect14.png");
					cha_skill04_war[14]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect15.png");
					cha_skill04_war[15]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect16.png");
					cha_skill04_war[16]=Toolkit.getDefaultToolkit().getImage("war_skill//war_skill04_effect17.png");
				
					 Image img08= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
					int skillsizew=150;
					int skillsizeh=150;
					int skillsizey=450;
					int skillsizex=x-55;
					if(skill04/3==1){
						skillsizey=455;
						skillsizex=x-150;
					}
					if(skill04/3==2){
						skillsizew=180;
						skillsizeh=180;
						skillsizex=x-180;
						skillsizey=430;
					}
					if(skill04/3==3){
						skillsizew=200;
						skillsizeh=200;
						skillsizey=410;
						skillsizex=x-210;
					}
					if(skill04/3==4){
						skillsizew=220;
						skillsizeh=220;
						skillsizey=390;
						
						skillsizex=x-240;
					
				}
				if(skill04/3==5){
					skillsizew=240;
					skillsizeh=240;
					skillsizey=370;
					skillsizex=x-270;
				
			}
				if(skill04/3==6){
					skillsizew=260;
					skillsizeh=260;
					skillsizey=355;
					skillsizex=x-300;
				
			}
			
			
		
			
			
		   
			if(skill04/3>16){
				skill04=0;
			}
			g.drawImage(img08, x, y,  w, h,this);
			g.drawImage(cha_skill04_war[skill04/3], skillsizex, skillsizey,   skillsizew, skillsizeh,this);
					
					requestFocus();
				}
			}
		requestFocus();
			
			
		}
		
			
			
			
			
		//	walkicno[0]=new JImagePanel(getIconImage());
		//	setIconImages(walkicon[0]);
		
		 if(c==1){
			/*
			 
			Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
			g.drawImage(img09, x, y,  60, 65,this);*/
			
			 if(moveStatus==0&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				         
            	 Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
	                g.drawImage(img09, x, y,  65, h,this);
             }
			 else if(moveStatus==1&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyRight==false){Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
					                g.drawImage(img09, x, y, 65, h,this);
				}
				
				else if(keyRight==true){
		//	walkiconright[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
		    walkiconright[0]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk02_right.png");
			walkiconright[1]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk03_right.png");
			walkiconright[2]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk04_right.png");
			walkiconright[3]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk05_right.png");
			
			if(rightw/4==0){
				w=70;
				
			    }
			 if(rightw/4==1){
				w=70;
				
			    }
			
			
			
			
			
			if(12<rightw){
				rightw=1;
				
			}
			g.drawImage(walkiconright[rightw/4], x, y,  w, h,this);
				}
			}
			else if(moveStatus==2&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyLeft==false){Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_left.png");
				                 	g.drawImage(img09, x, y,  65, h,this);
				}
					
				else if(keyLeft==true){
		//	walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
		    walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk02_left.png");
			walkiconleft[1]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk03_left.png");
			walkiconleft[2]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk04_left.png");
			walkiconleft[3]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk05_left.png");
			
			
			
			
				 if(leftw/5==1){
					w=65;
				    }
				
				
				 if(leftw/5==2){
					 w=65;
				 }
				
				
				
				
				if(15<leftw){
					leftw=1;
					
				}
				g.drawImage(walkiconleft[leftw/5], x, y,  w, h,this);
				}
			
			}
else if(Attack==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				
				if(moveStatus==0||moveStatus==1){
					
				Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
                g.drawImage(img09, x, 528,  50, 65,this);}
				else if(moveStatus==2){
				Image img09= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_left.png");
	            g.drawImage(img09, x, 528,  50, 65,this);}
				requestFocus();
				}
				
else if((moveStatus==0||moveStatus==1)&&jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
	war_jump[0]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
	war_jump[1]= Toolkit.getDefaultToolkit().getImage("arr_walk//arr_jump_right.png");
	war_jump[2]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_right.png");
int charwidth=65;
int charx=x;
if(char_jump/4==0){
	
	charwidth=65;
}
if(char_jump/4==1){
	y=498;
	charwidth=50;
	
	charx=x+20;
	
}
if(char_jump/4==2){
	y=528;
	
	if(char_jump==8){
	charx=x;}
}
if(char_jump/4>2){
	char_jump=0;
	
}
	
	g.drawImage(war_jump[char_jump/4], charx, y,  charwidth, 65,this);
}
else if(moveStatus==2&&jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
	war_jump[0]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_left.png");
	war_jump[1]= Toolkit.getDefaultToolkit().getImage("arr_walk//arr_jump_left.png");
	war_jump[2]= Toolkit.getDefaultToolkit().getImage("arr_walk//walk01_left.png");
	int charwidth=65;
	int charx=x;
	if(char_jump/4==0){
		
		charwidth=65;
	}
	if(char_jump/4==1){
		y=498;
		charwidth=50;
		
		charx=x;
		
	}
	if(char_jump/4==2){
		y=528;
		
		if(char_jump==8){
		charx=x;}
	}
	if(char_jump/4>2){
		char_jump=0;
		
	}
		
		g.drawImage(war_jump[char_jump/4], charx, y,  charwidth, 65,this);
}   
			else if(Attack==true&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==2){
				cha_attack_arr[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left01.png");
				cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left02.png");
				cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left03.png");
				cha_attack_arr[3]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left04.png");
				cha_attack_arr[4]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left05.png");
				cha_attack_arr[5]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left06.png");
			
				
				if(attack/5==0){
						w=50;
				}
				
				else if(attack/5==1){
					w=50;
				}
				else if(attack/5==2){
					w=50;
				}
				else if(attack/5==3){
					w=50;
				}
				else if(attack/5==4){
					w=50;
				}
				else if(attack/5==5){
					w=50;
				}
				
					
				else if(attack/5>5){
					attack=1;
					w=50;
				}
				g.drawImage(cha_attack_arr[attack/5], x, y,  w, h,this);
				
				requestFocus();
			}
			else if(moveStatus==1||moveStatus==0){
					cha_attack_arr_right[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right01.png");
					cha_attack_arr_right[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right02.png");
					cha_attack_arr_right[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
					cha_attack_arr_right[3]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right04.png");
					cha_attack_arr_right[4]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right05.png");
					cha_attack_arr_right[5]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right06.png");
				
					
					if(attack/5==0){
							w=50;
					}
					
					else if(attack/5==1){
						w=50;
					}
					else if(attack/5==2){
						w=50;
					}
					else if(attack/5==3){
						w=50;
					}
					else if(attack/5==4){
						w=50;
					}
					else if(attack/5==5){
						w=50;
					}
					
						
					else if(attack/5>5){
						attack=1;
						w=50;
					}
					g.drawImage(cha_attack_arr_right[attack/5], x, y,  w, h,this);
					
					requestFocus();
				}
			}
			else if(Skill01==true&&Attack==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill_arr_right[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect01_right.png");
					cha_skill_arr_right[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect02_right.png");
					cha_skill_arr_right[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect03_right.png");
					cha_skill_arr_right[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect04_right.png");
				
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right02.png");
					cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
					
					if(skillmove/5==0){
					w=50;
					   }
					if(skillmove/5==1){
						w=50;
				   }
					if(skillmove/5==2){
						
						w=50;
						  
					   }
				   
					if(skill01/5>3){
						skill01=0;
					}
					if(skillmove/5>2){
						skillmove=0;
					}
					
					
					g.drawImage(cha_attack_war_right[skillmove/5], x, y,  w, h,this);
					g.drawImage(cha_skill_arr_right[skill01/5], x+10, y+5,  w, h,this);
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill_arr_left[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect01_left.png");
					cha_skill_arr_left[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect02_left.png");
					cha_skill_arr_left[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect03_left.png");
					cha_skill_arr_left[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill01_effect04_left.png");
					
					cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left01.png");
					cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left02.png");
					cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left03.png");
					
					if(skillmove/5==0){
						w=50;
						   }
						if(skillmove/5==1){
							w=50;
					   }
						if(skillmove/5==2){
							
							w=50;
							  
						   }
					   
						if(skill01/5>3){
							skill01=0;
						}
						if(skillmove/5>2){
							skillmove=0;
						}
						
						
						g.drawImage(cha_attack_war[skillmove/5], x, y,  w, h,this);
						g.drawImage(cha_skill_arr_left[skill01/5], x-10, y+5,  w, h,this);
						requestFocus();
				}
			}
			
			
			
			else if(Skill02==true&&Attack==false&&Skill01==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill02_arr_right[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_right.png");
					cha_skill02_arr_right[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect02_right.png");
					cha_skill02_arr_right[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect03_right.png");
					cha_skill02_arr_right[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect04_right.png");
					
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=y-100;
					int skillsizex=x;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					
				
			cha_attack_arr[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right01.png");
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			if(skill02/3==0){
				skillsizey=y-93;
			}
            if(skill02/3==1){
            	skillsizey=y-86;
			}
             if(skill02/3==2){
            	 skillsizey=y-79;
			}
             if(skill02/3==3){
            	 skillsizey=y-72;
 			}
             if(skill02/3==4){
            	 skillsizey=y-67;
 			}
             if(skill02/3==5){
            	 skillsizey=y-60;
 			}
             if(skill02/3==6){
            	 skillsizey=y-53;
 			}
             if(skill02/3==7){
            	 skillsizey=y-44;
 			}
             if(skill02/3==8){
            	 skillsizey=y-35;
 			}
             if(skill02/3==9){
            	 skillsizey=y-28;
 			}
             if(skill02/3==10){
            	 skillsizey=y-18;
 			}
             if(skill02/3==11){
            	 skillsizey=y-6;
 			}
             if(skill02/3==12){
            	 skillsizey=y;
 			}
             if(skill02/3==13){
            	 skillsizey=y+3;
 			}
             if(skill02/3==14){
            	 skillsizey=y+3;
 			}
			
			if(skillmove/30==0){
				charsizew=50;
			}
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill02/3>14){
				skill02=0;
			}
			
			if(skillmove/30>1){
				skillmove=0;
			}
			
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+50, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+80, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+110, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+140, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+170, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+200, skillsizey, skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_right[skill02/3], skillsizex+230, skillsizey,  skillsizew,skillsizeh,this);
			
		  	g.drawImage(cha_attack_arr[1], x, charsizey,   charsizew, charsizeh,this);
			
					
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill02_arr_left[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect01_left.png");
					cha_skill02_arr_left[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect02_left.png");
					cha_skill02_arr_left[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect03_left.png");
					cha_skill02_arr_left[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill02_effect04_left.png");
					
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=y-100;
					int skillsizex=x;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					
				
			cha_attack_arr[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left01.png");
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			if(skill02/2==0){
				skillsizey=y-93;
			}
            if(skill02/2==1){
            	skillsizey=y-86;
			}
             if(skill02/2==2){
            	 skillsizey=y-79;
			}
             if(skill02/2==3){
            	 skillsizey=y-72;
 			}
             if(skill02/2==4){
            	 skillsizey=y-67;
 			}
             if(skill02/2==5){
            	 skillsizey=y-60;
 			}
             if(skill02/2==6){
            	 skillsizey=y-53;
 			}
             if(skill02/2==7){
            	 skillsizey=y-44;
 			}
             if(skill02/2==8){
            	 skillsizey=y-35;
 			}
             if(skill02/2==9){
            	 skillsizey=y-28;
 			}
             if(skill02/2==10){
            	 skillsizey=y-18;
 			}
             if(skill02/2==11){
            	 skillsizey=y-6;
 			}
             if(skill02/2==12){
            	 skillsizey=y;
 			}
             if(skill02/2==13){
            	 skillsizey=y+3;
 			}
             if(skill02/2==14){
            	 skillsizey=y+3;
 			}
			
			if(skillmove/30==0){
				charsizew=50;
			}
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill02/2>14){
				skill02=0;
			}
			
			if(skillmove/30>1){
				skillmove=0;
			}
			
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-60, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-90, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-120, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-150, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-180, skillsizey,  skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-210, skillsizey, skillsizew,skillsizeh,this);
			g.drawImage(cha_skill02_arr_left[skill02/2], skillsizex-240, skillsizey,  skillsizew,skillsizeh,this);
			
		  	g.drawImage(cha_attack_arr[1], x, charsizey,   charsizew, charsizeh,this);
					
					requestFocus();
				}
			}
			else if(Skill03==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill03_arr_right[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect01_right.png");
					cha_skill03_arr_right[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect02_right.png");
					cha_skill03_arr_right[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect03_right.png");
					cha_skill03_arr_right[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect04_right.png");
					cha_skill03_arr_right[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect05_right.png");
					cha_skill03_arr_right[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect06_right.png");
					cha_skill03_arr_right[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect07_right.png");
					cha_skill03_arr_right[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect08_right.png");
					cha_skill03_arr_right[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect09_right.png");
					cha_skill03_arr_right[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect10_right.png");
					cha_skill03_arr_right[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect11_right.png");
					cha_skill03_arr_right[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect12_right.png");
					cha_skill03_arr_right[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect13_right.png");
					cha_skill03_arr_right[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect14_right.png");
					cha_skill03_arr_right[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect15_right.png");
					cha_skill03_arr_right[15]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect16_right.png");
					
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=y-100;
					int skillsizex=x;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					
				
			cha_attack_arr[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right01.png");
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			
 			
            
 			if(skill03/3==0){
 				skillsizew=150;
 				skillsizey=y-90;
 			}
 			if(skill03/3==1){
 				skillsizew=200;
 				skillsizey=y-70;
 				skillsizex=x+20;
 			}
 			if(skill03/3==2){
 				skillsizew=200;
 				skillsizey=y-50;
 				skillsizex=x+40;
 			}
 			if(skill03/3==3){
 				skillsizew=250;
 				
 				skillsizey=y-25;
 				skillsizex=x+60;
 			}
 			if(skill03/3==4){
 				skillsizew=100;
 				skillsizeh=100;
 				skillsizey=y-55;
 				skillsizex=x+200;
 			}
 			if(skill03/3==5){
 				skillsizew=100;
 				skillsizeh=100;
 				skillsizey=y-50;
 				skillsizex=x+200;
 			}
 			if(skill03/3==6){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-60;
 				skillsizex=x+200;
 			}
 			if(skill03/3==7){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x+200;
 			}
 			if(skill03/3==8){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x+200;
 			}
 			if(skill03/3==9){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x+200;
 			}
 			if(skill03/3==10){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
 			if(skill03/3==11){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
 			if(skill03/3==12){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
 			if(skill03/3==13){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
 			if(skill03/3==14){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
 			if(skill03/3==15){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x+200;
 			}
			
			if(skillmove/30==0){
				charsizew=50;
			}
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill03/3>15){
				skill03=0;
			}
			
			if(skillmove/30>1){
				skillmove=0;
			}
			
		
			g.drawImage(cha_skill03_arr_right[skill03/3], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
			
		  	g.drawImage(cha_attack_arr[1], x, charsizey,   charsizew, charsizeh,this);
			
					
					requestFocus();
				}
				else if(moveStatus==2){
					cha_skill03_arr_left[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect01_left.png");
					cha_skill03_arr_left[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect02_left.png");
					cha_skill03_arr_left[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect03_left.png");
					cha_skill03_arr_left[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect04_left.png");
					cha_skill03_arr_left[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect05_left.png");
					cha_skill03_arr_left[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect06_left.png");
					cha_skill03_arr_left[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect07_left.png");
					cha_skill03_arr_left[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect08_left.png");
					cha_skill03_arr_left[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect09_left.png");
					cha_skill03_arr_left[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect10_left.png");
					cha_skill03_arr_left[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect11_left.png");
					cha_skill03_arr_left[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect12_left.png");
					cha_skill03_arr_left[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect13_left.png");
					cha_skill03_arr_left[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect14_left.png");
					cha_skill03_arr_left[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect15_left.png");
					cha_skill03_arr_right[15]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill03_effect16_left.png");
					
					int skillsizew=w;
					int skillsizeh=h;
					int skillsizey=y-100;
					int skillsizex=x;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					
				
			cha_attack_arr[0]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left01.png");
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			
 			
            
 			if(skill03/3==0){
 				skillsizew=150;
 				skillsizey=y-90;
 				skillsizex=x-120;
 			}
 			if(skill03/3==1){
 				skillsizew=200;
 				skillsizey=y-70;
 				skillsizex=x-150;
 			}
 			if(skill03/3==2){
 				skillsizew=200;
 				skillsizey=y-50;
 				skillsizex=x-170;
 			}
 			if(skill03/3==3){
 				skillsizew=250;
 				
 				skillsizey=y-25;
 				skillsizex=x-210;
 			}
 			if(skill03/3==4){
 				skillsizew=100;
 				skillsizeh=100;
 				skillsizey=y-55;
 				skillsizex=x-200;
 			}
 			if(skill03/3==5){
 				skillsizew=100;
 				skillsizeh=100;
 				skillsizey=y-50;
 				skillsizex=x-200;
 			}
 			if(skill03/3==6){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-60;
 				skillsizex=x-200;
 			}
 			if(skill03/3==7){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x-200;
 			}
 			if(skill03/3==8){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x-200;
 			}
 			if(skill03/3==9){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-50;
 				skillsizex=x-200;
 			}
 			if(skill03/3==10){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
 			if(skill03/3==11){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
 			if(skill03/3==12){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
 			if(skill03/3==13){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
 			if(skill03/3==14){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
 			if(skill03/3==15){
 				skillsizew=100;
 				skillsizeh=130;
 				skillsizey=y-70;
 				skillsizex=x-200;
 			}
			
			if(skillmove/30==0){
				charsizew=50;
			}
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill03/3>15){
				skill03=0;
			}
			
			if(skillmove/30>1){
				skillmove=0;
			}
			
		
			g.drawImage(cha_skill03_arr_left[skill03/3], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
			
		  	g.drawImage(cha_attack_arr[1], x, charsizey,   charsizew, charsizeh,this);
			
					
					requestFocus();
				}
			}
			 
			else if(Skill04==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill04_arr_right_pre[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect01_right_pre.png");
					cha_skill04_arr_right_pre[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect02_right_pre.png");
					cha_skill04_arr_right_pre[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect03_right_pre.png");
					cha_skill04_arr_right_pre[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect04_right_pre.png");
					cha_skill04_arr_right_pre[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect05_right_pre.png");
					cha_skill04_arr_right_pre[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect06_right_pre.png");
					cha_skill04_arr_right_pre[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect07_right_pre.png");
					cha_skill04_arr_right_pre[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect08_right_pre.png");
					cha_skill04_arr_right_pre[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect09_right_pre.png");
					cha_skill04_arr_right_pre[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect10_right_pre.png");
					cha_skill04_arr_right_pre[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect11_right_pre.png");
					cha_skill04_arr_right_pre[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect12_right_pre.png");
					cha_skill04_arr_right_pre[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect13_right_pre.png");
					cha_skill04_arr_right_pre[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect14_right_pre.png");
					cha_skill04_arr_right_pre[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect15_right_pre.png");
					cha_skill04_arr_right_pre[15]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect16_right_pre.png");
					cha_skill04_arr_right_pre[16]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect17_right_pre.png");
					cha_skill04_arr_right_pre[17]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect18_right_pre.png");
					cha_skill04_arr_right_pre[18]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect19_right_pre.png");
					cha_skill04_arr_right_pre[19]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect20_right_pre.png");
					cha_skill04_arr_right_pre[20]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect21_right.png");
					cha_skill04_arr_right_pre[21]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect22_right.png");
					cha_skill04_arr_right_pre[22]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect23_right.png");
					cha_skill04_arr_right_pre[23]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect24_right.png");
					cha_skill04_arr_right_pre[24]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect25_right.png");
					cha_skill04_arr_right_pre[25]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect26_right.png");
					cha_skill04_arr_right_pre[26]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect27_right.png");
					cha_skill04_arr_right_pre[27]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect28_right.png");
					cha_skill04_ball_arr_right[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball01_right.png");
					cha_skill04_ball_arr_right[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball02_right.png");
					cha_skill04_ball_arr_right[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball03_right.png");
					cha_skill04_ball_arr_right[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball04_right.png");
					cha_skill04_ball_arr_right[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball05_right.png");
					
					
					
					int skillsizew=180;
					int skillsizeh=150;
					int skillsizey=y-40;
					int skillsizex=x-40;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-40;
					
					
				
		
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			 
			if(skill04==5){
		    	skillsizew=180;
		    	skillsizey=y-4;
		    	skillsizex=x-40;
		    	skillsizeh=80;
		    }
            if(skill04==6){
            	
		    	skillsizey=y-37;
				skillsizex=x-20;
		    	
		                    }
            if(skill04==7){
            	
		    	skillsizey=y-36;
		    	skillsizex=x-20;
                      }
             if(skill04==8){
            	
 		    	skillsizey=y-38;
 		    	skillsizex=x-26;
	                      	    }
               if(skill04==9){
            	   
    		    	skillsizey=y-36;
    		    	skillsizex=x-29;
                 }
                if(skill04==10){
                	
    		    	skillsizey=y-38;
    		    	skillsizex=x-35;
                           }
               if(skill04==11){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-42;
                       }
               if(skill04==12){
            	   skillsizey=y-40;
   		    	skillsizex=x-49;
                       }
               if(skill04==13){
            	  
            	   skillsizey=y-40;
      		    	skillsizex=x-52;
                       }
               if(skill04==14){
            	 
            	   skillsizey=y-40;
     		    	skillsizex=x-55;
                       }
               if(skill04==15){
            	 
            	   skillsizey=y-40;
    		    	skillsizex=x-60;
                       }
               if(skill04==16){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-68;
                       }
               if(skill04==17){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-65;
                       }
               if(skill04==18){
            	   
            	   skillsizey=y-40;
   		    	skillsizex=x-65;
                       }
               if(skill04==19){
            	 
            	   skillsizey=y-40;
      		    	skillsizex=x-85;
                       }
               if(skill04==20){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
                       
               if(skill04==21){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
               if(skill04==22){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
               if(skill04==23){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
               if(skill04==24){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
               if(skill04==25){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
			
               if(skill04==26){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
               if(skill04==27){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-80;
                       }
			
			
			
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill04>27){
				
	        skill04=100;
	        skillsizey=y-40;
		    	skillsizex=x-80;
				
			}
			
			if(skill04_01==1){
				skill_ball_x=x;
			}
           if(skill04_01==2){
        	   skill_ball_x=x+100;
			}
           if(skill04_01==3){
        	   skill_ball_x=x+200;
			}
           if(skill04_01==4){
        	   skill_ball_x=x+300;
			}
           if(skill04_01>4){
        	   skill_ball_x=x+300;
        	   skill04_01=0;
           }
			
			
			
		
			
        
			g.drawImage(cha_skill04_arr_right_pre[skill04], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
		  	g.drawImage(cha_attack_arr[1], x, charsizey,   50, charsizeh,this);
		  	
		  	if(skill04>20){
		  		
		  	g.drawImage(cha_skill04_ball_arr_right[skill04_01], skill_ball_x+20, skillsizey+50,  50,50,this);
		  	
		  	}
					requestFocus();
				}
				
				else if(moveStatus==2){
					
					cha_skill04_arr_left_pre[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect01_left_pre.png");
					cha_skill04_arr_left_pre[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect02_left_pre.png");
					cha_skill04_arr_left_pre[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect03_left_pre.png");
					cha_skill04_arr_left_pre[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect04_left_pre.png");
					cha_skill04_arr_left_pre[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect05_left_pre.png");
					cha_skill04_arr_left_pre[5]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect06_left_pre.png");
					cha_skill04_arr_left_pre[6]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect07_left_pre.png");
					cha_skill04_arr_left_pre[7]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect08_left_pre.png");
					cha_skill04_arr_left_pre[8]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect09_left_pre.png");
					cha_skill04_arr_left_pre[9]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect10_left_pre.png");
					cha_skill04_arr_left_pre[10]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect11_left_pre.png");
					cha_skill04_arr_left_pre[11]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect12_left_pre.png");
					cha_skill04_arr_left_pre[12]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect13_left_pre.png");
					cha_skill04_arr_left_pre[13]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect14_left_pre.png");
					cha_skill04_arr_left_pre[14]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect15_left_pre.png");
					cha_skill04_arr_left_pre[15]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect16_left_pre.png");
					cha_skill04_arr_left_pre[16]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect17_left_pre.png");
					cha_skill04_arr_left_pre[17]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect18_left_pre.png");
					cha_skill04_arr_left_pre[18]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect19_left_pre.png");
					cha_skill04_arr_left_pre[19]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect20_left_pre.png");
					cha_skill04_arr_left_pre[20]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect21_left.png");
					cha_skill04_arr_left_pre[21]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect22_left.png");
					cha_skill04_arr_left_pre[22]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect23_left.png");
					cha_skill04_arr_left_pre[23]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect24_left.png");
					cha_skill04_arr_left_pre[24]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect25_left.png");
					cha_skill04_arr_left_pre[25]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect26_left.png");
					cha_skill04_arr_left_pre[26]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect27_left.png");
					cha_skill04_arr_left_pre[27]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_effect28_left.png");
					cha_skill04_ball_arr_left[0]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball01_left.png");
					cha_skill04_ball_arr_left[1]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball02_left.png");
					cha_skill04_ball_arr_left[2]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball03_left.png");
					cha_skill04_ball_arr_left[3]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball04_left.png");
					cha_skill04_ball_arr_left[4]=Toolkit.getDefaultToolkit().getImage("arr_skill//arr_skill04_ball05_left.png");
					
					
					
					int skillsizew=180;
					int skillsizeh=150;
					int skillsizey=y-40;
					int skillsizex=x-80;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					
					
				
		
			cha_attack_arr[1]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_left02.png");
			//cha_attack_arr[2]=Toolkit.getDefaultToolkit().getImage("arr_attack//arr_attack_right03.png");
			
			 
			if(skill04==5){
		    	skillsizew=180;
		    	skillsizey=y-4;
		    	skillsizex=x-80;
		    	skillsizeh=80;
		    }
            if(skill04==6){
            	
		    	skillsizey=y-37;
				skillsizex=x-100;
		    	
		                    }
            if(skill04==7){
            	
		    	skillsizey=y-36;
		    	skillsizex=x-100;
                      }
             if(skill04==8){
            	
 		    	skillsizey=y-38;
 		    	skillsizex=x-100;
	                      	    }
               if(skill04==9){
            	   
    		    	skillsizey=y-36;
    		    	skillsizex=x-95;
                 }
                if(skill04==10){
                	
    		    	skillsizey=y-38;
    		    	skillsizex=x-90;
                           }
               if(skill04==11){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-84;
                       }
               if(skill04==12){
            	   skillsizey=y-40;
   		    	skillsizex=x-76;
                       }
               if(skill04==13){
            	  
            	   skillsizey=y-40;
      		    	skillsizex=x-73;
                       }
               if(skill04==14){
            	 
            	   skillsizey=y-40;
     		    	skillsizex=x-73;
                       }
               if(skill04==15){
            	 
            	   skillsizey=y-40;
    		    	skillsizex=x-73;
                       }
               if(skill04==16){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-60;
                       }
               if(skill04==17){
            	  
   		    	skillsizey=y-40;
		    	skillsizex=x-60;
                       }
               if(skill04==18){
            	   
            	   skillsizey=y-40;
   		    	skillsizex=x-60;
                       }
               if(skill04==19){
            	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==20){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
                       
               if(skill04==21){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==22){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==23){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==24){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==25){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
			
               if(skill04==26){
              	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
               if(skill04==27){
                	 
            	   skillsizey=y-40;
      		    	skillsizex=x-40;
                       }
			
			
			
			if(skillmove/30==1){
				charsizew=50;
			}
			if(skillmove/30==2){
				charsizew=50;
			}
			if(skill04>27){
				
	           skill04=100;
	           skillsizey=y-40;
 		    	skillsizex=x-40;
				
			}
			
			if(skill04_01==1){
				skill_ball_x=x;
			}
           if(skill04_01==2){
        	   skill_ball_x=x-100;
			}
           if(skill04_01==3){
        	   skill_ball_x=x-200;
			}
           if(skill04_01==4){
        	   skill_ball_x=x-300;
			}
         
           if(skill04_01>4){
        	   skill_ball_x=x-300;
        	   skill04_01=0;
           }
			
			
			
		
			
        
			g.drawImage(cha_skill04_arr_left_pre[skill04], skillsizex, skillsizey,  skillsizew,skillsizeh,this);
		  
			g.drawImage(cha_attack_arr[1], x, charsizey, 50, charsizeh,this);
		  	
		  	if(skill04>20){
		  		
		  	g.drawImage(cha_skill04_ball_arr_left[skill04_01], skill_ball_x+20, skillsizey+50,  50,50,this);
		  	
		  	}
					
					requestFocus();
				}
			}
			
			requestFocus();
			
			
		}
		else if(c==2){
			/*
			Image img10= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
			g.drawImage(img10, x, y,  70, 65,this);
			*/
			 if(moveStatus==0&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
					
            	 Image img10= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
	                g.drawImage(img10, x, y,  70, h,this);
             }
			if(moveStatus==1&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyRight==false){Image img10= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
					                g.drawImage(img10, x, y, 70, h,this);
				}
				
				else if(keyRight==true){
		//	walkiconright[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
		    walkiconright[0]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk02_right.png");
			walkiconright[1]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk03_right.png");
			walkiconright[2]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk04_right.png");
			walkiconright[3]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk05_right.png");
			
			
			 if(rightw/5==0){
				w=68;
			    }
			
			 if(rightw/5==1){
					w=65;
				    }
			
			 if(rightw/5==2){
				 w=70;
			 }
			 if(rightw/5==3){
				 w=70;
			 }
			
		
			
			if(3<rightw/5){
				rightw=1;
			
			}
			g.drawImage(walkiconright[rightw/5], x, y,  w, h,this);
				}
			}
			else if(moveStatus==2&&keyRight==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyLeft==false){Image img10= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_left.png");
				                 	g.drawImage(img10, x, y,  70, h,this);
				                 	
				}
					
				else if(keyLeft==true){
		//	walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
		    walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk02_left.png");
			walkiconleft[1]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk03_left.png");
			walkiconleft[2]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk04_left.png");
			walkiconleft[3]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk05_left.png");
			
				 if(leftw/5==0){
					w=73;
				 }
				 if(leftw/5==1){
						w=70;
					 }
				 if(leftw/5==2){
					 w=73;
				 }
				 if(leftw/5==3){
					 w=70;
				 }
				
				
				
				if(3<leftw/5){
					leftw=1;
				
				}
				g.drawImage(walkiconleft[leftw/5], x, y,  w, h,this);
				}
				
			
			}
	
          else if(Attack==false&&keyRight==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				
				if(moveStatus==0||moveStatus==1){
					
				Image img10= Toolkit.getDefaultToolkit().getImage("maigc_walk//walk01_right.png");
				g.drawImage(img10, x, y,  70, h,this);}
				else if(moveStatus==2){
				Image img10= Toolkit.getDefaultToolkit().getImage("maigc_walk//walk01_left.png");
				g.drawImage(img10, x, y,  70, h,this);}
				requestFocus();
				
           }
  		else if(jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
		if(moveStatus==0||moveStatus==1){
  			magic_jump[0]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
			magic_jump[1]= Toolkit.getDefaultToolkit().getImage("magic_walk//magic_jump_right.png");
			magic_jump[2]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
		int charwidth=70;
		int charx=x;
		if(char_jump/4==1){
			y=498;
			charx=x+20;
			charwidth=45;
		}
		if(char_jump/4==2){
			y=528;
			
			charwidth=70;
		}
		if(char_jump/4>2){
			
			char_jump=0;
			
		}
			
			g.drawImage(magic_jump[char_jump/4], charx, y,  charwidth, 65,this);
  		}
		else if(moveStatus==2){
			war_jump[0]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_left.png");
			war_jump[1]= Toolkit.getDefaultToolkit().getImage("magic_walk//magic_jump_left.png");
			war_jump[2]= Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_left.png");
		int charwidth=70;
		int charx=x;
			if(char_jump/4==1){
			y=498;
			
			charwidth=45;
		}
		if(char_jump/4==2){
			
			y=528;
			charwidth=70;
		}
		if(char_jump/4>2){
			char_jump=0;
			
		}
			
			g.drawImage(war_jump[char_jump/4], charx, y,  charwidth, 65,this);
			requestFocus();
		}
		}
		
			else if(Attack==true&&keyRight==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==2){
				cha_attack_magic[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left01.png");
				cha_attack_magic[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left02.png");
		
			
				
				if(attack/15==0){
						
				}
				
				else if(attack/15==1){
					
				}
			
	
				else if(attack/15>1){
					attack=1;
					
				}
				g.drawImage(cha_attack_magic[attack/15], x, y,  70, h,this);
				
				requestFocus();
			}
				else if(moveStatus==0||moveStatus==1){
					cha_attack_magic_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right01.png");
					cha_attack_magic_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
			
				
					
					if(attack/15==0){
							
					}
					
					else if(attack/15==1){
						
					}
				
		
					else if(attack/15>1){
						attack=1;
						
					}
					g.drawImage(cha_attack_magic_right[attack/15], x, y,  70, h,this);
					
					requestFocus();
				}
				
			requestFocus();
			
		}
			else if(Skill01==true&&Attack==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill_magic_right[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect01_right.png");
					cha_skill_magic_right[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect02_right.png");
					cha_skill_magic_right[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect03_right.png");
					cha_skill_magic_right[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect04_right.png");
				
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
					int skillsizey=y-40;
					int skillsizex=x+40;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
					
                   if(skill01/3==1){
                	   skillsizex=x+70;
					 }
                     if(skill01/3==2){
                    	 skillsizex=x+120;
 					  }
                     if(skill01/3>3){
 						skill01=0;
 						skillsizex=x+40;
 					 }
                    
                     if(skillmove/15>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war_right[skillmove/15], x, y,  70, h,this);
					g.drawImage(cha_skill_magic_right[skill01/3], skillsizex, y+30,  30, 30,this);
					requestFocus();
				}
				else if(moveStatus==2){
					
					cha_skill_magic_left[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect01_right.png");
					cha_skill_magic_left[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect02_right.png");
					cha_skill_magic_left[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect03_right.png");
					cha_skill_magic_left[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill01_effect04_right.png");
					
					cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left01.png");
					cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left02.png");
					
					int skillsizey=y-40;
					int skillsizex=x-10;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					
					//magicvolt=x+10;
					
                   if(skill01/3==1){
                	   skillsizex=x-40;
					 }
                     if(skill01/3==2){
                    	 skillsizex=x-80;
 					  }
                     if(skill01/3>3&& skillsizex>-30){
 						skill01=0;
 						 skillsizex=x-10;
 					 }
                     if(skillmove/15==0){
  						
  					 }
                     if(skillmove/15==1){
                    	 
  					 }
                     if(skillmove/15>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war[skillmove/15], x, y,  70, h,this);
					g.drawImage(cha_skill_magic_left[skill01/3], skillsizex, y+30,  30, 30,this);
					requestFocus();
			}
				requestFocus();
			}
			else if(Skill02==true&&Attack==false&&Skill01==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill02_magic_right[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect01_right.png");
					cha_skill02_magic_right[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect02_right.png");
					cha_skill02_magic_right[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect03_right.png");
					cha_skill02_magic_right[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect04_right.png");
					cha_skill02_magic_right[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect05_right.png");
					cha_skill02_magic_right[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect06_right.png");
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
					int skillsizew=50;
					int skillsizeh=50;
					int skillsizey=y-80;
					int skillsizex=x+80;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
					if(skill02/8==1){
						skillsizey=y-40;
						skillsizex=x+90;
					}
                    if(skill02/8==2){
                    	skillsizey=y-14;
                    	skillsizex=x+90;
                    	skillsizew=50;
    					 skillsizeh=80;
					}
                     if(skill02/8==3){
                    	 skillsizey=y+15;
                    	 skillsizex=x+90;
					}
                     if(skill02/8==4){
                    	 skillsizey=y+15;
                    	 skillsizex=x+90;
 					}
                     if(skill02/8==5){
                    	 skillsizey=y+15;
                    	 skillsizex=x+90;
 					}
                     if(skill02/8>5){
 						skill02=0;
 						
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war_right[1], x, y,  70, h,this);
					g.drawImage(cha_skill02_magic_right[skill02/8], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					requestFocus();
				}
				
				if(moveStatus==2){
					
					cha_skill02_magic_left[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect01_left.png");
					cha_skill02_magic_left[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect02_left.png");
					cha_skill02_magic_left[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect03_left.png");
					cha_skill02_magic_left[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect04_left.png");
					cha_skill02_magic_left[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect05_left.png");
					cha_skill02_magic_left[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill02_effect06_left.png");
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left02.png");
					int skillsizew=50;
					int skillsizeh=50;
					int skillsizey=y-80;
					int skillsizex=x-60;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-60;
					//magicvolt=x+10;
					if(skill02/8==1){
						skillsizey=y-40;
						skillsizex=x-80;
					}
                    if(skill02/8==2){
                    	skillsizey=y-14;
                    	skillsizex=x-80;
                    	skillsizew=50;
    					 skillsizeh=80;
					}
                     if(skill02/8==3){
                    	 skillsizey=y+15;
                    	 skillsizex=x-80;
					}
                     if(skill02/8==4){
                    	 skillsizey=y+15;
                    	 skillsizex=x-80;
 					}
                     if(skill02/8==5){
                    	 skillsizey=y+15;
                    	 skillsizex=x-80;
 					}
                     if(skill02/8>5){
 						skill02=0;
 						
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war_right[1], x, y,  70, h,this);
					g.drawImage(cha_skill02_magic_left[skill02/8], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					requestFocus();
				}
		       }
			else if(Skill03==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill04==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill03_magic[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect01.png");
					cha_skill03_magic[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect02.png");
					cha_skill03_magic[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect03.png");
					cha_skill03_magic[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect04.png");
					cha_skill03_magic[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect05.png");
					cha_skill03_magic[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect06.png");
					cha_skill03_magic[6]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect07.png");
					cha_skill03_magic[7]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect08.png");
					cha_skill03_magic[8]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect09.png");
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
					int skillsizew=55;
					int skillsizeh=150;
					int skillsizex=x+86;
					int skillsizey=y-80;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
					if(skill03/5==0){
						skillsizew=25;
						skillsizeh=150;
						skillsizex=x+100;
						skillsizey=y-80;
					}
					
                     if(skill03/5>8){
 						skill03=0;
 						skillsizew=25;
						skillsizeh=150;
						skillsizex=x+100;
						skillsizey=y-80;
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war_right[1], x, y,  70, h,this);
					g.drawImage(cha_skill03_magic[skill03/5], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					g.drawImage(cha_skill03_magic[skill03/5], skillsizex+60, skillsizey,  skillsizew, skillsizeh,this);
					g.drawImage(cha_skill03_magic[skill03/5], skillsizex+120, skillsizey,  skillsizew, skillsizeh,this);
					requestFocus();
				}
				
				if(moveStatus==2){
					
					cha_skill03_magic[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect01.png");
					cha_skill03_magic[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect02.png");
					cha_skill03_magic[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect03.png");
					cha_skill03_magic[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect04.png");
					cha_skill03_magic[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect05.png");
					cha_skill03_magic[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect06.png");
					cha_skill03_magic[6]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect07.png");
					cha_skill03_magic[7]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect08.png");
					cha_skill03_magic[8]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill03_effect09.png");
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left01.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_left02.png");
					int skillsizew=55;
					int skillsizeh=150;
					int skillsizex=x-76;
					int skillsizey=y-80;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
					if(skill03/5==0){
						skillsizew=25;
						skillsizeh=150;
						skillsizex=x-60;
						skillsizey=y-80;
					}
					
                     if(skill03/5>8){
 						skill03=0;
 						skillsizew=25;
						skillsizeh=150;
						skillsizex=x-60;
						skillsizey=y-80;
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
                    g.drawImage(cha_attack_war_right[1], x, y,  70, h,this);
         			g.drawImage(cha_skill03_magic[skill03/5], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					g.drawImage(cha_skill03_magic[skill03/5], skillsizex-60, skillsizey,  skillsizew, skillsizeh,this);
					g.drawImage(cha_skill03_magic[skill03/5], skillsizex-120, skillsizey,  skillsizew, skillsizeh,this);
					requestFocus();
				}
		       }
			else if(Skill04==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&jumping==false){
				if(moveStatus==0||moveStatus==1){
					cha_skill04_magic[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect01.png");
					cha_skill04_magic[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect02.png");
					cha_skill04_magic[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect03.png");
					cha_skill04_magic[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect04.png");
					cha_skill04_magic[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect05.png");
					cha_skill04_magic[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect06.png");
					cha_skill04_magic[6]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect07.png");
					cha_skill04_magic[7]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect08.png");
					cha_skill04_magic[8]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect09.png");
					cha_skill04_magic[9]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect10.png");
					cha_skill04_magic[10]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect11.png");
					cha_skill04_magic[11]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect12.png");
					cha_skill04_magic[12]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect13.png");
					cha_skill04_magic[13]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect14.png");
					cha_skill04_magic[14]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect15.png");
					cha_skill04_magic[15]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect16.png");
					cha_skill04_magic[16]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect17.png");
					cha_skill04_magic[17]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect018.png");

					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_right.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
					int skillsizew=200;
					int skillsizeh=200;
					int skillsizex=x-50;
					int skillsizey=y-100;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
				
					
                     if(skill04/3>17){
 						skill04=0;
 						
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 						
 					}
                     
					
					
	                   
					
					g.drawImage(cha_attack_war_right[0], x, y,  70, h,this);
					g.drawImage(cha_skill04_magic[skill04/3], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
				
					requestFocus();
				}
				
				if(moveStatus==2){
					
					cha_skill04_magic[0]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect01.png");
					cha_skill04_magic[1]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect02.png");
					cha_skill04_magic[2]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect03.png");
					cha_skill04_magic[3]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect04.png");
					cha_skill04_magic[4]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect05.png");
					cha_skill04_magic[5]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect06.png");
					cha_skill04_magic[6]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect07.png");
					cha_skill04_magic[7]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect08.png");
					cha_skill04_magic[8]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect09.png");
					cha_skill04_magic[9]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect10.png");
					cha_skill04_magic[10]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect11.png");
					cha_skill04_magic[11]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect12.png");
					cha_skill04_magic[12]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect13.png");
					cha_skill04_magic[13]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect14.png");
					cha_skill04_magic[14]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect15.png");
					cha_skill04_magic[15]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect16.png");
					cha_skill04_magic[16]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect17.png");
					cha_skill04_magic[17]=Toolkit.getDefaultToolkit().getImage("magic_skill//magic_skill04_effect018.png");
					
					cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("magic_walk//walk01_left.png");
					cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
					int skillsizew=200;
					int skillsizeh=200;
					int skillsizex=x-80;
					int skillsizey=y-100;
					int charsizew=w;
					int charsizeh=h;
					int charsizey=y;
					int skill_ball_x=x-80;
					//magicvolt=x+10;
				
					
                     if(skill04/3>17){
 						skill04=0;
 						
 					 }
                     if(skillmove/30==0){
  						w=70;
  					 }
                     if(skillmove/30==1){
                    	 w=70;
  					 }
                     if(skillmove/30>1){
 						skillmove=0;
 						
 					}
                     
					
					
	                   
                    g.drawImage(cha_attack_war_right[0], x, y,  70, h,this);
         			g.drawImage(cha_skill04_magic[skill04/3], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
		
					requestFocus();
				}
		       }
			requestFocus();
			
		}
		
		
		
		else if(c==3){
			/*
			Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
			g.drawImage(img11, x, y,  45, 65,this);
			*/
			if(moveStatus==0&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				
           	 Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
	                g.drawImage(img11, x, y,  50, h,this);
            }
			if(moveStatus==1&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyRight==false){Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
					                g.drawImage(img11, x, y,  50, h,this);
				}
				
		else if(keyRight==true&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
		//	walkiconright[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_right.png");
		    walkiconright[0]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk02_right.png");
			walkiconright[1]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk03_right.png");
			walkiconright[2]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk04_right.png");
			walkiconright[3]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk05_right.png");
			
			
			 if(rightw/5==1){
				w=54;
			    }
			
			
			 if(rightw/5==2){
				 w=50;
			 }
			
			
			
			
			if(3<rightw/5){
				rightw=1;
				
			}
			g.drawImage(walkiconright[rightw/5], x, y,  w, h,this);
				}
			}
			else if(moveStatus==2&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
				if(keyLeft==false){Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
				                 	g.drawImage(img11, x, y,  50, h,this);
				}
					
				else if(keyLeft==true){
		//	walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("war_walk//walk01_left.png");
		    walkiconleft[0]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk02_left.png");
			walkiconleft[1]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk03_left.png");
			walkiconleft[2]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk04_left.png");
			walkiconleft[3]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk05_left.png");
			
				 if(leftw/5==1){
					w=54;
				    }
				
				
				 if(leftw/5==2){
					 w=50;
				 }
				
				
				
				
				if(3<leftw/5){
					leftw=1;
					
				}
				g.drawImage(walkiconleft[leftw/5], x, y,  w, h,this);
				}
			
			}
			 else if(Attack==false&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
					
					if(moveStatus==0||moveStatus==1){
						
					Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
					g.drawImage(img11, x, y,  50, h,this);}
					else if(moveStatus==2){
					Image img11= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
					g.drawImage(img11, x, y,  50, h,this);}
					requestFocus();
					}
					
				    
				else if(Attack==true&&keyLeft==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
					if(moveStatus==2){
						cha_attack_theif[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left01.png");
						cha_attack_theif[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left02.png");
						cha_attack_theif[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left03.png");
						cha_attack_theif[3]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left04.png");
						cha_attack_theif[4]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left05.png");
						cha_attack_theif[5]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left06.png");
						cha_attack_theif[6]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left07.png");
						cha_attack_theif[7]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left08.png");
						cha_attack_theif[8]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left09.png");
						cha_attack_theif[9]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left10.png");
				
					
					if(attack/4==0){
							
					}
					
					else if(attack/4==1){
						
					}
                     else if(attack/4==2){
						w=60;
					}
                     else if(attack/4==3){
 						w=55;
 					}
                     else if(attack/4==4){
                    	 w=50;
 					}
                     else if(attack/4==5){
 						
 					}
                     else if(attack/4==6){
 						w=55;
 					}
                     else if(attack/4==7){
 						w=50;
 					}
                     else if(attack/4==8){
 						
 					}
                     else if(attack/4==9){
                    	 w=60;
 					}
				
		
					else if(attack/4>9){
						w=50;
						attack=1;
						
					}
					g.drawImage(cha_attack_theif[attack/4], x, y,  w, h,this);
					
					requestFocus();
				}
					else if(moveStatus==0||moveStatus==1){
						cha_attack_theif_right[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right01.png");
						cha_attack_theif_right[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right02.png");
						cha_attack_theif_right[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right03.png");
						cha_attack_theif_right[3]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right04.png");
						cha_attack_theif_right[4]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right05.png");
						cha_attack_theif_right[5]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right06.png");
						cha_attack_theif_right[6]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right07.png");
						cha_attack_theif_right[7]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right08.png");
						cha_attack_theif_right[8]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right09.png");
						cha_attack_theif_right[9]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right10.png");
				
					
					if(attack/4==0){
							
					}
					
					else if(attack/4==1){
						
					}
                     else if(attack/4==2){
						w=60;
					}
                     else if(attack/4==3){
 						w=55;
 					}
                     else if(attack/4==4){
                    	 w=50;
 					}
                     else if(attack/4==5){
 						
 					}
                     else if(attack/4==6){
 						w=55;
 					}
                     else if(attack/4==7){
 						w=50;
 					}
                     else if(attack/4==8){
 						
 					}
                     else if(attack/4==9){
                    	 w=60;
 					}
				
		
					else if(attack/4>9){
						w=50;
						attack=1;
						
					}
					g.drawImage(cha_attack_theif_right[attack/4], x, y,  w, h,this);
					
					requestFocus();
				}
				}
				else if(jumping==true&&keyRight==false&&keyLeft==false&&Attack==false&&Skill01==false&&Skill02==false&&Skill03==false&&Skill04==false){
					if(moveStatus==0||moveStatus==1){
			  			theif_jump[0]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
			  			theif_jump[1]= Toolkit.getDefaultToolkit().getImage("theif_walk//theif_jumping_right.png");
			  			theif_jump[2]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
					int charwidth=50;
					int charx=x;
					if(char_jump/4==1){
						y=498;
						
					
					}
					if(char_jump/4==2){
						y=528;
						
					
					}
					if(char_jump/4>2){
						
						char_jump=0;
						
					}
						
						g.drawImage(theif_jump[char_jump/4], charx, y,  charwidth, 65,this);
			  		}
					else if(moveStatus==2){
						theif_jump[0]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
						theif_jump[1]= Toolkit.getDefaultToolkit().getImage("theif_walk//theif_jumping_left.png");
						theif_jump[2]= Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
					int charwidth=50;
					int charx=x;
						if(char_jump/4==1){
						y=498;
						
						
					}
					if(char_jump/4==2){
						
						y=528;
						
					}
					if(char_jump/4>2){
						char_jump=0;
						
					}
						
						g.drawImage(theif_jump[char_jump/4], charx, y,  charwidth, 65,this);
						requestFocus();
					}
					}
				else if(Skill01==true&&Attack==false&&Skill02==false&&Skill03==false&&Skill04==false&&jumping==false){
					if(moveStatus==0||moveStatus==1){
						cha_skill_theif_right[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect01_right.png");
						cha_skill_theif_right[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect02_right.png");
						cha_skill_theif_right[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect03_right.png");
						cha_skill_theif_right[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect04_right.png");
						cha_skill_theif_right[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect05_right.png");
						cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right01.png");
						cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right02.png");
						cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right03.png");
						cha_attack_war_right[3]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right04.png");
						cha_attack_war_right[4]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right05.png");
						
						
	                     if(skill01/5>4){
	 						skill01=0;
	 						
	 					 }
	                  
	                     if(skillmove/5>4){
	 						skillmove=0;
	 						
	 					}
	                     
						
						
		                   
						
						g.drawImage(cha_attack_war_right[skillmove/5], x, y,  w, h,this);
						g.drawImage(cha_skill_theif_right[skill01/5], x+20, y,  w, h,this);
						requestFocus();
					}
					else if(moveStatus==2){
						cha_skill_theif_left[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect01_left.png");
						cha_skill_theif_left[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect02_left.png");
						cha_skill_theif_left[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect03_left.png");
						cha_skill_theif_left[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect04_left.png");
						cha_skill_theif_left[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill01_effect05_left.png");
						cha_attack_war[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left01.png");
						cha_attack_war[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left02.png");
						cha_attack_war[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left03.png");
						cha_attack_war[3]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left04.png");
						cha_attack_war[4]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left05.png");
						
						
	                     if(skill01/5>4){
	 						skill01=0;
	 						
	 					 }
	                  
	                     if(skillmove/5>4){
	 						skillmove=0;
	 						
	 					}
	                     
						
						
		                   
						
						g.drawImage(cha_attack_war[skillmove/5], x, y,  w, h,this);
						g.drawImage(cha_skill_theif_left[skill01/5], x-20, y,  w, h,this);
						requestFocus();
						
		                   
						
						
				}
				}
				else if(Skill02==true&&Attack==false&&Skill01==false&&Skill04==false&&Skill03==false&&jumping==false){
					if(moveStatus==0||moveStatus==1){
						cha_skill02_theif[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect01.png");
						cha_skill02_theif[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect02.png");
						cha_skill02_theif[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect03.png");
						cha_skill02_theif[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect04.png");
						cha_skill02_theif[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect05.png");
						cha_skill02_theif[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect06.png");
						cha_skill02_theif[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect07.png");
						cha_skill02_theif[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect08.png");
		

						cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
						cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
						int skillsizew=100;
						int skillsizeh=100;
						int skillsizex=x-25;
						int skillsizey=y-15;
						int charsizew=w;
						int charsizeh=h;
						int charsizey=y;
						int skill_ball_x=x-80;
						//magicvolt=x+10;
					
						if(skill02/5==1){
	 						
							skillsizew=118;
							skillsizex=x-43;
	 					 }

						if(skill02/5==2){
	 						
							skillsizew=130;
							skillsizex=x-42;
	 					 }
                       if(skill02/5==3){
	 						
                    	   skillsizew=115;
							skillsizex=x-25;
	 					 }
                        if(skill02/5==4){
	 						
                    	   skillsizew=130;
							skillsizex=x-40;
	 					 }
                        if(skill02/5==5){
	 						
                        	  skillsizew=115;
  							skillsizex=x-40;
 	 					 }
	                     if(skill02/5>7){
	 						skill02=0;
	 						
	 					 }
	                     if(skillmove/30==0){
	  					
	  					 }
	                     if(skillmove/30==1){
	              
	  					 }
	                     if(skillmove/30>1){
	 						skillmove=0;
	 						
	 						
	 					}
	                     
						
						
		                   
						
						g.drawImage(cha_attack_war_right[0], x, y,  50, h,this);
						g.drawImage(cha_skill02_theif[skill02/5], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					
						requestFocus();
					}
					
					if(moveStatus==2){
						
						cha_skill02_theif[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect01.png");
						cha_skill02_theif[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect02.png");
						cha_skill02_theif[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect03.png");
						cha_skill02_theif[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect04.png");
						cha_skill02_theif[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect05.png");
						cha_skill02_theif[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect06.png");
						cha_skill02_theif[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect07.png");
						cha_skill02_theif[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill02_effect08.png");
		

						
						cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
						cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("magic_attack//magic_attack_right02.png");
						int skillsizew=100;
						int skillsizeh=100;
						int skillsizex=x-25;
						int skillsizey=y-15;
						int charsizew=w;
						int charsizeh=h;
						int charsizey=y;
						int skill_ball_x=x-80;
						//magicvolt=x+10;
					
						
	                  if(skill02/5==1){
	 						
							skillsizew=118;
							skillsizex=x-43;
	 					 }

						if(skill02/5==2){
	 						
							skillsizew=130;
							skillsizex=x-42;
	 					 }
                       if(skill02/5==3){
	 						
                    	   skillsizew=115;
							skillsizex=x-25;
	 					 }
                        if(skill02/5==4){
	 						
                    	   skillsizew=130;
							skillsizex=x-40;
	 					 }
                        if(skill02/5==5){
	 						
                        	  skillsizew=115;
  							skillsizex=x-40;
 	 					 }
	                     if(skill02/5>7){
	 						skill02=0;
	 						
	 					 }
	                     if(skillmove/30==0){
	  					
	  					 }
	                     if(skillmove/30==1){
	                    	
	  					 }
	                     if(skillmove/30>1){
	 						skillmove=0;
	 						
	 						
	 					}
	                     
						
						
							
							g.drawImage(cha_attack_war_right[0], x, y,  50, h,this);
							g.drawImage(cha_skill02_theif[skill02/5], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
			
						requestFocus();
					}
			       }
				else if(Skill03==true&&Attack==false&&Skill01==false&&Skill04==false&&Skill02==false&&jumping==false){
						if(moveStatus==0||moveStatus==1){
							cha_skill03_theif_right[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect01_right.png");
							cha_skill03_theif_right[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect02_right.png");
							cha_skill03_theif_right[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect03_right.png");
							cha_skill03_theif_right[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect04_right.png");
							cha_skill03_theif_right[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect05_right.png");
							cha_skill03_theif_right[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect06_right.png");
							cha_skill03_theif_right[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect07_right.png");
							cha_skill03_theif_right[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect08_right.png");
							cha_skill03_theif_right[8]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect09_right.png");
							cha_skill03_theif_right[9]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect10_right.png");
							cha_skill03_theif_right[10]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect11_right.png");
							cha_skill03_theif_right[11]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect12_right.png");
							cha_skill03_theif_right[12]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect13_right.png");
							cha_skill03_theif_right[13]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect14_right.png");
							cha_skill03_theif_right[14]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_right[15]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_right[16]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_right[17]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_right[18]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right04.png");
							cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right05.png");
							cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_right06.png");
							int skillsizew=15;
							int skillsizeh=55;
							int skillsizex=x-4;
							int skillsizey=y+10;
							int charsizew=60;
							int charsizeh=h;
							int charsizey=y;
							int skill_ball_x=x-80;
							//magicvolt=x+10;
							if(skill03/2==3){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==4){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==5){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==6){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==7){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==8){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==9){
								skillsizew=50;
								skillsizex=x-22;
		 					 }
							if(skill03/2==10){
								skillsizew=60;
								skillsizeh=60;
								skillsizex=x-27;
								skillsizey=y+8;
		 					 }
							if(skill03/2==11){
								skillsizew=60;
								skillsizeh=60;
								skillsizex=x-27;
								skillsizey=y+8;
								
		 					 }
							if(skill03/2==12){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+20;
								skillmove1++;
		 					 }
							if(skill03/2==13){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+20;
								skillmove1++;
								
		 					 }
							if(skill03/2==14){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+60;
								
								
		 					 }
							if(skill03/2==15){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+100;
								
								
		 					 }
							if(skill03/2==16){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+140;
								
								
		 					 }
							if(skill03/2==17){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+180;
								
								
		 					 }
							if(skill03/2==18){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x+220;
								
								
		 					 }
							
							
		                     if(skill03/2>18){
		 						skill03=0;
		 						 skillsizew=15;
								 skillsizeh=55;
								 skillsizex=x-4;
							     skillsizey=y+10;
							     skillmove1=0;
		 						
		 					 }
		                    
		                     if(skillmove1/2==1){
		                    	 charsizew=50;
		  					 }
		                     if(skillmove1/2==2){
		                    	 charsizew=50;
		  					 }
		                     if(skillmove1/2>2){
		 						skillmove1=0;
		 						
		 						
		 					}
		                     
							
							
			                   
							
							g.drawImage(cha_attack_war_right[skillmove1/2], x, y,  charsizew, h,this);
							g.drawImage(cha_skill03_theif_right[skill03/2], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
						
							requestFocus();
						}
						
						if(moveStatus==2){
							cha_skill03_theif_left[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect01_left.png");
							cha_skill03_theif_left[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect02_left.png");
							cha_skill03_theif_left[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect03_left.png");
							cha_skill03_theif_left[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect04_left.png");
							cha_skill03_theif_left[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect05_left.png");
							cha_skill03_theif_left[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect06_left.png");
							cha_skill03_theif_left[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect07_left.png");
							cha_skill03_theif_left[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect08_left.png");
							cha_skill03_theif_left[8]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect09_left.png");
							cha_skill03_theif_left[9]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect10_left.png");
							cha_skill03_theif_left[10]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect11_left.png");
							cha_skill03_theif_left[11]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect12_left.png");
							cha_skill03_theif_left[12]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect13_left.png");
							cha_skill03_theif_left[13]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_effect14_left.png");
							cha_skill03_theif_left[14]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_left[15]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_left[16]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_left[17]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_skill03_theif_left[18]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill03_ball.png");
							cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left04.png");
							cha_attack_war_right[1]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left05.png");
							cha_attack_war_right[2]=Toolkit.getDefaultToolkit().getImage("theif_attack//theif_attack_left06.png");
			
							int skillsizew=15;
							int skillsizeh=55;
							int skillsizex=x+45;
							int skillsizey=y+10;
							int charsizew=60;
							int charsizeh=h;
							int charsizey=y;
							int skill_ball_x=x-80;
							//magicvolt=x+10;
							if(skill03/2==3){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==4){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==5){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==6){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==7){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==8){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==9){
								skillsizew=50;
								skillsizex=x+28;
		 					 }
							if(skill03/2==10){
								skillsizew=60;
								skillsizeh=60;
								skillsizex=x+24;
								skillsizey=y+8;
		 					 }
							if(skill03/2==11){
								skillsizew=60;
								skillsizeh=60;
								skillsizex=x+24;
								skillsizey=y+8;
								
		 					 }
							if(skill03/2==12){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-40;
								skillmove1++;
		 					 }
							if(skill03/2==13){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-40;
								skillmove1++;
								
		 					 }
							if(skill03/2==14){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-80;
								
								
		 					 }
							if(skill03/2==15){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-120;
								
								
		 					 }
							if(skill03/2==16){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-160;
								
								
		 					 }
							if(skill03/2==17){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-200;
								
								
		 					 }
							if(skill03/2==18){
								skillsizew=70;
								skillsizeh=70;
								skillsizex=x-240;
								
								
		 					 }
							
							
		                     if(skill03/2>18){
		 						skill03=0;
		 						 skillsizew=15;
								 skillsizeh=55;
								 skillsizex=x+45;
								  skillsizey=y+10;
							     skillmove1=0;
		 						
		 					 }
		                    
		                     if(skillmove1/2==1){
		                    	 charsizew=50;
		  					 }
		                     if(skillmove1/2==2){
		                    	 charsizew=50;
		  					 }
		                     if(skillmove1/2>2){
		 						skillmove1=0;
		 						
		 						
		 					}
		                     
							
							
			                   
							
							g.drawImage(cha_attack_war_right[skillmove1/2], x, y,  charsizew, h,this);
							g.drawImage(cha_skill03_theif_left[skill03/2], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
				
							requestFocus();
						}
				       }
				else if(Skill04==true&&Attack==false&&Skill01==false&&Skill03==false&&Skill02==false&&jumping==false){
					if(moveStatus==0||moveStatus==1){
						cha_skill04_theif[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect01.png");
						cha_skill04_theif[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect02.png");
						cha_skill04_theif[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect03.png");
						cha_skill04_theif[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect04.png");
						cha_skill04_theif[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect05.png");
						cha_skill04_theif[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect06.png");
						cha_skill04_theif[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect07.png");
						cha_skill04_theif[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect08.png");
						cha_skill04_theif[8]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect09.png");
						cha_skill04_theif[9]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect10.png");
						cha_skill04_theif[10]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect11.png");
						cha_skill04_theif[11]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect12.png");
						cha_skill04_theif[12]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect13.png");
						cha_skill04_theif[13]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect14.png");
						cha_skill04_theif[14]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect15.png");
	
		
						cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_right.png");
			
						int skillsizew=150;
						int skillsizeh=150;
						int skillsizex=x-50;
						int skillsizey=y-60;
						int charsizew=50;
						int charsizeh=h;
						int charsizey=y;
						int skill_ball_x=x-80;
						//magicvolt=x+10;
				
						
						
	                     if(skill04/2>14){
	 						skill04=0;
	 						
	 					 }
	                    
	                  
	                     
						
						
		                   
						
						g.drawImage(cha_attack_war_right[0], x, y,  50, h,this);
						g.drawImage(cha_skill04_theif[skill04/2], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
					
						requestFocus();
					}
					
					if(moveStatus==2){
						cha_skill04_theif[0]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect01.png");
						cha_skill04_theif[1]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect02.png");
						cha_skill04_theif[2]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect03.png");
						cha_skill04_theif[3]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect04.png");
						cha_skill04_theif[4]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect05.png");
						cha_skill04_theif[5]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect06.png");
						cha_skill04_theif[6]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect07.png");
						cha_skill04_theif[7]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect08.png");
						cha_skill04_theif[8]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect09.png");
						cha_skill04_theif[9]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect10.png");
						cha_skill04_theif[10]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect11.png");
						cha_skill04_theif[11]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect12.png");
						cha_skill04_theif[12]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect13.png");
						cha_skill04_theif[13]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect14.png");
						cha_skill04_theif[14]=Toolkit.getDefaultToolkit().getImage("theif_skill//theif_skill04_effect15.png");
	
		
						cha_attack_war_right[0]=Toolkit.getDefaultToolkit().getImage("theif_walk//walk01_left.png");
			
						int skillsizew=150;
						int skillsizeh=150;
						int skillsizex=x-50;
						int skillsizey=y-60;
						int charsizew=50;
						int charsizeh=h;
						int charsizey=y;
						int skill_ball_x=x-80;
						//magicvolt=x+10;
				
						
						
	                     if(skill04/2>14){
	 						skill04=0;
	 						
	 					 }
	                    
	                  
	                     
						
						
		                   
						
						g.drawImage(cha_attack_war_right[0], x, y,  50, h,this);
						g.drawImage(cha_skill04_theif[skill04/2], skillsizex, skillsizey,  skillsizew, skillsizeh,this);
			
						requestFocus();
					}
			       }
			requestFocus();
		}
		
	}
	}




