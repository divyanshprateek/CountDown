package com.example.divyansh.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.mylist);

        final ArrayList<String> arraylist  = new ArrayList<String>();
        arraylist.add("Divyansh");
        arraylist.add("Bhavya");
        arraylist.add("Abhijit");
        arraylist.add("Raunak");
        arraylist.add("Karan");

        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arraylist);
        list.setAdapter(arrayadapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Hello " + arraylist.get(i),Toast.LENGTH_LONG).show();
            }
        });

    }
}
