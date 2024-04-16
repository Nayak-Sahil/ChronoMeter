package com.college.practical5;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton playBtn, pauseBtn;
    Chronometer chrnMeter;
    boolean canPlay = true, canPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playBtn = findViewById(R.id.playBtn);;
        pauseBtn = findViewById(R.id.pauseBtn);
        chrnMeter = findViewById(R.id.chronoMeter);

        playBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
    }

    public void displayPauseBtn(boolean wantToVisible){
        if(wantToVisible){
            pauseBtn.setVisibility(View.VISIBLE);
        }else{
            pauseBtn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playBtn){
            if (canPlay){
                Toast.makeText(MainActivity.this, "Stopwatch started.", Toast.LENGTH_SHORT).show();
                playBtn.setImageDrawable(getDrawable(R.drawable.reset));
                canPlay = false;
                canPause = true;
                displayPauseBtn(true);
                chrnMeter.setBase(SystemClock.elapsedRealtime());
                chrnMeter.start();
            }else{
                Toast.makeText(MainActivity.this, "Stopwatch reset.", Toast.LENGTH_SHORT).show();
                playBtn.setImageDrawable(getDrawable(R.drawable.play));
                canPlay = true;
                canPause = false;
                displayPauseBtn(false);
                chrnMeter.setBase(SystemClock.elapsedRealtime());
                chrnMeter.stop();
            }
        } else if (v.getId() == R.id.pauseBtn) {
            if(canPause){
                Toast.makeText(MainActivity.this, "Stopwatch stopped.", Toast.LENGTH_SHORT).show();
                pauseBtn.setImageDrawable(getDrawable(R.drawable.play));
                chrnMeter.stop();
                canPause = false;
            }else{
                Toast.makeText(MainActivity.this, "Stopwatch started.", Toast.LENGTH_SHORT).show();
                pauseBtn.setImageDrawable(getDrawable(R.drawable.pause));
                chrnMeter.start();
                canPause = true;
            }
        }
    }
}