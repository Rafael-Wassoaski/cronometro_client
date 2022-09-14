package com.rafaelwassoaski.cronometro_client.som;


import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Som {
    private URL nomeSom;

    public Som(){
        this.nomeSom = getClass().getResource("campainha.wav");
    }

    public void play() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
    	System.out.println(nomeSom.toString());
    	AudioInputStream som = AudioSystem.getAudioInputStream(nomeSom);
        Clip player = AudioSystem.getClip();
        player.open(som);
        player.start();
    }
}
