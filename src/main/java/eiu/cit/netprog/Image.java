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
public class Image {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.tanbinhtech.com:8443/july.webp");
            InputStream in = url.openStream();
            String file = "C:\\Users\\ADMIN\\lab-exercise\\src\\img.jpg";
            int c;
            File file2 = new File(file); 
            OutputStream write = new FileOutputStream(file2);
            //BufferedInputStream bis = new BufferedInputStream(in);
            //BufferedOutputStream bos = new BufferedOutputStream(write);
            //while((c=bis.read())!= -1){
            //bos.write(c);
            //}
            //bos.close();
            byte[] a = new byte[100000];
            int i = 0;
            while((c=in.read())!= -1){
               a[i] += (byte)c;
               i++;
            }
            write.write(a);
            write.close();
        }catch(MalformedURLException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
