package com.example.ample_sequence;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

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



        sp = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        sound1 = sp.load(getApplicationContext(), R.raw.sound1,1);
        sound2 = sp.load(getApplicationContext(), R.raw.sound2,1);
        sound3 = sp.load(getApplicationContext(), R.raw.sound3,1);
        sound4 = sp.load(getApplicationContext(), R.raw.sound4,1);
        sound5 = sp.load(getApplicationContext(), R.raw.sound5,1);
        sound6 = sp.load(getApplicationContext(), R.raw.sound6,1);
        sound7 = sp.load(getApplicationContext(), R.raw.sound7,1);
        sound8 = sp.load(getApplicationContext(), R.raw.sound8,1);
        //sound9 = sp.load(getApplicationContext(), R.raw.sound9,1);

        Instrument [] instruments = {
                createSampleOne(sound1),
                createSampleTwo(sound2),
                createSampleThree(sound3),
                createBassDrum(sound4),
                createClosedHat(sound5),
                createOpenHat(sound6),
                createClap(sound7),
                createDance(sound8),
        };


        sequencer = new Sequencer(this, sp, instruments);
        refresher = new Sequencer(this);


        Refresher runnable = new Refresher();
        new Thread(runnable).start();

    }

    //Mapping all row one toggle buttons to sample1 instrument (sound1)
    public Instrument createSampleOne(int sound1) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "sp" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument sampleOne = new Instrument(buttons, "sp", this.sound1);
        return sampleOne;
    }
    public Instrument createSampleTwo(int sound2) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "sptwo" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument sampleTwo = new Instrument(buttons, "sp", this.sound2);
        return sampleTwo;
    }
    public Instrument createSampleThree(int sound3) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "spthree" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument sampleThree = new Instrument(buttons, "sp", this.sound3);
        return sampleThree;
    }
    public Instrument createBassDrum(int sound4) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "bd" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument bassDrum = new Instrument(buttons, "sp", this.sound4);
        return bassDrum;
    }
    public Instrument createClosedHat(int sound5) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "clh" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument closedHat = new Instrument(buttons, "sp", this.sound5);
        return closedHat;
    }
    public Instrument createOpenHat(int sound6) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "oph" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument openHat = new Instrument(buttons, "sp", this.sound6);
        return openHat;
    }
    public Instrument createClap(int sound7) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "clp" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument clap = new Instrument(buttons, "sp", this.sound7);
        return clap;
    }
    public Instrument createDance(int sound1) {
        ToggleButton [] buttons = new ToggleButton[16];
        for(int i =0; i < 16; i ++) {
            String buttonID = "dance" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName() );
            buttons[i] = (ToggleButton) findViewById(resID);
        }
        Instrument dance = new Instrument(buttons, "sp", this.sound8);
        return dance;
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
