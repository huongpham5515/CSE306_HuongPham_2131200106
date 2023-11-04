/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 *
 * @author ADMIN
 */
public class SourceViewer {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.tanbinhtech.com/july.webp");
            InputStream in = url.openStream();
            int c;
            while((c=in.read())!= -1){
                System.out.print((char)c);
            }
        }catch(MalformedURLException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
