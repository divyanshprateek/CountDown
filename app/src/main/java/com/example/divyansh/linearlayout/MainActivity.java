package com.example.divyansh.linearlayout;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seek;
    TextView text;
    Button bt;
    MediaPlayer mp;
    Boolean isActive = false;
    CountDownTimer count;
    public void reset()
    {
        text.setText("0:30");
        seek.setProgress(30);
        count.cancel();
        bt.setText("GO");
        seek.setEnabled(true);
        isActive = false;
    }
    public void updateTimer(int i) {
        int min = (int) i / 60;
        int sec = i - min * 60;
        String s = Integer.toString(sec);
        if (sec <= 9) {
            s = "0" + s;
        }
        text.setText(min + ":" + s);
    }

    public void startTimer(View view) {
        if(isActive == false) {
            isActive = true;
            bt = (Button) findViewById(R.id.go);
            seek.setEnabled(false);
            bt.setText("STOP");
            count = new CountDownTimer(seek.getProgress() * 1000 + 100, 1000) {
                public void onTick(long millisecondsUntilDone) {
                    updateTimer((int) millisecondsUntilDone / 1000);
                }

                public void onFinish() {
                    text.setText("0:00");
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.horn);
                    mp.start();
                    reset();
                    //buzzer
                }
            }.start();
        }
        else
        {
            reset();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek = (SeekBar) findViewById(R.id.seek);
        text = (TextView) findViewById(R.id.text);

        seek.setMax(600);
        seek.setProgress(30);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("This is new session"," starting ...");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);
    }
    */
    }
}