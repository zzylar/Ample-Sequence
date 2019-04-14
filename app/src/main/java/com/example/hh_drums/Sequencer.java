package com.example.hh_drums;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.SystemClock;
import android.widget.ToggleButton;

import static com.example.hh_drums.R.raw.sound4;

public class Sequencer implements Runnable{

    private int tempo;
    private int Pad;
    private boolean [] selected = new boolean[16];
    private boolean playing = false;
    private SoundPool sp;
    private Context context;
    public ToggleButton [] buttons;
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

   public void setTempo(int tempo) {
        this.tempo = tempo;
   }

   public void setIsPlaying(boolean playing) {
        this.playing = playing;
   }

   public void setSample(int id, int sample) {

   }

   public void startSequence(ToggleButton [] buttons, int sound) {
       while(playing == true) {
           for (int i = 0; i < 16; i++) {
               try {
                   if(buttons[i].isChecked()) {
                       sp.play(sound, 1.0f, 1.0f, 0, 0, 1.0f);
                   }
                   Thread.sleep(((1000 * 60) / this.tempo)/4);
                   System.out.println(i);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }


    @Override
    public void run() {
        startSequence(buttons, this.sound);
    }
}
