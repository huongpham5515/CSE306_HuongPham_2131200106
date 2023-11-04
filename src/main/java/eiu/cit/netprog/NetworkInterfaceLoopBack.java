/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiu.cit.netprog;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author ADMIN
 */
public class NetworkInterfaceLoopBack {

    public static void main(String[] args) {

        try {
            InetAddress local = InetAddress.getByName("127.0.0.1");

            NetworkInterface ni = NetworkInterface.getByInetAddress(local);

            if (ni == null) {

                System.err.println("That's weird. No local loopback address.");

            } else {

                System.out.println(ni);

            }
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {

                NetworkInterface ni2 = interfaces.nextElement();

                System.out.println(ni2);

            }

        } catch (SocketException ex) {
            System.err.println("...Error, duh..");
        } catch (UnknownHostException ex) {
            System.err.println("...Cannot find, bleh...");
        }
    }
}
