package com.thewirecoy.app.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        mediaController = (MediaController)findViewById(R.id.mediaController);

        /*String[] songs = new String[]{
                "Song 1",
                "Song 2",
                "Song 3",
                "Song 4",
                "Song 5",
                "Song 6",
                "Song 7",
                "Song 8"
        }; */

        ArrayList<HashMap<String, String>> song = new SongsManager().getPlayList();

        HashMap<String, String> m = song.get(0);

        //String strArr[] = new String[m.size()];
        int i = 0;
        ArrayList<String> str = new ArrayList<>();

        for(HashMap<String, String> hash : song)
        {
            for (String current : hash.values()) {
                str.add(current);
                //strArr[i] = current;
            }
        }

       // ArrayAdapter<HashMap<String, String>> songAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, song);
        ArrayAdapter<String> songAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, str);

        listView.setAdapter(songAdapter);
        //ArrayList<String> songs = new ArrayList<String>();
        //ArrayAdapter<String> songsList = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_main, songs);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPos = position;
                String itemVal = (String)listView.getItemAtPosition(position);

                /*HashMap<String, String> m = (HashMap<String, String>) listView.getItemAtPosition(position);

                String strArr[] = new String[m.size()];
                int i = 0;

                    for (String current : m.values()) {
                        strArr[i] = current;
                        i++;
                    }


                Toast.makeText(getApplicationContext(), itemPos+" - "+strArr[1], Toast.LENGTH_SHORT).show();

                */

                Toast.makeText(getApplicationContext(), itemPos+" - "+itemVal, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
