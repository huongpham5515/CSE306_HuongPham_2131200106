/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ADMIN
 */
public class Sound {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://file-examples.com/storage/fe1134def");
            InputStream in = url.openStream();
            String file = "C:\\Users\\ADMIN\\lab-exercise\\src\\sound.mp3";
            File file2 = new File(file);
            OutputStream write = new FileOutputStream(file2);
            BufferedInputStream bis = new BufferedInputStream(in);
            BufferedOutputStream bos = new BufferedOutputStream(write);
            int c;
            while((c=bis.read())!= -1){
                bos.write(c);
            }
            bos.close();
            
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
