/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.*;
/**
 *
 * @author ADMIN
 */
public class DownloadAudio {
    public static void main(String[] args){
        try{
        URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
        InputStream in = url.openStream();
        String file = "C:\\Users\\ADMIN\\lab-exercise\\src\\sample10.wav";
        File file2 = new File(file);
        OutputStream audio = new FileOutputStream(file2);
          BufferedInputStream bis = new BufferedInputStream(in);
          BufferedOutputStream bos = new BufferedOutputStream(audio);
            int c;
            while((c=bis.read())!= -1){
                bos.write(c);
            }
            bos.close();
        }catch( MalformedURLException ex){
            
        } catch (IOException ex) {
           
        }
    }
}
