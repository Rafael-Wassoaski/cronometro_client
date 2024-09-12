package com.rafaelwassoaski.cronometro_client;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.rafaelwassoaski.cronometro_client.socket.Client;
import com.rafaelwassoaski.cronometro_client.som.Som;
import com.rafaelwassoaski.cronometro_client.timers.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class SecondaryController {

    @FXML
    private Text timer;

    private Thread countDownThread;

    private boolean playCampainha = true;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }


    @FXML
    private void zerarTimer() throws IOException {
        ZeroSeconds minutes = new ZeroSeconds();
        playCampainha = false;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void umMinutoTimer() throws IOException {
        OneMinute minutes = new OneMinute();
        playCampainha = true;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void umMinutoTrintaTimer() throws IOException {
        OneMinuteAndThirtySeconds minutes = new OneMinuteAndThirtySeconds();
        playCampainha = true;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void trintaSegunodsTimer() throws IOException {
        ThirtySeconds minutes = new ThirtySeconds();
        playCampainha = true;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void doisMinutosTimer() throws IOException {
        TwoMinute minutes = new TwoMinute();
        playCampainha = true;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void tresMinutosTimer() throws IOException {
        ThreeMinute minutes = new ThreeMinute();
        playCampainha = true;
        this.sendMinutes(minutes);

        this.countDown(minutes);
    }

    @FXML
    private void quatroMinutosTimer() throws IOException {
        FourMinute minutes = new FourMinute();
        playCampainha = true;
        this.sendMinutes(minutes);
        this.countDown(minutes);
    }
    
    @FXML
    private void campainha() {
    	Som som = new Som();
    	
    	try {
			som.play();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void tocarCampainha() {
    	Som som = new Som();
    	
    	try {
            playCampainha = true;
			som.play();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void sendMinutes(Timer timeCounter){
        Client client = new Client();

        client.sendStringMessage(Integer.toString(timeCounter.getSeconds()));
    }

    private void countDown(Timer timeToCount) throws IOException {
        this.resetCountColor();

        if(countDownThread!= null && countDownThread.isAlive()){
            countDownThread.interrupt();
        }

        countDownThread = this.updateTimerText(timeToCount);
        countDownThread.start();
    }
    
    private void resetCountColor(){
        this.timer.setFill(Paint.valueOf("001eff"));
    }


    private Thread updateTimerText(Timer timeToCount) {
        Thread thread = new Thread(() -> {
            try {
                timeToCount.countDown(timer);

                if(this.playCampainha){
                    this.tocarCampainha();
                    this.resetCountColor();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        return thread;
    }



}
