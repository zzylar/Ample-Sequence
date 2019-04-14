package com.example.hh_drums;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.SystemClock;
import android.widget.ToggleButton;

import static com.example.hh_drums.R.raw.sound4;
import static com.example.hh_drums.R.raw.sound5;

public class Sequencer implements Runnable{

    private int tempo;
    private int Pad;
    private boolean [] selected = new boolean[16];
    private boolean playing = false;
    private SoundPool sp;
    private Context context;
    public ToggleButton [] buttons;
    public Instrument [] instruments;
    int [] sounds;
    public int sound;



    public Sequencer(Context ctx, SoundPool sp, ToggleButton [] buttons, int sound) {
       this.buttons = buttons;
       this.tempo = 128;
       this.sp = sp;
       this.sound = sound;

   }

    public Sequencer(Context ctx) {
        this.buttons = buttons;
        this.tempo = 128;
        this.sp = sp;

    }
    public Sequencer(Context ctx, SoundPool sp, Instrument [] instruments) {
        this.buttons = buttons;
        this.tempo = 128;
        this.sp = sp;
        this.instruments = instruments;
    }

    public Sequencer(Context ctx, SoundPool sp, Instrument [] instruments, int [] sounds) {
        this.buttons = buttons;
        this.tempo = 128;
        this.sp = sp;
        this.instruments = instruments;
        this.sounds = sounds;

    }

   public void setTempo(int tempo) {
        this.tempo = tempo;
   }

   public void setIsPlaying(boolean playing) {
        this.playing = playing;
   }

   public void setSample(int id, int sample) {

   }

   public void startSequence(Instrument [] instruments) {
       while(playing == true) {
           for (int i = 0; i < 16; i++) {
               for(int j = 0; j < instruments.length; j++) {
                   if (instruments[j].getButtonAt(i).isChecked()) {
                       sp.play(instruments[j].getSound(), 1.0f, 1.0f, 0, 0, 1.0f);
                   }
               }
               try {
                   Thread.sleep(((1000 * 60) / this.tempo) / 4);
                   System.out.println(i);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

       }
   }


    @Override
    public void run() {
        startSequence(this.instruments);
    }
}
