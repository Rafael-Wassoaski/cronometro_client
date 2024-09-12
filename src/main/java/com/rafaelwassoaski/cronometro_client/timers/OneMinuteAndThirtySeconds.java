package com.rafaelwassoaski.cronometro_client.timers;

import javafx.scene.text.Text;

public class OneMinuteAndThirtySeconds extends Timer{
    public OneMinuteAndThirtySeconds(){
        super(90);
    }

    @Override
    public void countDown(Text text) throws InterruptedException {
        Minute minutesToCount = this.secondsToMinutes();


        for(int seconds = minutesToCount.getSeconds(); seconds >= 0; seconds --){

            if(seconds <10){
                text.setText("1:0" + seconds);
            }else{
                text.setText("1:" + seconds);
            }

            this.setCountRedIfTimeIsOvering(1, seconds, text);

            Thread.currentThread().sleep(1000);
        }

            for(int seconds = (minutesToCount.getSeconds() *2) -1 ; seconds >= 0; seconds --){

                if(seconds <10){
                    text.setText("0:0" + seconds);
                }else{
                    text.setText("0:" + seconds);
                }

                this.setCountRedIfTimeIsOvering(0, seconds, text);

                Thread.currentThread().sleep(1000);
        }
    }
}
