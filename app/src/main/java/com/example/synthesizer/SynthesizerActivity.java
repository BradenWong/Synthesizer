package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHighA;
    private Button buttonHighBb;
    private Button buttonHighB;
    private Button buttonHighC;
    private Button buttonHighCs;
    private Button buttonHighD;
    private Button buttonHighDs;
    private Button buttonHighE;
    private Button buttonHighF;
    private Button buttonHighFs;
    private Button buttonHighG;
    private Button buttonHighGs;
    private Button buttonScale;
    private Button buttonEscale;
    private Button buttonSong;
    private Button darude;
    private Button suprise;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHighA;
    private int noteHighBb;
    private int noteHighB;
    private int noteHighC;
    private int noteHighCs;
    private int noteHighD;
    private int noteHighDs;
    private int noteHighE;
    private int noteHighF;
    private int noteHighFs;
    private int noteHighG;
    private int noteHighGs;
    private int noteHighHighA;
    private int noteHighHighB;
    private int noteHighHighC;
    private int noteLowA;
    private int noteLowB;
    private int noteLowFs;
    private int noteLowGs;
    private int notea0;
    private int notea1;
    private int notea0new;
    private int notea1new;
    private int noteb0new;
    private int noteb1new;
    private int notea2;
    private int noteb0;
    private int noteb1;
    private int noteb2;
    private int notee1;
    private int notee2;
    private int notee1new;
    private int notee2new;
    private int notee3;
    private int noted1;
    private int noted2;
    private int noted3;
    private int noted1snew;
    private int noted2snew;
    private int notec1s;
    private int notec2s;
    private int notec1snew;
    private int notec2snew;
    private int notec3snew;
    private int noted3snew;
    private int notec3;
    private Map<Integer,Integer> noteMap;
    private Handler handler;


    private static final int WHOLE_NOTE = 500;
    public static final float DEFAULT_VOLUME= 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE= 1.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        handler = new Handler();
        wireWidgets();
        setListeners();
        initializeSoundPool();
    }
    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_csharp);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_dsharp);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fsharp);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gsharp);
        buttonHighA = findViewById(R.id.button_synth_highA);
        buttonHighBb = findViewById(R.id.button_synth_highBb);
        buttonHighB = findViewById(R.id.button_synth_highB);
        buttonHighC = findViewById(R.id.button_synth_highC);
        buttonHighCs = findViewById(R.id.button_synth_highCs);
        buttonHighD = findViewById(R.id.button_synth_highD);
        buttonHighDs = findViewById(R.id.button_synth_highDs);
        buttonHighE = findViewById(R.id.button_synth_highEs);
        buttonHighF = findViewById(R.id.button_synth_highF);
        buttonHighFs = findViewById(R.id.button_synth_highFs);
        buttonHighG = findViewById(R.id.button_synth_highG);
        buttonHighGs = findViewById(R.id.button_synth_highGs);
        buttonScale = findViewById(R.id.button_synth_scale);
        buttonEscale = findViewById(R.id.button_synth_escale);
        buttonSong = findViewById(R.id.button_synth_song);
        darude = findViewById(R.id.button_synth_darude);
        suprise = findViewById(R.id.button_synth_takeOnMe);
    }
    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonHighA.setOnClickListener(noteListener);
        buttonHighBb.setOnClickListener(noteListener);
        buttonHighB.setOnClickListener(noteListener);
        buttonHighC.setOnClickListener(noteListener);
        buttonHighCs.setOnClickListener(noteListener);
        buttonHighD.setOnClickListener(noteListener);
        buttonHighDs.setOnClickListener(noteListener);
        buttonHighE.setOnClickListener(noteListener);
        buttonHighF.setOnClickListener(noteListener);
        buttonHighFs.setOnClickListener(noteListener);
        buttonHighG.setOnClickListener(noteListener);
        buttonHighGs.setOnClickListener(noteListener);

        buttonScale.setOnClickListener(this);
        buttonEscale.setOnClickListener(this);
        buttonSong.setOnClickListener(this);
        darude.setOnClickListener(this);
        suprise.setOnClickListener(this);
    }
    private void initalizeNoteMap(){
        noteMap = new HashMap<>();
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_csharp, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_dsharp, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fsharp, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gsharp, noteGs);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, DEFAULT_PRIORITY);
        noteBb = soundPool.load(this, R.raw.scalebb, DEFAULT_PRIORITY);
        noteB = soundPool.load(this, R.raw.scaleb, DEFAULT_PRIORITY);
        noteC = soundPool.load(this, R.raw.scalec, DEFAULT_PRIORITY);
        noteCs = soundPool.load(this, R.raw.scalecs, DEFAULT_PRIORITY);
        noteD = soundPool.load(this, R.raw.scaled, DEFAULT_PRIORITY);
        noteDs = soundPool.load(this, R.raw.scaleds, DEFAULT_PRIORITY);
        noteE = soundPool.load(this, R.raw.scalee, DEFAULT_PRIORITY);
        noteF = soundPool.load(this, R.raw.scalef, DEFAULT_PRIORITY);
        noteFs = soundPool.load(this, R.raw.scalefs, DEFAULT_PRIORITY);
        noteG = soundPool.load(this, R.raw.scaleg, DEFAULT_PRIORITY);
        noteGs = soundPool.load(this, R.raw.scalegs, DEFAULT_PRIORITY);
        noteHighA = soundPool.load(this, R.raw.scalehigha, DEFAULT_PRIORITY);
        noteHighBb = soundPool.load(this, R.raw.scalehighbb, DEFAULT_PRIORITY);
        noteHighB = soundPool.load(this, R.raw.scalehighb, DEFAULT_PRIORITY);
        noteHighC = soundPool.load(this, R.raw.scalehighc, DEFAULT_PRIORITY);
        noteHighCs = soundPool.load(this, R.raw.scalehighcs, DEFAULT_PRIORITY);
        noteHighD = soundPool.load(this, R.raw.scalehighd, DEFAULT_PRIORITY);
        noteHighDs = soundPool.load(this, R.raw.scalehighds, DEFAULT_PRIORITY);
        noteHighE = soundPool.load(this, R.raw.scalehighe, DEFAULT_PRIORITY);
        noteHighF = soundPool.load(this, R.raw.scalehighf, DEFAULT_PRIORITY);
        noteHighFs = soundPool.load(this, R.raw.scalehighfs, DEFAULT_PRIORITY);
        noteHighG = soundPool.load(this, R.raw.scalehighg, DEFAULT_PRIORITY);
        noteHighGs = soundPool.load(this, R.raw.scalehighgs, DEFAULT_PRIORITY);
        noteHighHighA = soundPool.load(this, R.raw.scalehighhigha, DEFAULT_PRIORITY);
        noteHighHighB = soundPool.load(this,R.raw.scalehighhighb, DEFAULT_PRIORITY);
        noteHighHighC = soundPool.load(this,R.raw.scalehighhighc, DEFAULT_PRIORITY);
        //notea0 = soundPool.load(this,R.raw.scalea0, DEFAULT_PRIORITY);
        notea1 = soundPool.load(this, R.raw.scalea1, DEFAULT_PRIORITY);
        notea2 = soundPool.load(this, R.raw.scalea2, DEFAULT_PRIORITY);
        notea0new = soundPool.load(this,R.raw.scalea0new, DEFAULT_PRIORITY);
        notea1new = soundPool.load(this, R.raw.scalea1new, DEFAULT_PRIORITY);
        noteb0 = soundPool.load(this,R.raw.scaleb0, DEFAULT_PRIORITY);
        noteb1 = soundPool.load(this, R.raw.scaleb1, DEFAULT_PRIORITY);
        noteb0new = soundPool.load(this,R.raw.scaleb0new, DEFAULT_PRIORITY);
        noteb1new = soundPool.load(this, R.raw.scaleb1new, DEFAULT_PRIORITY);
        noteb2= soundPool.load(this, R.raw.scaleb2, DEFAULT_PRIORITY);
        notee1 = soundPool.load(this, R.raw.scalee1, DEFAULT_PRIORITY);
        notee2 = soundPool.load(this, R.raw.scalee2, DEFAULT_PRIORITY);
        notee1new = soundPool.load(this, R.raw.scalee1new, DEFAULT_PRIORITY);
        notee2new = soundPool.load(this, R.raw.scalee2new, DEFAULT_PRIORITY);
        notee3 = soundPool.load(this, R.raw.scalee3, DEFAULT_PRIORITY);
        noted1 = soundPool.load(this, R.raw.scaled1, DEFAULT_PRIORITY);
        noted2 = soundPool.load(this, R.raw.scaled2, DEFAULT_PRIORITY);
        noted1snew = soundPool.load(this, R.raw.scaled1snew, DEFAULT_PRIORITY);
        noted2snew = soundPool.load(this, R.raw.scaled2snew, DEFAULT_PRIORITY);
        noted3 = soundPool.load(this, R.raw.scaled3, DEFAULT_PRIORITY);
        notec1s = soundPool.load(this, R.raw.scalec1s, DEFAULT_PRIORITY);
        notec2s = soundPool.load(this, R.raw.scalec2s, DEFAULT_PRIORITY);
        notec1snew   = soundPool.load(this, R.raw.scalec1snew, DEFAULT_PRIORITY);
        notec2snew= soundPool.load(this, R.raw.scalec2snew, DEFAULT_PRIORITY);
        notec3snew= soundPool.load(this, R.raw.scalec3snew, DEFAULT_PRIORITY);
        noted3snew= soundPool.load(this, R.raw.scaled3snew, DEFAULT_PRIORITY);
        notec3 = soundPool.load(this, R.raw.scalec3, DEFAULT_PRIORITY);

    }




    @Override
    public void onClick(View view) {
        //one method to handel the clicks of all the buttons
        //but don't forget to tell the buttons who is doing the listening
        switch (view.getId()){
//            case R.id.button_synth_a:
//                soundPool.play(noteA, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_bb:
//                soundPool.play(noteBb, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_b:
//                soundPool.play(noteB, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_c:
//                soundPool.play(noteC, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_csharp:
//                soundPool.play(noteCs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_d:
//                soundPool.play(noteD, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_dsharp:
//                soundPool.play(noteDs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_e:
//                soundPool.play(noteE, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_f:
//                soundPool.play(noteF, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_fsharp:
//                soundPool.play(noteFs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_g:
//                soundPool.play(noteG, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_gsharp:
//                soundPool.play(noteGs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highA:
//                soundPool.play(noteHighA, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highBb:
//                soundPool.play(noteHighBb, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highB:
//                soundPool.play(noteHighB, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highC:
//                soundPool.play(noteHighC, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highCs:
//                soundPool.play(noteHighCs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highD:
//                soundPool.play(noteHighD, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highDs:
//                soundPool.play(noteHighDs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highEs:
//                soundPool.play(noteHighE, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highF:
//                soundPool.play(noteHighF, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highFs:
//                soundPool.play(noteHighFs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highG:
//                soundPool.play(noteHighG, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
//            case R.id.button_synth_highGs:
//                soundPool.play(noteHighGs, 1.0f, 1.0f, 1,0, 1.0f);
//                break;
            case R.id.button_synth_escale:
                playEscale();
                break;
            case R.id.button_synth_takeOnMe:
                scheduleSongs(2000, playTakeOnMe(), playLeftSong());
                break;
            case R.id.button_synth_song:
                scheduleSongs(1000, playTakeOnMe());
                break;
            case R.id.button_synth_darude:
                scheduleSongs(1000, playLeftSong());
                break;
            case R.id.button_synth_scale:
                playScale();
        }
    }

    private void scheduleSongs(long startDelay, Song... songs) {
        //the start delay makes sure all tasks are scheduled before songs are played
        long base = SystemClock.uptimeMillis() + startDelay;
        for (Song song: songs) {
            //delay accumulates as the song plays
            long delay = 0;
            for (final Note note: song.getNotes()) {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        soundPool.play(note.getNoteID(), 1f, 1f, 1, 0, 1f);
                        Log.d("SynthesizerActivity", ""+SystemClock.uptimeMillis());
                    }
                }, base + delay); //schedule the note to play at the sum of the uptime and the delay
                delay+=note.getDelay();
            }
        }
    }

    private Song playLeftSong() {
        Song takeOnMe = new Song();

        takeOnMe.add(new Note(noteb0new, 400));
        takeOnMe.add(new Note(noteb1new, 600));
        takeOnMe.add(new Note(noteb0new, 200));
        takeOnMe.add(new Note(noteb1new, 400));

        takeOnMe.add(new Note(notee1new, 400));
        takeOnMe.add(new Note(notee2new, 600));
        takeOnMe.add(new Note(notee1new, 200));
        takeOnMe.add(new Note(notee2new, 400));

        takeOnMe.add(new Note(notea0new, 400));
        takeOnMe.add(new Note(notea1new, 600));
        takeOnMe.add(new Note(notea0new, 200));
        takeOnMe.add(new Note(notea1new, 400));

        takeOnMe.add(new Note(noted2snew, 400));
        takeOnMe.add(new Note(noted3snew, 400));
        takeOnMe.add(new Note(notec2snew, 400));
        takeOnMe.add(new Note(notec3snew, 400));

        takeOnMe.add(new Note(noteb0new, 400));
        takeOnMe.add(new Note(noteb1new, 600));
        takeOnMe.add(new Note(noteb0new, 200));
        takeOnMe.add(new Note(noteb1new, 400));

        takeOnMe.add(new Note(notee1new, 400));
        takeOnMe.add(new Note(notee2new, 600));
        takeOnMe.add(new Note(notee1new, 200));
        takeOnMe.add(new Note(notee2new, 400));

        takeOnMe.add(new Note(notea0new, 400));
        takeOnMe.add(new Note(notea1new, 600));
        takeOnMe.add(new Note(notea0new, 200));
        takeOnMe.add(new Note(notea1new, 400));

        takeOnMe.add(new Note(noted2snew, 400));
        takeOnMe.add(new Note(noted3snew, 400));
        takeOnMe.add(new Note(notec2snew, 400));
        takeOnMe.add(new Note(notec3snew, 400));

        takeOnMe.add(new Note(noteb0new, 400));
        takeOnMe.add(new Note(noteb1new, 600));
        takeOnMe.add(new Note(noteb0new, 200));
        takeOnMe.add(new Note(noteb1new, 400));

        takeOnMe.add(new Note(notee1new, 400));
        takeOnMe.add(new Note(notee2new, 600));
        takeOnMe.add(new Note(notee1new, 200));
        takeOnMe.add(new Note(notee2new, 400));

        takeOnMe.add(new Note(noteb0new, 400));
        takeOnMe.add(new Note(noteb1new, 600));
        takeOnMe.add(new Note(noteb0new, 200));
        takeOnMe.add(new Note(noteb1new, 400));

        takeOnMe.add(new Note(notee1new, 400));
        takeOnMe.add(new Note(notee2new, 600));
        takeOnMe.add(new Note(notee1new, 200));
        takeOnMe.add(new Note(notee2new, 400));

        takeOnMe.add(new Note(noteb0new, 400));
        takeOnMe.add(new Note(noteb1new, 600));
        takeOnMe.add(new Note(noteb0new, 200));
        takeOnMe.add(new Note(noteb1new, 400));

        takeOnMe.add(new Note(notee1new, 400));
        takeOnMe.add(new Note(notee2new, 600));
        takeOnMe.add(new Note(notee1new, 200));
        takeOnMe.add(new Note(notee2new, 400));

        return takeOnMe;
    }

    private Song playTakeOnMe() {
        Song takeOnMe = new Song();

        //9
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighD, 200));
        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighE, 400));

        //10

        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighB, 200));

        //11
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighD, 400));

        takeOnMe.add(new Note(noteHighFs, 400));

        //12

        takeOnMe.add(new Note(noteHighFs, 400));

        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));

        //13
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighD, 200));
        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighE, 400));

        //14

        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighB, 200));

        //15
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighD, 400));

        takeOnMe.add(new Note(noteHighFs, 400));

        //

        takeOnMe.add(new Note(noteHighFs, 400));

        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));

        //17
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighD, 200));
        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighB, 400));

        takeOnMe.add(new Note(noteHighE, 400));

        //18

        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighGs, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighB, 200));

        //19
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighHighA, 200));
        takeOnMe.add(new Note(noteHighE, 400));

        takeOnMe.add(new Note(noteHighD, 400));

        takeOnMe.add(new Note(noteHighFs, 400));

        //20
        takeOnMe.add(new Note(noteHighFs, 400));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighE, 200));
        takeOnMe.add(new Note(noteHighFs, 200));
        takeOnMe.add(new Note(noteHighE, 200));

        //21
        takeOnMe.add(new Note(noteDs, 600));
        takeOnMe.add(new Note(noteDs, 400));
        takeOnMe.add(new Note(noteCs, 200));
        takeOnMe.add(new Note(noteB, 2000));

        //22

        //23
        takeOnMe.add(new Note(noteCs, 200));
        takeOnMe.add(new Note(noteCs, 400));
        takeOnMe.add(new Note(noteCs, 400));
        takeOnMe.add(new Note(noteA, 600));
        //24

        return takeOnMe;
    }

    private void playTheSong() {
        Song scale = new Song();
        //intro
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE*4));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE*4));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE*4));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE*4));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/4));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB,WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));
        scale.add(new Note(noteB, WHOLE_NOTE/4));

        //chorus
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB, WHOLE_NOTE/2));
        scale.add(new Note(noteB));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD,WHOLE_NOTE/2));
        scale.add(new Note(noteHighD));
        scale.add(new Note(noteHighA));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE,WHOLE_NOTE/2));
        scale.add(new Note(noteHighE));

        playSong(scale);






    }


    private void playASong() {
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteE);
        delay(WHOLE_NOTE);
        playNote(noteD);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE);
        playNote(noteFs);
        delay(WHOLE_NOTE*2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteE);
        delay(WHOLE_NOTE);
        playNote(noteD);
        delay(WHOLE_NOTE);
        playNote(noteHighA);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE*2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteHighD);
        delay(WHOLE_NOTE);
        playNote(noteHighB);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE);
        playNote(noteFs);
        delay(WHOLE_NOTE);
        playNote(noteE);
        delay(WHOLE_NOTE);
        playNote(noteHighC);
        delay(WHOLE_NOTE/2);
        playNote(noteHighC);
        delay(WHOLE_NOTE/2);
        playNote(noteHighB);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE);
        playNote(noteHighA);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE*2);
    }

    private void playEscale() {
        //E, F Sharp, G, A, B, C Sharp, D, E
        playNote(noteE);
        delay(WHOLE_NOTE/2);
        playNote(noteFs);
        delay(WHOLE_NOTE/2);
        playNote(noteHighA);
        delay(WHOLE_NOTE/2);
        playNote(noteHighB);
        delay(WHOLE_NOTE/2);
        playNote(noteHighCs);
        delay(WHOLE_NOTE/2);
        playNote(noteHighD);
        delay(WHOLE_NOTE/2);
        playNote(noteHighE);
        delay(WHOLE_NOTE/2);
    }

    private void playScale() {
        //play all notes with delay inbetween
        Song scale = new Song();
        scale.add(new Note(noteC));
        scale.add(new Note(noteD));
        scale.add(new Note(noteE));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteHighA));
        scale.add(new Note(noteHighB));
        scale.add(new Note(noteHighC));


        playSong(scale);

    }

    private void playSong(Song scale) {
        for(Note note : scale.getNotes()){
            playNote(note);
            delay(note.getDelay());

        }
    }


    private void delay(int wholeNote){
        try{
            Thread.sleep(wholeNote);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private class KeyboardNoteListener implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            int id = view.getId();

            int note = noteMap.get(id);

            playNote(note);
        }
    }
    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop , DEFAULT_RATE);
    }
    private void playNote(int note) {
        playNote(note, 0);
    }
    private void playNote(Note note){
        playNote(note.getNoteID(), 0);
    }

    class playSongClassasyncTask extends AsyncTask<List<Note>, Void, Void> {

        @Override
        protected Void doInBackground(List<Note>... lists) {
            for(Note note : lists[0]){
                soundPool.play(note.getNoteID(), DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, 0 , DEFAULT_RATE);
                try {
                    Thread.sleep(note.getDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return null;
        }
    }
}
