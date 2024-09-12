package com.rafaelwassoaski.cronometro_client.som;


import com.rafaelwassoaski.cronometro_client.App;

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
        this.nomeSom = App.class.getResource("campainha.wav");
    }

    public void play() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
    	System.out.println(nomeSom);
    	AudioInputStream som = AudioSystem.getAudioInputStream(nomeSom);
        Clip player = AudioSystem.getClip();
        player.open(som);
        player.start();
    }
}
