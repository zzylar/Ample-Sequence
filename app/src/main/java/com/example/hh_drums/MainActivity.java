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

    private static final int NUMBER_OF_SAMPLES = 8;
    private static final int NUMBER_OF_BEATS = 16;

    ToggleButton instrument1 [] = new ToggleButton[NUMBER_OF_SAMPLES];
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



    /*private Pad n1 = new Pad(tb1, 1);
    private Pad n2 = new Pad(tb2, 2);
    private Pad n3 = new Pad(tb3, 3);
    private Pad n4 = new Pad(tb4, 4);
    private Pad n5 = new Pad(tb5, 5);
    private Pad n6 = new Pad(tb6, 6);
    private Pad n7 = new Pad(tb7, 7);
    private Pad n8 = new Pad(tb8, 8);
    private Pad n9 = new Pad(tb9, 9);
    private Pad n10 = new Pad(tb10, 10);
    private Pad n11 = new Pad(tb11, 11);
    private Pad n12 = new Pad(tb12, 12);
    private Pad n13 = new Pad(tb13, 13);
    private Pad n14 = new Pad(tb14, 14);
    private Pad n15 = new Pad(tb15, 15);
    private Pad n16 = new Pad(tb16, 16);*/


    Sequencer sequencer;
    Sequencer refresher;
    /*
    public ToggleButton one = (ToggleButton) findViewById(R.id.one);
    public ToggleButton two = (ToggleButton) findViewById(R.id.one);
    public ToggleButton three = (ToggleButton) findViewById(R.id.one);
    public ToggleButton four = (ToggleButton) findViewById(R.id.one);
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ToggleButton tb1 = (ToggleButton) findViewById(R.id.clh1);
        ToggleButton tb2 = (ToggleButton) findViewById(R.id.clh2);
        ToggleButton tb3 = (ToggleButton) findViewById(R.id.clh3);
        ToggleButton tb4 = (ToggleButton) findViewById(R.id.clh4);
        ToggleButton tb5 = (ToggleButton) findViewById(R.id.clh5);
        ToggleButton tb6 = (ToggleButton) findViewById(R.id.clh6);
        ToggleButton tb7 = (ToggleButton) findViewById(R.id.clh7);
        ToggleButton tb8 = (ToggleButton) findViewById(R.id.clh8);
        ToggleButton tb9 = (ToggleButton) findViewById(R.id.clh9);
        ToggleButton tb10 = (ToggleButton) findViewById(R.id.clh10);
        ToggleButton tb11 = (ToggleButton) findViewById(R.id.clh11);
        ToggleButton tb12 = (ToggleButton) findViewById(R.id.clh12);
        ToggleButton tb13 = (ToggleButton) findViewById(R.id.clh13);
        ToggleButton tb14 = (ToggleButton) findViewById(R.id.clh14);
        ToggleButton tb15 = (ToggleButton) findViewById(R.id.clh15);
        ToggleButton tb16 = (ToggleButton) findViewById(R.id.clh16);

        ToggleButton [] buttons = {tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8, tb9, tb10, tb11, tb12,
                tb13, tb14, tb15, tb16};

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

   /* public void playsound1(View v) {
        sp.play(sound1,1.0f,1.0f,0,0,1.0f);


    }

    public void playsound2 (View v) {
        sp.play(sound2,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound3 (View v) {
        sp.play(sound3,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound4 (View v) {
        sp.play(sound4,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound5 (View v) {
        sp.play(sound5,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound6 (View v) {
        sp.play(sound6,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound7 (View v) {
        sp.play(sound7,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound8 (View v) {
        sp.play(sound8,1.0f,1.0f,0,0,1.0f);
    }

    public void playsound9 (View v) {
        sp.play(sound9,1.0f,1.0f,0,0,1.0f);
    }

*/


}
