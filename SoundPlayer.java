package ch03;

import java.applet.AudioClip;
import javax.swing.JApplet;

public class SoundPlayer {
   
   AudioClip inputSound; // 파일명에 그냥 파일명만 넣을것 // 지가알아서 찾아줌
   
   public SoundPlayer(String SoundFileURL){
      try {
         inputSound = JApplet.newAudioClip(getClass().getResource(SoundFileURL));
         }catch (Exception e) {System.out.println("파일을 못읽었습니다");}
   }
   
   public void startPlay(){
      try {
         inputSound.play();
        // System.out.println("음악재생");
      }catch (Exception e) {System.out.println("음악 재생을 못했습니다");}
   }
   
   public void stopPlayer(){
      inputSound.stop();
   }
}