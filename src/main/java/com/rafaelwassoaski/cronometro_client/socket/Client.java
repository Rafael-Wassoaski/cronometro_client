package com.rafaelwassoaski.cronometro_client.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 */
public class Client {

    private Socket socket;
    private static String serverAddres;
    private final int PORT = 9090;

    public static void setServerAddress(String serverAddres){
        Client.serverAddres = serverAddres;
    }

    public void sendStringMessage(String message){
        try {
            this.openConnection();
            this.createClientThread(message).start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Thread createClientThread(String message){
        System.out.println("nnn" + message);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("aaa" + message);


                try{
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    System.out.println("bbbb" + message);

                    writer.println(message);
                    writer.close();
                    closeConnection();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.getStackTrace();
                    System.out.println(e.getLocalizedMessage());
                }
            }
        });

        return thread;
    }

    private void openConnection() throws UnknownHostException, IOException{
        this.socket = new Socket(Client.serverAddres, PORT);
    }

    private void closeConnection() throws IOException{
        this.socket.close();
    }
}