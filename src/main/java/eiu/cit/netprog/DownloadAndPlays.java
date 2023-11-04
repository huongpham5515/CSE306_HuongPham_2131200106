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
public class DownloadAndPlays {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
            InputStream in = url.openStream();
            in = new BufferedInputStream(in);
            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            AudioFormat format = audio.getFormat();
           DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
           SourceDataLine sound = (SourceDataLine) AudioSystem.getLine(info);
           sound.open(format);
           sound.start();
           
           byte[] line = new byte[4096];
           int count = -1;
           
           while((count = audio.read(line))!= -1){
               sound.write(line, 0, count);
           }
           sound.drain();
           sound.close();
           audio.close();
        } catch (MalformedURLException ex) {

        } catch (IOException ex) {
           
        } catch (UnsupportedAudioFileException ex) {
           
        } catch (LineUnavailableException ex) {
           
        }
    }
}
