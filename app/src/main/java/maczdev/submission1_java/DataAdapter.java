package maczdev.submission1_java;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {

    Context context;
    private ArrayList<DataFilm> dataFilmsmain = new ArrayList<>();
    //Datavalues nilaidata = new Datavalues();

    public DataAdapter(Context konteks) {
        this.context = konteks;

    }

    public void setDataFilmsadapter(ArrayList<DataFilm> dataFilmsmain) {
        this.dataFilmsmain = dataFilmsmain;
    }

    @Override
    public int getCount() {
        return Datavalues.namafilm.length;
    }

    @Override
    public Object getItem(int position) {
        return dataFilmsmain.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_content, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        DataFilm dataFilm = (DataFilm) getItem(position);
        viewHolder.onBindViewHolder(dataFilm);

        return itemView;
    }


    private class ViewHolder {

        private TextView mIdView;
        private ImageView mContentView;

        public ViewHolder(View view) {

            mIdView = view.findViewById(R.id.judul_film);
            mContentView = view.findViewById(R.id.poster_film);
        }

        public void onBindViewHolder(DataFilm dataFilm) {

            mIdView.setText(dataFilm.getJudul());
            mContentView.setImageResource(dataFilm.getNomorposter());
        }
    }
}
