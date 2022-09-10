package com.rafaelwassoaski.cronometro_client.timers;

public class Minute {
    private int minutes;
    private int seconds;

    public Minute(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }
    
    public int getSeconds() {
        return seconds;
    }

    
}
