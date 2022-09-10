package com.rafaelwassoaski.cronometro_client.timers;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public abstract class Timer {

    private int seconds;

    protected Timer(int seconds){
        this.seconds = seconds;
    }

    public void countDown(Text text) throws InterruptedException{
        Minute minutesToCount = this.secondsToMinutes();
       

        for(int minute = minutesToCount.getMinutes(); minute >= 0 ; minute --){
            for(int seconds = minutesToCount.getSeconds(); seconds >= 0; seconds --){
                text.setText(minute + ":" + seconds);

                this.setCountRedIfTimeIsOvering(minute, seconds, text);

                Thread.currentThread().sleep(1000);
            }
        }
    }

    private void setCountRedIfTimeIsOvering(int minute, int seconds, Text text){
        if(minute == 0 && seconds < 10){
            text.setFill(Paint.valueOf("FF2A00"));
        }
    }

    private void resetCountColor(Text text){
        text.setFill(Paint.valueOf("001eff"));
    }

    private Minute secondsToMinutes(){
        if(seconds / 60 < 1){
            return new Minute(0, seconds);
            
        }

        double totalMinutes = seconds/60;
        int minutes = Math.abs(seconds/60);
        int numericSeconds = (int) totalMinutes - minutes;
        int seconds = numericSeconds * 60;

        System.out.println(seconds);
        System.out.println(minutes);

        if(seconds == 0){
            seconds = 59;
            minutes -= 1;
        }

        return new Minute(minutes, seconds);
    }
}
