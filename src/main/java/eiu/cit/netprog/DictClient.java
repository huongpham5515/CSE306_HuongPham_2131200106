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
public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
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
            for (String word : args) {
                define(word, writer, reader);
            }
            writer.write("quit\r\n");
            //writer.write("quit.");
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex);
        } finally { // dispose
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
    }

    static void define(String word, Writer writer, BufferedReader reader)
            throws IOException, UnsupportedEncodingException {
        writer.write("DEFINE fd-eng-lat " + word + "\r\n");
        //writer.write("DEFINE fd-eng-lat " + word + ".");
        writer.flush();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) { // OK
                return;
            } else if (line.startsWith("552 ")) { // no match
                System.out.println("No definition found for " + word);
                return;
            } else if (line.matches("\\d\\d\\d .*")) {
                continue;
            } else if (line.trim().equals(".")) {
                continue;
            } else {
                System.out.println(line);
            }
        }
    }
}
