package com.example.hh_drums;

import android.widget.ToggleButton;


/* Pad class acts a container for each ToggleButton, maintaining data as well as samples*/
public class Pad {
    ToggleButton tb;
    int padNum;

    public Pad (ToggleButton tb, int padNum) {
        this.tb = tb;
        this.padNum= padNum;
    }


    public ToggleButton getTb() {
        return this.tb;
    }

    public int getPadNum() {
        return this.padNum;
    }

    public void setToggleButton(ToggleButton tb) {
        this.tb = tb;
    }

    public void settbId(int tbId) {
       // this.tbId = tbId;
    }

    public boolean getStatus() {
        if(this.tb.isChecked() == true){
            return true;
        }else{
            return false;
        }
    }
}
