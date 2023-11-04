/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

/**
 *
 * @author ADMIN
 */
public class DownloadThenPlays {
    public static void main(String[] args) {
         try{
        URL url = new URL("https://www.tanbinhtech.com:8443/sample1.wav");
        InputStream in = url.openStream();
        String file = "C:\\Users\\ADMIN\\lab-exercise\\src\\metmoi.wav";
        File file2 = new File(file);
        OutputStream audio = new FileOutputStream(file2);
          BufferedInputStream bis = new BufferedInputStream(in);
          BufferedOutputStream bos = new BufferedOutputStream(audio);
            int c;
            while((c=bis.read())!= -1){
                bos.write(c);
            }
            bos.close();
          
        AudioInputStream music = AudioSystem.getAudioInputStream(file2);
        Clip sound = AudioSystem.getClip();
        sound.open(music);
        sound.start();
        Thread.sleep(sound.getMicrosecondLength()/1000);
            
        }catch( MalformedURLException ex){
            
        } catch (IOException ex) {
           
        } catch (UnsupportedAudioFileException ex) {
          
        } catch (LineUnavailableException ex) {
           
        } catch (InterruptedException ex) {
            
        }
    }
}
