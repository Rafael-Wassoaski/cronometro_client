package com.rafaelwassoaski.cronometro_client.socket;

public class ClientThread implements Runnable {
    private String message;

    public ClientThread(String message) {
        this.message = message;
    }



    @Override
    public void run() {
        // TODO Auto-generated method stub
        Client client = new Client();
        client.sendStringMessage(this.message);
    }
    
}
