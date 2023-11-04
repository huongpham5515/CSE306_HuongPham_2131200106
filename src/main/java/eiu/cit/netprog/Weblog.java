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
public class Weblog {
    public static void main(String[] args) {
        try{
            FileInputStream fin = new FileInputStream("C:/Users/ADMIN/lab-exercise/src/LTest.txt");
            Reader in = new InputStreamReader(fin);
            BufferedReader bin = new BufferedReader(in);
            
            for(String entry = bin.readLine(); entry != null; entry = bin.readLine()){
                //seperate out the IP address
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                //Ask DNS for the hostname and print it out
                try{
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName()+theRest);
                }catch(UnknownHostException ex){
                    System.err.println(entry);
                }
            }
        }catch(IOException ex){
            System.out.println("Exception" + ex);
        }
    }
}
