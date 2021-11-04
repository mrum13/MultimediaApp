package maczdev.submission1_java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDetailActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        DataFilm datasFilm = intent.getParcelableExtra("Information");
        //ArrayList<DataFilm> dataFilm = getIntent().getParcelableArrayListExtra(KEY);

        int posterFilms = datasFilm.getNomorposter();
        String titleFilm = datasFilm.getJudul();
        String detailFilms = datasFilm.getDetails();
        String aktorFilms = datasFilm.getAktor();

        ImageView imageView = findViewById(R.id.image1);
        try {
            imageView.setImageResource(posterFilms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView textView = findViewById(R.id.text3);
        textView.setText(titleFilm);
        TextView textView2 = findViewById(R.id.overview);
        textView2.setText(detailFilms);
        TextView textView1 = findViewById(R.id.detailsnya);
        textView1.setText(aktorFilms);
        btn_video = findViewById(R.id.buttonTrailer);
        btn_video.setOnClickListener(this);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    public void playVideo(View view) {
//
//        startActivity(new Intent(ItemDetailActivity.this, VideoActivity.class));
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonTrailer:
                startActivity(new Intent(ItemDetailActivity.this, VideoActivity.class));
                break;
        }

    }
}
