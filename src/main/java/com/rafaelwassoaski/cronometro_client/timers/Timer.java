package com.rafaelwassoaski.cronometro_client.timers;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public abstract class Timer {

    protected int seconds;

    protected Timer(int seconds){
        this.seconds = seconds;
    }
    public Minute minutesToCount;

    public Minute getMinutesToCount() {
        return minutesToCount;
    }

    public void countDown(Text text) throws InterruptedException{
        minutesToCount = this.secondsToMinutes();
       

        for(int minute = minutesToCount.getMinutes(); minute >= 0 ; minute --){
            for(int seconds = minutesToCount.getSeconds(); seconds >= 0; seconds --){

                if(seconds <10){
                    text.setText(minute + ":0" + seconds);
                }else{
                    text.setText(minute + ":" + seconds);
                }

                this.setCountRedIfTimeIsOvering(minute, seconds, text);

                Thread.currentThread().sleep(1000);
            }
        }
    }

    void setCountRedIfTimeIsOvering(int minute, int seconds, Text text){
        if(minute == 0 && seconds < 10){
            text.setFill(Paint.valueOf("FF2A00"));
        }
    }

    Minute secondsToMinutes(){
        if(seconds / 60.0 < 1){
            return new Minute(0, seconds);
            
        }

        double totalMinutes = seconds/60.0;
        int minutes = Math.abs(seconds/60);
        double numericSeconds = totalMinutes - minutes;
        double seconds = numericSeconds * 60;

        System.out.println(seconds);
        System.out.println(minutes);

        if(seconds == 0){
            seconds = 59;
            minutes -= 1;
        }

        return new Minute(minutes, (int) seconds);
    }

    public int getSeconds() {
        return seconds;
    }
}
