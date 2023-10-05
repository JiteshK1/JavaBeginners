package com.jitesh.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
try {
            InetAddress address = InetAddress.getLocalHost();
        DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String ecString;
            do {
                System.out.println("Enter sentence to be ecoed");
                ecString=scanner.nextLine();
                byte[] buffer= ecString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,address,5000);
                socket.send(packet);
                byte[] buffer2= new  byte[50];
                packet= new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
                System.out.println("text received is "+new String(buffer2,0,packet.getLength()));
            }while (!ecString.equals("exit"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
