package maczdev.submission1_java;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import static maczdev.submission1_java.Datavalues.casts;
import static maczdev.submission1_java.Datavalues.detailfilm;
import static maczdev.submission1_java.Datavalues.gambarfilm;
import static maczdev.submission1_java.Datavalues.namafilm;

public class ItemListActivity extends AppCompatActivity {

    ListView listView;
    private DataAdapter adapter;
    private ArrayList<DataFilm> dataFilmsmain;
    private String[] dataDetil;
    private String[] dataJudul;
    private int[] dataPhoto;
    private String[] dataAktor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Catalog Movie");

        listView = findViewById(R.id.listview);

        adapter = new DataAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ItemListActivity.this,dataFilmsmain.get(position).
                        getJudul(),Toast.LENGTH_LONG).show();
                playAudio(position);
                Context context = ItemListActivity.this;
                Intent intent = new Intent(context, ItemDetailActivity.class);
                DataFilm dataFilmx = new DataFilm(position);
                //intent.putParcelableArrayListExtra("Information",dataFilmsmain);
                intent.putExtra("Information",dataFilmx);
                context.startActivity(intent);
            }
        });
        prepare();
        additem();
    }

    private void playAudio(int position) {
        int[] audioitem={R.raw.alpukat,
                R.raw.alpukat_c,
                R.raw.apel,
                R.raw.apel_c,
                R.raw.ceri,
                R.raw.ceri_c,
                R.raw.durian,
                R.raw.durian_c,
                R.raw.jambu_air,
                R.raw.jambu_air_c,

                R.raw.manggis,
                R.raw.manggis_c,
                R.raw.strawberry,
                R.raw.straw,
                R.raw.strawberry_c};

        Uri uri = Uri.parse("android.resource://"+getClass().getPackage().getName()+"/"+audioitem[position]);

        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
//            Context context;
            player.setDataSource(ItemListActivity.this, uri);
//            player.setDataSource(String.valueOf(uri));
        }   catch (IOException e){
            e.printStackTrace();
        }

        try {
            player.prepare();
        } catch (IOException e){
            e.printStackTrace();
        }

        player.start();
    }

    private void prepare(){
        dataJudul = namafilm;
        dataPhoto = gambarfilm;
        dataDetil = detailfilm;
        dataAktor = casts;

    }

    private void additem(){
        dataFilmsmain = new ArrayList<>();
        for(int i = 0;i < dataJudul.length;i++){

            DataFilm dataFilm = new DataFilm();
            dataFilm.setJudul(dataJudul[i]);
            dataFilm.setNomorposter(dataPhoto[i]);
            dataFilm.setDetails(dataDetil[i]);
            dataFilm.setAktor(dataAktor[i]);
            dataFilmsmain.add(dataFilm);

        }

        adapter.setDataFilmsadapter(dataFilmsmain);
    }

}

