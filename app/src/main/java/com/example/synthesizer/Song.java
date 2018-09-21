package com.example.synthesizer;

import android.os.AsyncTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class Song {
    private List<Note> notes;
    private List<Note> second;

    public Song() {
        notes = new ArrayList<>();

    }

    public Song(List<Note> notes) {
        this.notes = notes;

    }
    public Song(List<Note> notes, List<Note> second){
        this.notes = notes;
        this.second = second;

    }
    public void add(Note note){
        notes.add(note);

    }

    @Override
    public String toString() {
        return "Song{" +
                "notes=" + notes +
                '}';
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
