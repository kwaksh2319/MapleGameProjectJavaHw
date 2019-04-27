package ch03;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
public class mainmaple {
        public static void main(String[] args){
        
        	    Timer m_timer=new Timer();
        	    TimerTask m_task=new TimerTask(){
              int j;
        	public void run(){
              mapletest01 mp1=new  mapletest01();
             // System.out.println("≈∏¿Ã∏”1");
             
    		  
        	     }
        	    };
        	    m_timer.schedule(m_task, 5000);
        //	IconButtonDemo01 mp= new IconButtonDemo01();
        }
}
