package com.ara.myapplication1;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
private ImageButton ferrarii,policee;
private MediaPlayer ferrarisound,policesound;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ferrarii = findViewById(R.id.ferrarii);
        policee = findViewById(R.id.policee);

         policesound= MediaPlayer.create(this,R.raw.ferrarisound);
         ferrarisound= MediaPlayer.create(this,R.raw.policesound);
        ferrarii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           playmusic(ferrarisound,policesound);
            }
        });
        policee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playmusic(policesound,ferrarisound);
            }
        });
    }
    private void playmusic(MediaPlayer m1,MediaPlayer m2){
        if (m1.isPlaying()){
            m1.pause();
            m1.seekTo(0);
            m1.setLooping(false);
        }
        if (m2.isPlaying()){
            m2.pause();
            m2.seekTo(0);
            m2.setLooping(false);
        }
        m1.start();
        m1.setLooping(true);
    }
}