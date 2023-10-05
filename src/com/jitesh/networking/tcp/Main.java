package com.jitesh.networking.tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(6000)){
//            Socket socket =serverSocket.accept();
//            System.out.println("Client Connected");
//            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
//            String ecoString=input.readLine();
//            if (ecoString.equals("exit")) break;
//
//            output.println("Echo from server "+ecoString);
            while (true){
                new Echoer(serverSocket.accept()).start();
            }
        }catch (IOException e){
            System.out.println("Server exception "+e.getMessage());
        }
    }
}
