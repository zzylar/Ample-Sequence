package com.example.ample_sequence;

import android.widget.ToggleButton;

public class Instrument {

    public ToggleButton[] buttons;
    public String instrumentName;
    public int sound;


    public Instrument (ToggleButton [] buttons, String instrumentName) {
        this.buttons = buttons;
        this.instrumentName = instrumentName;
    }

    public Instrument (ToggleButton [] buttons, String instrumentName, int sound) {
        this.buttons = buttons;
        this.instrumentName = instrumentName;
        this.sound =sound;
    }



    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public void setButtons(ToggleButton [] buttons) {
        this.buttons = buttons;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public ToggleButton [] getButtons() {
        return this.buttons;
    }

    public int getSound(){
        return this.sound;
    }

    public ToggleButton getButtonAt( int i) {
        return this.buttons[i];
    }

}
