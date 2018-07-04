package com.example.divyansh.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    public void createTable(int times)
    {
        final ArrayList<String> table  = new ArrayList<String>();

        for(int i = 1; i <= 10;i++)
        {
            table.add(times+ " * " + i + " = "+ Integer.toString(times * i));
        }

        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,table);
        list.setAdapter(arrayadapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        final SeekBar seek = (SeekBar) findViewById(R.id.seek);
        seek.setMax(20);
        seek.setProgress(10);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int times;
                if(i < min)
                {
                    times = min;
                    seek.setProgress(min);
                }
                else
                {
                    times = i;
                }
                createTable(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        createTable(10);
    }

}
