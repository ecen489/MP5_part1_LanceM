package com.example.musicplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_button,end_button;
    MediaPlayer audio_player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio_player = MediaPlayer.create(this,R.raw.bohemian_rhapsody); // initial start song
    }

    public void radio_click(View view) {
        ImageView img = (ImageView) findViewById(R.id.my_pic);
        boolean checked = ((RadioButton) view).isChecked(); //check if button is checked

        int ID = view.getId();

        if (ID == R.id.rad_queen) { // case for Queen to play
            if (checked) {
                img.setImageResource(R.drawable.queen); // set queen as background
            }
            try {
                audio_player.reset();
            } catch (Exception e) {

            }
            audio_player = MediaPlayer.create(this, R.raw.bohemian_rhapsody);
            audio_player.start();
        } else if (ID == R.id.rad_journey) { //journey button
            if (checked) {
                img.setImageResource(R.drawable.journey);
            }
            try {
                audio_player.reset();
            } catch (Exception e) {

            }
            audio_player = MediaPlayer.create(this, R.raw.dont_stop_believin); // similar process as above
            audio_player.start();
        } else if (ID == R.id.rad_eagles) { // eagles case
            if (checked) {
                img.setImageResource(R.drawable.eagles);
            }
            try {
                audio_player.reset();
            } catch (Exception e) {
            }
            audio_player = MediaPlayer.create(this, R.raw.hotel_california);
            audio_player.start();
        }
    }
    public void start_song(View view){
        audio_player.start();
    }
    public void stop_song(View view){
        audio_player.pause();
    }
}
