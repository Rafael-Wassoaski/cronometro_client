package com.rafaelwassoaski.cronometro_client;

import java.io.IOException;
import com.rafaelwassoaski.cronometro_client.socket.Client;
import com.rafaelwassoaski.cronometro_client.timers.FourMinute;
import com.rafaelwassoaski.cronometro_client.timers.OneMinute;
import com.rafaelwassoaski.cronometro_client.timers.ThreeMinute;
import com.rafaelwassoaski.cronometro_client.timers.Timer;
import com.rafaelwassoaski.cronometro_client.timers.TwoMinute;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class SecondaryController {

    @FXML
    private Text timer;

    private Thread countDownThread;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }


    @FXML
    private void zerarTimer() throws IOException {
        timer.setText("0:00");
    }

    @FXML
    private void umMinutoTimer() throws IOException {
        OneMinute minutes = new OneMinute();
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void doisMinutosTimer() throws IOException {
        TwoMinute minutes = new TwoMinute();
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void tresMinutosTimer() throws IOException {
        ThreeMinute minutes = new ThreeMinute();
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void quatroMinutosTimer() throws IOException {
        FourMinute minutes = new FourMinute();
        this.sendMinutes(minutes);
        this.countDown(minutes);
    }

    private void sendMinutes(Timer timeCounter){
        Client client = new Client();

        client.sendStringMessage(Integer.toString(timeCounter.getSeconds()));
    }

    private void countDown(Timer timeToCount) throws IOException {
        if(countDownThread!= null && countDownThread.isAlive()){
            countDownThread.interrupt();
        }

        countDownThread = this.updateTimerText(timeToCount);
        countDownThread.start();
    }


    private Thread updateTimerText(Timer timeToCount) {
        Thread thread = new Thread(() -> {
            try {
                timeToCount.countDown(timer);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        return thread;
    }



}
