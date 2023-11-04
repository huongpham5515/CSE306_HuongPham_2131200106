/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author ADMIN
 */
public class PlayAudioOnline {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://ice10.outlaw.fm/KIEV2");
            InputStream in = url.openStream();
            in = new BufferedInputStream(in);
            Player mp3 = new Player(in);
            mp3.play();
        } catch (MalformedURLException ex) {

        } catch (JavaLayerException ex) {

        } catch (IOException ex) {
            
        }
    }
}
