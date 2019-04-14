package com.example.hh_drums;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound4;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;

    Sequencer sequencer;
    Sequencer refresher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "clh" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);

        }

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1 = sp.load(getApplicationContext(), R.raw.sound1,1);
        sound2 = sp.load(getApplicationContext(), R.raw.sound2,1);
        sound3 = sp.load(getApplicationContext(), R.raw.sound3,1);
        sound4 = sp.load(getApplicationContext(), R.raw.sound4,1);
        sound5 = sp.load(getApplicationContext(), R.raw.sound5,1);
        sound6 = sp.load(getApplicationContext(), R.raw.sound6,1);
        sound7 = sp.load(getApplicationContext(), R.raw.sound7,1);
        sound8 = sp.load(getApplicationContext(), R.raw.sound8,1);
        sound9 = sp.load(getApplicationContext(), R.raw.sound9,1);

        sequencer = new Sequencer(this, sp, buttons, sound5);
        refresher = new Sequencer(this);


        Refresher runnable = new Refresher();
        new Thread(runnable).start();

    }


    public void play(View v) {

        sequencer.setIsPlaying(true);
        new Thread(sequencer).start();
    }

    public void stop(View v) {
        sequencer.setIsPlaying(false);
    }

    class Refresher extends Thread  {
        int sound;
        Refresher() {
        }

        public void run() {
            while(true) {
                sp.play(sound5,0.0f,0.0f,0,0,1.0f);
                System.out.print("Played sound 3");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
