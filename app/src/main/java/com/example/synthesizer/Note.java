package com.example.synthesizer;
import java.util.List;
public class Note {
    private int noteID;
    private int delay;
    public static final int WHOLE_NOTE = 3000;

    public Note(int noteID, int delay){
        this.noteID= noteID;
        this.delay = delay;

    }
    public Note (int noteID){
        this.noteID = noteID;
        this.delay = WHOLE_NOTE;

    }
    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", delay=" + delay +
                '}';
    }
}
