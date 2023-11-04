/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import javax.sound.sampled.*;

/**
 *
 * @author ADMIN
 */
public class AudioPlay {
    public static void main(String[] args) {
        try{
            String file = "C:\\Users\\ADMIN\\Downloads\\sample1.wav";
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(file));
            Clip sound = AudioSystem.getClip();
            sound.open(audio);
            sound.start();
            Thread.sleep(sound.getMicrosecondLength()/1000);
            
        }catch( UnsupportedAudioFileException ex){
            System.out.println("Error");
        }catch(LineUnavailableException e){
            System.out.println("Error");
        }catch(IOException x){
            System.out.println("Error");
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        
    }
}
