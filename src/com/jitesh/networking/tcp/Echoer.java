package com.jitesh.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends  Thread {
    private Socket socket;


    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            while(true) {
                String ecoString = input.readLine();
                System.out.println("Received from Client server "+ecoString);
                if (ecoString.equals("exit")) break;
                try {
                    Thread.sleep(15000);
                }catch (InterruptedException e1){
                    System.out.println(e1.getMessage());
                }
                output.println(ecoString);
            }
        }catch (IOException e){
            System.out.println( e.getMessage());
        }finally {
            try {
                socket.close();
            }catch (IOException e){

            }
        }
    }
}
