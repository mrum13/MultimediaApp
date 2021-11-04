package maczdev.submission1_java;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.video_view);

        Uri alamat_video =
                Uri.parse("android.resource://" +getPackageName()+ "/" +R.raw.androidcommercial);

        MediaController controller = new MediaController(VideoActivity.this);

        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);

        videoView.setVideoURI(alamat_video);
        videoView.start();

    }
}
