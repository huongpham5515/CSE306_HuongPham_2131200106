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
public class ConnectEliza {

    public static final String SERVER = "telehack.com";
    public static final int PORT = 23;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            int c, befo = -1;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
                if (c == '.') {
                    if (befo == '\n') {
                        break;
                    }
                }
                befo = c;
            }
            BufferedReader readLi = new BufferedReader(new InputStreamReader(System.in));
            writer.write("eliza" + "\r\n");
            writer.flush();
            readFirstLine(reader);

            String line = readLi.readLine();
            while (!(line.equals("quit" + "\r\n"))) {
                writer.write(line + "\r\n");
                writer.flush();
                readRespond(reader);
            }

        } catch (IOException ex) {
            System.err.print(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {

                }
            }
        }
    }
    public static void readFirstLine(BufferedReader reader){
        int c, count = 0;
        try{
            while((c = reader.read()) != -1){
                if((char) c == '\n'){
                    if(count == 2){
                        break;
                    }else{
                        count++;
                    }
                }
                System.out.print((char) c);
            }
        }catch(IOException ex){
            
        }
    }
    public static void readRespond(BufferedReader reader) {
        int c, count = 0;
        try {
            while ((c = reader.read()) != -1) {
                if ((char) c == '\n') {
                    if (count == 3) {
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.print((char) c);
                }
            }
            System.out.println();
        } catch (IOException ex) {

        }

    }

}
